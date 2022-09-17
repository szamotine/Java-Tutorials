package Section23.Models.Accounts;

public class Savings extends Account {

    public Savings(String id, String name, double balance) {
        super(id, name, balance);
    }

    public Savings(Savings source) {
        super(source);
    }

    @Override
    public boolean withdraw(double amount) {
        double withdrawalFee = 5;
        double balanceMinusAmount = round(getBalance() - amount-withdrawalFee);

        if(balanceMinusAmount>=0){
            return super.withdraw(amount+withdrawalFee);
        }
        return false;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ": " + super.toString();
    }
}
