package Section23.Models;

import java.sql.Timestamp;

public class Transaction {
    private String id;
    private static String transactionID;
    private String type;
    private double amount;
    private final Timestamp timeStamp;

    static{
        transactionID = "100";
    }

    public Transaction(String id, String type, double amount) {
        this.id = id;
        this.amount = amount;
        this.type = type;
        this.timeStamp = new Timestamp(new java.util.Date().getTime());
    }
    public Transaction(String type, double amount) {
        long transID = Long.parseLong(transactionID);
        transID ++;
        setTransactionID(transID);
        this.amount = amount;
        this.type = type;
        this.timeStamp = new Timestamp(new java.util.Date().getTime());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Timestamp getTimeStamp() {
        return timeStamp;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public static String getTransactionID() {
        return transactionID;
    }

    public static void setTransactionID(long transactionID) {
        Transaction.transactionID = String.valueOf(transactionID);
    }

    @Override
    public String toString() {
        return "Transaction{" + "id='" + id + '\'' + ", type='" + type + '\'' + ", amount=" + amount + ", timeStamp=" + timeStamp + '}';
    }
}
