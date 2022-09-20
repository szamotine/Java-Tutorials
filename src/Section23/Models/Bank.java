package Section23.Models;

import Section23.Models.Accounts.Account;
import Section23.Models.Accounts.Chequing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bank {
    private List<Account> accounts;
    private List<Transaction> transactions;

    public Bank() {
        this.accounts = new ArrayList<>();
        this.transactions = new ArrayList<>();
    }
    public void addAccount(Account a){
        this.accounts.add(a.clone());
        //System.out.println("Successfully added " + a);
    }
    private void addTransaction(Transaction t){
        this.transactions.add(new Transaction(t));
        //System.out.println("Successfully added " + t);
    }
    public Transaction[] getTransactions(String bankAccountID){
        return this.transactions.stream().filter(transaction -> transaction.getBankAccountID().equals(bankAccountID)).toArray(Transaction[]::new);
    }
    public Account getAccount(String bankAccountID){
        return this.accounts.stream().
                filter(account -> account.getId().equals(bankAccountID))
                .findFirst()
                .orElse(null);
    }
    public void withdrawTransaction(Transaction t){
        if(getAccount(t.getBankAccountID()).withdraw(t.getAmount())){
            addTransaction(t);
        }else{
            System.out.println("\n------------Transaction Unsuccessful------------\n");
            System.out.println("Name: " + getAccount(t.getBankAccountID()).getName());
            System.out.println("Transaction ID: " +  t.getId());
            System.out.println("Balance: " + getAccount(t.getBankAccountID()).getBalance());
            System.out.println("Type: " + t.getType() + ", Amount: " + t.getAmount());
        }
    }

    public void depositTransaction(Transaction t){
       getAccount(t.getBankAccountID()).deposit(t.getAmount());
       addTransaction(t);
    }

    public void executeTransaction(Transaction t){
        switch(t.getType()){
            case DEPOSIT:
                depositTransaction(t);
                break;
            case WITHDRAW:
                withdrawTransaction(t);
                break;
        }
    }
    private double getIncome(Taxable account){
        Transaction[] transactions = getTransactions(((Chequing)account).getId());
        return Arrays.stream(transactions).mapToDouble(transaction -> {
            switch(transaction.getType()){
                case WITHDRAW: return -transaction.getAmount();
                case DEPOSIT: return transaction.getAmount();
                default: return 0;
            }
        }).sum();
    }

    public void deductTaxes(){
        for(Account a : accounts){
            if (Taxable.class.isAssignableFrom(a.getClass())){
                Taxable taxable = (Taxable) a;
                taxable.tax(getIncome(taxable));
            }
        }
    }
}
