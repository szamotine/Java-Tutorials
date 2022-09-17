package BankManagementTests;

import Section23.Models.Accounts.Account;
import Section23.Models.Accounts.Chequing;
import Section23.Models.Accounts.Loan;
import Section23.Models.Accounts.Savings;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class BankManagementTests {

    Chequing chequing;
    Savings savings;
    Loan loan;

    Account[] accounts;

    @Before
    public void setup(){
        chequing = new Chequing("f84c43f4-a634-4c57-a644-7602f8840870","Michael Scott",1524.51);
        savings = new Savings("ce07d7b3-9038-43db-83ae-77fd9c0450c9", "Saul Goodman", 2241.60);
        loan = new Loan("4991bf71-ae8f-4df9-81c1-9c79cff280a5","Phoebe Buffay",2537.31);
        accounts = new Account[]{chequing,savings,loan};
    }

    @Test
    public void withdrawal(){
        double amount = 1440;
        assertTrue(chequing.withdraw(amount));
        assertTrue(savings.withdraw(amount));
        assertTrue(loan.withdraw(amount));
        assertEquals(84.51,chequing.getBalance());
        assertEquals(796.60,savings.getBalance());
        assertEquals(1068.51,loan.getBalance());

        assertTrue(chequing.withdraw(250));
        assertTrue(loan.withdraw(9000));
        assertEquals(-170.99,chequing.getBalance());
        assertEquals(-8111.49,loan.getBalance());

        assertFalse(chequing.withdraw(10000));
        assertFalse(savings.withdraw(2247));
    }


    @Test
    public void deposit(){
        double amount = 1000;
        savings.deposit(amount);
        chequing.deposit(amount);
        loan.deposit(amount);
        assertEquals(3241.60,savings.getBalance());
        assertEquals(2524.51,chequing.getBalance());
        assertEquals(3537.31,loan.getBalance());

        chequing.deposit(3100);
        assertEquals(5159.51, chequing.getBalance());


    }


    @Test
    public void checkOverdraftFee(){
        double fee = 5.50;
        double balance = chequing.getBalance();
        double withdrawal = balance + 100;
        assertTrue(chequing.withdraw(withdrawal));
        assertEquals(chequing.getBalance(), balance - withdrawal - fee);
    }

    @Test
    public void checkOverdraftLimit(){
        double fee = 5.50;
        double balance = chequing.getBalance();
        double withdrawal = balance + 250;
        assertFalse(chequing.withdraw(withdrawal));
        assertEquals(chequing.getBalance(),balance);

    }
}
