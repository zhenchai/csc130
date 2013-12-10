package project4;

/**
 * Title: FriendList.java
 * Description: A FriendList object consists of connected nodes that may be accessed and modified to represent a
 * Person's friend list.
 *
 * @author Marvin
 */
public class FriendList
{
    private int count;
    private Node<Person> first, loopPosition;

    /** default constructor - Initializes count to 0 and first to a Node that has no item and points to a null Node. */
    public FriendList()
    {
        count = 0;
        first = new Node<Person>(null, new Node<Person>());
    }

    /**
     * size - Returns the number of friends in the friend list.
     *
     * @return count - the number of friends in the friend list
     */
    public int size()
    {
        return count;
    }

    /**
     * isEmpty - Checks if the friend list is empty.
     *
     * @return true if the list does not contain at least one Person, false otherwise
     */
    public boolean isEmpty()
    {
        return (count == 0);
    }

    /**
     * addToFront - Adds a Person to the front of the friend list.
     *
     * @param aPerson the person to be added
     */
    public void addToFront(Person aPerson)
    {
        first.setNext(new Node<Person>(aPerson, first.getNext()));
        count++;
    }

    /**
     * remove - Removes a Person from the friend list.
     *
     * @param target the Person to be removed from the friend list
     * @return a reference to the Person that was removed
     */
    public Person remove(Person target)
    {
        resetList();
        while (loopPosition.getNext().getPerson() != null)
        {
            if (loopPosition.getNext().getPerson().equals(target))
            {
                loopPosition.setNext(loopPosition.getNext().getNext());
                count--;
                return target;
            }
            getNextPerson();
        }
        return null; // SFacebook class throws exception for non-existent target
    }

    /**
     * resetList - Sets loopPosition to the header sentinel.
     */
    public void resetList()
    {
        loopPosition = first;
    }

    /**
     * getNextPerson - Returns the next Person in the list and shifts loopPosition one over.
     *
     * @return a reference to the next Person in the list
     */
    public Person getNextPerson()
    {
        loopPosition = loopPosition.getNext();
        return loopPosition.getPerson();
    }

    /**
     * search - Checks for the existence of the Person in question.
     *
     * @param target the Person to be checked
     * @return true if the Person is in the list, false otherwise
     */
    public boolean search(Person target)
    {
        resetList();
        while (loopPosition.getNext().getPerson() != null)
        {
            if (getNextPerson().equals(target))
            {
                return true;
            }
        }
        return false;
    }

    /**
     * listOfFriends - Displays the contents of the friend list.
     *
     * @return a String containing a space separated list of names
     */
    public String listOfFriends()
    {
        String output = "";
        resetList();
        while (loopPosition.getNext().getPerson() != null)
        {
            output += getNextPerson().getName() + " ";
        }
        return output;
    }
}
