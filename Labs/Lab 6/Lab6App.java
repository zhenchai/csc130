package lab6;
import exceptionclasses.*;
import queues.*;

/**
 * Title: Lab6App
 * 
 * Description: Tests the LinkedQueue class's methods, primarily
 * the enqueue, dequeue, search, removeLast, and toString methods.
 * 
 * @author Marvin Yan, Jobar Saddler
 */
public class Lab6App {

	public static void main(String args[])
	{
		LinkedQueue<Product> theQueue = new LinkedQueue<Product>();
		System.out.println("theQueue contains: ");
		System.out.println(theQueue.toString());
		
		if(theQueue.isEmpty())
			System.out.println("theQueue is empty\n");
		else
			System.out.println("theQueue is NOT empty\n");
		
		Product p1 = new Product("111", 10, 1.99);
		Product p2 = new Product("222", 20, 2.99);
		Product p3 = new Product("333", 30, 3.99);
		
		theQueue.enqueue(p1);
		theQueue.enqueue(p2);
		theQueue.enqueue(p3);
		
		System.out.println("theQueue contains:");
		System.out.println(theQueue.toString());
		
		if(theQueue.isEmpty())
			System.out.println("theQueue is empty\n");
		else
			System.out.println("theQueue is NOT empty\n");

		System.out.println("The front-most item is: " + theQueue.front());
		System.out.println("\ntheQueue contains: ");
		System.out.println(theQueue.toString());
		
		System.out.println("The size of theQueue is " + theQueue.size());

		System.out.println("\nThe dequeued item: " + theQueue.dequeue());
		System.out.println("\ntheQueue contains: ");
		System.out.println(theQueue.toString());
		
		System.out.println("\nThe dequeued item: " + theQueue.dequeue());
		System.out.println("\ntheQueue contains: ");
		System.out.println(theQueue.toString());
		
		System.out.println("\nThe dequeued item: " + theQueue.dequeue());
		System.out.println("\ntheQueue contains: ");
		System.out.println(theQueue.toString());
		
		System.out.print("On dequeue: ");
		try
		{
			System.out.println(theQueue.dequeue());
		}
		catch(QueueException ex)
		{
			System.out.println(ex.getMessage());
		}
		
		System.out.print("\nWhen calling front: ");
		try
		{
			System.out.println(theQueue.front());
		}
		catch(QueueException ex)
		{
			System.out.println(ex.getMessage());
		}
		
		System.out.println("\nThe size of the queue is: " + theQueue.size());	
		System.out.println("\nThe product with the id 555 was found at position " + theQueue.search(new Product("555", 0, 0)));
		
		theQueue.enqueue(p1);
		theQueue.enqueue(p2);
		theQueue.enqueue(p3);
		
		System.out.println("\ntheQueue contains:");
		System.out.println(theQueue.toString());
		
		System.out.println("The product with the id 111 was found at position " + theQueue.search(new Product("111", 0, 0)));
		System.out.println("The product with the id 555 was found at position " + theQueue.search(new Product("555", 0, 0)));
		System.out.println("The product with the id 222 was found at position " + theQueue.search(new Product("222", 0, 0)));
		System.out.println("The product with the id 333 was found at position " + theQueue.search(new Product("333", 0, 0)));
		
		System.out.println("\nLast product removed: " + theQueue.removeLast());
		System.out.println("\ntheQueue contains:");
		System.out.println(theQueue.toString());
		
		System.out.println("\nLast product removed: " + theQueue.removeLast());
		System.out.println("\ntheQueue contains:");
		System.out.println(theQueue.toString());
		
		System.out.println("\nLast product removed: " + theQueue.removeLast());
		System.out.println("\ntheQueue contains:");
		System.out.println(theQueue.toString());
		
		System.out.print("On removeLast: ");
		try
		{
			System.out.println(theQueue.removeLast());
		}
		catch (QueueException ex)
		{
			System.out.println(ex.getMessage());
		}
		
		theQueue.enqueue(p1);
		System.out.println("\ntheQueue contains:");
		System.out.println(theQueue.toString());

	}
}
