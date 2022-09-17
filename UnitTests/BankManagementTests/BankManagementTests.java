package BankManagementTests;

import Section23.Models.Accounts.Chequing;
import Section23.Models.Accounts.Loan;
import Section23.Models.Accounts.Savings;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class BankManagementTests {

    Chequing chequing;
    Savings savings;
    Loan loan;

    @Before
    public void setup(){
        chequing = new Chequing("f84c43f4-a634-4c57-a644-7602f8840870","Michael Scott",1524.51);
        savings = new Savings("4991bf71-ae8f-4df9-81c1-9c79cff280a5","Phoebe Buffay",2537.31);
        loan = new Loan("23a8bae0-1725-4282-8401-2fd418b75682","Dean Winchester",2930.24);
    }

    @Test
    public void checkOverdraftFee(){
        double fee = 5.50;
        double balance = chequing.getBalance();
        double withdrawal = balance + 100;
        chequing.withdraw(withdrawal);
        assertEquals(chequing.getBalance(), balance - withdrawal - fee);
    }

    @Test
    public void checkOverdraftLimit(){
        double fee = 5.50;
        double balance = chequing.getBalance();
        double withdrawl = balance + 250;
        chequing.withdraw(withdrawl);
        assertEquals(chequing.getBalance(),balance );

    }
}
