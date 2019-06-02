// Hunter Cavers (1288108)
// Brad Sissons (1300752)

class Box
{
	private int x;
	private int y;
	private int z;
	
	public Box(int d1, int d2, int d3)
	{
		x = d1;
		y = d2;
		z = d3;
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
}