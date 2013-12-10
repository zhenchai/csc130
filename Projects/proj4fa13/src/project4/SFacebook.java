package project4;

/**
 * Title: SFacebook.java
 * Description: Contains the methods for creating an SFacebook object, interacting with the thePeople array, and
 * displaying the contents of the array.
 *
 * @author Marvin
 */
public class SFacebook
{
    private Person[] thePeople;
    private int count;

    /** default constructor - Initializes thePeople to a array of length 10 and count to 0 */
    public SFacebook()
    {
        thePeople = new Person[10];
        count = 0;
    }

    /**
     * add - Adds a Person to thePeople.
     *
     * @param name          the string name of the Person to be added
     * @param securityLevel 1 for visibility of friends of friends, 0 for immediate friends only
     */
    public void add(String name, int securityLevel)
    {
        // expand capacity if array is full
        if (count == thePeople.length)
        {
            Person[] temp = new Person[count * 2];
            for (int i = 0; i < count; i++)
            {
                temp[i] = thePeople[i];
            }
            thePeople = temp;
        }
        thePeople[count] = new Person(name, securityLevel);
        count++;
    }

    /**
     * friend - Grants mutual friend status between two Persons
     *
     * @param nameA String name of person A
     * @param nameB String name of person B
     */
    public void friend(String nameA, String nameB)
    {
        if (!nameA.equals(nameB))   //if not friending self
        {
            Person personA = findFriend(nameA);
            Person personB = findFriend(nameB);
            personA.addFriend(personB);
            personB.addFriend(personA);
        }
    }

    /**
     * unfriend - Removes friend status between two Persons
     *
     * @param nameA String name of person A
     * @param nameB String name of person B
     */
    public void unfriend(String nameA, String nameB)
    {
        if (!nameA.equals(nameB))   //if not unfriending self
        {
            Person personA = findFriend(nameA);
            Person personB = findFriend(nameB);
            personA.unfriend(personB);
            personB.unfriend(personA);
        }
    }

    /**
     * getFriends - Returns the friend list of a person
     *
     * @param nameA String name of person
     * @return a descriptive display of the person's friend list
     */
    public String getFriends(String nameA)
    {
        return nameA + " is friends with: " + findFriend(nameA).getFriends();
    }

    /**
     * getFriendsByLevel - Returns the friends and friends of friends of a person
     *
     * @param nameA String name of person
     * @return a descriptive display of the person's friend list and his friends of friends
     */
    public String getFriendsByLevel(String nameA)
    {
        return findFriend(nameA).getAllFriends();
    }

    /**
     * friendStatus - Checks for friendship between two Persons
     *
     * @param nameA String name of person A
     * @param nameB String name of person B
     * @return true if A is friends with B, false otherwise
     */
    public boolean friendStatus(String nameA, String nameB)
    {
        return findFriend(nameA).friendsWith(findFriend(nameB));
    }

    /**
     * toString - Returns the immediate friends of everyone in thePeople
     *
     * @return a descriptive output of every Person's friend list
     */
    public String toString()
    {
        String output = "";
        for (int i = 0; i < count; i++)
        {
            output += thePeople[i].getName() + " is friends with: " + thePeople[i].getFriends() + "\n";
        }
        return output;
    }

    /**
     * findFriend - Searches for a Person by checking for name and returns a reference to the Person
     *
     * @param target the String name of the Person to be searched
     * @return a reference to the Person object if found
     */
    public Person findFriend(String target)
    {
        for (int i = 0; i < count && target != null; i++)
        {
            if (thePeople[i].getName().equals(target))
            {
                return thePeople[i];
            }
        }
        throw new FriendNotFoundException();
    }
}
