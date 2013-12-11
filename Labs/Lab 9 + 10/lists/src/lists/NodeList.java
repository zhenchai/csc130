package lists;
import exceptionclasses.*;

/**
 * <p>Title: NodeList.java</p>
 *
 * <p>Description: Represents a linked implementation of a list. The front of
 * the list is referenced by contents.</p>
 *
 * @author Marvin Yan, Jobar Saddler
 */
public class NodeList<E> implements NodeListADT<E>
{
	private int count;
	private Node<E> contents;

	/**
	 * size --
	 * returns a count of the number of items in the list.
	 * @return the number of items currently in the list
	 */
	public int size()
	{
		return count;
	}

	/**
	 * isEmpty --
	 * determines whether or not the list is empty.
	 * @return true if this list is empty; false otherwise
	 */
	public boolean isEmpty()
	{
		return (count == 0);
	}

	/**
	 * first --
	 * returns a reference to the item at the front of the list. The item
	 * is not removed from the list.
	 * @return a reference to the first item in the list
	 * @throws EmptyListException if the list is empty
	 */
	public E first()
	{
		if (isEmpty())
			throw new EmptyListException ("List is empty!");

		return contents.getItem();
	}

	/**
	 * last -- 
	 * returns a reference to the item at the end of the list. The item
	 * is not removed from the list.
	 * @return a reference to the last item in the list
	 * @throws EmptyListException if the list is empty
	 */
	public E last()
	{
		if (isEmpty())
			throw new EmptyListException("List is empty!");

		Node<E> current = contents;
		while (current.getNext() != null)
			current = current.getNext();

		return current.getItem();
	}

	/**
	 * addToFront -- 
	 * adds the specified item to the front of the list.
	 * @param item a reference to the item to be added
	 */
	public void addToFront (E item)
	{
		contents = new Node<E>(item, contents);
		count++;
	}

	/**
	 * addToRear --
	 * adds a node to the end of the list.
	 * @param item a reference to the item to be added
	 */
	public void addToRear(E item)
	{
		if (!isEmpty())
		{
			Node<E> temp = contents;
			for (int i = 0; i < count - 1; i++)
			{
				temp = temp.getNext();
			}
			temp.setNext(new Node<E>(item));
		}
		else
		{
			contents = new Node<E>(item);
		}
		count++;
	}

	/**
	 * addAfter --
	 * adds the new item after the specified target.
	 * @param target a reference to the item to be located in the list
	 * @param item a reference to the new item to be added
	 * @throws ItemNotFoundException if the target is not found in the list
	 */
	public void addAfter (E item, E target)
	{
		if (isEmpty())
			throw new ItemNotFoundException("Target is not found!");

		Node<E> current = contents;
		Node<E> next;
		boolean found = false;

		while (!found && current != null)
		{
			next = current.getNext();
			if (current.getItem().equals(target))
			{
				found = true;
				Node<E> itemNode = new Node<E>(item);
				current.setNext(itemNode);
				itemNode.setNext(next);
				count++;
			}
			current = current.getNext();
		}

		if (!found)
			throw new ItemNotFoundException("Target is not found!");
	}

	/**
	 * addAt --
	 * adds the item at the specified position in the list.
	 * @param item a reference to the new item to be added
	 * @param pos the position where the item should be stored in the list
	 * @throws InvalidPositionException if pos is invalid; a valid position is 
	 * between 0 and count inclusive
	 */
	public void addAt(E item, int pos) 
	{

	}

	/**
	 * remove (int) --
	 * locates and removes the item at the specified position from the list.
	 * @param pos the location of the item to be removed from this list
	 * @return a reference to the removed item
	 * @throws EmptyListException if the list is empty
	 * @throws InvalidPositionException if the position is invalid. A valid
	 * position is in the range 0 - (count-1)
	 */
	public E remove(int pos) 
	{
		return null;
	}

