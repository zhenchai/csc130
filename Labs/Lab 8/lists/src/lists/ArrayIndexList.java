package lists;

import exceptionclasses.IndexOutOfBoundsException;

/**
 * <p>Title: ArrayIndexList.java</p>
 *
 * <p>Description: Represents an array implementation of an indexed list. The front of
 * the list is kept at array index 0.</p>
 * 
 */
public class ArrayIndexList<E> implements IndexListADT<E> 
{
	private E[] contents;
	private int count;

	/**
	 * default constructor --
	 * Creates an empty list using the default capacity.
	 */
	@SuppressWarnings("unchecked")
	public ArrayIndexList()
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
	public ArrayIndexList (int initialCapacity)
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
	 * Inserts the item at index pos, shifting to make room
	 * @param pos the position where the item should be inserted
	 * @param item a reference to the item to be added to the list 
	 * @throws IndexOutOfBoundsException if pos is invalid; pos is expected
	 * to be in the range 0-count
	 *
	 * @author Chris & David
	 */
	public void add(int pos, E item)
	{
		if (count == contents.length)
		{
			expandCapacity();
		}
		if (pos>=0 && pos<=count)
		{
			int i = count;
			while (i > pos)
			{
				contents[i] = contents[i-1];
				i--;
			}
			contents[pos] = item;
			count++;
		}
		else
			throw new IndexOutOfBoundsException("Could not add item outside of bounds.");
	}
	/** 
	 * get --
	 * Returns the item at index pos without removing it
	 * @param pos the position where the item is stored
	 * @return a reference to the item at index pos
	 * @throws IndexOutOfBoundsException if pos is invalid; pos is expected
	 * to be in the range 0-(count-1)
         *
	 * @author Chris & David
	 */
	public E get(int pos)
	{
		if (pos<=count && pos>=0)
			return contents[pos];
		else
			throw new IndexOutOfBoundsException("Could not get index out of bounds.");
	}

	/** 
	 * remove --
	 * Removes the item at index pos, shifting to fill the void
	 * @param pos the position where the item to be removed is stored
	 * @return a reference to the item removed from index pos
	 * @throws IndexOutOfBoundsException if pos is invalid; pos is expected
	 * to be in the range 0-(count-1)
	 */
	public E remove (int pos)
	{
		return null;
	}

	/** 
	 * set --
	 * Replaces the item at index pos with newItem, returning 
	 * the item previously stored there
	 * @param pos the position where newItem should be stored
	 * @param newItem a reference to the item to be stored in the list 
	 * @return a reference to the item previously stored at index pos
	 * @throws IndexOutOfBoundsException if pos is invalid; pos is expected
	 * to be in the range 0-(count-1)
	 */
	public E set (int pos, E newItem)
	{
		return null;
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

	/**
	 * toString --
	 * prints out the contents array in the correct order
	 * 
	 * @return a string containing the contents of contents[]
	 */
	public String toString()
	{
		String output = "";
		for(int i = 0; i < count; i++)
		{
			output += (contents[i] + "\n");
		}
		return output;
	}
}
