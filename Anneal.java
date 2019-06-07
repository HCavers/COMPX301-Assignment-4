import java.util.ArrayList;

class Anneal
{
	public static BoxStack process(BoxStack is, int temp, double cool, ArrayList<Box> pop)
	{
		double cooling = 1 - cool;
		int temperature = temp;
		BoxStack current = is;
		BoxStack best = is;
		int count = 0;
		while(temperature > 1)
		{
			BoxStack next = mutate(current, pop);
			int currentHeight = current.getStackHeight();
			int nextHeight = next.getStackHeight();
			if(nextHeight > currentHeight)
			{
				current = next;
			}
			
			if(current.getStackHeight() > best.getStackHeight())
			{
				best = current;
			}
			temperature *= cooling;
			count++;
		}
		String line = String.format("%d number of loops made", count);
		System.out.println(line);
		return best;
	}
	
	private static BoxStack mutate(BoxStack stack, ArrayList<Box> pop)
	{
		BoxStack newStack = new BoxStack(new ArrayList<Box>(stack.getStack()));
		Box[] newBoxes = new Box[5];
		int count = 0;
		while(count < 5)
		{
			int index = (int)(Math.random() * pop.size());
			if(!stack.contains(pop.get(index)))
			{
				newBoxes[count] = pop.get(index);
				count++;
			}
		}
		//insert
		/*
		for(int j = 0; j < 5; j++)
		{
			for(int k = 1; k < 7; k++)
			{
				for(int i = 0; i < stack.getStackSize() - 1; i++)
				{
					newBoxes[j].setTopFace(k);
					if((newBoxes[j].getTopFace()[0] < newStack.getBox(i).getTopFace()[0]) && (newBoxes[j].getTopFace()[1] < newStack.getBox(i).getTopFace()[1]) && (newBoxes[j].getTopFace()[0] > newStack.getBox(i+1).getTopFace()[0]) && (newBoxes[j].getTopFace()[1] > newStack.getBox(i+1).getTopFace()[1]))
					{
						newStack.insertBox(i, newBoxes[j]);
						break;
					}
				}
			}
		}
		*/
		//replace
		
		for(int i = 0; i < stack.getStackSize() - 2; i++)
		{
			for(int j = 0; j < 5; j++)
			{
				for(int k = 1; k < 7; k++)
				{
					newBoxes[j].setTopFace(k);
					//newStack.replaceBox(
					if((newBoxes[j].getTopFace()[0] < newStack.getBox(i).getTopFace()[0]) && (newBoxes[j].getTopFace()[1] < newStack.getBox(i).getTopFace()[1]) && (newBoxes[j].getTopFace()[0] > 				   newStack.getBox(i+2).getTopFace()[0]) && (newBoxes[j].getTopFace()[1] > newStack.getBox(i+2).getTopFace()[1]) && (newBoxes[j].getTopFace()[2] > newStack.getBox(i+1).getTopFace()[2]))
					{
						newStack.replaceBox(i+1, newBoxes[j]);
						break;
					}
				}
			}
		}
		return newStack;
	}
	
	private void replace(int index, Box box, BoxStack stack)
	{
		boolean belowTop = false;
		boolean aboveBottom = false;
		
		if(index == 0)
		{
			//return false;
		}
		else
		{
			Box topBox = stack.getBox(index - 1);
			if(box.getTopFace()[0] < topBox.getTopFace()[0] && box.getTopFace()[1] < topBox.getTopFace()[1])
			{
				//if(box.getTopFace()[0] > 
			}
		}
	}
}
