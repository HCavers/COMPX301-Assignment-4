// Hunter Cavers (1288108)
// Brad Sissons (1300752)

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

// Static class to load boxes from file
final class loadBox {
	// Static method to call
	public static ArrayList<Box> load(String fileName) throws FileNotFoundException {
		// Objects needed to read from file
		ArrayList<Box> boxes = new ArrayList<Box>();
		File file = new File(fileName);
		Scanner sc = new Scanner(file);
		// Variables needed to read from file
		String line = "";
		String[] boxValues;
		// While the file has input
		while (sc.hasNext()) {
			// Read and split the line
			line = sc.nextLine();			
			boxValues = line.split(" ");
			// Check line has correct number of elements
			if (boxValues.length == 3) {
				int[] boxInts = new int[] {Integer.parseInt(boxValues[0]), Integer.parseInt(boxValues[1]), Integer.parseInt(boxValues[2])};
				// Check all values are positive integers
				if ((boxInts[0] > 0) && (boxInts[1] > 0) && (boxInts[2] > 0)) {
					// Make new box and add to list
					Box box = new Box(boxInts[0], boxInts[1], boxInts[2]);
					boxes.add(box);
				}
			}
		}
		return boxes;
	}
}
