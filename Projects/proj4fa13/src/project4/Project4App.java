package project4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Title: Project4App.java
 * Description:
 *
 * @author Marvin
 */
public class Project4App
{
    public static void main(String[] args) throws FileNotFoundException
    {
        SFacebook facebook = new SFacebook();
        Scanner sc = new Scanner(new File("facebookData.txt"));

        String[] splitLine = sc.nextLine().split(" ", 3);
        String command = splitLine[0];

        while (!command.equals("X"))
        {
            String personA = splitLine[1];
            if (command.equals("P"))
            {
                System.out.println("Input: " + command + " " + personA + " " + splitLine[2]);

                int secLevel = Integer.parseInt(splitLine[2]);
                facebook.add(personA, secLevel);
                System.out.println(facebook.toString());
            }
            else if (command.equals("F"))
            {
                try
                {
                    System.out.println("Input: " + command + " " + personA + " " + splitLine[2]);
                    facebook.friend(personA, splitLine[2]);
                    System.out.println(facebook.toString());

                }
                catch (FriendNotFoundException ex)
                {
                    System.out.println(ex.getMessage());
                }
            }
            else if (command.equals("U"))
            {
                try
                {
                    System.out.println("Input: " + command + " " + personA + " " + splitLine[2]);
                    facebook.unfriend(personA, splitLine[2]);
                    System.out.println(facebook.toString());
                }
                catch (FriendNotFoundException ex)
                {
                    System.out.println(ex.getMessage());
                }
            }
            else if (command.equals("L"))
            {
                try
                {
                    System.out.println("Input: " + command + " " + personA);
                    System.out.println(facebook.getFriends(personA) + "\n");
                }
                catch (FriendNotFoundException ex)
                {
                    System.out.println(ex.getMessage());
                }
            }
            else if (command.equals("Q"))
            {
                try
                {
                    System.out.println("Input: " + command + " " + personA + " " + splitLine[2]);
                    if (facebook.friendStatus(personA, splitLine[2]))
                    {
                        System.out.println(personA + " and " + splitLine[2] + " are friends.\n");
                    }
                    else
                    {
                        System.out.println(personA + " and " + splitLine[2] + " are not friends.\n");
                    }
                }
                catch (FriendNotFoundException ex)
                {
                    System.out.println(ex.getMessage());
                }
            }
            else if (command.equals("V"))
            {
                try
                {
                    System.out.println("Input: " + command + " " + personA);
                    System.out.println(facebook.getFriendsByLevel(personA));
                }
                catch (FriendNotFoundException ex)
                {
                    System.out.println(ex.getMessage());
                }
            }
            splitLine = sc.nextLine().split(" ", 3);
            command = splitLine[0];
        }
    }
}
