package lab1;
import java.util.*;
import javax.swing.*;
/**
 * <p>Title: Lab #1</p>
 *
 * <p>Description: Airplane Class - An object of type Airplane contains a 
 * reference to a Seat array. The airplane has 10 seats. The first 4 seats are
 * first class and the remaining are coach class seats. A 
 * user can book a seat or cancel a seat. There is also a toString method that 
 * can be used to see the current status of all seats.</p>
 *
 * @author Marvin Yan, Jobar Saddler
 */
public class Airplane
{
	private Seat[] seats;
    String[] firstChoices;
    String[] coachChoices;
    List<String> list = new ArrayList<String>();
    int trueSeat;
	/**
	 * default constructor --
	 * Creates an Airplane that has 10 seats; the first 4 are first
	 * class and the remaining 6 are coach class seats.
	 */
	public Airplane()
	{
		seats = new Seat[10];
		for (int i=0; i<4; i++)
			seats[i] = new Seat("First Class", i+1);
		for (int i=4; i<seats.length; i++)
			seats[i] = new Seat("Coach Class", i+1);
	}

    // Rebuild list and add available first class seats
    public void refreshFirst()
    {
        list.clear();
        for (int i = 0; i < 4; i++)
        {
            if (seats[i].isEmpty())
            {
                list.add(Integer.toString(i+1)); // Prevent seat 0 from appearing as an option

            }
        }

        // Convert String list into String array
        firstChoices = list.toArray(new String[list.size()]);
    }

    // Rebuild list and add available coach class seats
    public void refreshCoach()
    {
        list.clear();
        for (int i = 4; i < 10; i++)
        {
            if (seats[i].isEmpty())
            {
                list.add(Integer.toString(i+1));

            }
        }

        coachChoices = list.toArray(new String[list.size()]);
    }
    /**
     * assignFirstClass --
     * Assigns the next available first class seat if one is available. A message is
     * displayed indicating the number and class of the seat that has been reserved if
     * one is available; if not, a message is displayed indicating that there are no
     * more first class seats available.
     */
	public void assignFirstClass()
	{
		refreshFirst();
        if (firstChoices.length != 0)
		{
            int pickSeat = JOptionPane.showOptionDialog(null,
                    "Which seat would you like to reserve?",
                    "Reservation System Menu",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    firstChoices,
                    firstChoices[0]);

            // Convert picked seat string into correct int
            trueSeat = Integer.parseInt(firstChoices[pickSeat]) - 1;

            // Perform seating and refresh available seats
            seats[trueSeat].assignSeat();
			JOptionPane.showMessageDialog(null, "Your reservation is complete!!" + "\n\n"
					+ "You have been assigned seat #" + seats[trueSeat].getSeatNumber()
					+ " in " + seats[trueSeat].getSeatType());
        }
		else
		{
			JOptionPane.showMessageDialog(
					null,
					"Sorry, there are no more First Class seats available!",
					"Reservation System",
					JOptionPane.DEFAULT_OPTION);
		}
	}

	/**
	 * assignCoachClass --
	 * Assigns the next available coach class seat if one is available. A message is
	 * displayed indicating the number and class of the seat that has been reserved if 
	 * one is available; if not, a message is displayed indicating that there are no 
	 * more coach class seats available.
	 */
	public void assignCoachClass()
	{
		refreshCoach();
        if (coachChoices.length != 0)
        {
            int pickSeat = JOptionPane.showOptionDialog(null,
                    "Which seat would you like to reserve?",
                    "Reservation System Menu",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    coachChoices,
                    coachChoices[0]);

            trueSeat = Integer.parseInt(coachChoices[pickSeat]) - 1;

            seats[trueSeat].assignSeat();
            JOptionPane.showMessageDialog(null, "Your reservation is complete!!" + "\n\n"
                    + "You have been assigned seat #" + seats[trueSeat].getSeatNumber()
                    + " in " + seats[trueSeat].getSeatType());
        }
        else
        {
            JOptionPane.showMessageDialog(
                    null,
                    "Sorry, there are no more Coach Class seats available!",
                    "Reservation System",
                    JOptionPane.DEFAULT_OPTION);
        }
    }
	/**
	 * cancelSeat --
	 * The user is asked to enter the number of the seat they wish to cancel. As long
	 * as the number is valid and the seat is currently occupied, then the requested
	 * seat is cancelled. An appropriate message is displayed to inform the user of 
	 * the result. 
	 */
	public void cancelSeat()
	{
		int sNum = Integer.parseInt(JOptionPane.showInputDialog
				("Enter the number of the seat you would like to cancel."));
		sNum--;
		if (sNum < 0 || sNum >= seats.length)
			JOptionPane.showMessageDialog(
					null,
					"Sorry, the seat number you entered is invalid.",
					"Reservation System",
					JOptionPane.DEFAULT_OPTION);
		else
			if (seats[sNum].isEmpty())
				JOptionPane.showMessageDialog(
						null,
						"Sorry, the seat you specified is not reserved!",
						"Reservation System",
						JOptionPane.DEFAULT_OPTION);
			else
			{
				seats[sNum].cancelSeat();
				JOptionPane.showMessageDialog(
						null,
						"Thank you, your reservation has been cancelled. Please come back again soon.",
						"Reservation System",
						JOptionPane.DEFAULT_OPTION);
			}
	}

	/**
	 * toString --
	 * Returns a string representing the current state of the airplane.
	 * @return the status of all seats on the plane
	 */
	public String toString()
	{
		String str = "";
		for(int i=0;i<seats.length;i++)
		{
			str += seats[i].toString() + "\n\n";
		}
		
	return str;
}
}

