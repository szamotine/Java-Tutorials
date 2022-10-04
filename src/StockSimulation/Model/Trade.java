package StockSimulation.Model;

public class Trade {

    public enum Stock{AAPL, FB, GOOG, TSLA}
    public enum Type{MARKET_BUY, MARKET_SELL}
    private Stock stock;
    private Type type;
    private double price;
    private int shares;


}
