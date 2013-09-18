package lab3;
@SuppressWarnings("serial")

/**
 * <p>Title: DateException.java</p>
 * 
 * @author Marvin Yan, Milton Arantes
 */

public class DateException extends Exception {
	public DateException()
	{
		super("Invalid value for Date");
	}
	
	public DateException(String message)
	{
		super(message);
	}
}
