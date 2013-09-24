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
		
		// Bear encounters bear
		if ((river[nextSpot] instanceof Bear) && (nextSpot != index))
		{	
			// 2 fish of different gender
			if (river[index].getGender() != river[nextSpot].getGender())
			{
				// Prevent spawning if river is full
				if (findEmpty() != -1)
				{
					spawn(true);
					moveOutput += "Bears at [" + index + "] and [" + nextSpot + "] spawned a new bear.\n";
				}
				// Randomly place new Bear into river
				else
					moveOutput += "Bears at [" + index + "] and [" + nextSpot + "] could not spawn a new bear. River is full.\n";
			}
			// 2 bears of same gender - moving bear wins
			else if (fight(index, nextSpot))
			{
				moveOutput += "Bear at [" + index + "] defeated bear at [" + nextSpot + "].\n";
			}
			// 2 bears of same gender - moving bear loses
			else
			{
				moveOutput += "Bear at [" + index + "] was killed by bear at [" + nextSpot + "].\n";
			}
		}
		// Moving into index occupied by a Fish
		else if (river[nextSpot] instanceof Fish)
		{
			moveOutput += "Bear at [" + index + "] ate fish at [" + nextSpot + "].\n";
			river[nextSpot] = river[index];
			river[index] = null;
		}
		// Normal move
		else if (nextSpot != index)
		{
			river[nextSpot] = river[index];
			river[index] = null;
			moveOutput += "Bear at [" + index + "] traveled to [" + nextSpot + "].\n";
		}
		// nextSpot was the same as current index
		else
		{
			moveOutput += "Bear at [" + index + "] did not move.\n";
		}
	}
}
