package StockSimulation.Model.Account;

import StockSimulation.Model.Trade.Stock;
import StockSimulation.utils.Color;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

import static StockSimulation.Model.Trade.Stock.*;

public abstract class Account {

    private Map<Stock, Integer> portfolio;

    private double funds;

    public Account(double amount) {
        this.portfolio = new HashMap<Stock, Integer>();
        this.funds = amount;
        portfolio.put(AAPL, 0);
        portfolio.put(FB, 0);
        portfolio.put(GOOG, 0);
        portfolio.put(TSLA, 0);
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
