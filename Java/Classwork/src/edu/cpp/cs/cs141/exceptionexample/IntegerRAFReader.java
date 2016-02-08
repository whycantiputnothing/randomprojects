/**
 * 
 */
package edu.cpp.cs.cs141.exceptionexample;

import java.io.*;
import java.util.*;

/**
 * @author Brandon Nguyen
 *
 */
public class IntegerRAFReader {

	private static final String INT_FILE = "integers.dat";
	private static final int numOfInts = 100;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		populateFileWIthInts();
		printIntsToScreen();
		
	}
	
	public static void printIntsToScreen(){
		FileInputStream intsFile = null;
	
		try {
			intsFile = new FileInputStream(INT_FILE);
			DataInputStream dis = new DataInputStream(intsFile);
			
			for( int i = 0; i < numOfInts; i++){
				System.out.println(dis.readInt());
				dis.
			}
			
			intsFile.close();
			
		} catch (IOException e){
			e.printStackTrace();
		}
		
		
		
	}
	
	public static void populateFileWIthInts(){
		try {
			FileOutputStream intsFile = new FileOutputStream(INT_FILE);
			DataOutputStream dos = new DataOutputStream(intsFile);
			
			for(int i = 0; i < numOfInts; i++){
				Random rand = new Random();
				dos.writeInt(rand.nextInt(1000));
			}
			
			intsFile.close();
		} catch(IOException e){
			e.printStackTrace();
		}
	
	}

}
