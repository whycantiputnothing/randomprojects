/**
 * 
 */
package edu.cpp.cs.cs141.exceptionexample;

import java.io.Serializable;

/**
 * @author Brandon Nguyen
 *
 */
public class ObjectSave implements Serializable{

	private int savedNum = 0;
	
	private String savedName = "Obj";
	public int getSavedNum() {
		return savedNum;
	}
	public void setSavedNum(int savedNum) {
		this.savedNum = savedNum;
	}
	public String getSavedName() {
		return savedName;
	}
	public void setSavedName(String savedName) {
		this.savedName = savedName;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
