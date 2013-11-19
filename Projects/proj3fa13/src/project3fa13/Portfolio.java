package project3fa13;

import exceptionclasses.InvalidSaleException;
import lists.ArrayIndexList;

import java.text.*;

/**
 * Title: Portfolio.java
 * Description: Contains the methods for creating a Portfolio object, processing transactions and displaying the
 * contents of the portfolio.
 */
public class Portfolio
{
    private ArrayIndexList<Stock> stocks;
    private SymbolTable symbols;
    private double worth;

    /**
     * parameterized constructor --
     * Creates a Portfolio object with specified SymbolTable
     *
     * @param symbols a SymbolTable object
     */
    public Portfolio(SymbolTable symbols)
    {
        stocks = new ArrayIndexList<Stock>();
        this.symbols = symbols;
    }

    /**
     * processTransaction -- updates the contents and order of the stocks array when shares are bought or sold by
     * updating or removing array contents
     *
     * @param action   the type of transaction (buy or sell)
     * @param quantity the number of shares bought or sold
     * @param price    the price per share of the stock
     * @param symbol   the ticker symbol of the stock
     */
    public void processTransaction(char action, int quantity, double price, String symbol)
    {
        if (action == 'b')
        {
            stocks.add(stocks.size(), new Stock(quantity, price, symbol));
            worth -= quantity * price;
        }
        else
        {
            if (stocks.size() == 0)
            {
                throw new InvalidSaleException("Portfolio is empty!");
            }
            // determine total number of shares of the stock
            int totalQuantity = 0;
            for (int i = 0; i < stocks.size(); i++)
            {
                Stock currentStock = stocks.get(i);
                if (currentStock.getTickerSymbol().equals(symbol))
                {
                    totalQuantity += currentStock.getSharesOwned();
                }
            }
            // throw ISE if trying to sell more shares than owned
            if (quantity > totalQuantity)
            {
                throw new InvalidSaleException("Could not sell " + quantity + " shares of " + symbols.findCompany
                        (symbol) + ":\nInsufficient shares for sale!\n");
            }

            // remove shares of one price until 0 before checking for next price
            int tempQuantity = quantity;
            for (int i = 0; i < stocks.size(); i++)
            {
                Stock currentStock = stocks.get(i);
                if (currentStock.getTickerSymbol().equals(symbol))
                {
                    while (tempQuantity != 0 && currentStock.getSharesOwned() != 0)
                    {
                        currentStock.setSharesOwned(currentStock.getSharesOwned() - 1);
                        tempQuantity--;
                    }
                    if (currentStock.getSharesOwned() == 0)
                    {
                        stocks.remove(i);
                        i--; // compensate for array shift
                    }
                }
            }
            worth += quantity * price;
        }
    }

    /**
     * toString -- prints out the contents of stocks in the correct order
     *
     * @return a string containing the contents of stocks
     */
    public String toString()
    {
        DecimalFormat df = new DecimalFormat("$###,##0.00");
        String output = "\n";
        for (int i = 0; i < stocks.size(); i++)
        {
            output += symbols.findCompany(stocks.get(i).getTickerSymbol()) + "\n" +
                    stocks.get(i).toString() + "\n\n";
        }
        return output + "\n" + "Net profit: " + df.format(worth) + "\n";
    }
}
