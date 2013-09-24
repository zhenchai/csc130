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
		
		// Fish encounters fish
		if ((river[nextSpot] instanceof Fish) && (nextSpot != index))
		{	
			// 2 fish of different gender
			if (river[index].getGender()!= river[nextSpot].getGender())
			{
				// Prevent spawning if river is full
				if (findEmpty() != -1)
				{
					spawn(false);
					moveOutput += "Fish at [" + index + "] and [" + nextSpot + "] spawned a new fish.\n";
				}
				// Randomly place new Fish into river
				else
					moveOutput += "Fish at [" + index + "] and [" + nextSpot + "] could not spawn a new fish. River is full.\n";
			}
			
			// 2 fish of same gender - moving fish wins
			else if (fight(index, nextSpot))
			{
				moveOutput += "Fish at [" + index + "] defeated fish at [" + nextSpot + "]\n";
			}
			// 2 fish of same gender - moving fish loses
			else
			{
				moveOutput += "Fish at [" + index + "] was killed by fish at [" + nextSpot + "]\n";
			}
		}
		// Moving into index occupied by a Bear
		else if (river[nextSpot] instanceof Bear)
		{
			moveOutput += "Fish at [" + index + "] swam to bear at [" + nextSpot + "] and was eaten.\n";
			river[index] = null;
		}
		// Normal move
		else if (nextSpot != index)
		{
			moveOutput += "Fish at [" + index + "] traveled to [" + nextSpot + "].\n";
			river[nextSpot] = river[index];
			river[index] = null;
		}
		// nextSpot was the same as current index
		else
		{
			moveOutput += "Fish at [" + index + "] did not move.\n";
		}		
	}
}
