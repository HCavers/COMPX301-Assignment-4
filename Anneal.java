import java.util.ArrayList;

class Anneal
{
	public static BoxStack process(BoxStack is, int temp, double cool, ArrayList<Box> pop)
	{
		double cooling = 1 - cool;
		int temperature = temp;
		BoxStack current = is;
		BoxStack best = is;
		RandomStack rs = new RandomStack();
		int count = 0;
		while(temperature > 1)
		{
			BoxStack next = rs.getRS(pop);
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
}