	/**
	 * remove --
	 * locates and removes the target from the list.
	 * @param target a reference to an initialized item containing data 
	 * in its key-field
	 * @return a reference to the removed item
	 * @throws EmptyListException if the list is empty
	 * @throws ItemNotFoundException if the target is not found
	 */
	//THIS METHOD DOES NOT WORK AS EXPECTED
	public E remove (E target)
	{
		if (isEmpty())
			throw new EmptyListException("List is empty!");

		Node<E> current = contents;
		Node<E> prev = null;
		boolean found = false;

		while (!found && current != null)
		{
			if (current.getItem().equals(target))
				found = true;
			prev = current;
			current = current.getNext();
		}

		if (!found)
			throw new ItemNotFoundException("Target is not found!");
		else
		{
			prev.setNext(current.getNext());
			count--;
		}

		return current.getItem();
	}
	
	public E remove2(E target)
	{
		E temp = null;
		boolean found = false;
		Node<E> current = contents;
		
		if (isEmpty())
			throw new ItemNotFoundException("Target is not found!");
		
		if (current.getItem().equals(target)) //first item == target?
		{
			temp = contents.getItem();
			contents = contents.getNext();
			found = true;
			count--;
			return temp;
		}
		while (!found && current != null)
		{
			// loop -- next node's item == target?
			if (current.getNext() != null && current.getNext().getItem().equals(target)) 
			{
				temp = current.getNext().getItem();
				found = true;
				current.setNext(current.getNext().getNext());
				count--;
				return temp;
			}
			else
				current = current.getNext();
		}
		throw new ItemNotFoundException("Target is not found!");
	}
	
	/**
	 * removeFirst -- 
	 * removes and returns the first item in the list.
	 * @return a reference to what was the first item in the list
	 * @throws EmptyListException if the list is empty
	 */
	public E removeFirst()
	{
		if (isEmpty())
			throw new EmptyListException("List is empty!");
		
		Node<E> removedNode = contents;
		contents = contents.getNext();
		count--;
		return removedNode.getItem();
	}

	/**
	 * removeLast -- 
	 * removes and returns the last item in the list.
	 * @return the item removed from the end of the list
	 * @throws EmptyListException if the list is empty
	 */
	//THIS METHOD DOES NOT WORK AS EXPECTED
	public E removeLast()
	{
		if (isEmpty())
			throw new EmptyListException("List is empty!");

		Node<E> temp = contents;
		Node<E> current = contents;  
		Node<E> prev = null;		

		while (current.getNext() != null) 
		{
			prev = current; 
			current = current.getNext();
		} 
		prev.setNext(null); 

		count--;
		return temp.getItem();
	}

	/**
	 * set(int, E) --
	 * Stores the new item at the specified position and returns the item
	 * that was previously stored there.
	 * @param pos the position where the new item should be stored
	 * @param newItem a reference to the new item to be stored in this list
	 * @return a reference to the item that was previously stored at pos
	 * @throws EmptyListException if the list is empty
	 * @throws InvalidPositionException if the position passed is invalid. A 
	 * valid position is in the range 0 - (count-1)
	 */
	public E set(int pos, E newItem) 
	{
		return null;
	}

	/**
	 * set(E, E) --
	 * Stores the new item where oldItem was previously stored and returns the item
	 * that was previously stored there.
	 * @param oldItem a reference to the item to locate; this item must have a value
	 * stored in its key-field
	 * @param newItem a reference to the new item to be stored in this list
	 * @return a reference to the item that was previously stored in the list
	 * @throws EmptyListException if the list is empty
	 * @throws ItemNotFoundException if the oldItem is not found
	 */
	public E set(E oldItem, E newItem) 
	{
		return null;
	}

	/**
	 * search --
	 * Searches for target, returning a count of the number of times target appears
	 * in this list.
	 * @param target a reference to the item to locate; this item must have a value
	 * stored in its key-field
	 * @return a count of the number of times target appears in this list
	 */
	public int search(E target)
	{
		return 0;
	}
	
	/**
	 * toString --
	 * returns a string representation of the list.
	 * @return a reference to a String containing the items in the list
	 */
	public String toString()
	{
		Node<E> current = contents;
		String result = new String();

		while (current != null)
		{
			result = result + current.getItem().toString() + "\n";
			current = current.getNext();
		}

		return result;
	}

}

