// Hunter Cavers (1288108)
// Brad Sissons (1300752)

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
final class loadBox {
	public static ArrayList<Box> load(String fileName) throws FileNotFoundException {
		ArrayList<Box> boxes = new ArrayList<Box>();
		File file = new File(fileName);
		Scanner sc = new Scanner(file);
		
		String line = "";
		String[] boxValues;
		
		while (sc.hasNext()) {
			line = sc.nextLine();
			
			boxValues = line.split(" ");
			
			if (boxValues.length == 3) {
				int[] boxInts = new int[] {Integer.parseInt(boxValues[0]), Integer.parseInt(boxValues[1]), Integer.parseInt(boxValues[2])};
			
				if ((boxInts[0] > 0) && (boxInts[1] > 0) && (boxInts[2] > 0)) {
					Box box = new Box(boxInts[0], boxInts[1], boxInts[2]);
					boxes.add(box);
				}
			}
		}
		return boxes;
	}
}
