package StockSimulation.Model;

public class Stock {

    public enum StockName{AAPL, FB, GOOG, TSLA};
    private StockName name;
    private double price;

    public Stock(StockName name) {
        this.name = name;
    }

    public StockName getName(){
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if(price < 0) throw new IllegalArgumentException("Price < 0");
        this.price = price;
    }
}
