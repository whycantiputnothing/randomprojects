import java.util.*;

/**
 * @author Brandon
 *	interface wasn't used for this class because in this example only 1 type of student was required.
 *	could easily be implemented as a child of an interface "student"
 */
public class Student {
	private String ID;
	private List<String> answer;
	
	/**
	 * @param s makes a student object with s as ID
	 */
	Student(String s) {
		ID = s;
		answer = new ArrayList<String>();
	}
	
	/**
	 * @param s
	 * @param answer
	 * makes a student object with s as id and list answer for answer
	 */
	Student(String s, List<String> answer) {
		ID = s;
		this.answer	= answer;
	}
	
	public List<String> getAnswer(){
		return answer;
	}
	
	public void setAnswer(List<String> l) {
		answer = l;
	}
	
	public String getID(){
		return ID;
	}
	
	public void setID(String s) {
		ID = s;
	}
}
