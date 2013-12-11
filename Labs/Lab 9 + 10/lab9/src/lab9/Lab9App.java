package lab9;

import exceptionclasses.*;
import lists.*;

/**
 * Title: Lab9App class</p>
 *
 * Description: Creates two NodeList objects, list and emptyList, and tests the NodeList class.
 *
 * @author Marvin Yan, Jobar Saddler
 */
public class Lab9App {
	public static void main(String args[])
	{
		NodeList<Product> list = new NodeList<Product>();
		NodeList<Product> emptyList = new NodeList<Product>();

		System.out.println("The list contains: " + list.size() + " item(s).");
				
		list.addToFront(new Product("11111", 10, 1.99));
		list.addToFront(new Product("22222", 20, 2.99));
		
		System.out.println("The list contains: " + list.size() + " item(s).");
		System.out.println(list.toString());
		
		emptyList.addToRear(new Product("12121", 12, 12.99));		
		list.addToRear(new Product("33333", 30, 3.99));
		
		System.out.println("Testing the addToRear method on an empty list:");
		System.out.println("The empty list contains: " + emptyList.size() + " item(s).");
		System.out.println(emptyList.toString());
		
		System.out.println("Testing the addToRear method on a list that contains data:");
		System.out.println("The list contains: " + list.size() + " item(s).");
		System.out.println(list.toString());

		emptyList.addToRear(new Product("23232", 23, 23.99));
		System.out.println("Testing the addToRear method on a list that contains one item:");
		System.out.println("The list contains: " + emptyList.size() + " item(s).");
		System.out.println(emptyList.toString());

		emptyList = new NodeList<Product>();
		try
		{
			System.out.println("Testing the addAfter method on an empty list:");
			emptyList.addAfter(new Product("23232", 23, 13.99), new Product("12121", 12, 12.99));
		}
		catch (ItemNotFoundException ex)
		{
			System.out.println(ex.getMessage());
		}
		System.out.println("The empty list contains: " + emptyList.size() + " item(s).");
		System.out.println(emptyList.toString());
		
		list.addAfter(new Product("44444", 40, 4.99), new Product("22222", 0, 0));
		System.out.println("Adding three new items 'after' the first, middle and last item:");
		System.out.println("The list contains: " + list.size() + " item(s).");
		System.out.println(list.toString());
		
		list.addAfter(new Product("55555", 50, 5.99), new Product("11111", 0, 0));
		System.out.println("The list contains: " + list.size() + " item(s).");
		System.out.println(list.toString());
		
		list.addAfter(new Product("66666", 60, 6.99), new Product("33333", 0, 0));
		System.out.println("The list contains: " + list.size() + " item(s).");
		System.out.println(list.toString());
		
		try
		{
			list.addAfter(new Product("77777", 70, 7.99), new Product("99999", 0, 0));
			
		}
		catch (ItemNotFoundException ex)
		{
			System.out.println("Testing the addAfter when the target is not found:");
			System.out.println("Trying to add 77777 after 99999: " + ex.getMessage());
		}
		System.out.println("The list contains: " + list.size() + " item(s).");
		System.out.println(list.toString());
		
		emptyList = new NodeList<Product>();
		try
		{
			System.out.println("Testing the removeFirst method on an empty list:");
			System.out.println(emptyList.removeFirst());
		}
		catch (EmptyListException ex)
		{
			System.out.println(ex.getMessage());
		}
		System.out.println("The list contains: " + emptyList.size() + " item(s).");
		System.out.println(emptyList.toString());
		
		System.out.println("Testing the removeFirst method on a list containing data:");
		System.out.println("Removed item is: " + list.removeFirst());
		System.out.println("The list contains: " + list.size() + " item(s).");
		System.out.println(list.toString());

		System.out.println("Testing the removeFirst method by removing all remaining items:");
		int size = list.size();
		for (int i = 0; i < size; i++)
		{
			System.out.println("Removed item is: " + list.removeFirst());
		}
		System.out.println("The list contains: " + list.size() + " item(s).");
		System.out.println(list.toString());
		
		System.out.println("Testing remove2 on an empty list:");
		try
		{
			emptyList.remove2(new Product("55555", 0, 0));
		}
		catch (ItemNotFoundException ex)
		{
			System.out.println(ex.getMessage());
		}
		System.out.println("The list contains: " + emptyList.size() + " item(s).");
		System.out.println(emptyList.toString());
		
		list.addToFront(new Product("44444", 40, 4.99));
		list.addToFront(new Product("33333", 30, 3.99));
		list.addToFront(new Product("22222", 20, 2.99));
		list.addToFront(new Product("11111", 10, 1.99));
		
		System.out.println("The list contains: " + list.size() + " item(s).");
		System.out.println(list.toString());
		
		System.out.println("Testing remove2 on a list that contains data:");
		System.out.println("Removing 11111 -- found -> " + 
				list.remove2(new Product("11111", 0, 0)));
		System.out.println("The list contains: " + list.size() + " item(s).");
		System.out.println(list.toString());
		
		System.out.println("Testing remove2 on a list that contains data:");
		System.out.println("Removing 33333 -- found -> " + 
				list.remove2(new Product("33333", 0, 0)));
		System.out.println("The list contains: " + list.size() + " item(s).");
		System.out.println(list.toString());
		
		System.out.println("Testing remove2 on a list that contains data:");
		System.out.println("Removing 44444 -- found -> " + 
				list.remove2(new Product("44444", 0, 0)));
		System.out.println("The list contains: " + list.size() + " item(s).");
		System.out.println(list.toString());
		
		try 
		{
			System.out.println("Removing 55555 -- found -> " + 
				list.remove2(new Product("55555", 0, 0)));
		}
		catch (ItemNotFoundException ex)
		{
			System.out.println(ex.getMessage());
		}
		System.out.println("The list contains: " + list.size() + " item(s).");
		System.out.println(list.toString());
		
		System.out.println("Removing 22222 -- found -> " + 
				list.remove2(new Product("22222", 0, 0)));
		System.out.println("The list contains: " + list.size() + " item(s).");
		System.out.println(list.toString());
	}
	
}
