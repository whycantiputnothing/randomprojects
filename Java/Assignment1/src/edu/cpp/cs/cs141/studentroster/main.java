/**
 * 
 */
package edu.cpp.cs.cs141.studentroster;
import java.util.Scanner;
/**
 * @author Brandon-PC
 *
 */
public class main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		
		System.out.print("How many students are there? ");
		int rosterLength = in.nextInt();
		in.nextLine();
		Student[] students = new Student[rosterLength];
		
		for (int i = 0; i < students.length; i++){
			System.out.print("What is the name of student #" + (i + 1) + "? ");
			String studentName = in.nextLine();
			
			System.out.println("What grade did " + studentName + " recieve? ");
			int studentGrade = in.nextInt();
			in.nextLine();
			
			students[i] = new Student(studentName, i);
			
			students[i].setGrade(studentGrade);
		}
		
		System.out.print("Would you like to print the roster or quit? press p to print or any other key to quit ");
		String print = in.next();
		
		if (print.equals("p")){
			for (int j = 0; j < students.length; j++){ 
				System.out.println("Name: " + students[j].getName());
				System.out.println("Grade: " + students[j].getGrade() +"%");
				System.out.println("ID #: " + students[j].getId());
				System.out.println();
			}
			
			System.out.println("type any key to quit");
			String quit = in.next();
			System.exit(0);
		}
		
		else 
			System.exit(0);
			in.close();
	}
	

}
