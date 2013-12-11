package lab11;

import exceptionclasses.EmptyListException;
import exceptionclasses.ItemNotFoundException;

public class Lab11App
{
    public static void main(String args[])
    {
        ArrayOrderedList<Product> theList = new ArrayOrderedList<Product>();
        theList.add(new Product("3", 3, 3.0));
        theList.add(new Product("2", 2, 2.0));
        theList.add(new Product("5", 5, 5.0));
        theList.add(new Product("1", 1, 1.0));
        theList.add(new Product("4", 4, 4.0));
        
        System.out.println("The list contains: \n" + theList.toString());
        System.out.println("Searching for 1...");
        System.out.println(theList.recursiveBinSearch(new Product("1", 0, 0))); 
        System.out.println("\nSearching for 2...");
        System.out.println(theList.recursiveBinSearch(new Product("2", 0, 0))); 
        System.out.println("\nSearching for 3...");
        System.out.println(theList.recursiveBinSearch(new Product("3", 0, 0))); 
        System.out.println("\nSearching for 4...");
        System.out.println(theList.recursiveBinSearch(new Product("4", 0, 0))); 
        System.out.println("\nSearching for 5...");
        System.out.println(theList.recursiveBinSearch(new Product("5", 0, 0))); 

        try
        {
            System.out.println("\nSearching for 99...");
            System.out.println(theList.recursiveBinSearch(new Product("99", 0, 0)));    
        }
        catch (ItemNotFoundException ex)
        {
            System.out.println(ex.getMessage());
        }
        
        System.out.println("\nThe list should not be modified: \n" + theList.toString());
        
        ArrayOrderedList<Product> emptyList = new ArrayOrderedList<Product>();
        System.out.println("The empty list contains: \n" + emptyList.toString());
        
        try
        {
            System.out.println("\nSearching for 99...");
            System.out.println(emptyList.recursiveBinSearch(new Product("99", 0, 0))); 
        }
        catch (EmptyListException e)
        {
            System.out.println(e.getMessage());
        }
        
        System.out.println("\nThe empty list should not be modified: \n" + emptyList.toString());
    }
}
