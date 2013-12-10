package project4;

/**
 * Title: Person.java
 * Description:
 *
 * @author Marvin
 */
public class Person
{
    private String name;
    private int securityLevel;
    private FriendList friends;

    public Person(String name, int securityLevel)
    {
        this.name = name;
        this.securityLevel = securityLevel;
        friends = new FriendList();
    }

    public String getName()
    {
        return name;
    }

    public void addFriend(Person newFriend)
    {
        friends.addToFront(newFriend);
    }

    public void unfriend(Person target)
    {
        friends.remove(target);
    }

    public boolean friendsWith(Person target)
    {
        return friends.search(target);
    }

    public String getFriends()
    {
        return friends.listOfFriends();
    }

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
