// Hunter Cavers (1288108)
// Brad Sissons (1300752)

class Box
{
	// Instance Variables
	private int x;			// x dimension of box
	private int y;			// y dimension of box
	private int z;			// z dimension of box
	private int topFace;	// The top face of the box
	
	// Constructor
	public Box(int d1, int d2, int d3)
	{
		x = d1;
		y = d2;
		z = d3;
		topFace = 1;
	}
	
	// Returns dimensions in face 1 orientation
	public int[] getFace1()
	{
		int[] array = new int[] {x, y, z}; //0, 1, 2
		return array;
	}
	
	// Returns dimensions in face 2 orientation
	public int[] getFace2()
	{
		int[] array = new int[] {x, z, y}; //0, 2, 1
		return array;
	}
	
	// Returns dimensions in face 3 orientation
	public int[] getFace3()
	{
		int[] array = new int[] {y, x, z}; //1, 0, 2
		return array;
	}
	
	// Returns dimensions in face 4 orientation
	public int[] getFace4()
	{
		int[] array = new int[] {y, z, x}; //1, 2, 0
		return array;
	}
	
	// Returns dimensions in face 5 orientation
	public int[] getFace5()
	{
		int[] array = new int[] {z, x, y}; //2, 0, 1
		return array;
	}
	
	// Returns dimensions in face 6 orientation
	public int[] getFace6()
	{
		int[] array = new int[] {z, y, x}; //2, 1, 0
		return array;
	}
	
	// Sets which face is on top
	public void setTopFace(int face)
	{
		// Make sure inut is within bounds
		if(face < 1 || face > 6)
		{
			throw new IndexOutOfBoundsException("Index must be between 1 and 6");
		}
		else
		{
			topFace = face;
		}
	}
	
	// Returns dimensions in top face orientation
	public int[] getTopFace()
	{
		if(topFace == 1)
		{
			return getFace1();
		}
		else if(topFace == 2)
		{
			return getFace2();
		}
		else if(topFace == 3)
		{
			return getFace3();
		}
		else if(topFace == 4)
		{
			return getFace4();
		}
		else if(topFace == 5)
		{
			return getFace5();
		}
		else if(topFace == 6)
		{
			return getFace6();
		}
		else
		{
			return null;
		}
	}
}
