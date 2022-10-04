package StockSimulation.Model.Account;

import StockSimulation.Model.Trade;

public class Personal extends Account {

    public Personal(double amount) {
        super(amount);
    }

    @Override
    public boolean ExecuteTrade(Trade trade) {

        if(trade.getType().equals(Trade.Type.MARKET_SELL)){
            trade.setTradeTax(0.05);
        }
        return super.ExecuteTrade(trade);
    }
}
