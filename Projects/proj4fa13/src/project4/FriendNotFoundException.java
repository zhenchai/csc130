package project4;

/**
 * Title: FriendNotFoundException.java
 * Description: Exception class used by the SFacebook class.
 *
 * @author Marvin Yan
 */
public class FriendNotFoundException extends RuntimeException
{
    /**
     * default constructor -- invokes the parameterized constructor in the parent class, RuntimeException, to store the
     * string "Friend not found!".
     */
    public FriendNotFoundException()
    {
        super("Friend not found!\n");
    }

    /**
     * parameterized constructor -- invokes the parameterized constructor in the parent class, RuntimeException, to
     * store the string message.
     *
     * @param message a reference to a String object that contains information about the type of exception that
     *                occurred
     */
    public FriendNotFoundException(String message)
    {
        super(message);
    }
}
