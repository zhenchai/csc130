package lists;

public interface IndexListADT<E>
{
    /** Returns the number of items in the list */
    public int size();

    /** Returns whether the list is empty */
    public boolean isEmpty();

    /** Inserts the item at index pos, shifting to make room */
    public void add(int pos, E item);

    /** Returns the item at index pos without removing it */
    public E get(int pos);

    /** Removes the item at index pos, shifting to fill the void */
    public E remove(int pos);

    /** Replaces the item at index pos with newItem, returning the item previously stored there */
    public E set(int pos, E newItem);
}
