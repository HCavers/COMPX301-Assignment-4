// Hunter Cavers (1288108)
// Brad Sissons (1300752)

class Box
{
	private int x;
	private int y;
	private int z;
	private int topFace;
	
	public Box(int d1, int d2, int d3)
	{
		x = d1;
		y = d2;
		z = d3;
		topFace = 1;
	}
	
	public int[] getFace1()
	{
		int[] array = new int[] {x, y, z}; //0, 1, 2
		return array;
	}
	
	public int[] getFace2()
	{
		int[] array = new int[] {x, z, y}; //0, 2, 1
		return array;
	}
	
	public int[] getFace3()
	{
		int[] array = new int[] {y, x, z}; //1, 0, 2
		return array;
	}
	
	public int[] getFace4()
	{
		int[] array = new int[] {y, z, x}; //1, 2, 0
		return array;
	}
	
	public int[] getFace5()
	{
		int[] array = new int[] {z, x, y}; //2, 0, 1
		return array;
	}
	
	public int[] getFace6()
	{
		int[] array = new int[] {z, y, x}; //2, 1, 0
		return array;
	}
	
	public void setTopFace(int face)
	{
		if(face < 1 || face > 6)
		{
			throw new IndexOutOfBoundsException("Index must be between 1 and 6");
		}
		else
		{
			topFace = face;
		}
	}
	
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
