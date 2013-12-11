package lab11;

import exceptionclasses.*;

/**
 * <p>Title: ArrayIndexList.java</p>
 *
 * <p>Description: Represents an array implementation of an indexed list. The front of
 * the list is kept at array index 0.</p>
 * 
 */
public class ArrayOrderedList<E> implements OrderedListADT<E> 
{
	private E[] contents;
	private int count;

	/**
	 * default constructor --
	 * Creates an empty list using the default capacity.
	 */
	@SuppressWarnings("unchecked")
	public ArrayOrderedList()
	{
		count = 0;
		contents = (E[])(new Object[100]);
	}

	/**
	 * parameterized constructor --
	 * Creates an empty list using the specified capacity.
	 * @param initialCapacity the initial size of the list as specified by the user
	 */
	@SuppressWarnings("unchecked") 
	public ArrayOrderedList (int initialCapacity)
	{
		count = 0;
		contents = (E[])(new Object[initialCapacity]);
	}

	/** 
	 * size -- 
	 * Returns the number of items in the list 
	 * @return count
	 */
	public int size()
	{
		return count;
	}

	/** 
	 * isEmpty --
	 * Returns whether the list is empty
	 * @return true if the list is empty; false otherwise 
	 */
	public boolean isEmpty()
	{
		return count == 0;
	}
	
	/**
	 * add --
	 * adds the specified Comparable item to this list, keeping
	 * the elements in sorted order.
	 * @param newItem a reference to the new item to be added to the list  
	 */
	@SuppressWarnings("unchecked")
	public void add(E newItem)
	{
		if (size() == contents.length)
			expandCapacity();

		Comparable<E> temp = (Comparable<E>) newItem;
		int i = 0;
		while (i < count && temp.compareTo(contents[i]) > 0)
			i++;
  
		for (int j=count; j > i; j--)
			contents[j] = contents[j-1];
  
		contents[i] = newItem;
		count++;
	}

	/**
	 * contains --
	 * Determines the position of the specified item. 
	 * @param target a reference to the item to locate
	 * @return the index of the specified target if it is found; -1 if it
	 * is not found
	 */
	@SuppressWarnings("unchecked")
	public boolean contains(E target)
	{
		int i = 0;
		while(i < count && ((Comparable <E>)target).compareTo(contents[i]) > 0)
		{
			i++;
		}
		if(i == count || ((Comparable <E>)contents[i]).compareTo(target) != 0)
			return false;
		else 
			return true;
	}
	
	/**
	 * binSearch --
	 * locates and returns the target from the list if it is found
	 * @param target a reference to an "initialized" item containing a value
	 * for the key-field
	 * @return a reference to the item from the list if found
	 * @throws an EmptyCollection if the list is empty
	 * @throws an ElementNotFoundException if the target is not found
	 */
	@SuppressWarnings("unchecked")
	public E binSearch(E target)
	{
		if (isEmpty())
			throw new EmptyListException("List is empty!");

		int first = 0, last = count-1;
		int midpoint = 0;
		boolean found = false;

		Comparable<E> temp = (Comparable<E>) target;

		while (first <= last && !found)
		{
			midpoint = (first + last) / 2;

			if (temp.compareTo(contents[midpoint]) == 0)
				found = true;
			else if (temp.compareTo(contents[midpoint]) < 0)
				last = midpoint - 1;
			else 
				first = midpoint + 1;
		}

		if (!found)
			throw new ItemNotFoundException("Item not found!");

		return contents[midpoint];

	}
	
	/**
	 * recursiveBinSearch --
	 * calls the private recursive method to locate and return the target
	 * from the list if it is found
	 * @param target a reference to an "initialized" item containing a value
	 * for the key-field
	 * @return a reference to the item from the list if found
	 * @throws an EmptyListException if the list is empty
	 * @throws an ItemNotFoundException if the target is not found
	 */
	public E recursiveBinSearch(E target)
	{
		if (isEmpty())
			throw new EmptyListException("List is empty!");

		return recBinSearch(target, 0, count-1);
	}

	/**
	 * recBinSearch --
	 * locates and returns the target from the list if it is found; the 
	 * method searches the subset of items from first to last
	 * @param target a reference to an "initialized" item containing a value
	 * for the key-field
	 * @param first the index of the first item in the current subset
	 * @param last the index of the last item in the current subset
	 * @return a reference to the item from the list if found
	 * @throws an ItemNotFoundException if the target is not found
	 */
	@SuppressWarnings("unchecked")
	private E recBinSearch(E target, int first, int last)
	{
	    int midpoint = (first + last) / 2;
	    Comparable<E> temp = (Comparable<E>) target;
	    
	    if (first > last)
	    {
	        throw new ItemNotFoundException("Item not found!");
	    }
	    
	    if (temp.compareTo(contents[midpoint]) == 0)
	    {
	        return contents[midpoint];
	    }
	    else if (temp.compareTo(contents[midpoint]) < 0)
	    {
	        return recBinSearch(target, first, midpoint - 1);
	    }
	    else
	    {
	        return recBinSearch(target, midpoint + 1, last);
	    }
	}
	
	/**
	 * toString --
	 * returns a string representation of this list.
	 * @return a reference to a String containing the items in the list
	 */
	public String toString()
	{
		String temp = new String();
		for (int i=0; i<count; i++)
		{
			temp += contents[i].toString() + "\n";
		}
		return temp;
	}

	/**
	 * expandCapacity --
	 * creates a new array to store the contents of this list with
	 * twice the capacity of the old one.
	 */
	@SuppressWarnings("unchecked")
	protected void expandCapacity()
	{
		E[] larger = (E[])(new Object[contents.length*2]);

		for (int i=0; i < count; i++)
			larger[i] = contents[i];

		contents = larger;
	}
}

