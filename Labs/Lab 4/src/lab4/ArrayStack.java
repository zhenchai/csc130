package stacks;
import exceptionclasses.*;

/**
 * <p>Title: The Stack Class</p>
 *
 * <p>Description: Defines the properties and behaviors of a basic stack.</p>
 *
 * @author Darel Dumont, Marvin Yan
 */
public class ArrayStack<E> implements StackADT<E>
{
	/**
	 * items - a reference to an Object array; the array contains the stack items
	 */
	protected E[] contents;
	/**
	 * top - an index to the top-most item in the stack
	 */
	protected int top;

	/**
	 * default constructor - creates an empty stack capable of storing at most 10 items
	 */
	@SuppressWarnings("unchecked")
	public ArrayStack()
	{
		contents = (E[]) (new Object[20]);
		top = -1;
	}

	/**
	 * parameterized constructor - creates a stack whose initial size
	 * is specified by the user
	 */
	@SuppressWarnings("unchecked")
	public ArrayStack(int size)
	{
		contents = (E[]) (new Object[size]);
		top = -1;
	}

	/**
	 * push method - stores a new item on the top of the stack
	 * @param item a reference to the item to be stored on the top of the stack
	 */
	public void push(E item)
	{
		if (top < contents.length-1)
		{			
			top++;
			contents[top] = item;
		}
	}

	/**
	 * pop method - removes the top-most item from the stack
	 * @return a reference to the item which was stored on top of the stack
	 * @throws StackException if the stack is empty
	 */
	public E pop() throws StackException
	{
		if (isEmpty())
			throw new StackException("The stack is empty.");
		E topItem = contents[top];
		contents[top] = null;
		top--;
		return topItem;
	}

	/**
	 * peek method - returns the top-most item on the stack without removing it
	 * @return a reference to the item which is stored on top of the stack
	 * @throws StackException if the stack is empty
	 */    
	public E peek() throws StackException
	{
		if (isEmpty())
			throw new StackException("The stack is empty.");

		return contents[top];
	}

	/**
	 * isEmpty method - determines whether or not the stack is empty
	 * @return true if the stack is empty; false if the stack is not empty
	 */
	public boolean isEmpty()
	{
		return top == -1;
	}

	/**
	 * size method - returns a count of the number of items in the stack
	 * @return the number of items in the stack
	 */
	public int size()
	{
		return top + 1;
	}

	/**
	 * search method - returns the 1-based position where an item is on the stack.
	 * If the item is on the stack, the method returns the distance from the top 
	 * of the stack; the topmost item on the stack is considered to be at distance
	 * 1. The equals method is used to compare target to the items on the stack. 
	 * @param target a reference to the item to search for
	 * @return the 1-based position from the top of the stack where the item 
	 * is located; returns -1 if the item is not on the stack
	 */
	public int search(E target)
	{
		int found = -1;
		
		for(int i = top; i>-1;i--)
			if(contents[i].equals(target))
				found = top - i + 1;
		
		return found;
	}

	/**
	 * toString method - returns a String representing the state of the stack
	 * @return a string containing all items in the stack, in order from top to bottom
	 */
	public String toString()
	{
		String str = "";
		for(int i = top; i > -1; i--)
			str += contents[i].toString() + "\n";
		return str;
	}
}
