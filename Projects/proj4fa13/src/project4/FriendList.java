package project4;

/**
 * Title: FriendList.java
 * Description:
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

    public int size()
    {
        return count;
    }

    public boolean isEmpty()
    {
        return (count == 0);
    }

    public void addToFront(Person aPerson)
    {
        first.setNext(new Node<Person>(aPerson, first.getNext()));
        count++;
    }

    // |/|A|B|/|
    // |/|A|/|
    // |/|/|
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

    public void resetList()
    {
        loopPosition = first;
    }

    public Person getNextPerson()
    {
        loopPosition = loopPosition.getNext();
        return loopPosition.getPerson();
    }

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
