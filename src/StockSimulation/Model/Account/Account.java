package StockSimulation.Model.Account;

import StockSimulation.Model.ITrade;
import StockSimulation.Model.Stock;
import StockSimulation.Model.Trade;
import StockSimulation.utils.Color;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;


public abstract class Account implements ITrade {

    private Map<Stock.StockName, Integer> portfolio;
    private double funds;

    public Account(double amount) {
        this.portfolio = new HashMap<>();
        this.funds = round(amount);
    }

    public Account(Account source) {

        this.portfolio = new HashMap<>(Map.copyOf(source.portfolio));
        this.funds = source.funds;
    }

    @Override
    public boolean ExecuteTrade(Trade trade) {

        if (trade.getType().equals(Trade.Type.MARKET_SELL)){
            return sellShares(trade.getStock(), trade.getNumberOfShares());

        }else{
            return buyShares(trade.getStock(), trade.getNumberOfShares());
        }

    }

    public void addStock(Stock stock, int numberOfShares){
        if(stock == null || numberOfShares < 0) throw new IllegalArgumentException("Error: Account.addStock()");
        this.portfolio.put(stock.getName(), numberOfShares);
    }


    public boolean sellShares(Stock stock,int numberOfShares){

        int availableShares = getInventory(stock);

        if(availableShares < numberOfShares){
            return false;
            //throw new IllegalArgumentException("Error: number of shares in Account.sellShares()");
        }

        portfolio.put(stock.getName(), availableShares-numberOfShares);

        funds += round(stock.getPrice() * numberOfShares);

        return true;

    }
    public int getInventory(Stock stock){
        return this.portfolio.get(stock.getName());
    }

    public boolean buyShares(Stock stock, int numberOfShares){
        double price = round(numberOfShares * stock.getPrice());

        if(price < funds){
            portfolio.put(stock.getName(), portfolio.get(stock.getName()) + numberOfShares);
            funds -= price;
            return true;
        }

        return false;

    }

    public String toString() {
        return "\n  Stock\t\t"  + Color.RESET + "Shares" +
                "\n\n" + displayPortfolio() + Color.RESET +
                "\n  Funds Left\t" + Color.GREEN + "$" + round(this.getFunds()) + Color.RESET;
    }

    public double getFunds() {
        return this.funds;
    }

    private String displayPortfolio() {

        StringBuilder temp = new StringBuilder();
        for(Map.Entry<Stock.StockName,Integer> m : portfolio.entrySet() ){
            if(m.getValue() > 0){
                temp.append("\n  " + Color.BLUE).append(m.getKey()).append("\t\t").append(Color.GREEN).append(m.getValue());
            }
        }
        return temp.toString();
    }

    protected double round(double amount){
        DecimalFormat formatter = new DecimalFormat("#.##");
        return Double.parseDouble(formatter.format(amount));
    }
}
