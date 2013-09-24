package proj1fa13;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * Title: Project 1
 * 
 * Description: The application class is responsible for creating an Animal object. After
 * 10 iterations of moving all Animal objects in the river array, the user is presented with
 * options to either view the entire log, or simply the activity log and array from each 
 * iteration. The user is always returned to the main menu until he/she chooses to quit.
 * 
 * 
 * @author Marvin Yan
 */
public class Proj1App 
{
	
	public static void main(String[] args)
	{
		
		Animal anim = new Animal();
		anim.populateRiver();
		String[] days = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
		String[] riverLog = new String[10];
		String[] moveLog  = new String[10];
		String fullLog = "";
		
		// Log everything and organize it by days
		for (int i = 0; i < 10; i++)
		{
		  moveLog[i] = Animal.moveOutput;
		  riverLog[i] = anim.toString();
		  anim.moveAll();
		}
		
		// Full log output layout
		for (int i = 0; i < 10; i++)
		{
			fullLog += "Day " + (i + 1) + "\n\n----Movement/Encounters Log----\n\n" + moveLog[i] + 
										  "\n---------River Snapshot---------\n\n" + riverLog[i] +  
					                      "\n---------------------------------------------------\n\n";
		}
		
		// Main menu
		String[] choices = {"View river snapshots", "View activity snapshots", "View full log", "Quit"};
		int choice = JOptionPane.showOptionDialog(null,
				"A 10 day river scenario has been generated. Please select an option.", 			
				"River Simulator",         
				JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				null,
				choices,                			
				choices[0]); 
		
		while (choice != 3)
		{
			switch (choice)
			{
			case 0: // Individual river snapshots option
				int dayChoice = JOptionPane.showOptionDialog(null,
		                "Which day's river snapshot would you like to view?",
		                "River Simulator",
		                JOptionPane.DEFAULT_OPTION,
		                JOptionPane.QUESTION_MESSAGE,
		                null,
		                days,
		                days[0]);
				
				JTextArea text = new JTextArea(21,30);
				JScrollPane scroll = new JScrollPane(text);
				text.setText(riverLog[dayChoice]);
				JOptionPane.showMessageDialog(
						null,
						scroll,
						"River Simulator",
						JOptionPane.DEFAULT_OPTION);
				break;
				
			case 1: // Individual activity logs option
				int logChoice = JOptionPane.showOptionDialog(null,
		                "Which day's movement/encounters log would you like to view?",
		                "River Simulator",
		                JOptionPane.DEFAULT_OPTION,
		                JOptionPane.QUESTION_MESSAGE,
		                null,
		                days,
		                days[0]);
				
				JTextArea text1 = new JTextArea(15,30);
				JScrollPane scroll1 = new JScrollPane(text1);
				text1.setText(moveLog[logChoice]);
				JOptionPane.showMessageDialog(
						null,
						scroll1,
						"River Simulator",
						JOptionPane.DEFAULT_OPTION);
				break;
				
			case 2: // Full log option
				JTextArea text2 = new JTextArea(50,35);
				JScrollPane scroll2 = new JScrollPane(text2);
				text2.setText(fullLog);
				JOptionPane.showMessageDialog(
						null,
						scroll2,
						"River Simulator",
						JOptionPane.DEFAULT_OPTION);
			}// end switch
			
			choice = JOptionPane.showOptionDialog(null,
					"A 10 day river scenario has been generated. Please select an option.", 			
					"River Simulator",         
					JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE,
					null,
					choices,                			
					choices[0]); 
		}// end while
	}
}
