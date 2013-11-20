package lists;

import exceptionclasses.IndexOutOfBoundsException;

/**
 * Title: ArrayIndexList.java
 * Description: Represents an array implementation of an indexed list. The front of the list is kept at array index 0.
 */
public class ArrayIndexList<E> implements IndexListADT<E>
{
    private E[] contents;
    private int count;

    /**
     * default constructor -- Creates an empty list using the default capacity.
     */
    @SuppressWarnings("unchecked")
    public ArrayIndexList()
    {
        count = 0;
        contents = (E[]) (new Object[100]);
    }

    /**
     * parameterized constructor -- Creates an empty list using the specified capacity.
     *
     * @param initialCapacity the initial size of the list as specified by the user
     */
    @SuppressWarnings("unchecked")
    public ArrayIndexList(int initialCapacity)
    {
        count = 0;
        contents = (E[]) (new Object[initialCapacity]);
    }

    /**
     * size -- Returns the number of items in the list
     *
     * @return count
     */
    public int size()
    {
        return count;
    }

    /**
     * isEmpty -- Returns whether the list is empty
     *
     * @return true if the list is empty; false otherwise
     */
    public boolean isEmpty()
    {
        return count == 0;
    }

    /**
     * add -- Inserts the item at index pos, shifting to make room
     *
     * @param pos  the position where the item should be inserted
     * @param item a reference to the item to be added to the list
     * @throws IndexOutOfBoundsException if pos is invalid; pos is expected to be in the range 0-count
     */
    public void add(int pos, E item)
    {
        if (pos < 0 || pos > count)
        {
            throw new IndexOutOfBoundsException("Could not add item outside of bounds!");
        }

        if (count == contents.length)
        {
            expandCapacity();
        }
        else
        {
            for (int i = count; i > pos; i--)
            {
                contents[i] = contents[i - 1];
            }
            contents[pos] = item;
            count++;
        }
    }

    /**
     * get -- Returns the item at index pos without removing it
     *
     * @param pos the position where the item is stored
     * @return a reference to the item at index pos
     * @throws IndexOutOfBoundsException if pos is invalid; pos is expected to be in the range 0-(count-1)
     */
    public E get(int pos)
    {
        if (pos < 0 || pos >= count)
        {
            throw new IndexOutOfBoundsException("Could not get index out of bounds!");
        }

        return contents[pos];
    }

    /**
     * remove -- Removes the item at index pos, shifting to fill the void
     *
     * @param pos the position where the item to be removed is stored
     * @return a reference to the item removed from index pos
     * @throws IndexOutOfBoundsException if pos is invalid;
     * pos is expected to be in the range 0-(count-1)
     */
    public E remove(int pos)
    {
        if (pos < 0 || pos >= count)
        {
            throw new IndexOutOfBoundsException("Invalid removal position!");
        }

        E removedItem = contents[pos];
        for(int i = pos; i < count - 1; i++)
        {
            contents[i] = contents[i + 1];
        }
        if (pos == count - 1)
	{
	    contents[count - 1] = null;
  	}
        count--;
        return removedItem;
    }

    /**
     * set -- Replaces the item at index pos with newItem, returning the item previously stored there
     *
     * @param pos     the position where newItem should be stored
     * @param newItem a reference to the item to be stored in the list
     * @return a reference to the item previously stored at index pos
     * @throws IndexOutOfBoundsException if pos is invalid; pos is expected to be in the range 0-(count-1)
     */
    public E set(int pos, E newItem)
    {
        if (pos < 0 || pos >= count)
        {
            throw new IndexOutOfBoundsException("Invalid setting position!");
        }

        E temp = contents[pos];
        contents[pos] = newItem;
        return temp;
    }

    /**
     * expandCapacity -- creates a new array to store the contents of this list with twice the capacity of the old one.
     */
    @SuppressWarnings("unchecked")
    protected void expandCapacity()
    {
        E[] larger = (E[]) (new Object[contents.length * 2]);

        for (int i = 0; i < count; i++)
        {
            larger[i] = contents[i];
        }

        contents = larger;
    }

    /**
     * toString -- prints out the contents array in the correct order
     *
     * @return a string containing the contents of contents[]
     */
    public String toString()
    {
        String output = "";
        for (int i = 0; i < count; i++)
        {
            output += (contents[i] + "\n");
        }
        return output;
    }
}
