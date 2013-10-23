package queues;
import exceptionclasses.*;

/**
 * <p>Title: CircularArrayQueue Class</p>
 *
 * <p>Description: Provides basic Queue functionality, including the ability
 * to enqueue and dequeue items to/from the queue, get the front-most item, 
 * determine whether or not the queue is empty, determine the queue's size, 
 * and to get a String representation of the items in the queue.</p>
 *
 * @author Marvin Yan, Jobar Saddler
 */
public class CircularArrayQueue<E> implements QueueADT<E>
{

	protected int front;
	protected int rear;
	protected E[] contents;
	protected int count;

	/**
	 * default constructor -- creates an empty queue.
	 */
	@SuppressWarnings("unchecked")
	public CircularArrayQueue()
	{
		front = 0;
		rear = 0;
		contents = (E[]) (new Object[100]);
		count = 0;
	}

	/**
	 * parameterized constructor --
	 * creates an empty queue that is initially capable of storing 
	 * 'size' items.
	 * @param size the initial size of the queue as specified by the user
	 */
	@SuppressWarnings("unchecked")
	public CircularArrayQueue(int size)
	{
		front = 0;
		rear = 0;
		if (size > 0)
			contents = (E[]) (new Object[size]);
		else
			contents = (E[]) (new Object[100]);
		count = 0;
	}

	/**
	 * enqueue --
	 * stores a new item at the rear of the queue; if the queue becomes
	 * full, its size is automatically increased to accommodate additional items.
	 * @param newItem a reference to the item to be stored at the rear of the queue
	 */
	public void enqueue(E newItem)
	{
		if (count == contents.length)
			expandCapacity();
		contents[rear] = newItem;
		rear = (rear + 1) % contents.length;
		count++;
	}

    /**
     * enqueueFront --
     * stores a new item at the front of the queue; if the queue becomes
     * full, its size is automatically increased to accommodate additional items.
     * @param newItem a reference to the item to be stored at the front of the queue
     */
    @SuppressWarnings("unchecked")
    public void enqueueFront(E newItem)
    {
        if (count == contents.length)
        {
            expandCapacity();
            E[] temp = (E[]) (new Object[contents.length]);

            for (int i = 0; i < count; i++)
                temp[i + 1] = contents[i];

            temp[0] = newItem;
            front = 0;
            contents = temp;
        }
        else
        {
            // can't refactor ... brain hurts
            if (front == 0 && contents[front] != null)
                front = contents.length - 1;
            else if (front != 0)
                front--;

            contents[front] = newItem;
        }
        count++;
    }

	/**
	 * dequeue -- removes the front-most item from the queue.
	 * @return a reference to the object which was stored at the front of the
	 * queue
	 * @throws QueueException if the queue is empty
	 */
	public E dequeue()
	{
		if (isEmpty())
			throw new QueueException("Queue is empty!");

		E temp = contents[front];
		contents[front] = null;
		front = (front + 1) % contents.length;
		count--;
		return temp;
	}

    /**
     * dequeueRear -- removes the last item from the queue.
     * @return a reference to the object which was stored at the front of the
     * queue
     * @throws QueueException if the queue is empty
     */
    public E dequeueRear()
    {
        if (isEmpty())
            throw new QueueException("Queue is empty!");

        E temp = contents[rear];
        contents[rear] = null;
        rear--;
        if (rear == -1)
            rear = contents.length - 1;
        count--;
        return temp;
    }

	/**
	 * front --
	 * returns the item stored at the front of the queue; the queue 
	 * is not modified.
	 * @return a reference to the object which is stored at the front of the queue
	 * @throws QueueException if the queue is empty
	 */
	public E front()
	{
		if (isEmpty())
			throw new QueueException("Queue is empty!");
		else
			return contents[front];
	}

	/**
	 * isEmpty -- determines whether or not the queue is empty.
	 * @return true if the queue is empty; false otherwise
	 */
	public boolean isEmpty()
	{
		return count == 0;
	}

	/**
	 * count -- returns the count of the number of items in the queue.
	 * @return count
	 */
	public int size()
	{
		return count;
	}

	/**
	 * expandCapacity --
	 * a private method called upon by the enqueue method when the queue 
	 * becomes full; the queue size is doubled to accommodate the storage of
	 * additional items.
	 */
	@SuppressWarnings("unchecked")
	private void expandCapacity()
	{
		E[] temp = (E[]) (new Object[contents.length * 2]);
		int frontTemp = front;
		for(int i = 0; i < count; i++)
		{
			temp[i] = contents[frontTemp];
			frontTemp = (frontTemp + 1) % contents.length;
		}
		contents = temp;
		front = 0;
		rear = count;
		System.out.println("The size of the queue has been expanded to " + contents.length);
	}

	/**
	 * toString method - returns a String representing the current state of the queue.
	 * @return a String containing all items in the queue
	 */
	public String toString()
	{
		String output = "";
		int frontTemp = front;

		for(int i = 0; i < count; i++)
		{
			output += contents[frontTemp] + "\n";
			frontTemp = (frontTemp + 1) % contents.length;
		}
		return output;
	}
}
