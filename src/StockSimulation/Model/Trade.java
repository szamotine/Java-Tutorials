package StockSimulation.Model;

public class Trade {
    public enum Type{MARKET_BUY, MARKET_SELL}
    private final Stock stock;
    private Type type;
    private int numberOfShares;
    private double tradeTax = 1;

    public Trade(Stock stock, String tType, int numberOfShares) {

        if(stock == null) throw new IllegalArgumentException("Error: Stock null in Trade()");
        this.stock = stock;

        if(!(tType.equals("buy")) && !(tType.equals("sell"))){
            throw new IllegalArgumentException("Error: wrong type in Trade()");
        }
        if (tType.equals("buy")){
            type = Type.MARKET_BUY;
        }else{
            type = Type.MARKET_SELL;
        }

        if(numberOfShares < 0){
            throw new IllegalArgumentException("Error: number of shares in Trade()");
        }
        this.numberOfShares = numberOfShares;
    }

    //#region Getters/Setters
    public Stock getStock() {
        return stock;
    }

    public Type getType() {
        return type;
    }

    public int getNumberOfShares() {
        return numberOfShares;
    }

    public void setNumberOfShares(int numberOfShares) {
        checkParam(numberOfShares);
        this.numberOfShares = numberOfShares;
    }
    public double getTradeTax() {
        return tradeTax;
    }
    public void setTradeTax(double tradeTax) {
        checkParam(tradeTax);
        this.tradeTax = tradeTax;
    }

    private void checkParam(double number){
        if(number < 0){
            throw new IllegalArgumentException("Error: Check param in Trade()");
        }
    }
    //#endregion
}
