package proj1fa13;

import java.util.ArrayList;
import java.util.Random;

public class Animal {
	private boolean gender; 	       			   		// Male: true, Female: false
	private float   strength;      			   		    // Strength: 0 to 99.9
	
	protected int 	 nextSpot;      			   		// The appropriate index for the animal's next move
	protected static String moveOutput = "Initial state of river\n";   // Stores the activity log for each iteration
	protected static Animal[] river = new Animal[20]; 	// To ensure the same river is being modified by Bear/Fish
	
	// Accessor methods
	public boolean getGender()   { return gender; }
	public float   getStrength() { return strength; }
	
	Random rng = new Random();
	ArrayList<Integer> emptyIndices = new ArrayList<Integer>();

	/**
	 * Default constructor of Animal class. Each animal is
	 * generated with a random gender and strength.
	 */
	public Animal()
	{	
		gender   = rng.nextBoolean();
		strength = rng.nextFloat() * 100;
	}
	
	/**
	 * Randomly places 10 animals into the river array.
	 */
	public void populateRiver()
	{
		while (emptyIndices.size() != 10) // 10 animals requirement at start
		{
			switch (rng.nextInt(3))
			{
			case 0:
				river[rng.nextInt(20)] = new Bear();
				break;
			case 1:
				river[rng.nextInt(20)] = new Fish();
				break;
			default:
				river[rng.nextInt(20)] = null;
			}
			findEmpty(); // force emptyIndices update
		}
	}
	
	/**
	 * Creates a new Bear or Fish object as specified and 
	 * places it in a random, unoccupied location in river.
	 * 
	 * @param type true for bear, false for fish
	 */
	public void spawn(boolean type)
	{
		if (type)
		{
			river[findEmpty()] = new Bear();
		}
		else
		{
			river[findEmpty()] = new Fish();
		}
	}
	
	/**
	 * Generates a random, valid direction for the animal's next
	 * move. The method correctly checks for index 0 and 19
	 * to prevent an out of bounds exception.
	 * 
	 * @param index the current index of the animal being moved
	 * @return      -1, 0, or 1
	 */
	public int moveDirection(int index)
	{
		switch (index)
		{
		case 0:
			return rng.nextInt(2); // 0, 1
		case 19:
			return rng.nextInt(2)-1; // -1, 0
		default:
			return rng.nextInt(3)-1; // -1, 0, 1
		}	
	}
	
	/**
	 * Default move method. Initializes the nextSpot variable for 
	 * use by subclasses.
	 * 
	 * @param index the current index of the animal being moved
	 */
	public void move(int index)
	{
		nextSpot = index + moveDirection(index);
	}
	
	/**
	 * Iterates through river and calls move() on each animal 
	 * object. Nulls are skipped. moveOutput is cleared each 
	 * iteration to allow for a new log.
	 */
	public void moveAll()
	{
		moveOutput = "";
		for (int i = 0; i < 20; i++)
		{
			if (river[i] != null)
			{
				river[i].move(i);
			}
		}
	}
	
	/**
	 * Finds all indices in river that contain null, if any, 
	 * and randomly returns one of them.
	 * 
	 * @return an integer representing an empty index, or -1
	 * 		   if river is full
	 */
	public int findEmpty()
	{
		emptyIndices.clear();
		for (int i = 0; i < 20; i++)
		{
			if (river[i] == null)
				emptyIndices.add(i);
		}
		
		if (emptyIndices.size() != 0){
			return (int) emptyIndices.get(rng.nextInt(emptyIndices.size()));
		}
		else
			return -1;
	}
	
	/**
	 * Compares the strengths of two animals and updates their
	 * positions afterwards.
	 * 
	 * @param index     animal at river[index]
	 * @param nextIndex animal at river[nextSpot]
	 * @return          true only if animal at index survives
	 */
	public boolean fight(int index, int nextIndex)
	{
		if (river[index].getStrength() >= river[nextIndex].getStrength())
		{
			river[nextIndex] = river[index];
			river[index] = null;
			return true;
		}
		else
		{
			river[index] = null;
			return false;
		}
	}
	 
	/**
	 * Iterates through river once and returns a string containing
	 * each index's current status.
	 */
	public String toString()
	{
		String output = "";
		for (int i = 0; i < 20; i++)
		{
			String animalType = "Fish";
			String genderType = "F";
			
			if (river[i] != null)
			{
				if (river[i].getGender()) { genderType = "M"; }
				if (river[i] instanceof Bear) { animalType = "Bear"; }
			    output += String.format("Index %d: %s (Gender: %s | Strength: %.1f)\n", i, animalType, genderType, river[i].getStrength());
			}
			else
			{
				output += String.format("Index %d: \n", i);
			}
		}
		return output;
	}
}
