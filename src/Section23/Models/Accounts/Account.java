package Section23.Models.Accounts;

import java.text.DecimalFormat;

public abstract class Account {
    private String id;
    private String name;
    private double balance;

    public  boolean withdraw(double amount){
        amount = round(amount);
        if (amount >= 0 ) {
            setBalance(round(getBalance() - amount));
            return true;
        }
        return false;
    }

    public void deposit(double amount) {
        if(amount < 0){
            throw new IllegalArgumentException("Deposit cannot be negative");
        }
        setBalance(round(getBalance() + amount));
    }

    public Account(String id, String name, double balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }
    public Account(Account source) {
        this.id = source.id;
        this.name = source.name;
        this.balance = source.balance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        checkParam(id);
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        checkParam(name);
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    private void checkParam(String param){
        if (param == null || param.isBlank()){
            throw new IllegalArgumentException("Field cannot be null or blank");
        }
    }

    @Override
    public String toString() {
        return  "id= " + id
                + " \tname= " + name
                + " \tbalance= " + balance;
    }

    protected double round(double amount){
        DecimalFormat formatter = new DecimalFormat("#.##");
        return Double.parseDouble(formatter.format(amount));
    }
}
