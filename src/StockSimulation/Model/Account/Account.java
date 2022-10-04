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
        this.portfolio = new HashMap<Stock.StockName, Integer>();
        this.funds = amount;

        //TODO: add list of stocks, initialize at zero
        /*
        portfolio.put(AAPL, 0);
        portfolio.put(FB, 0);
        portfolio.put(GOOG, 0);
        portfolio.put(TSLA, 0);

         */
    }

    public Account(Account source) {
        //TODO: Copy Constructor
        //this.portfolio = new HashMap<Stock.StockName, Integer>(Map.copyOf(source.portfolio));
        this.funds = source.funds;
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

        funds += stock.getPrice() * numberOfShares;

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
        return null;
    }

    protected double round(double amount){
        DecimalFormat formatter = new DecimalFormat("#.##");
        return Double.parseDouble(formatter.format(amount));
    }
}
