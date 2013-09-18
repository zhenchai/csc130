package proj1fa13;

public class Bear extends Animal {
	
	public Bear()
	{
		super();
	}
	
	public void move(int index)
	{
		int nextSpot = index + moveDirection(index);
		if ((river[nextSpot] instanceof Bear) && (nextSpot != index))
		{
			float indexStr = river[index].getStrength();
			float nextStr = river[nextSpot].getStrength();
			boolean indexGender = river[index].getGender();
			boolean nextGender = river[nextSpot].getGender();
			
			// Do not spawn more if river is full
			if ((indexGender != nextGender) && (findEmpty() != -1))
			{
				spawn(1);
				System.out.println("Another bear has spawned.");
			}
			else if (indexStr >= nextStr)
			{
				river[nextSpot] = river[index];
				System.out.println("Bear at [" + index + "] defeated bear at [" + nextSpot + "].");
				river[index] = null;
			}
			else
			{
				System.out.println("Bear at [" + index + "] was killed by bear at [" + nextSpot + "].");
				river[index] = null;
			}
		}
		else if (river[nextSpot] instanceof Fish)
		{
			System.out.println("Bear at [" + index + "] ate fish at [" + nextSpot + "].");
			river[nextSpot] = river[index];
			river[index] = null;
		}
		else if (nextSpot != index)
		{
			river[nextSpot] = river[index];
			river[index] = null;
			System.out.println("Bear at [" + index + "] traveled to [" + nextSpot + "].");
		}
	}
}
