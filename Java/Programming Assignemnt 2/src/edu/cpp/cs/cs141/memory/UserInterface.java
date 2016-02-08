/**
 * 
 */

package edu.cpp.cs.cs141.memory;

import java.util.*;


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
public class UserInterface {

	private String input = "";

	private String firstGuess = "";

	private int firstGuess1 = 0;

	private int firstGuess2 = 0;

	private String secondGuess = "";

	private int secondGuess1 = 0;

	private int secondGuess2 = 0;

	private GameEngine GE = null;

	Scanner in = null;

	public UserInterface(GameEngine game) {
		this.GE = game;
		in = new Scanner(System.in);
	}

	/**
	 * makes grid and starts loop 
	 */
	public void startGame() {
		System.out.println("-------------Welcome to a game of memory!-------------");
		GE.makeGrid();
		playGame();
	}

	/**
	 * main loop for the game
	 */
	private void playGame() {

		while (GE.isGameOver() == false) {
			System.out.println(GE.cardsAsString());
			System.out.println("# of moves: " + GE.getNumberOfMoves());
			firstGuess();
			if (GE.isCardFlipped(firstGuess1, firstGuess2) == true) {
				flippedCard();
			} 
			
			else {
				secondGuess();
				if (GE.isCardFlipped(secondGuess1, secondGuess2) == true) {
					flippedCard();
				} 
				
				else if (secondGuess.equals(firstGuess)) {
					System.out.println(
							"Your second guess cannot be the same as your first guess." + "\nPlease try again.");
				} 
				
				else {
					if (GE.isMatch(firstGuess, secondGuess) == true) {
						match();
						GE.flipCard(firstGuess1, firstGuess2);
						GE.flipCard(secondGuess1, secondGuess2);
						GE.increaseNumberOfMoves();
					} 
					
					else {
						noMatch();
						GE.increaseNumberOfMoves();
					}
				}
			}
		}
		overGame();
	}

	private void firstGuess() {
		System.out.println("enter the position of the first card as two integers seperated by a space (e.g., 0 0)");
		firstGuess = in.nextLine();
		firstGuess1 = Integer.parseInt(firstGuess.substring(0, 1));
		firstGuess2 = Integer.parseInt(firstGuess.substring(2, 3));
		System.out.println("This card is a " + GE.getCardAt(firstGuess1, firstGuess2).getCardType());
	}

	private void secondGuess() {
		System.out.println("enter the position of the second card");
		secondGuess = in.nextLine();
		secondGuess1 = Integer.parseInt(secondGuess.substring(0, 1));
		secondGuess2 = Integer.parseInt(secondGuess.substring(2, 3));
		System.out.println("This card is a " + GE.getCardAt(secondGuess1, secondGuess2).getCardType());
	}

	private void match() {
		System.out.println("You've found a match!");
	}

	private void noMatch() {
		System.out.println("Not a match!");
	}

	private void flippedCard() {
		System.out.println("That card has already been flipped!");
		System.out.println("Please try again");
	}

	private void overGame() {
		System.out.println("\nYou won in " + GE.getNumberOfMoves() + " moves");
		System.out.println("press 's' to shuffle the deck and play again");
		System.out.println("or press enter to end the game");
		input = in.nextLine();
		if (input.equals("s")) {
			GE.shuffle();
			GE.reset();
			playGame();
		}

		else
			System.exit(0);
	}

}
