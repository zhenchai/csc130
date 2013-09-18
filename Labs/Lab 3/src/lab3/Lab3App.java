package lab3;
import java.io.*;

/**
 * <p>Title: Lab3App.java</p>
 *
 * <p>Description: This class prompts the user for information to construct
 *  a Date object and tests the methods of the Date class. This class also
 *  attempts to catch any thrown exceptions.</p>
 *
 * @author Marvin Yan, Milton Arantes
 */
public class Lab3App 
{
	 public static void main(String[] args)
	 {
	    //Create a BufferedReader object and connect it to System.in
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    Date aDate;
	    int month, day, year;
	    boolean done = false;
	    aDate = new Date();
	    int step = 0;
	    
	    while (!done)
	    {
		    try {
		    	switch(step)
		    	{
		    	case 0: 
		    		System.out.print("Enter the month as an integer: ");
		    		aDate.setMonth(Integer.parseInt(br.readLine()));
		    	case 1:
		    		step = 1;
		    		System.out.print("Enter the day as an integer: ");
		    		aDate.setDay(Integer.parseInt(br.readLine()));
		    	case 2:
		    		step = 2;
		    		System.out.print("Enter the year as an integer: ");
		    		aDate.setYear(Integer.parseInt(br.readLine()));
		    	}	
			    System.out.println(aDate.toString());

			    done = true;
		    }
		    catch (NumberFormatException ex) {
		    	System.out.println("NumberFormatException: " + ex.getMessage());
		    }
		    catch (IOException ex) {
		    	System.out.println("IOException " + ex.getMessage());
		    }
		    catch (DateException ex) {
		    	System.out.println("DateException: " + ex.getMessage());
		    }
	    }
	 }
}