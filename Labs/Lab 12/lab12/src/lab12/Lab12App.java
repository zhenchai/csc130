package lab12;

import exceptionclasses.EmptyCollectionException;

/**
 * <p>Title: Lab12App.java</p>
 *
 * <p>Description: Tests the BinarySearchTree class.</p>
 *
 * @author Marvin Yan, Jobar Saddler
 */
public class Lab12App
{
    public static void main(String[] args)
    {
        BinarySearchTree<Integer> theTree = new BinarySearchTree<Integer>();
        theTree.add(31);   
        theTree.add(45);   
        theTree.add(23);   
        theTree.add(59);   
        theTree.add(37);   
        theTree.add(50);   
        
        System.out.println("InOrder Traversal:");
        theTree.printInOrder();
        
        System.out.println("\n\nPreOrder Traversal:");
        theTree.printPreOrder();
        
        System.out.println("\n\nPostOrder Traversal:");
        theTree.printPostOrder();
        
        System.out.println("\n\nContains 45: " + theTree.contains(45));
        System.out.println("Contains 23: " + theTree.contains(23));
        System.out.println("Contains 50: " + theTree.contains(50));
        System.out.println("Contains 31: " + theTree.contains(31));
        System.out.println("Contains 5: " + theTree.contains(5));

        System.out.println("\nThe min item is: " + theTree.findMin());
        BinarySearchTree<Integer> emptyTree = new BinarySearchTree<Integer>();
        try
        {
            System.out.println(emptyTree.findMin());

        }
        catch (EmptyCollectionException ex)
        {
            System.out.println(ex.getMessage());
        }
        
        System.out.println("\nThe tree contains: ");
        theTree.printInOrder();
        System.out.println("\nAfter removing the min item, the tree contains: ");
        theTree.removeMin();
        theTree.printInOrder();
        System.out.println("\nAfter removing the min item, the tree contains: ");
        theTree.removeMin();
        theTree.printInOrder();
        System.out.println("\nAfter removing the min item, the tree contains: ");
        theTree.removeMin();
        theTree.printInOrder();
        
        try
        {
            emptyTree.removeMin();
        }
        catch (EmptyCollectionException ex)
        {
            System.out.println("\n" + ex.getMessage());
        }

    }
}
