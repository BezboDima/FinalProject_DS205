package dataStructures;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

import backcode.Buttons;
import backcode.CustomLabel;
import backcode.OneDialogue;
import backcode.TwoDialogue;

/**
 * Vector implements functions of Actionlistener and InteractiveData. It can
 * be displayed on the Screen and behaves like an Vector
 * 
 * @author Dmitry
 *
 */
public class Vector implements ActionListener, InteractiveData {

	// VectorDataStructure Simulator uses custom buttons and label
	private CustomLabel arrayLabel = new CustomLabel();
	private Buttons buttons = new Buttons();
	private JFrame frame = new JFrame("Vector");

	/**
	 * Initializes the frame and makes it visible
	 */
	public Vector() {

		frame.setLayout(new GridLayout(0, 1));
		frame.setSize(720, 240);

		buttons.addListener(this);

		frame.add(buttons.getPanel());
		frame.add(arrayLabel.getPanel());

		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.setVisible(true);

	}

	/**
	 * Adds the element at the given position with shifting of other elements in
	 * front. And makes the added element green. If pop-window is closed does
	 * nothing Element must be positive integer below 10 for design purposes
	 */
	public void addElement() {

		if (arrayLabel.getSize() == 5) {
			JOptionPane.showMessageDialog(null, "Vector Is Full");
			return;
		}

		TwoDialogue diolog = new TwoDialogue();
		int position = 0;
		int number = -1;

		do {
			diolog.askInputMessage("Positive Number below 10: ", "Position below 5: ");

			// If user inputed non-integer asks for input again
			try {
				number = Integer.parseInt(diolog.getInput());
				position = Integer.parseInt(diolog.getSecondInput());
			} catch (NumberFormatException ex) {
				continue;
			}

			// If position is more than the size of array or number does not follow the
			// requirement ask again for input
			if (number > 0 && number < 10 && position >= 1 && position <= 5) {
				arrayLabel.addInFront(position, number);
				arrayLabel.setColorGreen(position);
				break;
			}

		} while (diolog.getResult() == JOptionPane.OK_OPTION);

	}

	/**
	 * Changes the element at the given position. And makes the changed element
	 * blue. If pop-window is closed does nothing Element must be positive integer
	 * below 10 for design purposes
	 */
	public void changeElement() {

		TwoDialogue diolog = new TwoDialogue();
		int position = 0;
		int number = -1;

		// If user inputed non-integer asks for input again
		do {
			diolog.askInputMessage("Positive Number below 10: ", "Position below 5: ");
			try {
				number = Integer.parseInt(diolog.getInput());
				position = Integer.parseInt(diolog.getSecondInput());
			} catch (NumberFormatException ex) {
				continue;
			}

			// If position is more than the size of array or number does not follow the
			// requirement ask again for input
			if (number > 0 && number < 10 && position >= 1 && position <= 5) {
				arrayLabel.setNumber(position, number);
				arrayLabel.setColorBlue(position);
				break;
			}

		} while (diolog.getResult() == JOptionPane.OK_OPTION);

	}

	/**
	 * Removes the element at the given position. And makes the removed element red.
	 * If pop-window is closed does nothing
	 */
	public void removeElement() {

		if (arrayLabel.getSize() == 0) {
			JOptionPane.showMessageDialog(null, "Vector Is Empty");
			return;
		}

		OneDialogue diolog = new OneDialogue();
		int position = 0;

		// If user inputed non-integer asks for input again
		do {
			diolog.askInputMessage("Please input the position of 5 or less");

			try {
				position = Integer.parseInt(diolog.getInput());
			} catch (NumberFormatException ex) {
				continue;
			}

			// If position is more than the size of array ask again for input
			if (position >= 1 && position <= 5) {
				arrayLabel.removeNumber(position);
				arrayLabel.setColorRed(position);
				break;
			}

		} while (diolog.getResult() == JOptionPane.OK_OPTION);

	}

	/**
	 * Clears the array
	 */
	public void clear() {

		arrayLabel.clearLabel();
	}

	/**
	 * Closes the frame and makes it invisible
	 */
	public void closeFrame() {
		frame.setVisible(false);
	}

	/**
	 * Checks if frame is showing on the screen
	 */
	public boolean isShowing() {
		return frame.isShowing();

	}

	/**
	 * Keeps track of the buttons pushed and performs corresponding actions
	 */
	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equals("add")) {
			addElement();
		}
		if (e.getActionCommand().equals("remove")) {
			removeElement();
		}
		if (e.getActionCommand().equals("clear")) {
			clear();
		}
		if (e.getActionCommand().equals("change")) {
			changeElement();
		}
	}
}