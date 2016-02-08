/**
 * 
 */
package edu.cpp.cs.cs141.exceptionexample;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

/**
 * @author apoloimagod
 *
 */
public class IntegerRAFReader1 {
	
	private static final String INT_FILE = "integers.dat";
	private static final int numOfInts = 100;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		populateFileWithInts();
		printIntsToScreen();
	}
	
	public static void printIntsToScreen() {
		FileInputStream intsFile = null;

		try {
			intsFile = new FileInputStream(INT_FILE);
			DataInputStream dis = new DataInputStream(intsFile);
			
			for (int i = 0; i < numOfInts; ++i) {
				System.out.println(dis.readInt());
			}
			
			intsFile.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public static void populateFileWithInts() {
		try {
		FileOutputStream intsFile = new FileOutputStream(INT_FILE);
		DataOutputStream dos = new DataOutputStream(intsFile);
		
		for(int i = 0; i < numOfInts; ++i) {
			Random rand = new Random();
			dos.writeInt(rand.nextInt(1000));
		}
		
		intsFile.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
