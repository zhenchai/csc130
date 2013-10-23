package lab7;

import exceptionclasses.*;
import queues.*;

/**
 * <p>Title: Lab7App Class</p>
 *
 * <p>Description: The application class creates a CircularArrayQueue object that can hold
 * references to Product objects. Such objects may be enqueued or dequeued from theQueue
 * among other methods. </p>
 *
 * @author Marvin Yan, Jobar Saddler
 */
public class Lab7App {
	public static void main(String[] args)
	{
		CircularArrayQueue<Product> theQueue = new CircularArrayQueue<Product>(3);
		System.out.println("theQueue contains: \n" + theQueue.toString());
		
		theQueue.enqueue(new Product("111", 1, 1.99));
		theQueue.enqueue(new Product("222", 2, 2.99));
		System.out.println("theQueue contains: \n" + theQueue.toString());
		
		System.out.println("Dequeued item: " + theQueue.dequeue());
		System.out.println("\ntheQueue contains: \n" + theQueue.toString());
		
		System.out.println("Dequeued item: \n" + theQueue.dequeue());
		System.out.println("\ntheQueue contains: \n" + theQueue.toString());

		theQueue.enqueue(new Product("333", 3, 3.99));
		theQueue.enqueue(new Product("444", 4, 4.99));
		System.out.println("theQueue contains: \n" + theQueue.toString());

		theQueue.enqueue(new Product("555", 5, 5.99));
		theQueue.enqueue(new Product("666", 6, 6.99));
		System.out.println("\ntheQueue contains: \n" + theQueue.toString());

        theQueue.enqueue(new Product("777", 7, 7.99));
        theQueue.enqueue(new Product("888", 8, 8.99));
        System.out.println("\ntheQueue contains: \n" + theQueue.toString());

        System.out.println("Dequeue all:") ;
        while(!theQueue.isEmpty())
        {
            System.out.println(theQueue.dequeue());
        }
        System.out.println("\ntheQueue contains: \n" + theQueue.toString());

        try
        {
            System.out.println("Dequeue on an empty queue:");
            theQueue.dequeue();
            System.out.println("A QueueException should have been thrown!");
        }
        catch (QueueException ex)
        {
            System.out.println(ex.getMessage());
        }

        theQueue = new CircularArrayQueue<Product>(3);
        theQueue.enqueueFront(new Product("111", 1, 1.99));
        theQueue.enqueueFront(new Product("222", 2, 2.99));
        theQueue.enqueueFront(new Product("333", 3, 3.99));
        System.out.println("\ntheQueue contains: \n" + theQueue.toString());

        while(!theQueue.isEmpty())
        {
            System.out.println("Dequeued item: \n" + theQueue.dequeueRear());
            System.out.println("\ntheQueue contains: \n" + theQueue.toString());
        }
    }
}
