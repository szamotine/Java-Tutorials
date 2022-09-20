package Section23.Models.Accounts;

import Section23.Models.Taxable;

public class Chequing extends Account implements Taxable {
    private static final double OVERDRAFT_FEE = 5.50;
    private static final double OVERDRAFT_LIMIT = 200;

    private static final double TAXABLE_INCOME = 3000;
    private static final double TAX_RATE = 0.15;

    public Chequing(String id, String name, double balance) {
        super(id, name, balance);
    }

    public Chequing(Chequing source) {
        super(source);
    }
    @Override
    public Account clone() {
        return new Chequing(this);
    }

    @Override
    public void deposit(double amount) {
       // amount = calculateIncomeAfterTax(amount);
        super.deposit(amount);
    }

    @Override
    public boolean withdraw(double amount) {
        double balanceMinusAmount = round(getBalance() - amount);

        if(balanceMinusAmount >=0){
            return super.withdraw(amount);
        }else if(balanceMinusAmount - OVERDRAFT_FEE >= -OVERDRAFT_LIMIT ){
            return super.withdraw(amount + OVERDRAFT_FEE);
        }
        return false;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ": " + super.toString();
    }

    @Override
    public double calculateIncomeAfterTax(double amount) {
        double tax = Math.max(0, amount - TAXABLE_INCOME) * TAX_RATE;
        return amount - tax;
    }
    @Override
    public void tax(double income) {
        double tax = Math.max(0, income - TAXABLE_INCOME) * TAX_RATE;
        super.setBalance(super.round(super.getBalance() - tax));
    }
}
