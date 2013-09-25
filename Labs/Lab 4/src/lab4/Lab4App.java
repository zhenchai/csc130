package lab4;
import exceptionclasses.StackException;
import stacks.ArrayStack;

/**
 * <p>Title: Lab4App</p>
 *
 * <p>Description: </p>
 *
 * @author Darel Dumont, Marvin Yan
 */
public class Lab4App {
	public static void main(String[] args) throws StackException
	{
		ArrayStack<Card> theStack = new ArrayStack<Card>();
		ArrayStack<Card> anotherStack = new ArrayStack<Card>();
		ArrayStack<Card> thirdStack = new ArrayStack<Card>();

		theStack.push(new Card(18));
		theStack.push(new Card(3));
		theStack.push(new Card(34));
		theStack.push(new Card(28));
		System.out.println(theStack.toString());
		
		System.out.println("Item popped: " + theStack.pop());
		System.out.println("\ntheStack now contains: \n" + theStack.toString());
		
		try {
			System.out.println("Testing pop on anotherStack");
			anotherStack.pop();
		}
		catch(StackException s) {
			System.out.println("StackException: " + s.getMessage());
		}
		
		System.out.println("\nTopmost item: " + theStack.peek());
		System.out.println("\ntheStack now contains: \n" + theStack.toString());
		
		try {
			System.out.println("Testing peek on anotherStack");
			anotherStack.peek();
		}
		catch(StackException s) {
			System.out.println("StackException: " + s.getMessage());
		}
		
		System.out.println("\nSize of theStack: " + theStack.size());
		System.out.println(theStack.toString());
		System.out.println("\nSize of anotherStack: " + anotherStack.size());
		
		System.out.println("Searching for 8 of Hearts. It was found at position " + theStack.search(new Card(34)));
		System.out.println("Searching for 3 of Clubs. It was found at position " + theStack.search(new Card(3)));
		System.out.println("Searching for 5 of Diamonds. It was found at position " + theStack.search(new Card(18)));
		System.out.println("Searching for Ace of Diamonds. It was found at position " + theStack.search(new Card(14)));
		System.out.println("Searching for Ace of Diamonds in anotherStack. It was found at position " + theStack.search(new Card(14)));
		
		anotherStack.push(new Card(51));
		anotherStack.push(new Card(7));
		anotherStack.push(new Card(21));
		anotherStack.push(new Card(37));
		anotherStack.push(new Card(29));
		anotherStack.push(new Card(43));
		anotherStack.push(new Card(16));
		anotherStack.push(new Card(1));
		System.out.println("\nanotherStack now contains: \n" + anotherStack.toString());
		
		if (theStack.size() >= anotherStack.size())
		{
			while(!anotherStack.isEmpty())
			{
				thirdStack.push(theStack.pop());
				thirdStack.push(anotherStack.pop());
			}
			
			while(!theStack.isEmpty())
				thirdStack.push(theStack.pop());
		}
	
		else
		{
			while(!theStack.isEmpty())
			{
				thirdStack.push(anotherStack.pop());
				thirdStack.push(theStack.pop());
			}
			while(!anotherStack.isEmpty())
				thirdStack.push(anotherStack.pop());
		}
	
		System.out.println("\nThe thirdStack now contains: \n" + thirdStack.toString());
		
		Card[] theCards = new Card[thirdStack.size()];
		
		System.out.println("The following cards were removed and stored in the Card array");

		for(int i=0; i<theCards.length;i++ )
		{
			theCards[i] = thirdStack.pop();
			System.out.println(theCards[i].toString());
		}
		
		System.out.println("\nChallenge");
		ArrayStack<Card> chalStack = new ArrayStack<Card>(2);
		
		System.out.println("chalStack's size is: " + chalStack.getArrayLength());
		chalStack.push(new Card(1));
		chalStack.push(new Card(2));
		System.out.println(chalStack.toString());
		chalStack.push(new Card(3));
		System.out.println("chalStack's size is: " + chalStack.getArrayLength());
		System.out.println(chalStack.toString());

	}
}
