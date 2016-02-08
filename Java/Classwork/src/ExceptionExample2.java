/**
 * 
 */
package edu.csupomona.cs.cs141.practice;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Edwin Rodr&iacute;guez
 *
 */
public class ExceptionExample2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		File f = new File("file.txt");
		try {
			Scanner sc = new Scanner(f);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Code here to recover...");
		}
	}

}
