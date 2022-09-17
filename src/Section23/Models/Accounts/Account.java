package Section23.Models.Accounts;

public abstract class Account {
    private String id;
    private String name;
    private double balance;

    public abstract void withdraw(double amount);
    public abstract void deposit(double amount);

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
}
