/**
 * 
 */
package edu.cpp.cs.cs141.friutsample;

/**
 * @author Brandon Nguyen
 *
 */
public abstract class Fruit {
	
	private boolean isSweet;
	
	private boolean isSour;
	
	public Fruit(boolean sour, boolean sweet){
		isSour = sour;
		isSweet = sweet;
	}

	public boolean isSweet() {
		return isSweet;
	}

	public boolean isSour() {
		return isSour;
	}
	
	public abstract String fruitName();

}
