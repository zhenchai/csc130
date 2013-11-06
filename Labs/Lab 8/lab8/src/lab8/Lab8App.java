package lab8;

import lists.*;
import exceptionclasses.IndexOutOfBoundsException;

/**
 * <p>Title: Lab8App.java</p>
 *
 * <p>Description: Tests the add and get methods of ArrayIndexList.</p>
 *
 * @author: Marvin Yan, Jobar Saddler
 * 
 */
public class Lab8App {
	public static void main(String[] args)
	{
		ArrayIndexList<Product> indexList = new ArrayIndexList<Product>(3);
		
		// Testing add method
		System.out.println("Adding to empty list.");
		indexList.add(0, new Product("000", 0, 0));
		System.out.println(indexList.toString());
		
		System.out.println("Adding within list bounds.");
		indexList.add(1, new Product("111", 0, 0));
		System.out.println(indexList.toString());
		
		System.out.println("Adding between indices.");
		indexList.add(1, new Product("222", 0, 0));
		System.out.println(indexList.toString());
		
		// Testing add exception
		try
		{
			System.out.println("Trying to add out of bounds.");
			indexList.add(4, new Product("333", 0, 0));
			System.out.println(indexList.toString());
		}
		catch(IndexOutOfBoundsException ex)
		{
			System.out.println(ex.getMessage() + "\n");
		}
		
		// Testing add's call to expandCapacity
		System.out.println("Adding between indices when full.");
		indexList.add(2, new Product("444", 0, 0));
		System.out.println(indexList.toString());
		
		// Testing get method
		System.out.println("Getting first index.");
		System.out.println(indexList.get(0));
		System.out.println("\nState of list.");
		System.out.println(indexList.toString());
		
		System.out.println("Getting second index.");
		System.out.println(indexList.get(1));
		
		System.out.println("\nGetting out of bounds index.");
		try
		{
			System.out.println(indexList.get(7));
		}
		catch(IndexOutOfBoundsException ex)
		{
			System.out.println(ex.getMessage());
		}
	}
}
