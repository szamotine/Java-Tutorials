package StockSimulation.Model.Account;

import StockSimulation.Model.Trade;

public class TFSA extends Account {

    public TFSA(double amount) {
        super(amount);
    }

    @Override
    public boolean ExecuteTrade(Trade trade) {

        if(trade.getType().equals(Trade.Type.MARKET_SELL)){
            trade.setTradeTax(0.01);
        }
        else{
            trade.setTradeTax(1.01);
        }

        return super.ExecuteTrade(trade);
    }
}
