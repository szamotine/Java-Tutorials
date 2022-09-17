package Section23.Models.Accounts;

import Section23.Models.Taxable;

public class Chequing extends Account implements Taxable {

    public Chequing(String id, String name, double balance) {
        super(id, name, balance);
    }

    public Chequing(Chequing source) {
        super(source);
    }

    @Override
    public void deposit(double amount) {
        amount = calculateTax(amount);
        super.deposit(amount);
    }

    @Override
    public boolean withdraw(double amount) {
        double overdraftLimit = 200;
        double overdraftFee = 5.50;
        double balanceMinusAmount = round(getBalance() - amount);

        if(balanceMinusAmount >=0){
            return super.withdraw(amount);
        }else if(balanceMinusAmount - overdraftFee >= -overdraftLimit ){
            return super.withdraw(amount + overdraftFee);
        }
        return false;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ": " + super.toString();
    }

    @Override
    public double calculateTax(double amount) {
        double taxRate = 0.15;

        if(amount > 3000){
            return amount-amount*taxRate;
        }else{
            return amount;
        }
    }
}
