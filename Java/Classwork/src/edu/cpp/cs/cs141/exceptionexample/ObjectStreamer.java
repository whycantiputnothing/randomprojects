/**
 * 
 */
package edu.cpp.cs.cs141.exceptionexample;

import java.io.*;
import java.io.IOException;

/**
 * @author Brandon Nguyen
 *
 */
public class ObjectStreamer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private static void saveObject(ObjectSave os){
		try{
			FileOutputStream fos = new FileOutputStream("objectSave.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(os);
			
			
			fos.close();
			
			
		} catch(IOException e){
			e.printStackTrace();
		}
	}

}
