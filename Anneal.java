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
			BoxStack next = RandomStack.getRS(pop);
			int currentHeight = current.getStackHeight();
			int nextHeight = next.getStackHeight();
			if(nextHeight > currentHeight)
			{
				current = next;
			}
			else
			{
				double energy = (currentHeight - nextHeight) / temperature;
				double prob = Math.random();
				if(energy < prob)
				{
					current = next;
				}
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
			if(stack.contains(pop.get(index)))
			{
				newBoxes[count] = pop.get(index);
				count++;
			}
		}
		
		return null;
	}
}