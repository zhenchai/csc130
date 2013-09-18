package proj1fa13;

import java.util.Scanner;

public class Proj1App 
{
	
	public static void main(String[] args)
	{
		
		Animal anim = new Animal();
		anim.populateRiver();
		Scanner sc = new Scanner(System.in);
		System.out.println("A randomly populated river was generated.\n");
		anim.currentRiverInfo();

		// 10 iterations
		for (int i = 0; i < 10; i++)
		{
			System.out.println("\nDay " + (i + 1) + " has begun.\n");
			anim.moveAll();
			System.out.println("");
			anim.currentRiverInfo();
			System.out.println("\nNight falls. End of day " + (i + 1) + "\n");
			System.out.println("\n Enter any key to continue.");
			sc.next();
		}
		
	}
}
