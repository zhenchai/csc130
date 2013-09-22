package proj1fa13;

import java.util.ArrayList;
import java.util.Random;


public class Animal {
	private    boolean gender; 	       			   // Male: true, Female: false
	private    float   strength;      			   // Strength: 0 to 99.9
	protected  int 	   nextSpot;      			   // The appropriate index for the animal's next move
	protected  float   indexStr;      			   // Strength of current animal
	protected  boolean indexGender;   			   // Gender of current animal
	protected  float   nextStr;       			   // Strength of next location's animal
	protected  boolean nextGender;    			   // Gender of next location's animal
	
	protected static String moveOutput = "Initial state of river\n";
	protected static Animal[] river = new Animal[20]; // To ensure the same river is being modified by Bear/Fish
	
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
	 * @param type indicate 1 for bear, any other int for fish
	 */
	public void spawn(int type)
	{
		if (type == 1)
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
	 * Default move method. Initializes the nextSpot, indexStr,
	 * and indexGender variables for use by subclasses. If an
	 * encounter with another animal will occur, nextStr and
	 * nextGender are also initialized.
	 * 
	 * @param index the current index of the animal being moved
	 * @return      the string log of all movements and encounters
	 */
	public void move(int index)
	{
		nextSpot = index + moveDirection(index);
		indexStr = river[index].getStrength();
		indexGender = river[index].getGender();
		if(river[nextSpot] != null)
		{
			nextStr = river[nextSpot].getStrength();
			nextGender = river[nextSpot].getGender();
		}
	}
	
	/**
	 * Iterates through river and calls move() on each animal 
	 * object. Nulls are skipped.
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
	 * Finds all indices in river that contain null and
	 * randomly returns one of them, if any.
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
	 * Iterates through river once and prints out each 
	 * index's current status.
	 */
	public String currentRiverInfo()
	{
		String output = "";
		for (int i = 0; i < 20; i++)
		{
			String animalType = "Fish";
			String genderType = "F";
			
			if (river[i] != null)
			{
				if (river[i].getGender() == false) { genderType = "M"; }
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
