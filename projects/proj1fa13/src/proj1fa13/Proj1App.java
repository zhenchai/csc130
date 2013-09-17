package proj1fa13;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Proj1App 
{
	
	public static void main(String[] args)
	{
		
		Animal anAnimal = new Animal();
		
		anAnimal.populateRiver();
		anAnimal.currentRiverInfo();
		anAnimal.spawn(false);
		anAnimal.currentRiverInfo();

	}
}
