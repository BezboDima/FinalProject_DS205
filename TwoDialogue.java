package backcode;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * TwoDialogue class calls dialogue message with two inputs for the user,
 * extends OneDialogue class
 * 
 * @author Dmitry
 *
 */
public class TwoDialogue extends OneDialogue {

	private JTextField secondField = new JTextField(5);
	private JLabel secondLabel = new JLabel();

	/**
	 * Initializes the panel with 2 user input for input dialogue window
	 */
	public TwoDialogue() {

		super.myPanel.add(Box.createHorizontalStrut(15)); // a spacer
		super.myPanel.add(secondLabel);
		super.myPanel.add(secondField);
	}

	/**
	 * Calls an dialogue window with 2 input with the chosen message
	 * 
	 * @param first  message to show
	 * @param second message to show
	 */
	public void askInputMessage(String message1, String message2) {
		secondLabel.setText(message2);
		super.askInputMessage(message1);
	}

	/**
	 * Get the second input from the user as a String, if window was closed it is
	 * null
	 * 
	 * @return Second Input from the user
	 */
	public String getSecondInput() {
		return secondField.getText();
	}

}
