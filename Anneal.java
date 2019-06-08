// Hunter Cavers (1288108)
// Brad Sissons (1300752)

import java.util.ArrayList;

class Anneal
{
	public static BoxStack process(BoxStack is, int temp, double cool, ArrayList<Box> pop)
	{
		// Variables needed
		double cooling = 1 - cool;		// Value used to cool temperature
		int temperature = temp;			// Temperature
		BoxStack current = is;			// The current stack
		BoxStack best = is;				// The best stack
		int count = 0;
		// While temperature has not cooled down
		while(temperature > 1)
		{
			// Mutate current box
			BoxStack next = mutate(current, pop);
			// Get the heights of the current and the mutated box
			int currentHeight = current.getStackHeight();
			int nextHeight = next.getStackHeight();
			// If mutated box is better than current box
			if(nextHeight > currentHeight)
			{
				// Make current the mutated box
				current = next;
			}
			// If current box is better than the best box 
			if(current.getStackHeight() > best.getStackHeight())
			{
				// Set best as current
				best = current;
			}
			// Cool the temperature down and increae the count
			temperature *= cooling;
			count++;
		}
		// Print out how many loops were made and the best stack found
		String line = String.format("%d number of loops made", count);
		System.out.println(line);
		return best;
	}
	
	// Mutates the stack passed in with random changes
	private static BoxStack mutate(BoxStack stack, ArrayList<Box> pop)
	{
		// Make a clone of the current stack
		BoxStack newStack = new BoxStack(new ArrayList<Box>(stack.getStack()));
		// Fill an array with 10 boxes from population that are not already in stack
		Box[] newBoxes = new Box[10];
		int count = 0;
		while(count < 10)
		{
			int index = (int)(Math.random() * pop.size());
			if(!stack.contains(pop.get(index)))
			{
				newBoxes[count] = pop.get(index);
				count++;
			}
		}
		// Loop through each box in the stack
		for(int i = 0; i < newStack.getStackSize(); i++)
		{
			// Loop through each of the randomly selected boxes
			for(Box box : newBoxes)
			{
				// Loop through each of the faces the box could have
				boolean needBreak = false;
				for(int j = 1; j < 7; j++)
				{
					box.setTopFace(j);
					// Check if box is a better fit in the stack than the current box at position i
					if(replace(i, box, newStack))
					{
						// If box is better then replace it
						newStack.replaceBox(i, box);
						needBreak = true;
						break;
					}
					if(needBreak)
					{
						break;
					}
				}
			}
		}
		return newStack;
	}
	
	// Checks if box can replace box at position i in stack
	private static boolean replace(int index, Box box, BoxStack stack)
	{
		// Boolean variables to use as flags
		boolean belowTop = false;
		boolean aboveBottom = false;
		
		// If we are at bottom box then return as bottom box is always the box with the biggest area
		if(index == 0)
		{
			return false;
		}
		else
		{
			// Otherwise get box above current position and check if supplied box is bigger and can underneath it
			Box topBox = stack.getBox(index - 1);
			if(box.getTopFace()[0] < topBox.getTopFace()[0] && box.getTopFace()[1] < topBox.getTopFace()[1])
			{
				if(box.getTopFace()[2] > topBox.getTopFace()[2])
				{
					// If it is bigger and has a better height then set flag for replacement
					belowTop = true;
				} 
			}
		}
		// If we are at the top box the set flag as good as we dont need to be smaller than a box above us
		if(index == stack.getStackSize() - 1)
		{
			aboveBottom = true;
		}
		else
		{
			// Otherwise get box above us and check that supplied box is smaller 
			Box belowBox = stack.getBox(index + 1);
			if(box.getTopFace()[0] > belowBox.getTopFace()[0] && box.getTopFace()[1] > belowBox.getTopFace()[1])
			{
				if(box.getTopFace()[2] > box.getTopFace()[2])
				{
					// If it is smaller then set flag for replacement
					aboveBottom = true;
				}
			}
		}
		// If both flags are set for replacement then return true otherwise return false
		if(belowTop == true && aboveBottom == true)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
