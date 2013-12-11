package lab11;

public interface OrderedListADT<E>
{
	/** Returns the number of items in the list */
	public int size();
	
	/** Returns whether the list is empty */
	public boolean isEmpty();
	
	/** Inserts the item at its appropriate location */
	public void add(E item);
	
	/** Returns a string representation of this list. */
	public String toString();
}

