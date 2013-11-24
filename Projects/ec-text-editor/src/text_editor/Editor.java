package text_editor;

import lists.ArrayIndexList;

/**
 * Title: Editor.java
 *
 * Description: The Editor class provides the functions of a basic text editor.
 *
 * @author Marvin Yan
 */
public class Editor
{
    private ArrayIndexList<Character> theString;
    private Cursor theCursor;
    
    /** default constructor */
    public Editor()
    {
        theString = new ArrayIndexList<Character>();
        theCursor = new Cursor();
    }

    /** left -- Move cursor left one character. */
    public void left()
    {
        if (theCursor.getPosition() > 0)
        {
            theCursor.decrement();
        }
    }

    /** right -- Move cursor right one character. */
    public void right()
    {
        if (theCursor.getPosition() < theString.size())
        {
            theCursor.increment();
        }
    }

    /** cut -- Delete the character right of the cursor. */
    public void cut()
    {
        if (theCursor.getPosition() != theString.size() && theString.size() != 0)
        {
            theString.remove(theCursor.getPosition());
        }
    }

    /**
     * paste -- Insert a character after the cursor.
     *
     * @param c the character to be pasted
     */
    public void paste(char c)
    {
        if (theString.isEmpty() && theCursor.getPosition() == 0)
        {
            theString.add(theCursor.getPosition(), c);
        }
        else
        {
            theString.add(theCursor.getPosition(), c);
        }
    }

    /**
     * toString -- Returns a string of characters in the list
     *
     * @return the contents of the list array in string form
     */
    public String toString()
    {
        String output = "";
        
        for (int i = 0; i < theString.size(); i++)
        {
            if (theCursor.getPosition() == i)
            {
                output += "|";
            }
            output += theString.get(i);
        }
        
        if (theCursor.getPosition() == theString.size())
        {
            output += "|";
        }
        return output + "\n" + theCursor.toString();
    }
}
