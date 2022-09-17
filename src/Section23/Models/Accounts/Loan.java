package Section23.Models.Accounts;

public class Loan extends Account {
    public Loan(String id, String name, double balance) {
        super(id, name, balance);
    }

    public Loan(Loan source) {
        super(source);
    }

    @Override
    public void withdraw(double amount) {

    }

    @Override
    public void deposit(double amount) {

    }
    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ": " + super.toString();
    }
}
