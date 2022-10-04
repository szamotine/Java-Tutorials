package StockSimulationTests;

import StockSimulation.Model.Account.Account;
import StockSimulation.Model.Account.Personal;
import StockSimulation.Model.Account.TFSA;
import StockSimulation.Model.Stock;
import StockSimulation.Model.Trade;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.*;

public class SellTests {
    //#region Member Declarations
    List<Account> accounts;
    Account personal;
    Account TFSA;
    List<Stock> stocks;
    static final double INITIAL_DEPOSIT = 1000;
    Stock FB;
    Stock AAPL;
    Stock GOOG;
    Stock TSLA;
    Trade sell;
    Trade buy;
    //#endregion

    @Before
    public void setup(){

        accounts = new ArrayList<>();
        personal = new Personal(INITIAL_DEPOSIT);
        TFSA = new TFSA(INITIAL_DEPOSIT);
        accounts.add(personal);
        accounts.add(TFSA);

        FB = new Stock(Stock.StockName.FB);
        AAPL = new Stock(Stock.StockName.AAPL);
        GOOG = new Stock(Stock.StockName.GOOG);
        TSLA = new Stock(Stock.StockName.TSLA);

        stocks = new ArrayList<>();
        stocks.add(FB);
        stocks.add(AAPL);
        stocks.add(GOOG);
        stocks.add(TSLA);

        //Initialize each stock price to 10
        for(Stock s : stocks){
            s.setPrice(10);
            //Set each account inventory to 10 of each stock
            for(Account a : accounts){
                a.addStock(s,10);
            }
        }

        sell = new Trade(FB, "sell", 5);
        buy = new Trade (AAPL, "buy", 5);

    }

    @Test
    public void Test_PersonalAccountPurchaseShare_SharesDecrease(){


        assertEquals(10,personal.getInventory(sell.getStock()) );
        assertTrue(personal.ExecuteTrade(sell));
        assertEquals(5, personal.getInventory(sell.getStock()));

    }
    @Test
    public void Test_TFSAAccountPurchaseShare_SharesIncrease(){

        assertEquals(10,TFSA.getInventory(sell.getStock()) );
        assertTrue(TFSA.ExecuteTrade(sell));
        assertEquals(5, TFSA.getInventory(sell.getStock()));


    }
    @Test
    public void SaleWithInsufficientShares_NoFundsAdded(){
        sell.setNumberOfShares(11);

        assertEquals(1000.00, TFSA.getFunds());
        assertEquals(10,TFSA.getInventory(sell.getStock()) );
        assertFalse(TFSA.ExecuteTrade(sell));
        assertEquals(10, TFSA.getInventory(sell.getStock()));
        assertEquals(1000.00, TFSA.getFunds());

        assertEquals(1000.00, personal.getFunds());
        assertEquals(10,personal.getInventory(sell.getStock()) );
        assertFalse(personal.ExecuteTrade(sell));
        assertEquals(10, personal.getInventory(sell.getStock()));
        assertEquals(1000.00, personal.getFunds());

    }
    @Test
    public void Personal_AccountShareSale_FundsIncreaseTradeFeeApplied(){

    }
    @Test
    public void TFSA_AccountShareSale_FundsIncreaseTradeFeeApplied(){

    }


}
