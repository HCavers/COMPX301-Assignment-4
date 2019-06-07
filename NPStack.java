// Hunter Cavers (1288108)
// Brad Sissons (1300752)

import java.util.ArrayList;
import java.io.FileNotFoundException;

class NPStack
{
	// Default values of parameters
	static int temperature = 10000;
	static int cooling = 0.3;
	static String inputFileName = "";
	
	public static void main(String[] args) throws FileNotFoundException {
		// For each arguments
		for(int i = 0; i < args.length; i++)
		{
			try
			{
				// Check if they match input parameters
				if (args[i].equals("-f")) inputFileName = args[i + 1];
				if (args[i].equals("-t")) temperature = Integer.parseInt(args[i + 1]);
				if (args[i].equals("-c")) cooling = Integer.parseInt(args[i + 1]);
			}
			catch(Exception e)
			{
				System.err.println("Please enter valid arguemnts. Use -f to specify the input file, -t to specify the temperature and -c to specify the cooling");
			}
		}
		
		// Check if file was entered
		if(inputFileName == "")
		{
			System.out.println("Enter File Name:");
			inputFileName = System.console().readLine();
		}
		
		// Load in boxes from file
		ArrayList<Box> boxes = loadBox.load(inputFileName);
		// Make a random stack
		BoxStack stack = RandomStack.getRS(boxes);
		// Anneal random for better solution
		BoxStack newStack = Anneal.process(stack, temperature, cooling, boxes);
		// Print stack
		newStack.print();
	}
}
