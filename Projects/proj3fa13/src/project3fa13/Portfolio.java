package project3fa13;

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

    }

    public String toString()
    {
        return null;
    }
}
