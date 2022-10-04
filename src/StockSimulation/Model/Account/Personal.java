package StockSimulation.Model.Account;

public class Personal extends Account {

    private final double SELL_TRADE_FEE = 0.05;


    public Personal(double amount) {
        super(amount);
        System.out.println("Personal account created");


    }
}
