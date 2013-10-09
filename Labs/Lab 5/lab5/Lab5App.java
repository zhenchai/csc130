package lab5;

import stacks.LinkedStack;
import exceptionclasses.StackException;

/**
 * <p>Title: Lab5Apps</p>
 *
 * <p>Descrioption: Tests the LinkedStack class and handles its exceptions. Creates a LinkedStack of 
 * Cards for manipulation./p>
 *
 * @author Marvin Yan, Jobar Saddler
 */

public class Lab5App 
{
	public static void main(String[] args)
	{
		LinkedStack<Card> theStack = new LinkedStack<Card>();
		LinkedStack<Card> anotherStack = new LinkedStack<Card>();


		theStack.push(new Card(18));
		theStack.push(new Card(3));
		theStack.push(new Card(34));
		theStack.push(new Card(28));
		theStack.push(new Card(9));
		theStack.push(new Card(36));

		System.out.println("theStack now contains:\n" + theStack.toString());

		System.out.println("Topmost item: " + theStack.peek());
		System.out.println("theStack now contains:\n" + theStack.toString());

		System.out.println("Testing peek on anotherStack:");
		try
		{
			anotherStack.peek();
		}

		catch(StackException ex)
		{
			System.out.println("StackException: " + ex.getMessage());
		}

		System.out.println("\nThe size of theStack: " + theStack.size());
		System.out.println("The size of anotherStack: " + anotherStack.size());

		System.out.println("\ntheStack now contains:\n" + theStack.toString());

		System.out.println("anotherStack now contains:\n" + anotherStack.toString());

		System.out.println("Searching for the 10 of hearts. It was found at position: " + theStack.search(new Card(36)));
		System.out.println("Searching for the 2 of hearts. It was found at position: " + theStack.search(new Card(28)));
		System.out.println("Searching for the 5 of Diamonds. It was found at position: " + theStack.search(new Card(18)));
		System.out.println("Searching for the 1 of Diamonds. It was found at position: " + theStack.search(new Card(14)));
		System.out.println("Searching for the 1 of Diamonds in anotherStack. It was found at position: " + anotherStack.search(new Card(14)));

		Card current;
		LinkedStack<Card> temp = new LinkedStack<Card>();
		int size = theStack.size();

		for(int i=0; i<size;i++)
		{
			current = theStack.pop();
			if(current.getValue() != 2)
			{
				temp.push(current);
			}
		}

		size = temp.size();
		for(int i=0;i<size;i++)
			theStack.push(temp.pop());

		System.out.println("\ntheStack now contains:\n" + theStack);

	}

}
