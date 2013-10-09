package stacks;
import exceptionclasses.StackException;

/**
 * <p>Title: The LinkedStack Class</p>
 *
 * <p>Description: Defines the properties and behaviors of a basic stack
 * implemented using a linked list.</p>
 *
 * @author Marvin Yan, Jobar Saddler
 */
public class LinkedStack<E> implements StackADT<E> {

	protected Node<E> top;

	/**
	 * default constructor - creates an empty stack
	 */
	public LinkedStack()
	{
		top = null;
	}

	/**
	 * push method - stores a new item on the top of the stack
	 * @param item a reference to the item to be stored on top of the stack
	 */
	public void push (E element)
	{
		top = new Node<E>(element, top);
	}

	/**
	 * pop method - removes the top-most item from the stack
	 * @return a reference to the item which was stored on top of the stack
	 * @throws StackException if the stack is empty
	 */
	public E pop()
	{
		if (isEmpty())
			throw new StackException("Stack is empty!");

		E result = top.getItem();
		top = top.getNext();

		return result;
	}

	/**
	 * peek method - returns the top-most item on the stack without removing it
	 * @return a reference to the item which is stored on top of the stack
	 * @throws StackException if the stack is empty
	 */    
	public E peek()
	{
		if(isEmpty())
			throw new StackException("Stack is empty!");
		else
			return top.getItem();
	}

	/**
	 * isEmpty method - determines whether or not the stack is empty
	 * @return true if the stack is empty; false if the stack is not empty
	 */
	public boolean isEmpty()
	{
		return (top == null);
	}

	/**
	 * size method - returns a count of the number of items in the stack
	 * @return the number of items in the stack
	 */
	public int size()
	{
		int size = 0;
		Node<E> current;
		current = top;
		while(current != null)
		{
			current = current.getNext();
			size++;
		}
		return size;
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
		Node<E> current;
		current = top;
		int counter = 1;
		while((current != null) &&(current.getNext() != null) && (!current.getItem().equals(target)))
		{
			current = current.getNext();
			counter++;
		}

		if((current != null) && current.getItem().equals(target))
			return counter;
		else
			return -1;
	}

	/**
	 * toString method - returns a String representing the state of the stack
	 * @return a string containing all items in the stack
	 */
	public String toString()
	{
		Node<E> current;
		current = top;
		String output = "";
		while(current != null)
		{
			output += (current.getItem() + "\n");
			current = current.getNext();
		}
		return output;
	}
}

