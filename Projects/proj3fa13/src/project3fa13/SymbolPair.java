package project3fa13;

/**
 * Title: SymbolPair.java
 * Description: Contains a constructor for creating symbol pairs and accessor methods for retrieving the stored
 * strings.
 */
public class SymbolPair
{
    private String tickerSym;
    private String companyName;

    /**
     * parameterized constructor -- Creates a symbol pair using the specified names
     *
     * @param tickerSym   the ticker symbol
     * @param companyName the company name
     */
    public SymbolPair(String tickerSym, String companyName)
    {
        this.tickerSym = tickerSym;
        this.companyName = tickerSym;
    }

    /**
     * getTickerSymbol -- Returns the ticker symbol of the stock.
     *
     * @return the ticker symbol of the stock
     */
    public String getTickerSymbol()
    {
        return tickerSym;
    }

    /**
     * getCompanyName -- Returns the company name of the stock.
     *
     * @return the company name of the stock
     */
    public String getCompanyName()
    {
        return companyName;
    }
}
