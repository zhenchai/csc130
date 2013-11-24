package exceptionclasses;

/**
 * Title: The IndexOutOfBoundsException Class
 * Description: Exception class used by the ArrayIndexList class.
 *
 * @author Instructor
 */
@SuppressWarnings("serial")
public class IndexOutOfBoundsException extends RuntimeException
{
    /**
     * default constructor -- invokes the parameterized constructor in the parent class, RuntimeException, to store the
     * string 'Invalid index'.
     */
    public IndexOutOfBoundsException()
    {
        super("Invalid index");
    }

    /**
     * parameterized constructor -- invokes the parameterized constructor in the parent class, RuntimeException, to
     * store the string message.
     *
     * @param message a reference to a String object that contains information about the type of exception that
     *                occurred
     */
    public IndexOutOfBoundsException(String message)
    {
        super(message);
    }
}