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
 * Queue implements functions of Actionlistener and InteractiveData. It can
 * be displayed on the Screen and behaves like an Queue
 * 
 * @author Dmitry
 *
 */
public class Queue implements ActionListener, InteractiveData {

	// QueueDataStructure Simulator uses custom buttons and label
	private CustomLabel arrayLabel = new CustomLabel();
	private Buttons buttons = new Buttons();
	private JFrame frame = new JFrame("Queue");
	// rear keeps track where element must be entered
	private int rear = 1;

	/**
	 * Initializes the frame and makes it visible
	 */
	public Queue() {

		frame.setLayout(new GridLayout(0, 1));
		frame.setSize(720, 240);

		buttons.addListener(this);

		frame.add(buttons.getPanel());
		frame.add(arrayLabel.getPanel());

		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.setVisible(true);

	}

	/**
	 * Adds the element at the beginning with shifting of other elements in front.
	 * And makes the added element green. If pop-window is closed does nothing
	 * Element must be positive integer below 10 for design purposes
	 */
	public void addElement() {

		if (arrayLabel.getSize() == 5) {
			JOptionPane.showMessageDialog(null, "Queue Is Full");
			return;
		}

		OneDialogue diolog = new OneDialogue();
		int number = -1;

		// If user inputed non-integer asks for input again
		do {
			diolog.askInputMessage("Input a positive number below 10: ");

			try {
				number = Integer.parseInt(diolog.getInput());
			} catch (NumberFormatException ex) {
				continue;
			}

			// If number does not follow the requirement ask again for input
			if (number > 0 && number < 10) {
				arrayLabel.addInFront(rear, number);
				arrayLabel.setColorGreen(rear);

				// Update the rear value
				rear = (rear % 5) + 1;
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
	 * Removes the last element that was written and colors the space red
	 */
	public void removeElement() {

		if (arrayLabel.getSize() == 0) {
			JOptionPane.showMessageDialog(null, "Queue Is Empty");
			return;
		}

		// Get the position to delete accordingly to rear and size
		int remove = ((5 - arrayLabel.getSize()) + rear) % 5;
		if (remove == 0)
			remove = 5;

		arrayLabel.removeNumber(remove);
		arrayLabel.setColorRed(remove);

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
