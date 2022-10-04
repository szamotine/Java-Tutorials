package StockSimulation.Model.Account;

import StockSimulation.Model.Stock;
import StockSimulation.Model.Trade;
import StockSimulation.utils.Color;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;


public abstract class Account {

    private Map<Stock.StockName, Integer> portfolio;

    private double funds;

    public Account(double amount) {
        this.portfolio = new HashMap<>();
        this.funds = amount;
    }

    public Account(Account source) {

        this.portfolio = new HashMap<Stock.StockName, Integer>(Map.copyOf(source.portfolio));
        this.funds = source.funds;
    }

    public void addStock(Stock stock, int numberOfShares){
        if(stock == null || numberOfShares < 0) throw new IllegalArgumentException("Error: Account.addStock()");
        this.portfolio.put(stock.getName(), numberOfShares);
    }

    public boolean transaction(Stock stock, Trade.Type type){
       //TODO: sell, purchase
        if (type.equals(Trade.Type.MARKET_SELL)){
            return true;
        }
        return false;
    }

    public boolean sellShares(Stock stock,int numberOfShares){
        int availableShares = portfolio.get(stock.getName());

        if(numberOfShares > availableShares || numberOfShares < 0){
            throw new IllegalArgumentException("Error: Number of shares");
        }

        portfolio.put(stock.getName(), availableShares-numberOfShares);

        funds += round(stock.getPrice() * numberOfShares);

        return true;


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
