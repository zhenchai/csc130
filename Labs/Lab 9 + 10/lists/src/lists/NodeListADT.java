package lists;

public interface NodeListADT<E> {
	
	/**  Returns the number of items in this list. */
	public int size();

	/**  Returns true if this list is empty. */
	public boolean isEmpty();

	/**  Returns a reference to the first item in this list. */
	public E first ();

	/**  Returns a reference to the last item in this list. */
	public E last ();

	/**  Adds the specified item to the front of this list. */
	public void addToFront (E item);

	/**  Adds the specified item to the rear of this list. */
	public void addToRear (E item);

	/**  Adds the specified item after the specified target. */
	public void addAfter (E item, E target);
	
	/**  Adds the specified item at the specified location. */
	public void addAt (E item, int pos);

	/**  Removes and returns the item at the specified position from this list. */
	public E remove (int pos);
	
	/**  Removes and returns the specified item. */
	public E remove (E item);
	
	/** Replaces the item at position pos with newItem, returning 
	 * the item previously stored there */
	public E set (int pos, E newItem);
	
	/** Replaces the old item with the new item, returning the
	 * item previously stored */
	public E set (E oldItem, E newItem);
	
	/** Determines the number of times target is foudn within this list. */
	public int search(E target);
	
	/** Returns a string representing the current state of the list. */
	public String toString();
}
