package proj2fa13;

/**
 * <p>Title: The DiscardPile class</p>
 *
 * <p>Description: This class contains methods necessary for discard piles used in card games.</p>
 *
 * @author Marvin Yan
 */
public class DiscardPile 
{
	// instance variables
    private Card[] pile;
    private boolean frozen;
    private int top;

    public DiscardPile()
    {
        pile = new Card[1];  // to make testing easier
        frozen = false;
        top = -1;
    }

    public Card removeCard()
    {
        if (!frozen && top > -1)
        {
            Card removed = pile[top];
            pile[top] = null;
            top--;
            return removed;
        }
        else if (!frozen && top == -1)
        {
            throw new DiscardPileException("No cards to remove; the pile is empty!");
        }
        else
        {
            throw new DiscardPileException("Discard pile is frozen!");
        }
    }

    public Card[] removeCards(int numCards)
    {
        if (!frozen && size() >= numCards)
        {
            Card[] output = new Card[numCards];
            int counter = 0;
            while(counter != numCards)
            {
                output[counter] = removeCard();
                counter++;
            }
            return output;
        }
        else if (frozen)
        {
            throw new DiscardPileException("Discard pile is frozen!");
        }
        else
        {
            throw new DiscardPileException("Discard pile does not contain enough cards!");
        }
    }

    public void freeze()
    {
        frozen = true;
    }

    public void unfreeze()
    {
        frozen = false;
    }

    public void addCard(Card addedCard)
    {
        if (pile.length == top + 1)
        {
            Card[] temp = new Card[pile.length * 2];
            for (int i = 0; i < pile.length; i++)
            {
                temp[i] = pile[i];
            }
            pile = temp;
        }
        pile[top+1] = addedCard;
        top++;
    }

    public int size()
    {
        return top + 1;
    }

    public boolean isEmpty()
    {
        if (top == -1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public String toString()
    {
        int size = size();
        String output = "";
        if (size > 0)
        {
            for (int i = 0; i < size; i++)
            {
                output += "Card " + (i + 1) + ": " + pile[i].toString() + "\n";
            }
            return output;
        }
        else
        {
            return "Discard pile is empty";
        }
    }
}
