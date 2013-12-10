package text_editor;

/**
 * Title: Cursor.java
 *
 * Description: A Cursor object retains the current position of the cursor in the text editor.
 * (glorified int variable IMO)
 *
 * @author Marvin Yan
 */
public class Cursor
{
    private int pos;

    /** Default constructor */
    public Cursor()
    {
        pos = 0;
    }

    /** increment -- Increments position. */
    public void increment()
    {
        pos++;
    }

    /** decrement -- Decrements position. */
    public void decrement()
    {
        pos--;
    }

    /**
     * getPosition -- Returns the current cursor position.
     *
     * @return 0-based position of cursor
     */
    public int getPosition()
    {
        return pos;
    }

    /**
     * toString -- Provides a descriptive output of the current cursor position.
     *
     * @return a string indicating the position of the cursor
     */
    public String toString()
    {
        return "The cursor is at index: " + pos;
    }
}
