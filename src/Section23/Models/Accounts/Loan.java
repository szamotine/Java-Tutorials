package Section23.Models.Accounts;

public class Loan extends Account {
    public Loan(String id, String name, double balance) {
        super(id, name, balance);
    }

    public Loan(Loan source) {
        super(source);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ": " + super.toString();
    }

    @Override
    public boolean withdraw(double amount) {
        double fixedInterestRate = 1.02;
        double balanceMinusAmount = round(getBalance() - amount*fixedInterestRate);
        if(balanceMinusAmount >= -10000){
            return super.withdraw(amount*fixedInterestRate);
        }
        return false;
    }
}
