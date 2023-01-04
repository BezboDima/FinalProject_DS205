package backcode;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import dataStructures.ArrayList;
import dataStructures.InteractiveData;
import dataStructures.Queue;
import dataStructures.Stack;
import dataStructures.Vector;

/**
 * Display Is the main class that combines the Data Structures and the main
 * menu, and lets them to interact with each other
 * 
 * @author Dmitry
 *
 */
public class Display implements ActionListener {

	// Use the array of Interactive Data Windows(size of 3 limits the amount of
	// windows that can be opened at ones)
	private InteractiveData[] dataStructure = { null, null, null };
	private JButton menu = new JButton("Menu");

	JFrame frame = new JFrame("Data Simulator");
	JPanel panel = new JPanel();

	/**
	 * Initializes the size of the frame as well as its "menu" button in action
	 * listener. Sets the window to be visible
	 */
	public Display() {

		frame.setSize(860, 350);

		menu.addActionListener(this);
		menu.setPreferredSize(new Dimension(200, 80));
		menu.setFont(new Font("Calibri", Font.PLAIN, 30));

		JLabel label = new JLabel("Data Structure Simulator");
		label.setFont(new Font("Calibri", Font.PLAIN, 50));

		JLabel label2 = new JLabel("Please press menu to make a decision or to quit!");
		label2.setFont(new Font("Calibri", Font.PLAIN, 40));

		JLabel label3 = new JLabel("(You can open no more than 3 Data Windows)");
		label3.setFont(new Font("Calibri", Font.PLAIN, 40));

		panel.add(label, BorderLayout.NORTH);
		panel.add(label2, BorderLayout.NORTH);
		panel.add(label3, BorderLayout.NORTH);
		panel.add(menu, BorderLayout.NORTH);

		frame.add(panel);
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.setVisible(true);

	}

	/**
	 * Calls the menu input, if user pressed quit make menu invisible and if user
	 * closed menu do nothing. If user choose data structure, gets the info about
	 * data and open InteractiveData window
	 */
	public void callMenu() {

		Menu m = new Menu();

		if (m.getInput() == null) {
			return;
		}

		if (m.getInput().equals("5")) {
			frame.setVisible(false);
			return;
		}

		m.getInfo();
		addStructure(Integer.parseInt(m.getInput()));
	}

	/**
	 * Closes all open windows, including Menu and Data Structures displayed
	 */
	public void closeAll() {

		for (int i = 0; i < dataStructure.length; i++) {

			if (dataStructure[i] != null) {
				dataStructure[i].closeFrame();
				dataStructure[i] = null;
			}
		}

		frame.setVisible(false);
	}

	/**
	 * Returns the array of Interactive Data Windows
	 * 
	 * @return
	 */
	public InteractiveData[] getDs() {
		return dataStructure;
	}

	/**
	 * Checks if menus is Showing on the screen
	 * 
	 * @return
	 */
	public boolean isShowing() {
		return frame.isShowing();

	}

	/**
	 * Checks whenever the menu button was pushed
	 */
	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equals("Menu")) {
			callMenu();
		}

	}

	/**
	 * Checks if Interactive Data Array has an empty space and returns its index, if
	 * not found returns -1
	 * 
	 * @return
	 */
	protected int getEmpty() {
		int e = -1;
		for (int i = 0; i < dataStructure.length; i++) {
			if (dataStructure[i] == null)
				e = i;
		}

		return e;
	}

	/**
	 * Helper method that adds the data Structure into the array, checks if array
	 * has space and if not does nothing
	 * 
	 * @param n
	 */
	protected void addStructure(int n) {

		if (getEmpty() == -1) {
			JOptionPane.showMessageDialog(null, "Reached limit of Max Windows (3)");
			return;
		}

		int rear = getEmpty();

		switch (n) {

		case (1):
			dataStructure[rear] = new ArrayList();
			break;

		case (2):
			dataStructure[rear] = new Vector();
			break;

		case (3):
			dataStructure[rear] = new Stack();
			break;

		case (4):
			dataStructure[rear] = new Queue();
			break;
		}

	}

}
