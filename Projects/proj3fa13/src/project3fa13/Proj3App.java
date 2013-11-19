package project3fa13;

import exceptionclasses.InvalidSaleException;

import java.io.File;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Title: Proj3App.java
 * Description: The application class creates a SymbolTable object and a Portfolio object. Transactions in
 * "stockdata.txt" are processed.
 */
public class Proj3App
{
    public static void main(String args[]) throws Exception
    {
        File symbolDataFile = new File("symboldata.txt");
        File stockDataFile = new File("stockdata.txt");
        SymbolTable symbolData = new SymbolTable(symbolDataFile);

        Portfolio myPortfolio = new Portfolio(symbolData);
        Scanner fileScan = new Scanner(stockDataFile);
        String[] splitLine;

        DecimalFormat df = new DecimalFormat("$###,##0.00");

        while (fileScan.hasNextLine())
        {
            System.out.println("+------Beginning transaction------+\n\n" +
                    "Pre-Transaction Portfolio:\n" +
                    myPortfolio.toString());

            splitLine = fileScan.nextLine().split(" ", 4);

            char action = splitLine[0].charAt(0);
            int quantity = Integer.parseInt(splitLine[1]);
            double price = Double.parseDouble(splitLine[2]);
            String symbol = splitLine[3];

            if (action == 'b')
            {
                System.out.println("+--------------BUY----------------+\n" +
                        symbolData.findCompany(symbol) + "\n" +
                        "Price per share: " + df.format(price) + "\n" +
                        "Shares to be bought: " + quantity + "\n" +
                        "+---------------------------------+\n");
            }
            else
            {
                System.out.println("+-------------SELL----------------+\n" +
                        symbolData.findCompany(symbol) + "\n" +
                        "Price per share: " + df.format(price) + "\n" +
                        "Shares to be sold: " + quantity + "\n" +
                        "+---------------------------------+\n");
            }

            try
            {
                myPortfolio.processTransaction(action, quantity, price, symbol);
            }
            catch (InvalidSaleException ex)
            {
                System.out.println(ex.getMessage());
            }

            System.out.println("Post-Transaction Portfolio:\n" +
                    myPortfolio.toString() +
                    "\n+--------Ending transaction-------+\n");
        }
    }
}
