package proj1fa13;

public class Fish extends Animal {

	public Fish()
	{
		super();
	}
	
	public void move(int index)
	{
		int nextSpot = index + moveDirection(index);
		if ((river[nextSpot] instanceof Fish) && (nextSpot != index))
		{
			float indexStr = river[index].getStrength();
			float nextStr = river[nextSpot].getStrength();
			boolean indexGender = river[index].getGender();
			boolean nextGender = river[nextSpot].getGender();
			
			if ((indexGender != nextGender) && (findEmpty() != -1))
			{
				spawn(2);
				System.out.println("Another fish has spawned.");
			}
			else if (indexStr >= nextStr)
			{
				
				river[nextSpot] = river[index];
				System.out.println("Fish at [" + index + "] defeated fish at [" + nextSpot + "]");
				river[index] = null;
			}
			else
			{
				System.out.println("Fish at [" + index + "] was killed by fish at [" + nextSpot + "]");
				river[index] = null;
			}
		}
		else if (river[nextSpot] instanceof Bear)
		{
			System.out.println("Fish at [" + index + "] swam to bear at [" + nextSpot + "] and was eaten.");
			river[index] = null;
		}
		else if (nextSpot != index)
		{
			System.out.println("Fish at [" + index + "] traveled to [" + nextSpot + "].");
			river[nextSpot] = river[index];
			river[index] = null;
		}
	}
}
