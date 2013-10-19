package proj2fa13;

import java.util.Random;

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
        numCards = numDecks * 52 + numJokers;
        cards = new Card[numCards];
        int counter = 0;            // times needed to loop deck creation
        int last = 0;               // remember last index
        while (counter < numDecks)
        {
            for (int i = last; i < last + 52; i++)
            {
                cards[i] = new Card(i - 52 * counter); // fix params for Card()
            }
            last += 52;
            counter++;
        }
        if (numJokers > 0)
        {
            for (int i = 0; i < numJokers; i++)
            {
                cards[last] = Card.createJoker();
                last++;
            }
        }
    }
    /**
     * shuffleDeck method -- places the cards in the deck in a random order
     */
    public void shuffleDeck() throws DeckException
    {
        Card temp;
        int ran1, ran2;
        if (numCards != 0) {
        	for (int i=0; i<numCards; i++)
            {
                ran1 = (int)(Math.random()*numCards);
                ran2 = (int)(Math.random()*numCards);
                temp = cards[ran1];
                cards[ran1] = cards[ran2];
                cards[ran2] = temp;
            }
        }
        else {
        	throw new DeckException("No cards to shuffle; the deck is empty!");
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
			throw new DeckException("No cards to deal; the deck is empty!");
		}
	}
    
    /**
     * cut -- simulates cutting the deck by generating a random number
     * in the appropriate range and using this number to determine the place
     * where the dec should be cut
     */
    public void cut() 
    {
    	if (numCards > 1)
        {
            Random rng = new Random();
            int cutIndex = (rng.nextInt(11) - 5) + (numCards / 2);  // variance of 5 from center
            if (numCards < 10)  // assume small decks can be cut perfectly
            {
                cutIndex = numCards/2;
            }

            Card[] cutDeck = new Card[numCards];

            // take top half and put it on the bottom
            for (int i = 0; i < numCards - cutIndex; i++)
            {
                cutDeck[i] = cards[cutIndex + i]; //set bottom
            }

            // take bottom half and put it after last index of cutDeck
            for (int i = numCards - cutIndex; i < numCards; i++)
            {
                cutDeck[i] = cards[i - (numCards - cutIndex)];  // cards[] starting from index 0
            }
            cards = cutDeck;
    	}
        else if (numCards == 1)
        {
            // do nothing
        }
        else
        {
    		throw new DeckException("No deck to cut; the deck is empty!");
    	}
    }
    
    public void putCardsInDeck(Card[] newCards) 
    {
    	if (numCards == 0)
        {
    		cards = newCards;
            numCards = newCards.length;
            newCards = new Card[newCards.length]; // set each element to null
    	}
        else
        {
    		throw new DeckException("Cards could not be stored in deck; the deck is not empty!");
    	}
    }
    
    public boolean isEmpty()
    {
        return numCards == 0;
    }
    
    public String toString() 
    {
        String output = "";
        for (int i = 0; i < numCards; i++)
        {
            output += "Card " + (i + 1) + ": " + cards[i].toString() + "\n";
        }
    	return output;
    }
}

