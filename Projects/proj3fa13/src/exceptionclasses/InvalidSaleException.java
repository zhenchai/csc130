package exceptionclasses;

/**
 * Title: The InvalidSaleException Class
 *
 * Description: Exception class used by the Portfolio class.
 *
 * @author Instructor
 */
public class InvalidSaleException extends RuntimeException{
    /**
     * parameterized constructor --
     * invokes the parameterized constructor in the parent class,
     * RuntimeException, to store the string message.
     * @param message a reference to a String object that contains information
     * about the type of exception that occurred
     */
    public InvalidSaleException(String message)
    {
        super(message);
    }
}
