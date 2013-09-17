package proj1fa13;

import java.util.ArrayList;
import java.util.Random;

/* Write a Java program to simulate an ecosystem containing two types of creatures,
 * bears and fish. The ecosys consists of a river, which is modeled as a relatively
 * large array. Each cell of the array should contain an Animal obj, which can be a 
 * Bear object or a Fish object, or null. In each time step, bears and fish attempt 
 * to move into adj array cells or tey can stay where they are at random. If two 
 * animals of the same type are about to collide in the same cell, then they stay 
 * where they are but they create a new instance of that type of animal, placed 
 * randomly in the array. If a bear and a fish collide, the fish dies. Use actual 
 * obj creation via the new operator to model the creation of new objects, and 
 * provide a visualization of the array after each time step.
 * 
 * Write a simulator as in the previous proj, but add a Boolean gender field and a
 * floating-point strength field to each Animal obj. Now, if two animals of the same 
 * type try to collide, then they only create a new instance of that type of animal
 * if they are of different genders. Otherwise, if two animals of the same type and 
 * gender try to collide, then only the one of larger strength survives.
 */

public class Animal {
	private boolean  type; 		       // Bear: true, Fish: false
	private boolean  gender; 	       // Male: true, Female: false
	private int  	 position;	       // Index in river array: 0 to 19
	private float 	 strength;         // Strength: 0 to 99.99
	
	// Accessor methods
	public boolean getType()     { return type; }
	public boolean getGender()   { return gender; }
	public float   getStrength() { return strength; }
	public int     getPosition() { return position; }
	
	Random rng = new Random();
	Animal[] river = new Animal[20];
	ArrayList<Integer> emptyIndices = new ArrayList<Integer>();

	public Animal()
	{		
		type     = rng.nextBoolean();
		gender   = rng.nextBoolean();
		strength = rng.nextFloat() * 100;
		position = findEmpty();  
	}
	
	public Animal(boolean t)
	{
		type     = t;
		gender   = rng.nextBoolean();
		strength = rng.nextFloat() * 100;
		position = findEmpty(); 
	}
	
	// Populates river with animals at start
	public void populateRiver()
	{
		while(emptyIndices.size() != 10) // 10 animal requirement at start
		{
			river[rng.nextInt(20)] = new Animal();
			findEmpty();
		}
	}
	
	// Makes the appropiate animal object and spawns it in the river
	public void spawn(boolean type)
	{
		if(type) 
			river[findEmpty()] = new Animal(type);
		else
			river[findEmpty()] = new Animal(type);
	}
	
	/* Return an int indicating encounter
	public int move()
	{
		for(int i = 0; i < 20; i++)
		{
			
		}
	} */
	
	// Return a random empty index
	public int findEmpty()
	{
		emptyIndices.clear();
		for(int i = 0; i < 20; i++)
		{
			if(river[i] == null)
				emptyIndices.add(i);
		}
		return (int) emptyIndices.get(rng.nextInt(emptyIndices.size()));
	}
	
	public void currentRiverInfo()
	{
		for(int i = 0; i < 20; i++)
		{
			String output;
			if(river[i] != null)
			{
				String animal = "Fish";
				String gender = "F";
				if(river[i].getType())
				{
					animal = "Bear";
				}
				if(river[i].getGender())
				{
					gender = "M";
				}
			    output = String.format("Index %d: %s (Gender: %s | Strength: %.3f)", i, animal, gender, river[i].getStrength());
			}
			else
			{
				output = String.format("Index %d: Nothing", i);
			}
			System.out.println(output);
		}
	}
}
