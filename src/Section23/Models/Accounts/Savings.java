package Section23.Models.Accounts;

public class Savings extends Account {
    public static final double WITHDRAWAL_FEE = 5;

    public Savings(String id, String name, double balance) {
        super(id, name, balance);
    }

    public Savings(Savings source) {
        super(source);
    }
    @Override
    public Account clone() {
        return new Savings(this);
    }

    @Override
    public boolean withdraw(double amount) {
        double balanceMinusAmount = round(getBalance() - amount-WITHDRAWAL_FEE);

        if(balanceMinusAmount>=0){
            return super.withdraw(amount+WITHDRAWAL_FEE);
        }
        return false;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ": " + super.toString();
    }
}
