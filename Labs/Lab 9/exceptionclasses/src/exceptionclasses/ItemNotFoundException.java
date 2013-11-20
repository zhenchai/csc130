package exceptionclasses;

/**
 * <p>Title: ItemNotFoundException Class</p>
 * <p>Description: Exception class for use by list classes</p>
 * @author Darci Burdge
 */
@SuppressWarnings("serial")
public class ItemNotFoundException extends RuntimeException
{
	public ItemNotFoundException (String message)
	{
		super (message);
	}
}
