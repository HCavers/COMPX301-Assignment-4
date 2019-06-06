import java.util.ArrayList;
import java.io.FileNotFoundException;

class NPStack
{
	static int temperature;
	static int cooling;
	static String inputFileName = "";
	
	public static void main(String[] args) throws FileNotFoundException {
		for(int i = 0; i < args.length; i++)
		{
			try
			{
				if (args[i].equals("-f")) inputFileName = args[i + 1];
				if (args[i].equals("-t")) temperature = Integer.parseInt(args[i + 1]);
				if (args[i].equals("-c")) cooling = Integer.parseInt(args[i + 1]);
			}
			catch(Exception e)
			{
				System.err.println("Please enter valid arguemnts. Use -f to specify the input file, -t to specify the temperature and -c to specify the cooling");
			}
		}
		
		if(inputFileName == "")
		{
			System.out.println("Enter File Name:");
			inputFileName = System.console().readLine();
		}
		
		ArrayList<Box> boxes = loadBox.load(inputFileName);
		BoxStack stack = RandomStack.getRS(boxes);
		stack.print();
	}
}
