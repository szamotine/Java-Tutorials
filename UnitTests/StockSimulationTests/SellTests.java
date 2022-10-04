package StockSimulationTests;

import StockSimulation.Model.Account.Account;
import StockSimulation.Model.Account.Personal;
import StockSimulation.Model.Account.TFSA;
import StockSimulation.Model.Stock;
import StockSimulation.Model.Trade;
import org.junit.Before;

import java.util.ArrayList;
import java.util.List;

public class SellTests {
    List<Account> accounts;
    Account personal;
    Account tfsa;
    List<Stock> stocks;
    static final double INITIAL_DEPOSIT = 1000;
    Stock FB;
    Stock AAPL;
    Stock GOOG;
    Stock TSLA;
    Trade sell;
    Trade buy;

    @Before
    public void setup(){

        accounts = new ArrayList<>();
        personal = new Personal(INITIAL_DEPOSIT);
        tfsa = new TFSA(INITIAL_DEPOSIT);
        accounts.add(personal);
        accounts.add(tfsa);

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
}
