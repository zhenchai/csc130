package proj1fa13;

public class Bear extends Animal {
	
	/**
	 * Default constructor of Bear class. Each bear is generated
	 * with a random gender and strength.
	 */
	public Bear()
	{
		super();
	}
	
	/**
	 * Overrides move() in Animal. Checks for encounters and 
	 * provides the output accordingly.
	 * 
	 * @param index the current index of the bear being moved
	 */
	public void move(int index)
	{
		super.move(index);
		if ((river[nextSpot] instanceof Bear) && (nextSpot != index))
		{	
			// Prevent spawning if river is full
			if (indexGender != nextGender)
			{
				if (findEmpty() != -1)
				{
					spawn(1);
					moveOutput += "Bears at [" + index + "] and [" + nextSpot + "] spawned a new bear.\n";
				}
				else
					moveOutput += "Bears at [" + index + "] and [" + nextSpot + "] could not spawn a new bear. River is full.\n";
			}
			else if (indexStr >= nextStr)
			{
				river[nextSpot] = river[index];
				moveOutput += "Bear at [" + index + "] defeated bear at [" + nextSpot + "].\n";
				river[index] = null;
			}
			else
			{
				moveOutput += "Bear at [" + index + "] was killed by bear at [" + nextSpot + "].\n";
				river[index] = null;
			}
		}
		else if (river[nextSpot] instanceof Fish)
		{
			moveOutput += "Bear at [" + index + "] ate fish at [" + nextSpot + "].\n";
			river[nextSpot] = river[index];
			river[index] = null;
		}
		else if (nextSpot != index)
		{
			river[nextSpot] = river[index];
			river[index] = null;
			moveOutput += "Bear at [" + index + "] traveled to [" + nextSpot + "].\n";
		}
		else
		{
			moveOutput += "Bear at [" + index + "] did not move.\n";
		}
	}
}
