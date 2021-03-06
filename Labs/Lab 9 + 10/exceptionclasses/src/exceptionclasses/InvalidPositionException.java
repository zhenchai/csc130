package exceptionclasses;

/**
 * Thrown when a position is determined to be invalid.
 * @author Roberto Tamassia, Michael Goodrich
 */
@SuppressWarnings("serial")
public class InvalidPositionException extends RuntimeException {  
  public InvalidPositionException(String err) {
    super(err);
  }
  public InvalidPositionException() {
    super();
  }
}
