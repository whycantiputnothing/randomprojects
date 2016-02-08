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

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		UserInterface ui = new UserInterface(new GameEngine());
		ui.startGame();
	}

}

