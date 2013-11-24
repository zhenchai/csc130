package text_editor;

import java.util.Scanner;

/**
 * Title: MainTest.java
 *
 * Description: This application class creates an Editor object and tests all methods of the Editor class.
 *
 * @author Marvin Yan
 */
public class MainTest
{
    public static void main(String args[])
    {
        Editor theEditor = new Editor();
        System.out.println("Simple text editor 1.0\n" +
                "Commands:\n" +
                "/quit  - exit\n" +
                "/left  - move cursor left\n" +
                "/right - move cursor right\n" +
                "/cut   - delete character right of cursor\n" +
                "/paste c - paste desired character to the right of cursor\n");

        Scanner scan = new Scanner(System.in);
        String[] splitLine = new String[2];
        String input;
        splitLine[0] = "";
        System.out.println("Enter a command...");

        while (!splitLine[0].equals("/quit"))
        {
            input = scan.nextLine();
            splitLine = input.split(" ", 2);

            // note to self: no switch w/ char unless Java 7+
            if (splitLine[0].equals("/paste") && splitLine.length == 2 && splitLine[1].length() == 1)
            {
                theEditor.paste(splitLine[1].charAt(0));
            }
            else if (splitLine[0].equals("/left"))
            {
                theEditor.left();
            }
            else if (splitLine[0].equals("/right"))
            {
                theEditor.right();
            }
            else if (splitLine[0].equals("/cut"))
            {
                theEditor.cut();
            }
            else if (!splitLine[0].equals("/quit"))
            {
                System.out.println("Invalid command or argument.");
            }
            System.out.println("Current string: " + theEditor.toString() + "\n");
        }
        System.out.println("Program terminated.");
    }
}
