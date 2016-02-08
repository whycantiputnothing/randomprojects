/**
 * 
 */
package edu.cpp.cs.cs141.exceptionexample;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author Brandon Nguyen
 *
 */
public class BinaryFilesExamples {

	public static void main(String args[]){
		FileInputStream fis;
		try {
			fis = new FileInputStream("numbers.dat");
			DataInputStream dis = new DataInputStream(fis);
			System.out.println(dis.readLong());
			
			fis.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	private static void writeNumber (int n){
		try {
			FileOutputStream fos = new FileOutputStream("numbers.dat");
			DataOutputStream dos = new DataOutputStream(fos);
					
			dos.writeInt(n);
			
			fos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
