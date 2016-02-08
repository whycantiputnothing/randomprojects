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

public class GameEngine {

	private int numberOfMoves = 0;

	private Grid gameCards = new Grid();
	
	/**
	 * @param firstGuess from UI
	 * @param secondGuess from UI
	 * checks if the two cards match
	 * @return true if cards match, false if they do not
	 */
	public boolean isMatch(String firstGuess, String secondGuess) {
		boolean bool;
		String s = firstGuess;
		int i = Integer.parseInt(s.substring(0, 1));
		int j = Integer.parseInt(s.substring(2, 3));
		String cardType = gameCards.getCardAt(i, j).getCardType();

		String s1 = secondGuess;
		int x = Integer.parseInt(s1.substring(0, 1));
		int y = Integer.parseInt(s1.substring(2, 3));
		String cardType2 = gameCards.getCardAt(x, y).getCardType();
		if (cardType.equals(cardType2)) { 
			bool = true;
		} else
			bool = false;
		return bool;
	}

	/**
	 * @param i = row index 
	 * @param j = column index
	 * flips the card at (i, j)
	 */
	public void flipCard(int i, int j) {
		gameCards.getCardAt(i, j).setIsFlipped(true);
	}

	/**
	 * @param i row index
	 * @param j column index
	 * checks if card is flipped at position (i, j)
	 * @return true if card is flipped, false if its not
	 */
	public boolean isCardFlipped(int i, int j) {
		boolean bool;
		if (gameCards.getCardAt(i, j).getIsFlipped())
			bool = true;
		else
			bool = false;
		return bool;
	}

	public int getNumberOfMoves() {
		return numberOfMoves;
	}

	public void increaseNumberOfMoves() {
		numberOfMoves++;
	}

	/**
	 * checks if the game is over with the use of a match counter
	 */
	public boolean isGameOver() {
		boolean bool;
		int matchCount = 0;
 
		for (int i = 0; i < gameCards.GRID_SIZE; i++) {
			for (int j = 0; j < gameCards.GRID_SIZE; j++) {
				if (gameCards.getCardAt(i, j).getIsFlipped())
					matchCount++;
			}
		}

		if (matchCount == 16)
			bool = true;
		else
			bool = false;
		return bool;
	}

	/**
	 * @return a formatted String of the array
	 */
	public String cardsAsString() {
		return gameCards.toString();
	}

	/**
	 * @param i row index
	 * @param j column index
	 * @return an object of type Card
	 */
	public Card getCardAt(int i, int j) {
		return gameCards.getCardAt(i, j);
	}

	/**
	 * intializes the Grid
	 */
	public void makeGrid() { 
		gameCards.makeGrid();
	}

	/**
	 * resets the board by flipping all the cards to 'facedown' and the numberOfMoves
	 * to zero 
	 */
	public void reset() {
		numberOfMoves = 0;
		for (int i = 0; i < gameCards.GRID_SIZE; i++) {
			for (int j = 0; j < gameCards.GRID_SIZE; j++) {
				gameCards.getCardAt(i, j).setIsFlipped(false);
			}
		}
	}

	public void shuffle() {
		gameCards.shuffle();
	}

}
