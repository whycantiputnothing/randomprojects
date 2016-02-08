/**
 * 
 */
package edu.cpp.cs.cs141.exceptionexample;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Brandon Nguyen
 *
 */
public class ExceptionExample {

	public static void main(String[] args) {

	}

	private static void fileOpeningExample() {
		Scanner sc = new Scanner(System.in);
		boolean goodFileName = false;
		int tries = 0;
		
		do{
			try{
				System.out.println("enter file name: ");
				String fileName = sc.nextLine();
				
				File file = new File(fileName);
				Scanner fileScanner = new Scanner(file); 
				printFileContents(fileScanner);
				goodFileName = true;
				tries++;
				
			}
			catch(FileNotFoundException fnfe) {
				System.out.println("Wrong file name! try again");
			} 
			finally{
				tries++;	
			}
		} while(!goodFileName);
		
		System.out.println("Took you " + tries + "  tries to open that file");
	
	}

	private static void printFileContents(Scanner fileScanner){
		while(fileScanner.hasNextLine())
		System.out.println(fileScanner.nextLine());
	}
	private static void arrayAcessExample() {
		Scanner sc = new Scanner(System.in);
		int[] happy = new int[7];

		boolean goodInput = false;
		int x = -1;
		do {
			try {
				System.out.println("enter index: ");
				x = sc.nextInt();
				System.out.println(happy[x]);
				goodInput = true;

			} 
			catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("bad input try again");
			}
		} while (!goodInput);

	}

}
