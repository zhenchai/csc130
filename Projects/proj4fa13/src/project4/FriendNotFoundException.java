package project4;

/**
 * Title: FriendNotFoundException.java
 * Description: Exception class used by the ..
 *
 * @author Marvin Yan
 */
@SuppressWarnings("serial")
public class FriendNotFoundException extends RuntimeException
{
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
