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
     *
     * @param symbols a SymbolTable object
     */
    public Portfolio(SymbolTable symbols)
    {
        stocks = new ArrayIndexList<Stock>();
        this.symbols = symbols;
    }

    public void processTransaction(char action, int quantity, double price, String symbol)
    {
        String transactionInfo = "";
        transactionInfo +=
            "+-----TRANSACTION IN PROGRESS-----+\n" +
            "|                                 |\n" +
            "+     Pre-transaction Portfolio   +\n" +
            toString() +
            "+                                 +\n" +
            "|                                 |\n";
        // note to self: '' -> char, "" -> string
        if (action == 'b')
        {
            stocks.add(stocks.size(), new Stock(quantity, price, symbol));
            // clarify meaning of worth...
            worth += quantity * price;

            // output
            transactionInfo +=
                "+---------------BUY---------------+\n" +
                symbols.findCompany(symbol) + "(" + symbol + ")\n" +
                "Shares Bought: " + quantity + "\n" +
                "Price: " + price + "\n" +
                "+---------------------------------+\n" +
                "|                                 |\n" +
                "+    Post-transaction Portfolio   +\n" +
                toString() +
                "+                                 +\n" +
                "|                                 |\n" +
                "+---------END TRANSACTION---------+\n";

        }
        else if (action == 's')
        {
        }
        else
        {
            throw new InvalidSaleException("Invalid transaction type!");
        }
        System.out.println(transactionInfo);
    }

    public String toString()
    {
        String output = "";
        for (int i = 0; i < stocks.size(); i++)
        {
            output += stocks.get(i).toString() + "\n";
        }
        return output;
    }
}
