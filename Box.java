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
		int[] array = new int[] {x, z, y};
		return array;
	}
	
	public int[] getFace2()
	{
		int[] array = new int[] {y, z, x};
		return array;
	}
	
	public int[] getFace3()
	{
		int[] array = new int[] {x, y, z};
		return array;
	}
	
	public void setTopFace(int face)
	{
		if(face < 1 || face > 3)
		{
			throw new IndexOutOfBoundsException("Index must be between 1 and 3");
		}
		else
		{
			topFace = face;
		}
	}
	
	public int [] getTopFace()
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
		else
		{
			return null;
		}
	}
}