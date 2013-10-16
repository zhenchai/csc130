package proj2fa13;

/**
 * <p>Title: The Card class</p>
 *
 * <p>Description: This class represents a single playing card </p>
 * 
 * @author Instructor and Marvin Yan
 */
public class Card
{
	// instance variables
	private int value;
	private String suit;

	/**
	 * Card constructor --
	 * this constructor gets called when an object of the Card class
	 * is instantiated -- based upon the number received it determines the
	 * value and suit of the card
	 * @param num a number that gets converted to a value between 1 and 13
	 */
	public Card(int num)
	{
		int suitNumber;
		value = num % 13;
		if (value == 0)
			value = 13;
		suitNumber = num / 13;
		if (suitNumber == 0)
			suit = "clubs";
		else if (suitNumber == 1)
			suit = "diamonds";
		else if (suitNumber == 2)
			suit = "hearts";
		else if (suitNumber == 3)
			suit = "spades";
		else
			suit = "ERROR";
	}

	/**
	 * getValue method -- returns what's stored in the instance variable value
	 * @return the state of the instance variable value
	 */
	public int getValue()
	{
		return value;
	}

	/**
	 * getSuit method -- 
	 * returns what's stored in the instance variable suit
	 * @return a reference to a String that contains the state of the instance variable suit
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
	public boolean equals(Card otherCard)
	{
		return ((value == otherCard.value) && (suit.equals(otherCard.suit)));
	}
	
	/**
	 * createJoker method --
	 * Creates and returns a Joker
	 * @return a reference to a Card object with suit "joker"
	 */
	public static Card createJoker()
	{
		Card joker = new Card(-1);
		joker.suit = "joker";
		joker.value = -1;
		return joker;
	}
	
	/**
	 * toString method -- 
	 * returns the state of the card object as a string
	 * @return a reference to a String object that contains the values stored
	 * in the instance variables
	 */
	public String toString()
	{
		if (value == -1)
			return "Joker";
		else if (value == 1)
			return "Ace of " + suit;
		else if (value == 11)
			return "Jack of " + suit;
		else if (value == 12)
			return "Queen of " + suit;
		else if (value == 13)
			return "King of " + suit;
		else
			return value + " of " + suit;
	}
}

