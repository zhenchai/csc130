package text_editor;

/**
 * Title: Cursor.java
 *
 * Description: A Cursor object retains the current position of the cursor in the text editor.
 *
 * @author Marvin Yan
 */
public class Cursor
{
    private int pos;

    public Cursor()
    {
        pos = 0;
    }

    public void increment()
    {
        pos++;
    }

    public void decrement()
    {
        pos--;
    }

    public int getPosition()
    {
        return pos;
    }

    public String toString()
    {
        return "The cursor is at index: " + pos;
    }
}
