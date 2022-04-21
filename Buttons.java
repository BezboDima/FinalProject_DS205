package backcode;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Button class creates 4 buttons in the same panel with names:
 * "Add""Remove""Clear""Change". It is used for dataStructure classes
 * 
 * @author Dmitry
 *
 */
public class Buttons {

	// Set up the 4 buttons with labels and a panel
	private JPanel panel;
	private JButton[] buttons = new JButton[4];
	private String[] labels = { "add", "remove", "clear", "change" };

	/**
	 * initializes a panel with 4 buttons and sets their action command depending on
	 * their name
	 */
	public Buttons() {

		panel = new JPanel();
		panel.setLayout(new GridLayout(1, 0));

		for (int i = 0; i < 4; i++) {
			buttons[i] = new JButton(labels[i]);
			buttons[i].setActionCommand(labels[i]);
			panel.add(buttons[i]);
		}

	}

	/**
	 * Gets the panel with a buttons
	 * 
	 * @return
	 */
	public JPanel getPanel() {
		return panel;
	}

	/**
	 * Initializes an Action listener for the buttons that can be the class that
	 * implements the Action Performer method
	 * 
	 * @param h
	 */
	public void addListener(ActionListener h) {

		for (int i = 0; i < 4; i++) {
			buttons[i].addActionListener(h);
		}
	}
}
