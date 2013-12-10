package project4;

/**
 * Title: SFacebook.java
 * Description:
 *
 * @author Marvin
 */
public class SFacebook
{
    private Person[] thePeople;
    private int count;

    public SFacebook()
    {
        thePeople = new Person[10];
        count = 0;
    }

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

    public String getFriends(String nameA)
    {
        return nameA + " is friends with: " + findFriend(nameA).getFriends();
    }

    public String getFriendsByLevel(String nameA)
    {
        return findFriend(nameA).getAllFriends();
    }

    public boolean friendStatus(String nameA, String nameB)
    {
        return findFriend(nameA).friendsWith(findFriend(nameB));
    }

    public String toString()
    {
        String output = "";
        for(int i = 0; i < count; i++)
        {
            output += thePeople[i].getName() + " is friends with: " + thePeople[i].getFriends() + "\n";
        }
        return output;
    }

    public Person findFriend(String target)
    {
        for(int i = 0; i < count && target != null; i++)
        {
            if (thePeople[i].getName().equals(target))
            {
                return thePeople[i];
            }
        }
        throw new FriendNotFoundException();
    }
}
