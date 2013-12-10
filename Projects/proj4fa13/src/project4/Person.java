package project4;

/**
 * Title: Person.java
 * Description: A Person object stores a name, security level, and a friend list. The friend list may accessed and
 * modified.
 *
 * @author Marvin
 */
public class Person
{
    private String name;
    private int securityLevel;
    private FriendList friends;

    /**
     * parameterized constructor - Initializes name and security to the specified argument values and initializes a
     * FriendList for the Person.
     *
     * @param name          String name of the Person
     * @param securityLevel 1 for visibility of friends of friends, 0 for immediate friends only
     */
    public Person(String name, int securityLevel)
    {
        this.name = name;
        this.securityLevel = securityLevel;
        friends = new FriendList();
    }

    /**
     * getName - Returns the Person's name.
     *
     * @return name of the Person
     */
    public String getName()
    {
        return name;
    }

    /**
     * addFriend - Adds a Person to the friend list.
     *
     * @param newFriend the Person to be friended
     */
    public void addFriend(Person newFriend)
    {
        friends.addToFront(newFriend);
    }

    /**
     * unfriend - Removes a Person from the friend list.
     *
     * @param target the Person to be unfriended
     */
    public void unfriend(Person target)
    {
        friends.remove(target);
    }

    /**
     * friendsWith - Checks if target is in the friend list.
     *
     * @param target the Person to be checked
     * @return true if friends, false otherwise
     */
    public boolean friendsWith(Person target)
    {
        return friends.search(target);
    }

    /**
     * getFriends - Returns the friends of a Person.
     *
     * @return the friends of a Person
     */
    public String getFriends()
    {
        return friends.listOfFriends();
    }

    /**
     * getAllFriends - Returns the friends and/or friends of friends of a Person depending on security level.
     *
     * @return the immediate friends only if level 0, otherwise includes friends of friends
     */
    public String getAllFriends()
    {
        if (securityLevel == 1)
        {
            String friends1 = friends.listOfFriends();            // a is friends with |b, c|
            String[] splitFriends = friends1.split(" ");    // b is friends with |e|, c is friends with |f, g|
            String output = "";
            boolean found;
            Person current;
            for (int i = 0; i < splitFriends.length; i++)
            {
                found = false;
                friends.resetList();
                for (int j = 0; j < friends.size() && !found; j++)
                {
                    current = friends.getNextPerson();
                    if (current.getName().equals(splitFriends[i]))
                    {
                        output += "and \n" + current.getName() + " is friends with: " + current.getFriends();
                        found = true;
                    }
                }
            }
            return name + " is friends with: " + getFriends() + output + "\n";
        }
        else
        {
            return name + " is friends with: " + getFriends() + "\n";
        }
    }

    /**
     * equals - Determines if two Persons have the same name (names are considered unique).
     *
     * @param target a reference to a Person object
     * @return true if two Persons have the same name, otherwise false
     */
    public boolean equals(Person target)
    {
        return (name.equals(target.getName()));
    }
}
