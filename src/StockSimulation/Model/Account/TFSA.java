package StockSimulation.Model.Account;

public class TFSA extends Account {

    private final double BUY_TRADE_FEE = 0.01;
    private final double SELL_TRADE_FEE = 0.01;

    public TFSA(double amount) {
        super(amount);
        System.out.println("TFSA account created");
    }
}
