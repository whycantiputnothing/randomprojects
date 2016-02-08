/**
 * 
 */
package edu.cpp.cs.cs141.memory;

/**
 * CS 141: Introduction to Programming and Problem Solving
 * Professor: Edwin Rodr&iacute;guez
 *
 * Programming Assignment #2
 *
 * <Match Game>
 *
 * Brandon Nguyen
 */

public abstract class Card {
	
	private String cardType;
	
	private boolean isFlipped;
	
	public Card (String s){
		cardType = s;
	}

	public String getCardType() {
		return cardType;
	}
	
	public void setCardType(String s) {
		cardType = s;
	}

	public boolean getIsFlipped() {
		return isFlipped;
	}
	
	public void setIsFlipped(boolean s) {
		isFlipped = s;
	}

}
