package dataStructures;

/**
 * Interactive Data is an Interface that combines all data Structures that need
 * to be displayed on the screen and to be interacted with
 * 
 * @author Dmitry
 *
 */
public interface InteractiveData {

	public void addElement();

	public void removeElement();

	public void changeElement();
	
	public void clear();

	public void closeFrame();

	public boolean isShowing();
}
