
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class FourInALine {
	private boolean isPlayerTurn;
	private int milliSeconds;
	private Board board;
	private Scanner in;
	private List<String> moves;

	public FourInALine() {
		in = new Scanner(System.in);
		board = new Board(new int[8][8], 64);
		moves = new ArrayList<>();
		System.out.println("Four in a Line Game\n");
	}

	public void start() {
		playerPrompt();
		secondsPrompt();
		AlphaBeta ai = new AlphaBeta(milliSeconds, !isPlayerTurn);
		Action action = new Action(-1, -1);
		int counter = 0;
		while (board.getEmptySpaces() > 0) {
			if (isPlayerTurn) {
				System.out.print("Choose Opponent's next move: ");
				String choice = in.nextLine();
				while (!board.move(choice, isPlayerTurn)) {
					System.out.println("Invalid input.");
					System.out.print("Choose Opponent's next move: ");
					choice = in.nextLine();
				}
				moves.set(moves.size() - 1, moves.get(moves.size() - 1) + choice + "  ");
				counter++;
			} else {
				action = ai.miniMaxSearch(board);
				moves.set(moves.size() - 1, moves.get(moves.size() - 1) + action.toString() + "  ");
				board.move(action.getRow(), action.getCol(), isPlayerTurn);
				print();
				System.out.println("Player's move is: " + action.toString() + "\n");
				counter++;
			}
			isPlayerTurn = !isPlayerTurn;
			if (counter == 2) {
				counter = 0;
				moves.add("");
			}
			if (board.isWin() != 0) {
				break;
			}
		}
		switch (board.isWin()) {
		case 0:
			System.out.println("Game ended in a tie");
			break;
		case 1:
			System.out.println("Player won");
			break;
		case -1:
			System.out.println("Opponent won");
		}
		in.close();
	}

	private void playerPrompt() {
		while (true) {
			System.out.print("Who goes first, C for computer, O for opponent: ");
			String choice = in.nextLine().toUpperCase();
			char ch = choice.charAt(0);
			if (choice.length() == 1) {
				if (ch == 'O') {
					isPlayerTurn = true;
					moves.add("Opponent vs. Player");
					break;
				} else if (ch == 'C') {
					isPlayerTurn = false;
					moves.add("Player vs. Opponent");
					break;
				}
			}
		}
		moves.add("");
	}

	private void secondsPrompt() {
		System.out.println("\nHow much time (in seconds) will you allow the computer to think?");
		while (true) {
			try {
				System.out.print("Time: ");
				milliSeconds = in.nextInt();
				in.nextLine();
				if (milliSeconds > 30) {
					System.out.println("Please enter a time that is less than 30 seconds.");
				} else {
					break;
				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid input.");
				in.nextLine();
			}
		}
		milliSeconds *= 1000;
	}

	private void print() {
		String[] board = this.board.toString().split("\n");
		int max = (board.length > moves.size()) ? board.length : moves.size();
		for (int i = 0; i < max; i++) {
			if (i < board.length) {
				System.out.print("\n" + board[i] + "\t");
				if (i < moves.size()) {
					if (i > 0) {
						System.out.print("  " + i + ". ");
					}
					System.out.print(moves.get(i));
				}
			} else {
				System.out.print("\n                  " + "\t  " + i + ". ");
				System.out.print(moves.get(i));
			}
		}
		System.out.println("\n");
	}
}