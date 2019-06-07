// Hunter Cavers (1288108)
// Brad Sissons (1300752)

import java.util.ArrayList;

class BoxStack
{
	ArrayList<Box> stack;
	
	public BoxStack()
	{
		stack = new ArrayList<Box>();
	}
	
	public BoxStack(ArrayList<Box> newStack)
	{
		stack = newStack;
	}
	
	public void addBox(Box box)
	{
		stack.add(box);
	}
	
	public ArrayList<Box> getStack()
	{
		return stack;
	}
	
	public int getStackSize()
	{
		return stack.size();
	}
	
	public int getStackHeight()
	{
		int height = 0;
		for(Box box : stack)
		{
			int[] boxValues = box.getTopFace();
			height += boxValues[2];
		}
		return height;
	}
	
	public int getStackHeight(int index)
	{
		int height = 0;
		for(int i = 0; i <= index; i++)
		{
			Box box = stack.get(i);
			int[] boxValues = box.getTopFace();
			height += boxValues[2];
		}
		return height;
	}
	
	public Box getBox(int index)
	{
		return stack.get(index);
	}
	
	public void removeBox(int index)
	{
		stack.remove(index);
	}
	
	public void insertBox(int index, Box box)
	{
		stack.add(index, box);
	}
	
	public void replaceBox(int index, Box box)
	{
		stack.remove(index);
		stack.add(index, box);
	}
	
	public void print()
	{
		int count = 0;
		for(Box box : stack)
		{
			int[] boxValues = box.getTopFace();
			int height = getStackHeight(count);
			String line = String.format("%d %d %d %d", boxValues[0], boxValues[1], boxValues[2], height);
			System.out.println(line);
			count++;
		}
	}
	
	public boolean contains(Box box)
	{
		for(Box value : stack)
		{
			if(box == value)
			{
				return true;
			}
		}
		return false;
	}
}
