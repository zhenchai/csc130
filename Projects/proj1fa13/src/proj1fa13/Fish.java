package proj1fa13;

public class Fish extends Animal {
	
	/**
	 * Default constructor of Fish class. Each fish is generated
	 * with a random gender and strength.
	 */
	public Fish()
	{
		super();
	}
	
	/**
	 * Overrides move() in Animal. Checks for encounters and 
	 * provides the output accordingly.
	 * 
	 * @param index the current index of the fish being moved
	 */
	public void move(int index)
	{
		super.move(index);
		if ((river[nextSpot] instanceof Fish) && (nextSpot != index))
		{	
			if ((indexGender != nextGender) && (findEmpty() != -1))
			{
				spawn(2);
				moveOutput += "Fish at [" + index + "] and [" + nextSpot + "] spawned a new fish.\n";
			}
			else if (indexStr >= nextStr)
			{
				river[nextSpot] = river[index];
				moveOutput += "Fish at [" + index + "] defeated fish at [" + nextSpot + "]\n";
				river[index] = null;
			}
			else
			{
				moveOutput += "Fish at [" + index + "] was killed by fish at [" + nextSpot + "]\n";
				river[index] = null;
			}
		}
		else if (river[nextSpot] instanceof Bear)
		{
			moveOutput += "Fish at [" + index + "] swam to bear at [" + nextSpot + "] and was eaten.\n";
			river[index] = null;
		}
		else if (nextSpot != index)
		{
			moveOutput += "Fish at [" + index + "] traveled to [" + nextSpot + "].\n";
			river[nextSpot] = river[index];
			river[index] = null;
		}
		else
		{
			moveOutput += "Fish at [" + index + "] did not move.\n";
		}		
	}
}
