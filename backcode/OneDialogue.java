package backcode;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * OneDialogue class calls dialogue message with one input for the user
 * 
 * @author Dmitry
 *
 */
public class OneDialogue {

	private JTextField field = new JTextField(5);
	private JLabel label = new JLabel();
	private int result;

	protected JPanel myPanel;

	/**
	 * Initializes a panel for dialogue window with one input and text label
	 */
	public OneDialogue() {

		myPanel = new JPanel();
		myPanel.add(label);
		myPanel.add(field);
	}

	/**
	 * Calls an dialogue window with 1 input with the chosen message
	 * 
	 * @param Message to show
	 */
	public void askInputMessage(String message) {
		label.setText(message);
		result = JOptionPane.showConfirmDialog(null, myPanel, "User Input", JOptionPane.OK_CANCEL_OPTION);
	}

	/**
	 * get a result whenever it is OK or CANCEL/closed window
	 * 
	 * @return
	 */
	public int getResult() {
		return result;
	}

	/**
	 * Get an input from the user as a String, if window was closed it is null
	 * 
	 * @return Input from the user
	 */
	public String getInput() {
		return field.getText();
	}
}
