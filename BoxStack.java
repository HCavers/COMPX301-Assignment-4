// Hunter Cavers (1288108)
// Brad Sissons (1300752)

import java.util.ArrayList;

class BoxStack
{
	// Instance variables
	ArrayList<Box> stack;		// List to hold stack
	
	// Constructor that makes a new empty stack
	public BoxStack()
	{
		stack = new ArrayList<Box>();
	}
	
	// Constructor that takes a existing list
	public BoxStack(ArrayList<Box> newStack)
	{
		stack = newStack;
	}
	
	// Add a box to the stack
	public void addBox(Box box)
	{
		stack.add(box);
	}
	
	// Returns the stack
	public ArrayList<Box> getStack()
	{
		return stack;
	}
	
	// Get the number of elements in the stack
	public int getStackSize()
	{
		return stack.size();
	}
	
	// Calculates the height of all boxes in the stack
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
	
	// Calculates the height of the stack up to box at position index
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
	
	// Gets the box at position index
	public Box getBox(int index)
	{
		return stack.get(index);
	}
	
	// Removes the box at position index
	public void removeBox(int index)
	{
		stack.remove(index);
	}
	
	// Inserts the box into position index
	public void insertBox(int index, Box box)
	{
		stack.add(index, box);
	}
	
	// Replaces the box at position index with box given as input
	public void replaceBox(int index, Box box)
	{
		stack.remove(index);
		stack.add(index, box);
	}
	
	// Prints the contents of the stack to standard out
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
	
	// Checks if the stack already contains the box
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
