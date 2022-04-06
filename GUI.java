import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class GUI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String userDatatype = JOptionPane.showInputDialog(null, "Please enter the DataType. Examples are: "
				+ "\n1) ArrayList" + "\n2) Vector" + "\n3) Queue" + "\n4) Stack");

		userDatatype = userDatatype.toUpperCase();
		boolean quit = false;
		do {

			quit = false;

			switch (userDatatype) {

			case ("ARRAYLIST"):

				break;
			case ("VECTOR"):

				break;
			case ("STACK"):
				System.out.println("3");
				break;
			case ("QUEUE"):

				break;

			default:
				userDatatype = JOptionPane.showInputDialog(null,
						"Incorrect input: " + "\n1) ArrayList" + "\n2) Vector" + "\n3) Queue" + "\n4) Stack");
				userDatatype = userDatatype.toUpperCase();
				quit = true;
			}

		} while (quit);
	}

}
