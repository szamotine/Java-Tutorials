package StockSimulation.Model;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Stock stock = (Stock) o;
        return  getName() == stock.getName();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
