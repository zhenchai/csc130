package proj2fa13;

/**
 * <p>Title: The Deck class</p>
 *
 * <p>Description: This class represents a Deck of 52 playing cards.  It
 * gets created in order and then must be shuffled to randomize the order of
 * the cards.  Cards are dealt from the top of the deck.</p>
 * 
 * @author Instructor and Marvin Yan
 */
public class Deck 
{
	//instance variables
    private Card[] cards;
    private int numCards;

    /**
     * default constructor which creates the deck of 52 cards (without Jokers) in order
     */
    public Deck()
    {
        numCards = 52;
        cards = new Card[numCards];
        for (int i=0; i<cards.length;i++)
        {
            cards[i] = new Card(i);
        }
    }

    /**
     * parameterized constructor which creates a multi-deck Deck object that 
     * may contain jokers
     * @param numDecks number of decks
     * @param numJokers number of jokers
     */
    public Deck(int numDecks, int numJokers)
    {
    	
    }
    /**
     * shuffleDeck method -- places the cards in the deck in a random order
     */
    public void shuffleDeck() throws DeckException
    {
        Card temp;
        int ran1, ran2;
        numCards = cards.length;
        if (numCards != 0) {
        	for (int i=0; i<100; i++)
            {
                ran1 = (int)(Math.random()*numCards);
                ran2 = (int)(Math.random()*numCards);
                temp = cards[ran1];
                cards[ran1] = cards[ran2];
                cards[ran2] = temp;
            }
        }
        else {
        	throw new DeckException("No cards to shuffle; the deck is empty.");
        }
    }
    
    /**
     * dealCard -- deals the top card from the deck and decreases the number
     * of cards in the deck by 1
     * @return a reference to the Card being dealt
     */
    public Card dealCard() throws DeckException
    {
		if (numCards > 0) {
			numCards--;
			return cards[numCards];
		} else {
			throw new DeckException("No cards to deal; the deck is empty.");
		}
	}
    
    /**
     * cut -- simulates cutting the deck by generating a number close to 1/2 
     * the deck size
     */
    public void cut() 
    {
    	if (numCards > 0) {
    		// RNG
    	} else {
    		throw new DeckException("No deck to cut; the deck is empty.");
    	}
    }
    
    public void putCardsInDeck(Card[] newCards) 
    {
    	if (numCards == 0) {
    		shuffleDeck();
    	} else {
    		throw new DeckException("Cards could not be stored in deck; the deck is not empty.");
    	}
    }
    
    public boolean isEmpty()
    {
    	if (numCards == 0) {
    		return true;
    	} else {
    		return false;
    	}
    }
    
    public String toString() 
    {
    	return null;
    }
}

