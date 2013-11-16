package project3fa13;

import exceptionclasses.InvalidSaleException;
import lists.ArrayIndexList;

/**
 * Created with IntelliJ IDEA. User: Marvin Date: 11/16/13 Time: 12:10 AM To change this template use File | Settings |
 * File Templates.
 */
public class Portfolio
{
    private ArrayIndexList<Stock> stocks;
    private SymbolTable symbols;
    private double worth;

    /**
     * parameterized constructor --
     * Creates a Portfolio object with specified SymbolTable
     * @param symbols a SymbolTable object
     */
    public Portfolio(SymbolTable symbols)
    {
        this.symbols = symbols;
    }

    public void processTransaction(char action, int quantity, double price, String symbol)
    {
        // action = 'b' or 's', quantity = #, price = #, symbol = ""
        // note to self: '' -> char, "" -> string
        Stock current;
        boolean found = false;
        if (action == 'b')
        {
            for(int i = 0; i < stocks.size(); i++)
            {
                current = stocks.get(i);
                // update existing stock quantity if price matches
                if ((current.getTickerSymbol() == symbol) && (current.getPurchasePrice() == price))
                {
                    current.setSharesOwned(quantity + current.getSharesOwned());
                    found = true;
                }
            }
            // otherwise add as new stock
            if (!found)
            {
                stocks.add(stocks.size(), new Stock(quantity, price, symbol));
            }
            // portfolio value or capital gain/loss?
            worth += quantity * price;
        }
        else if (action == 's')
        {
            /*
            for(int i = 0; i < stocks.size(); i++)
            {
                current = stocks.get(i);
                if (current.getTickerSymbol() == symbol)
                {
                    current.setSharesOwned(current.getSharesOwned() - quantity);
                    found = true;
                }
            } */
        }
        else
        {
            throw new InvalidSaleException("Invalid transaction type!");
        }
    }

    public String toString()
    {
        String output = "";
        return output;
    }
}
