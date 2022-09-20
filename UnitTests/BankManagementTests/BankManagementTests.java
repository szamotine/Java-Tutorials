package BankManagementTests;

import Section23.Models.Accounts.Account;
import Section23.Models.Accounts.Chequing;
import Section23.Models.Accounts.Loan;
import Section23.Models.Accounts.Savings;
import Section23.Models.Bank;
import Section23.Models.Transaction;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.*;

public class BankManagementTests {
    //#region Fields
    Chequing chequing;
    Savings savings;
    Loan loan;
    double amount;
    Account[] accounts;
    Bank bank;

    Transaction t1;
    //#endregion
    @Before
    public void setup(){
        chequing = new Chequing("f84c43f4-a634-4c57-a644-7602f8840870","Michael Scott",1524.51);
        savings = new Savings("ce07d7b3-9038-43db-83ae-77fd9c0450c9", "Saul Goodman", 2241.60);
        loan = new Loan("4991bf71-ae8f-4df9-81c1-9c79cff280a5","Phoebe Buffet",2537.31);
        accounts = new Account[]{chequing,savings,loan};
        amount = 1400;
        t1 = new Transaction("1546992000","DEPOSIT","f84c43f4-a634-4c57-a644-7602f8840870",810.05);
        bank = new Bank();
        bank.addAccount(new Chequing("f84c43f4-a634-4c57-a644-7602f8840870", "Michael Scott", 1524.51));

    }

    //#region Chequing Account Tests
    @Test
    public void withdrawalChequings(){
        assertTrue(chequing.withdraw(amount));
        assertEquals(124.51,chequing.getBalance());
    }
    @Test
    public void withdrawalChequingsOverdraft(){
        assertTrue(chequing.withdraw(amount + 250));
        assertEquals(-130.99,chequing.getBalance());
    }
    @Test
    public void withdrawalChequingsOverLimit(){
        assertFalse(chequing.withdraw(10000));
    }

    @Test
    public void depositChequing(){
        assertEquals(1524.51, chequing.getBalance());
        chequing.deposit(1000);
        assertEquals(2524.51,chequing.getBalance());

    }
    @Test
    public void depositChequingWithTax(){
        assertEquals(1524.51, chequing.getBalance());
        chequing.deposit(3100);
        assertEquals(4609.51, chequing.getBalance());
    }

    //#endregion

    //#region Savings Account Tests
    @Test
    public void withdrawalSavings(){
        assertTrue(savings.withdraw(amount));
        assertEquals(836.60,savings.getBalance());
    }
    @Test
    public void withdrawalSavingsOverLimit(){
        assertFalse(savings.withdraw(2241.60));
    }
    @Test
    public void depositSavings(){
        double amount = 1000;
        savings.deposit(amount);
        assertEquals(3241.60,savings.getBalance());
    }
    //#endregion

    //#region Loans Account Tests
    @Test
    public void withdrawalLoan(){
        assertTrue(loan.withdraw(amount));
        assertEquals(3965.31,loan.getBalance());
    }
    @Test
    public void withdrawalLoanOverLimit(){
        assertFalse(loan.withdraw(7463.00));
    }
    @Test
    public void depositLoan(){
        assertEquals(2537.31, loan.getBalance());
        loan.deposit(1000);
        assertEquals(1537.31,loan.getBalance());
    }

    //#endregion

    //#region Transaction Tests
    @Test (expected = IllegalArgumentException.class)
    public void TransactionWrongType() {
        Transaction t2 = new Transaction("1546992000", "NDEPOSIT", "5b6af5d4-bd3c-480c-9f35-c3b76cf3a271", 810.05);
    }

    //#region Bank Tests

    @Test
    public void successfulTransactions(){
        assertEquals(1524.51,this.bank.getAccount("f84c43f4-a634-4c57-a644-7602f8840870").getBalance());

        this.bank.executeTransaction(new Transaction("1546905600","WITHDRAW",  "f84c43f4-a634-4c57-a644-7602f8840870", 624.99));

        this.bank.executeTransaction(new Transaction("1578700800","Deposit",  "f84c43f4-a634-4c57-a644-7602f8840870", 441.93));

        assertEquals(2, bank.getTransactions("f84c43f4-a634-4c57-a644-7602f8840870").length);

        assertEquals(1341.45,this.bank.getAccount("f84c43f4-a634-4c57-a644-7602f8840870").getBalance());

    }
    @Test
    public void failedTransactions(){
        assertEquals(1524.51,this.bank.getAccount("f84c43f4-a634-4c57-a644-7602f8840870").getBalance());

        this.bank.executeTransaction(new Transaction("1546905600","WITHDRAW",  "f84c43f4-a634-4c57-a644-7602f8840870", 1900));

        assertEquals(0, bank.getTransactions("f84c43f4-a634-4c57-a644-7602f8840870").length);

        assertEquals(1524.51,this.bank.getAccount("f84c43f4-a634-4c57-a644-7602f8840870").getBalance());
    }
    @Test
    public void taxDeduction() {

        this.bank.executeTransaction(new Transaction("1578700800","Deposit",  "f84c43f4-a634-4c57-a644-7602f8840870", 4000));
        this.bank.executeTransaction(new Transaction("1546905600","WITHDRAW",  "f84c43f4-a634-4c57-a644-7602f8840870", 500));
        this.bank.deductTaxes();
        assertEquals(4949.51, bank.getAccount("f84c43f4-a634-4c57-a644-7602f8840870").getBalance());
    }

    //#endregion
}
