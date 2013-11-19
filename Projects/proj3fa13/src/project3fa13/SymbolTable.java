package project3fa13;

import lists.ArrayIndexList;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Title: SymbolTable.java
 * Description: Creates a symbol table using information read from a file and allows for ticker symbol lookup.
 */
public class SymbolTable
{
    private ArrayIndexList<SymbolPair> symbolPairs;

    /**
     * parameterized constructor -- Scans specified file and creates a SymbolTable object.
     *
     * @param symbolDataFile file containing ticker symbols and company names
     * @throws FileNotFoundException if file is not found
     */
    public SymbolTable(File symbolDataFile) throws FileNotFoundException
    {
        symbolPairs = new ArrayIndexList<SymbolPair>();
        Scanner fileScan = new Scanner(symbolDataFile);
        String[] splitLine;
        while (fileScan.hasNextLine())
        {
            /* http://stackoverflow.com/questions/5067942/what-is-the-best-way-to-extract-the-first-word-from-a-string-in-java
             First word = ticker symbol, rest of line = company name
             */
            splitLine = fileScan.nextLine().split(" ", 2);
            symbolPairs.add(symbolPairs.size(), (new SymbolPair(splitLine[0], splitLine[1].trim())));
        }
    }

    /**
     * findCompany -- Returns the ticker symbol's company name
     *
     * @param symbol the ticker symbol to be searched
     * @return the respective company name
     */
    public String findCompany(String symbol)
    {
        for (int i = 0; i < symbolPairs.size(); i++)
        {
            SymbolPair pair = symbolPairs.get(i);
            if (pair.getTickerSymbol().equals(symbol))
            {
                return pair.getCompanyName();
            }
        }
        return "Ticker symbol not recognized!";
    }
}
