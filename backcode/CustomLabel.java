package backcode;

import java.awt.BorderLayout;
import java.awt.Font;
import java.util.Arrays;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * CustomLabel Class creates an Interactive array label that can be manipulated
 * and changed depending on the methods, used for dataStructures
 * 
 * @author Dmitry
 *
 */
public class CustomLabel {

	private class LabelArray {

		// Class uses the basic array and manual size variable
		private int[] data;
		private int size;

		/**
		 * Initializes the array of size 5, where number of -1 is considered an empty
		 * spot in the array
		 */
		LabelArray() {

			data = new int[5];
			size = 0;
			Arrays.fill(data, -1);
		}

		/**
		 * Sets the number in the array
		 * 
		 * @param index  place where number is placed
		 * @param number
		 */
		public void set(int index, int number) {

			if (data[index] == -1)
				size++;
			data[index] = number;
		}

		/**
		 * Removes the number from the array at index
		 * 
		 * @param index
		 */
		public void remove(int index) {

			if (data[index] == -1)
				return;

			data[index] = -1;
			size--;
		}

		/**
		 * Clears the array and fills it with -1
		 */
		public void clear() {

			Arrays.fill(data, -1);
			size = 0;
		}

		/**
		 * Adds the new number to the array with shifting of other numbers in front of
		 * it
		 * 
		 * @param index
		 * @param number
		 */
		public void addWithShift(int index, int number) {

			if (size == data.length)
				return;

			int numIn = number;
			int temp;
			for (int i = index; i < data.length; i++) {
				temp = data[i];
				data[i] = numIn;

				if (temp == -1)
					break;

				numIn = temp;
			}

			size++;

		}

		/**
		 * Returns the size of an array
		 * 
		 * @return size of array
		 */
		public int getSize() {

			return size;
		}

		/**
		 * Returns the number at the given index
		 * 
		 * @param index
		 * @return
		 */
		public int getElement(int index) {

			return data[index];
		}

		/**
		 * Custom toString method, where -1 elements are left as blank
		 */
		public String toString() {

			String replace = " ";
			for (int i = 0; i < data.length; i++) {

				if (data[i] == -1) {
					replace += "[ ] ";
				} else {
					replace += "[" + data[i] + "] ";
				}
			}

			return replace;
		}
	}

	private JPanel panel;
	private JLabel arrayLabel;
	private String lab;
	private LabelArray array = new LabelArray();

	/**
	 * initializes the label that will depend on its array and string, as well as
	 * its panel
	 */
	public CustomLabel() {

		panel = new JPanel();

		lab = " [ ] [ ] [ ] [ ] [ ] ";

		arrayLabel = new JLabel(lab + " S: " + array.getSize());
		arrayLabel.setFont(new Font("Calibri", Font.PLAIN, 80));

		panel.add(arrayLabel, BorderLayout.SOUTH);

	}

	/**
	 * Gets a panel of the label
	 * 
	 * @return panel
	 */
	public JPanel getPanel() {
		return panel;
	}

	/**
	 * sets the number at the given position and changes the label
	 * 
	 * @param position
	 * @param number
	 */
	public void setNumber(int position, int number) {

		array.set(position - 1, number);
		lab = array.toString();
		arrayLabel.setText(lab + " S: " + array.getSize());
	}

	/**
	 * Adds the number at the given position with the shifting of the elements in
	 * front, and changes the label
	 * 
	 * @param position
	 * @param number
	 */
	public void addInFront(int position, int number) {
		array.addWithShift(position - 1, number);
		lab = array.toString();
		arrayLabel.setText(lab + " S: " + array.getSize());
	}

	/**
	 * with the shifting of the elements, and changes the label
	 * 
	 * @param position
	 */
	public void removeNumber(int position) {

		array.remove(position - 1);
		lab = array.toString();
		arrayLabel.setText(lab + " S: " + array.getSize());
	}

	/**
	 * Clears the label making it empty
	 */
	public void clearLabel() {

		array.clear();
		lab = array.toString();
		arrayLabel.setText(lab + " S: " + array.getSize());
	}

	/**
	 * Sets the color of the elements at given position to Red in the label
	 * 
	 * @param position
	 */
	public void setColorRed(int position) {

		// Identifies the center of the string depending on the position
		int saperator = position * 4 - 2;

		// Splits the string in 3 parts, one of which will bw colored
		String left = lab.substring(0, saperator - 1);
		String right = lab.substring(saperator + 2, lab.length());
		String number = lab.substring(saperator - 1, saperator + 2);

		// Color the label using HTML
		arrayLabel.setText(String.format("<html>%s<font color='red'>%s</font>%s S: %s</html>", left, number, right,
				array.getSize()));
	}

	/**
	 * Sets the color of the elements at given position to Green in the label
	 * 
	 * @param position
	 */
	public void setColorGreen(int index) {

		// Identifies the center of the string depending on the position
		int saperator = index * 4 - 2;

		// Splits the string in 3 parts, one of which will bw colored
		String left = lab.substring(0, saperator - 1);
		String right = lab.substring(saperator + 2, lab.length());
		String number = lab.substring(saperator - 1, saperator + 2);

		// Color the label using HTML
		arrayLabel.setText(String.format("<html>%s<font color='green'>%s</font>%s S: %s</html>", left, number, right,
				array.getSize()));
	}

	/**
	 * Sets the color of the elements at given position to Blue in the label
	 * 
	 * @param position
	 */
	public void setColorBlue(int index) {

		// Identifies the center of the string depending on the position
		int saperator = index * 4 - 2;

		// Splits the string in 3 parts, one of which will bw colored
		String left = lab.substring(0, saperator - 1);
		String right = lab.substring(saperator + 2, lab.length());
		String number = lab.substring(saperator - 1, saperator + 2);

		// Color the label using HTML
		arrayLabel.setText(String.format("<html>%s<font color='blue'>%s</font>%s S: %s</html>", left, number, right,
				array.getSize()));
	}

	/**
	 * Returns the size of an label array (that has numbers)
	 * 
	 * @return
	 */
	public int getSize() {

		return array.getSize();
	}

	/**
	 * Returns the size of an label array If it is empty return -1
	 * 
	 * @return
	 */
	public int getElement(int position) {
		return array.getElement(position - 1);
	}
}
