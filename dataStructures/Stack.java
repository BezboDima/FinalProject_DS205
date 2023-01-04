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
 * Stack implements functions of Actionlistener and InteractiveData. It can be
 * displayed on the Screen and behaves like an Stack
 * 
 * @author Dmitry
 *
 */
public class Stack implements ActionListener, InteractiveData {

	// StackDataStructure Simulator uses custom buttons and label
	private CustomLabel arrayLabel = new CustomLabel();
	private Buttons buttons = new Buttons();
	private JFrame frame = new JFrame("Stack");

	/**
	 * Initializes the frame and makes it visible
	 */
	public Stack() {

		frame.setSize(720, 240);
		frame.setLayout(new GridLayout(0, 1));

		buttons.addListener(this);

		frame.add(buttons.getPanel());
		frame.add(arrayLabel.getPanel());

		frame.setVisible(true);
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

	}

	/**
	 * Adds the element at the end of the stack. And makes the added element green.
	 * If pop-window is closed does nothing Element must be positive integer below
	 * 10 for design purposes
	 */
	public void addElement() {

		if (arrayLabel.getSize() == 5) {
			JOptionPane.showMessageDialog(null, "Stack Is Full");
			return;
		}

		OneDialogue diolog = new OneDialogue();
		int number = -1;

		do {
			diolog.askInputMessage("Input a positive number below 10: ");

			// If user inputed non-integer asks for input again
			try {
				number = Integer.parseInt(diolog.getInput());
			} catch (NumberFormatException ex) {
				continue;
			}

			if (number > 0 && number < 10) {
				arrayLabel.addInFront(arrayLabel.getSize() + 1, number);
				arrayLabel.setColorGreen(arrayLabel.getSize());
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

				if (arrayLabel.getElement(position) == -1) {
					JOptionPane.showMessageDialog(null, "You cant change a number at empty spot, try to add instead");
				} else {
					arrayLabel.setNumber(position, number);
					arrayLabel.setColorBlue(position);
				}
				break;
			}

		} while (diolog.getResult() == JOptionPane.OK_OPTION);

	}

	/**
	 * Removes the last element that was written and colors the space red
	 */
	public void removeElement() {

		if (arrayLabel.getSize() == 0) {
			JOptionPane.showMessageDialog(null, "Stack Is Empty");
			return;
		}
		arrayLabel.removeNumber(arrayLabel.getSize());
		arrayLabel.setColorRed(arrayLabel.getSize() + 1);

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
		// TODO Auto-generated method stub
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
