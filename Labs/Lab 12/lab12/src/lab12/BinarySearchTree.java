package lab12;

import exceptionclasses.EmptyCollectionException;

/**
 * <p>Title: BinarySearchTree.java</p>
 *
 * <p>Description: Represents a binary search tree class.</p>
 *
 * @author Marvin Yan, Jobar Saddler
 */
public class BinarySearchTree<T>
{
	//instance variables
	private BTreeNode<T> root;

	/**
	 * Creates an empty binary search tree. 
	 */
	public BinarySearchTree()
	{
		root = null;
	}

	/**
	 * Creates a binary search tree containing one node.
	 * @param item a reference to the item that will be stored in
	 * the root of this tree
	 */ 
	public BinarySearchTree (T item)
	{
		root = new BTreeNode<T>(item);
	}

	/**
	 * isEmpty method - determines if the tree is empty
	 * @return true if the tree is empty; false otherwise
	 */
	public boolean isEmpty()
	{
		return root == null;
	}

	/**
	 * add - adds the new item to the binary search tree
	 * @param item a reference to the item to be added to this tree
	 */
	public void add(T newItem)
	{
		root = addNode(root, newItem);
	}

	/**
	 * addNode - inserts the new item into its appropriate location
	 * within the tree.
	 * @param current a reference to the current node
	 * @param item a reference to the item to be added to this tree
	 * @return the reference to the new node created to store the new item
	 */
	@SuppressWarnings("unchecked")
	private BTreeNode<T> addNode(BTreeNode<T> current, T item)
	{
		if (current == null)
			current = new BTreeNode<T>(item);
		else if (((Comparable<T>)item).compareTo(current.getItem()) < 0)
			current.setLeft(addNode(current.getLeft(), item));
		else
			current.setRight(addNode(current.getRight(), item));
		return current;
	}
	
	public void printInOrder()
	{
	    printNodesInOrder(root);
	}
	
	private void printNodesInOrder(BTreeNode<T> current)
	{
	    if (current != null)
	    {
	        printNodesInOrder(current.getLeft());
	        System.out.print(current.getItem() + " ");
	        printNodesInOrder(current.getRight());
	    }
	}
	
	public void printPreOrder() //V,L,R
    {
        printNodesPreOrder(root);
    }
    
    private void printNodesPreOrder(BTreeNode<T> current)
    {
        if (current != null)
        {
            System.out.print(current.getItem() + " ");
            printNodesPreOrder(current.getLeft());
            printNodesPreOrder(current.getRight());
        }
    }
    
    public void printPostOrder() //L,R,V
    {
        printNodesPostOrder(root);
    }
    
    private void printNodesPostOrder(BTreeNode<T> current)
    {
        if (current != null)
        {
            printNodesPostOrder(current.getLeft());
            printNodesPostOrder(current.getRight());
            System.out.print(current.getItem() + " ");
        }
    }
    
    public boolean contains(T item)
    {
        return containsItem(root, item);
    }
    
    private boolean containsItem(BTreeNode<T> current, T item)
    {
        if (current != null)
        {
            if (item.equals(current.getItem()))
                return true;
            else if (((Comparable<T>)item).compareTo(current.getItem()) < 0)
            {
                if (containsItem(current.getLeft(), item))
                    return true;
                return false;
            }
            else
            {
                if (containsItem(current.getRight(), item))
                    return true;
                return false;
            }
        }
        return false;
    }
    
    public T findMin()
    {
        return findMinNode(root).getItem();
    }
    
    private BTreeNode<T> findMinNode(BTreeNode<T> current)
    {
        if (isEmpty())
            throw new EmptyCollectionException("BinarySearchTree");
        
        if (current.getLeft() == null)
            return current;
        else
            return findMinNode(current.getLeft());
    }
    
    public void removeMin()
    {
        root = removeMinNode(root);
    }
    
    private BTreeNode<T> removeMinNode(BTreeNode<T> current)
    {
        if (isEmpty())
            throw new EmptyCollectionException("BinarySearchTree");
        
        if (current.getLeft() == null)
        {
            current = current.getRight();
        }
        else if (current.getLeft().getLeft() == null)
        {
            current.setLeft(null);
        }
        else 
        {
            removeMinNode(current.getLeft());
        }
        return current;
        
        /*
        if (current == null)
            current = new BTreeNode<T>(item);
        else if (((Comparable<T>)item).compareTo(current.getItem()) < 0)
            current.setLeft(addNode(current.getLeft(), item));
        else
            current.setRight(addNode(current.getRight(), item));
        return current;
        */
    }
}
