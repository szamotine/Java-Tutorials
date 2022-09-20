package Section23.Models.Accounts;

public class Loan extends Account {
    public Loan(String id, String name, double balance) {
        super(id, name, balance);
    }

    public Loan(Loan source) {
        super(source);
    }
    @Override
    public Account clone() {
        return new Loan(this);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ": " + super.toString();
    }

    @Override
    public boolean withdraw(double amount) {
        double fixedInterestRate = 1.02;
        double balancePlusAmount = round(getBalance() + amount*fixedInterestRate);
        if(balancePlusAmount <= 10000){
            super.deposit(amount*fixedInterestRate);
            return true;
        }
        return false;
    }

    @Override
    public void deposit(double amount) {
        super.withdraw(amount);
    }
}
