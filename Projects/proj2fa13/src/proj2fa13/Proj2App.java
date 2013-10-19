package proj2fa13;

/**
 * <p>Title: The Proj2App class</p>
 *
 * <p>Description: This class is responsible for testing all class methods </p>
 *
 * @author Marvin Yan
 */
public class Proj2App {
	
	public static void main(String[] args)
    {
        System.out.println("Now testing Deck class...");
        Deck theDeck = new Deck();       // start with 52 cards
        Deck multiDeck = new Deck(2, 2); // start with 106 cards (2 decks + 2 jokers)
        Deck emptyDeck = new Deck();     // 0 cards
        Deck miniDeck = new Deck();      // start with 6 cards

        for (int i = 0; i < 52; i++)
        {
            emptyDeck.dealCard();
        }

        for (int i = 0; i < 46; i++)
        {
            miniDeck.dealCard();
        }

        // Default Deck constructor
        System.out.println("theDeck contains: \n" + theDeck.toString());
        // Parameterized Deck constructor
        System.out.println("multiDeck contains: \n" + multiDeck.toString());
        // An empty deck
        System.out.println("emptyDeck contains: \n" + emptyDeck.toString());
        // A deck with 1 card
        System.out.println("miniDeck contains: \n" + miniDeck.toString());

        // Normal shuffleDeck
        theDeck.shuffleDeck();
        System.out.println("theDeck after shuffling: \n" + theDeck.toString());

        // shuffleDeck on empty deck
        try
        {
            System.out.println("Trying shuffleDeck on emptyDeck...");
            emptyDeck.shuffleDeck();
            System.out.println("-----Error in shuffleDeck method!-----");
        }
        catch (DeckException ex)
        {
            System.out.println("DeckException: " + ex.getMessage() + "\n");
        }

        // shuffleDeck on 6 cards
        miniDeck.shuffleDeck();
        System.out.println("miniDeck after shuffling: \n" + miniDeck.toString());

        // Normal dealCard
        System.out.println("Dealing from theDeck: " + theDeck.dealCard());

        // dealCard on empty deck
        try
        {
            System.out.println("\nTrying dealCard on emptyDeck...");
            emptyDeck.dealCard();
            System.out.println("-----Error in dealCard method!-----");
        }
        catch (DeckException ex)
        {
            System.out.println("DeckException: " + ex.getMessage() + "\n");
        }

        // dealCard on 6 card deck
        System.out.println("Dealing from miniDeck: " + miniDeck.dealCard());

        // Normal cut
        theDeck.cut();
        System.out.println("\ntheDeck after cut: \n" + theDeck.toString());

        // cut on empty deck
        try
        {
            System.out.println("\nTrying cut on emptyDeck...");
            emptyDeck.cut();
            System.out.println("-----Error in cut method!-----");
        }
        catch (DeckException ex)
        {
            System.out.println("DeckException: " + ex.getMessage());
        }

        // cut on 5 card deck
        System.out.println("\nminiDeck before cut: \n" + miniDeck.toString());

        miniDeck.cut();
        System.out.println("miniDeck after cut: \n" + miniDeck.toString());

        // Normal putCardsInDeck
        Card[] someCards = new Card[3];
        someCards[0] = new Card(1);
        someCards[1] = new Card(2);
        someCards[2] = new Card(3);

        emptyDeck.putCardsInDeck(someCards);
        System.out.println("Adding 3 cards to emptyDeck...\n" + emptyDeck.toString());
        System.out.println("Trying putCardsInDeck on a non-empty deck...");
        try
        {
            emptyDeck.putCardsInDeck(someCards);
            System.out.println("-----Error in putCardsInDeck method!-----");
        }
        catch (DeckException ex)
        {
            System.out.println("DeckException: " + ex.getMessage() + "\n");
        }

        // restore emptyDeck to empty state
        for (int i = 0; i < 3; i++)
        {
            emptyDeck.dealCard();
        }

        // isEmpty on non-empty deck
        System.out.println("isEmpty on theDeck: " + theDeck.isEmpty());

        // isEmpty on empty deck
        System.out.println("isEmpty on emptyDeck: " + emptyDeck.isEmpty() + "\n");

        // Card class methods
        Card card1 = new Card(1);
        Card card2 = new Card(1);
        Card card3 = new Card(2);

        System.out.println("Now testing Card class...\n");
        System.out.println("card1 toString: " + card1.toString());
        System.out.println("card1's value: " + card1.getValue());
        System.out.println("card1's suit: " + card1.getSuit());
        System.out.println("card1 equal to card2: " + card1.equals(card2));
        System.out.println("card1 equal to card3: " + card1.equals(card3) + "\n");
        // createJoker tested in multiDeck constructor

        // DiscardPile methods
        System.out.println("Now testing DiscardPile class...\n");
        DiscardPile thePile = new DiscardPile();
        System.out.println("thePile's initial state: " + thePile.toString() + "\n");

        System.out.println("isEmpty on thePile: " + thePile.isEmpty() + "\n");

        // test addCard and expansion
        System.out.println("Add 5 cards to thePile (which can only hold 1 card)...\n");
        thePile.addCard(card1);
        thePile.addCard(card3);
        thePile.addCard(new Card(3));
        thePile.addCard(new Card(4));
        thePile.addCard(new Card(5));

        System.out.println("thePile now contains: \n" + thePile.toString());
        System.out.println("isEmpty on thePile: " + thePile.isEmpty() + "\n");

        // removeCard
        System.out.println("Removing top card from thePile: " + thePile.removeCard() + "\n");

        thePile.freeze();
        try
        {
            System.out.println("Removing top card from thePile when frozen: ");
            thePile.removeCard();
            System.out.println("-----Error in removeCard method!-----");
        }
        catch (DiscardPileException ex)
        {
            System.out.println("DiscardPileException: " + ex.getMessage() + "\n");
        }

        DiscardPile emptyPile = new DiscardPile();
        try
        {
            System.out.println("Removing top card from emptyPile: ");
            emptyPile.removeCard();
            System.out.println("-----Error in removeCard method!-----");
        }
        catch (DiscardPileException ex)
        {
            System.out.println("DiscardPileException: " + ex.getMessage() + "\n");
        }
        thePile.unfreeze();
        // removeCards
        System.out.println("Current state of thePile: \n" + thePile.toString() + "\n");

        System.out.println("Remove 2 cards from thePile...");
        thePile.removeCards(2);
        System.out.println("New state of thePile: \n" + thePile.toString());

        thePile.freeze();

        try
        {
            System.out.println("Remove 2 cards from frozen thePile: ");
            thePile.removeCards(2);
            System.out.println("-----Error in removeCards method!-----");
        }
        catch (DiscardPileException ex)
        {
            System.out.println("DiscardPileException: " + ex.getMessage() + "\n");
        }

        try
        {
            System.out.println("Remove 2 cards from emptyPile: ");
            emptyPile.removeCards(2);
            System.out.println("-----Error in removeCards method!-----");
        }
        catch (DiscardPileException ex)
        {
            System.out.println("DiscardPileException: " + ex.getMessage() + "\n");
        }

    }
}
