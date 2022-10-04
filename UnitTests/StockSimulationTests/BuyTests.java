package StockSimulationTests;


import StockSimulation.Model.Account.Account;
import StockSimulation.Model.Account.Personal;
import StockSimulation.Model.Account.TFSA;
import org.junit.Before;
import org.junit.Test;

public class BuyTests {
    Account[] accounts;
    static final double INITIAL_DEPOSIT = 4000;

    @Before
    public void setup(){
        accounts = new Account[2];
        accounts[0] = new Personal(INITIAL_DEPOSIT);
        accounts[1] = new TFSA(INITIAL_DEPOSIT);

    }

    @Test
    public void Test_PersonalAccountPurchaseShare_SharesIncrease(){

    }

    @Test
    public void Test_TFSAAccountPurchaseShare_SharesIncrease(){

    }
    @Test
    public void PurchaseWithInsufficientFunds_NoSharesAdded(){

    }
    @Test
    public void PersonalAccountSharePurchase_FundsDecrease(){

    }
    @Test
    public void TFSAAccountSharePurchase_FundsDecreaseTradeFeeApplied(){

    }
}
