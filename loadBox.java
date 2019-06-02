// Hunter Cavers (1288108)
// Brad Sissons (1300752)

import java.util.*;

class loadBox {
	public static ArrayList<Box> load(String fileName) {
		ArrayList<Box> boxes = new ArrayList<Box>();
		
		Scanner sc = new Scanner(fileName);
		
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
