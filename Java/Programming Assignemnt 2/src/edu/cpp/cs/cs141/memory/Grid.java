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

public class Grid {
	
	public static final int GRID_SIZE = 4;
	
	private Card[][] cards = new Card[GRID_SIZE][GRID_SIZE];

	
	/**
	 * intializes the grid and shuffles it
	 */
	public void makeGrid() {
		cards[0][0] = new CardQuestion();
		cards[0][1] = new CardQuestion();
		cards[0][2] = new CardPlus();
		cards[0][3] = new CardPlus();
		cards[1][0] = new CardMinus();
		cards[1][1] = new CardMinus();
		cards[1][2] = new CardStar();
		cards[1][3] = new CardStar();
		cards[2][0] = new CardExclamation();
		cards[2][1] = new CardExclamation();
		cards[2][2] = new CardSlash();
		cards[2][3] = new CardSlash();
		cards[3][0] = new CardPound();
		cards[3][1] = new CardPound();
		cards[3][2] = new CardPercent();
		cards[3][3] = new CardPercent();
		shuffle();
	}
	
	
	/**
	 * @param i = row index
	 * @param j = column index
	 * @return a Card object from cards at position (i, j)
	 */
	public Card getCardAt(int i, int j){
		return cards[i][j];
	}

	/**
	 * shuffles the cards 
	 */
	public void shuffle() {
		List<Card> shuffle = new ArrayList<Card>();   

		for (int i = 0; i < cards.length; i++) {
			for (int j = 0; j < cards[i].length; j++) {
				shuffle.add(cards[i][j]);
			}
		}
		Collections.shuffle(shuffle);

		int shuffleCount = 0;
		for (int i = 0; i < cards.length; i++) {
			for (int j = 0; j < cards[i].length; j++) {
				cards[i][j] = shuffle.get(shuffleCount);
				shuffleCount++;
			}
		}

	}
	/**
	 * turns the array into a formatted String
	 */
	public String toString() {
		String str = "";
		for (Card[] row : cards) {
			for (Card a : row) {
				if (a.getIsFlipped())
					str += ("["+ a.getCardType() + "]");
				else
					str +=("[ ]");
			}
			str += "\n";
		}
		return str;

	}

}