package Section23.Models;

import Section23.Models.Accounts.Account;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bank {
    private Map <String, Account> accounts;
    private List<Account> accountList;
    private List<Transaction> transactionList;
    public Bank(){
        accounts = new HashMap<>();

    }

    public Map<String, Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Map<String, Account> accounts) {
        this.accounts = accounts;
    }

    public Account getAccount(String id) {
        return accounts.get(id);
    }
    public void addAccount(String id, Account source) {
        if(source == null){
            throw new IllegalArgumentException("Account cannot be null");
        }
        accounts.put(id, source);
    }
    public boolean verifyAccountID(String accountID){
        return accounts.containsKey(accountID);
    }
}
