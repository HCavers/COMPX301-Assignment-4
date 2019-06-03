// Hunter Cavers (1288108)
// Brad Sissons (1300752)

import java.util.ArrayList;

class RandomStack
{
	BoxStack rs;
	
	public RandomStack()
	{
		rs = new BoxStack();
	}
	
	public BoxStack getRS(ArrayList<Box> pop)
	{
		ArrayList<Box> tempPop = new ArrayList<Box>(pop);
		int range = tempPop.size();

		while(range > 0)
		{
			int boxPos = ((int)(Math.random() * range));
			Box newBox = tempPop.get(boxPos);
			tempPop.remove(boxPos);
			newBox.setTopFace((int)(Math.random() * 3) + 1);
			
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
