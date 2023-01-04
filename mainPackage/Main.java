package mainPackage;

import backcode.Display;
import dataStructures.InteractiveData;

public class Main {

	public static void main(String[] args) {
		// Creates a display
		Display display = new Display();

		// Get the windows of Data Structures
		InteractiveData[] dataStructures = display.getDs();

		// Checks whenever the display is showing and not closed, if it is close
		// terminate the program and close everything
		while (display.isShowing()) {

			for (int i = 0; i < dataStructures.length; i++) {
				if (dataStructures[i] != null) {

					// If one of the Window of Data Structure was closed free the spot for the new
					// Window
					if (!dataStructures[i].isShowing()) {
						dataStructures[i].closeFrame();
						dataStructures[i] = null;
					}
				}
			}
		}

		// Help Garbage collector
		display.closeAll();
		display = null;
		dataStructures = null;
		System.exit(0);
	}

}
