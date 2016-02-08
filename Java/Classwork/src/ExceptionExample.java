
import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] array = new int[3];
		int i;
		
		while (true) {
			try {
				System.out.println("Tell me which element you want to see:");
				i = sc.nextInt();
				System.out.println("Showing the ith element: " + array[i]);
				System.out.println("Please enter a number:");
				int num = sc.nextInt();
				System.out.println("yay! you have a brain!");
				break;
			} catch (InputMismatchException e) {
				System.out.println("Try again,"
						+ " can't you tell a number from a string????");
				sc.nextLine();
			} finally {
				System.out.println("You can run, but you can't hide!");
			}
		}
	}
}
