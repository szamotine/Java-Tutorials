package Section23.Models;

import org.jetbrains.annotations.NotNull;

import java.sql.Timestamp;

public class Transaction implements Comparable<Transaction> {
    private String id;
    private static String transactionID;
    private String bankAccountID;
    private TransactionType type;
    public enum TransactionType {
        WITHDRAW,
        DEPOSIT;

    }
    private double amount;
    private final Timestamp timeStamp;

    static{
        transactionID = "100";
    }

    public Transaction(String id, String type, String bankAccountID, double amount) {
        this.id = id;
        this.amount = amount;
        this.type = checkType(type);
        this.timeStamp = new Timestamp(new java.util.Date().getTime());
        this.bankAccountID = bankAccountID;
    }
    public Transaction(Transaction source) {
        this.id = source.id;
        this.amount = source.amount;
        this.type = source.type;
        this.timeStamp = new Timestamp(new java.util.Date().getTime());
        this.bankAccountID = source.bankAccountID;
    }
    public Transaction(String type,String bankAccountID, double amount) {
        long transID = Long.parseLong(transactionID);
        transID ++;
        setTransactionID(transID);
        this.amount = amount;
        this.type = checkType(type);
        this.timeStamp = new Timestamp(new java.util.Date().getTime());
        this.bankAccountID = bankAccountID;
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

    public TransactionType getType() {
        return type;
    }

    public void setType(String type) {
        this.type = checkType(type);
    }

    public static String getTransactionID() {
        return transactionID;
    }

    public static void setTransactionID(long transactionID) {
        Transaction.transactionID = String.valueOf(transactionID);
    }

    @Override
    public String toString() {
        return "Transaction{"
                + "id='" + id + '\''
                + ", type='" + type + '\''
                + ", account='" + bankAccountID + '\''
                + ", amount=" + amount
                + ", timeStamp=" + timeStamp + '}';
    }

    @Override
    public int compareTo(@NotNull Transaction o) {
        return this.timeStamp.compareTo(o.getTimeStamp());
    }
    public TransactionType checkType(String type){
        if(String.valueOf(TransactionType.DEPOSIT).equalsIgnoreCase(type)){
            return TransactionType.DEPOSIT;
        }
        if(String.valueOf(TransactionType.WITHDRAW).equalsIgnoreCase(type)){
            return TransactionType.WITHDRAW;
        }
        throw new IllegalArgumentException("Transaction type must be Withdraw or Deposit");
    }
}
