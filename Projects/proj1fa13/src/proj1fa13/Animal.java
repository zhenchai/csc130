package proj1fa13;

import java.util.ArrayList;
import java.util.Random;


public class Animal {
	private boolean  gender; 	       // Male: true, Female: false
	private float 	 strength;         // Strength: 0 to 99.999
	
	// Accessor methods
	public boolean getGender()   { return gender; }
	public float   getStrength() { return strength; }
	
	Random rng = new Random();
	ArrayList<Integer> emptyIndices = new ArrayList<Integer>();
	public static Animal[] river = new Animal[20]; // To avoid changing river clones

	public Animal()
	{	
		gender   = rng.nextBoolean();
		strength = rng.nextFloat() * 100;
	}
	
	// Populates river with animals at start
	public void populateRiver()
	{
		while (emptyIndices.size() != 10) // 10 animal requirement at start
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
			findEmpty();
		}
	}
	
	// Makes a bear/fish and spawns it in an empty index
	// 1 = bear, rest = fish
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
	
	// Return a random int representing direction based on index
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
	
	// No implementation necessary
	public void move(int index){};
	
	// Iterate through river and move all animals once
	public void moveAll()
	{
		for (int i = 0; i < 20; i++)
		{
			if (river[i] != null)
			{
				river[i].move(i);
			}
		}
	}
	
	// Return a random empty index
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
	
	public void currentRiverInfo()
	{
		for (int i = 0; i < 20; i++)
		{
			String output = "";
			String animalType = "Fish";
			String genderType = "F";
			
			if (river[i] != null)
			{
				if (river[i].getGender() == false) { genderType = "M"; }
				if (river[i] instanceof Bear) { animalType = "Bear"; }
			    output = String.format("Index %d: %s (Gender: %s | Strength: %.3f)", i, animalType, genderType, river[i].getStrength());
			}
			else
			{
				output = String.format("Index %d: ", i);
			}
			System.out.println(output);
		}
	}
}
