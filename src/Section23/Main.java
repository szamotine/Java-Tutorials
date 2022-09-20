package Section23;

import Section23.Models.Accounts.Account;
import Section23.Models.Accounts.Chequing;
import Section23.Models.Accounts.Loan;
import Section23.Models.Accounts.Savings;
import Section23.Models.Bank;
import Section23.Models.Transaction;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static final String ACCOUNT_LIST = "accounts.txt";
    static final String TRANSACTION_LIST  = "transactions.txt";

    static List<Account> accounts = new ArrayList<>();
    static List<Transaction> transactions = new ArrayList<>();
    static Bank bank;
    public static void main(String[] args) throws FileNotFoundException {


        getData(ACCOUNT_LIST);
        getData(TRANSACTION_LIST);
        bank = new Bank();

        for(Account a: accounts){
            bank.addAccount(a);
        }






        /*
        bank.addAccount(accounts.get(0));
        bank.addTransaction(transactions.get(0));
        System.out.println("\n\n ------Printing all accounts------");
        accounts.forEach(System.out::println);

        System.out.println("\n\n ------Printing all Transactions------");
        transactions.forEach(System.out::println);
        Collections.sort(transactions);
        System.out.println("\n\n ------Printing all sorted Transactions------");
        transactions.forEach(System.out::println);
        */

    }

    public static void getData(String filename) throws FileNotFoundException {
        String path = "src\\Section23\\Resources\\" + filename;

        FileInputStream fis = new FileInputStream(path);
        Scanner scanFile = new Scanner(fis);
        if(filename.equalsIgnoreCase("accounts.txt")){
            getAccounts(scanFile,filename);
        }
        if(filename.equalsIgnoreCase("transactions.txt")){
            getTransactions(scanFile,filename);
        }
        scanFile.close();
    }

    public static void getTransactions(Scanner scanFile, String fileName){
        while(scanFile.hasNextLine()){
            try{
                String line = scanFile.nextLine();
                String[] temp = line.split(",");
                String id = temp[0];
                String type = temp[1];
                String account = temp[2];
                double amount = Double.parseDouble(temp[3]);
                transactions.add(new Transaction(id,type,account,amount));

            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static void getAccounts(Scanner scanFile, String fileName) throws FileNotFoundException {

        while(scanFile.hasNextLine()){
            try{
                String line = scanFile.nextLine();
                String[] temp = line.split(",");
                String accountType = temp[0];
                String accountID = temp[1];
                String name = temp[2];
                double balance = Double.parseDouble(temp[3]);

                if(accountType.equalsIgnoreCase("chequing")){
                    Chequing tempAccount = new Chequing(accountID,name, balance);
                  // System.out.println(tempAccount);
                    accounts.add(tempAccount);

                }
                if(accountType.equalsIgnoreCase("savings")){
                    accounts.add(new Savings(accountID,name, balance));
                }
                if(accountType.equalsIgnoreCase("loan")){
                    accounts.add(new Loan(accountID,name, balance));
                }
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * Name: createObject
     * @param values (String[] values)
     * @return Account
     *
     * Inside the function:
     *   1. Dynamically creates a Chequing, Loan, or Savings object based on the values array.
     */
    public static Account createObject(String[] values){
        try {
            return (Account)Class.forName("src.main.model.account." + values[0])
                    .getConstructor(String.class, String.class, double.class)
                    .newInstance(values[1], values[2], Double.parseDouble(values[3]));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
