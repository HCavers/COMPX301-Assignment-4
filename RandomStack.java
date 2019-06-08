// Hunter Cavers (1288108)
// Brad Sissons (1300752)

import java.util.ArrayList;
import java.util.*;

final class RandomStack
{
	// Gets a psuedo random stack from a population of boxes
	public static BoxStack getRS(ArrayList<Box> pop)
	{
		// Variables needed
		BoxStack rs = new BoxStack();
		ArrayList<Box> tempPop = new ArrayList<Box>(pop);
		int range = tempPop.size();
		// For each box in the population
		for(int i = 0; i < range; i++)
		{
			Box box = tempPop.get(i);
			int[] boxValues = box.getTopFace();
			// Check each face of the box to set the top face as the face with the biggest area
			if(boxValues[0] > boxValues[1])
			{
				if(boxValues[0] > boxValues[2])
				{
					if(boxValues[1] > boxValues[2])
					{
						box.setTopFace(1); //0, 1, 2
					}
					else
					{
						box.setTopFace(2); //0, 2, 1
					}
				}
				else
				{
					box.setTopFace(5); //2, 0, 1
				}
			}
			else
			{
				if(boxValues[0] > boxValues[2])
				{
					box.setTopFace(3); //1, 0, 2
				}
				else
				{
					if(boxValues[1] > boxValues[2])
					{
						box.setTopFace(4); //1, 2, 0
					}
					else
					{
						box.setTopFace(6); //2, 1, 0
					}
				}
			}
		}
		// Sort boxs to have biggest area first
		Comparator<Box> compareByArea = new Comparator<Box>()
		{
			@Override
			public int compare(Box b1, Box b2)
			{
				Integer area1 = b1.getTopFace()[0] * b1.getTopFace()[1];
				Integer area2 = b2.getTopFace()[0] * b2.getTopFace()[1];
				return area1.compareTo(area2);
			}
		};
		
		Collections.sort(tempPop, compareByArea);
		Collections.reverse(tempPop);
		// Loop from biggest box to smallest box
		while(range != 0)
		{
			// Get box from stack 
			Box newBox = tempPop.get(0);
			tempPop.remove(0);
			// If the stack is not empty
			if(rs.getStackSize() != 0)
			{
				// Check if new box fits on top of the stack
				Box topBox = rs.getBox(rs.getStackSize() - 1);
				
				int[] topBoxValues = topBox.getTopFace();
				int[] newBoxValues = newBox.getTopFace();
				
				if((newBoxValues[0] < topBoxValues[0]) && (newBoxValues[1] < topBoxValues[1]))
				{
					// If it does then add to top of stack
					rs.addBox(newBox);
				}
			}
			else
			{
				// Otherwise add box to empty stack
				rs.addBox(newBox);
			}
			range--;
		}
		return rs;
	}
}
