
public class Board {
	private int[][] board;
	private int emptySpaces;

	/* Board constructor */
	public Board(int[][] b, int s) {
		board = b;
		emptySpaces = s;
	}

	public int[][] getBoard() {
		return board;
	}

	public int getEmptySpaces() {
		return emptySpaces;
	}

	public int getBoardLength() {
		return board.length;
	}

	public int isWin() {
		int dimension = board.length;
		for (int row = 0; row < dimension; row++) {
			for (int column = 0; column < dimension; column++) {
				int player = board[row][column];
				if (player == 0)
					continue;

				if (column + 3 < dimension && player == board[row][column + 1] && player == board[row][column + 2]
						&& player == board[row][column + 3])
					return player;
				if (row + 3 < dimension) {
					if (player == board[row + 1][column] && player == board[row + 2][column]
							&& player == board[row + 3][column])
						return player;
				}
			}
		}
		return 0;
	}

	public boolean move(String input, boolean isPlayerTurn) {
		int row = input.toUpperCase().charAt(0) - 65;
		int col = input.charAt(1) - 49;
		return move(row, col, isPlayerTurn);
	}

	public boolean move(int row, int column, boolean isPlayerTurn) {
		if (row < 0 || column < 0 || row >= board.length || column >= board.length || board[row][column] != 0) {
			return false;
		}
		emptySpaces--;
		if (isPlayerTurn) {
			board[row][column] = -1;
		} else {
			board[row][column] = 1;
		}
		return true;
	}

	public boolean undoMove(int row, int column) {
		if (board[row][column] == 0) {
			return false;
		} else {
			emptySpaces++;
			board[row][column] = 0;
			return true;
		}
	}

	public String toString() {
		String str = "  1 2 3 4 5 6 7 8\n";
		char ch = 'A';
		for (int i = 0; i < board.length; i++) {
			str += ((ch++) + " ");
			for (int j = 0; j < board.length; j++) {
				if (board[i][j] == 0) {
					str += "- ";
				} else if (board[i][j] == 1) {
					str += "O ";
				} else {
					str += "X ";
				}
			}
			str += "\n";
		}
		return str;
	}
}
