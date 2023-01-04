package backcode;

import javax.swing.JOptionPane;

public class Menu {

	// Input from the menu stored as a string
	private String userInput;

	/**
	 * Initializes the menu and immediately asks for input
	 */
	Menu() {
		askInput();
	}

	/**
	 * Displays Info about the data structure chosen by user as Pop-up window, if
	 * input is null does nothing
	 */
	public void getInfo() {

		switch (userInput) {

		case ("1"):
			JOptionPane.showMessageDialog(null,
					"ArrayList in Java is used to store dynamically \n"
							+ "sized collection of elements. Contrary to Arrays \n"
							+ "that are fixed in size, an ArrayList grows its size \n"
							+ "automatically when new elements are added to it.");
			break;

		case ("2"):
			JOptionPane.showMessageDialog(null,
					"Vector implements a dynamic array that means \n"
							+ "it can grow or shrink as required. Like an array, \n"
							+ "it contains components that can be accessed \n" + "using an integer index.");
			break;

		case ("3"):
			JOptionPane.showMessageDialog(null,
					"A stack is a conceptual structure consisting \n"
							+ "of a set of homogeneous elements and is based on \n"
							+ "the principle of last in first out (LIFO).");
			break;

		case ("4"):
			JOptionPane.showMessageDialog(null,
					"A queue is a conceptual structure consisting \n"
							+ "of a set of homogeneous elements and is based on \n"
							+ "the principle of first in first out (FIFO).");
			break;

		}
	}

	/**
	 * Asks an input from the user and stores it as a String, if user wishes to
	 * cancel the menu store input as null
	 */
	public void askInput() {

		userInput = JOptionPane.showInputDialog(null, "Please enter the DataType. Examples are: " + "\n1) ArrayList"
				+ "\n2) Vector" + "\n3) Stack" + "\n4) Queue" + "\n5) Quit");
		if (userInput == null) {
			return;
		}

		// Checks if input from user if one of the menu options, if not ask again
		while (checkMistake()) {

			userInput = JOptionPane.showInputDialog(null, "Incorrect input. Try again: " + "\n1) ArrayList"
					+ "\n2) Vector" + "\n3) Queue" + "\n4) Stack" + "\n5) Quit");
			if (userInput == null) {
				return;
			}
		}
	}

	/**
	 * Returns the current user input as String
	 * 
	 * @return
	 */
	public String getInput() {
		return userInput;
	}

	/**
	 * Protected helping method to check for mistake in the Input from the user,
	 * returns true if user picked a non existing object
	 * 
	 * @return true if user picked a non existing object
	 */
	protected boolean checkMistake() {

		boolean result = false;
		switch (userInput) {

		case ("1"):
			break;

		case ("2"):
			break;

		case ("3"):
			break;

		case ("4"):
			break;

		case ("5"):
			break;

		default:
			result = true;
		}

		return result;
	}
}
