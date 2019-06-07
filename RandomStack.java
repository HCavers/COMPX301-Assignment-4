// Hunter Cavers (1288108)
// Brad Sissons (1300752)

import java.util.ArrayList;
import java.util.*;

final class RandomStack
{
	public static BoxStack getRS(ArrayList<Box> pop)
	{
		BoxStack rs = new BoxStack();
		ArrayList<Box> tempPop = new ArrayList<Box>(pop);
		int range = tempPop.size();
		
		for(int i = 0; i < range; i++)
		{
			Box box = tempPop.get(i);
			int[] boxValues = box.getTopFace();
			
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
		
		while(range != 0)
		{
			Box newBox = tempPop.get(0);
			tempPop.remove(0);
			
			if(rs.getStackSize() != 0)
			{
				Box topBox = rs.getBox(rs.getStackSize() - 1);
				
				int[] topBoxValues = topBox.getTopFace();
				int[] newBoxValues = newBox.getTopFace();
				
				if((newBoxValues[0] < topBoxValues[0]) && (newBoxValues[1] < topBoxValues[1]))
				{
					rs.addBox(newBox);
				}
			}
			else
			{
				rs.addBox(newBox);
			}
			range--;
		}
		return rs;
	}
}
