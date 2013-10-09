package lab5;

/**
 * <p>Title: The Card Class</p>
 *
 * <p>Description: Description: This class will represent a single playing card 
 * that has a value between 1 and 13 and a suit (clubs, diamonds, hearts or 
 * spades).  A card can return its value or its suit, determine if two cards
 * are the same or return a reference to a String containing the card’s value 
 * and suit.</p>
 */

public class Card
{
	/**
     * value - an integer between 1 - 13 representing the card
     */
    private int value;
    /**
     * suit - a String whose value is one of the four suits
     */
    private String suit;

    /**
     * parameterized Card constructor --
     * Gets called when an object of the Card class is instantiated sending a number 
     * as an argument -- it determines the value and suit of the card based upon the 
     * number received.
     * @param num a number that gets converted to a value between 1 and 13
     * and one of the four suits (clubs, diamonds, hearts, or spades)
     */
    public Card(int num)
    {
    	value = num % 13;
    	if (value == 0)
    		value = 13;
    	int s = num / 13;
    	if (s == 0)
    		suit = "clubs";
    	else if (s == 1)
    		suit = "diamonds";
    	else if (s == 2)
    		suit = "hearts";
    	else if (s == 3)
    		suit = "spades";
    	else
    		suit = "ERRROR";
    }

    /**
     * getValue method --
     * Returns what's stored in the instance variable value.
     * @return the state of the instance variable value
     */
    public int getValue()
    {
    	return value;
    }

    /**
     * getSuit method --
     * Returns what's stored in the instance variable suit.
     * @return a reference to a String that contains the state 
     * of the instance variable suit
     */
    public String getSuit()
    {
    	return suit;
    }

    /**
     * equals method --
     * Compares the values and suits of two card objects.
     * @param otherCard a reference to another Card object
     * @return true if both cards have the same value and suit; false otherwise
     */
    public boolean equals(Object otherCard)
    {
    	Card temp = (Card) otherCard;
    	return ((value == temp.value) && (suit.equals(temp.suit)));
    }

    /**
     * toString method --
     * Returns the state of the card object.
     * @return a reference to a String object that contains the values stored
     * in the instance variables
     */
    public String toString()
    {
    	return value + " of " + suit;
    }
}
