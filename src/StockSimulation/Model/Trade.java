package StockSimulation.Model;

public class Trade {


    public enum Type{MARKET_BUY, MARKET_SELL}
    private Stock stock;
    private Type type;
    private int numberOfShares;

    public Trade(Stock stock, String tType, int numberOfShares) {
        if(stock == null) throw new IllegalArgumentException("Error: Stock null in Trade()");
        this.stock = stock;

        if(!(tType.equals("buy")) && !(tType.equals("sell"))){
            throw new IllegalArgumentException("Error: wrong type in Trade()");
        }
        if (tType.equals("buy")) type = Type.MARKET_BUY;
        if (tType.equals("sell")) type = Type.MARKET_SELL;

        if(numberOfShares < 0){
            throw new IllegalArgumentException("Error: number of shares in Trade()");
        }
        this.numberOfShares = numberOfShares;
    }
    public Trade(Trade source) {
        this.stock = source.stock;
        this.type = source.type;
        this.numberOfShares = source.numberOfShares;
    }

    //#region Getters/Setters
    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getNumberOfShares() {
        return numberOfShares;
    }

    public void setNumberOfShares(int numberOfShares) {
        this.numberOfShares = numberOfShares;
    }
    //#endregion
}
