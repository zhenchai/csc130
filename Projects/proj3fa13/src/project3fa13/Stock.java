package project3fa13;

/**
 * Title: Stock.java
 *
 * Description: A Stock object will store a quantity, price, and name.
 * Accessors, mutators, and a toString are defined as well as an equals
 * method which overrides the equals method defined in the Object class.
 *
 */
public class Stock {
    private int sharesOwned;
    private double purchasePrice;
    private String tickerSym;

    /**
     * parameterized constructor --
     * Creates a Stock object with specified values
     * @param sharesOwned   quantity of stock owned
     * @param purchasePrice price at which the stock was bought
     * @param tickerSym     ticker symbol of stock
     */
    public Stock(int sharesOwned, double purchasePrice, String tickerSym)
    {
        this.sharesOwned = sharesOwned;
        this.purchasePrice = purchasePrice;
        this.tickerSym = tickerSym;
    }

    /**
     * getSharesOwned --
     * Returns the number of shares owned.
     * @return sharesOwned
     */
    public int getSharesOwned()
    {
        return sharesOwned;
    }

    /**
     * getPurchasePrice --
     * Returns the price at which the stock was bought.
     * @return purchasePrice
     */
    public double getPurchasePrice()
    {
        return purchasePrice;
    }

    /**
     * getTickerSymbol --
     * Returns the tickerSymbol of the stock
     * @return tickerSym
     */
    public String getTickerSymbol()
    {
        return tickerSym;
    }

    /**
     * setSharesOwned --
     * Changes the number of shares owned.
     */
    public void setSharesOwned(int quantity)
    {
        sharesOwned = quantity;
    }

    /**
     * toString --
     * Returns the ticker symbol, shares owned, and purchase price
     * @return a string containing tickerSym, sharesOwned, and purchasePrice
     */
    public String toString()
    {
        return tickerSym + " - " + "Quantity: " + sharesOwned + ", Purchase Price: " + purchasePrice;
    }
}
