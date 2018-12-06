
public class AlphaBeta {
	private boolean isAiFirst;
	private int alpha;
	private int beta;
	private int depth;
	private long startTime;
	private long length;

	public AlphaBeta(long limit, boolean b) {
		depth = Integer.MAX_VALUE;
		length = limit;
		isAiFirst = b;
	}

	public Action miniMaxSearch(Board board) {
		int score;
		int currentRow = 0;
		int currentCol = 0;
		alpha = Integer.MIN_VALUE;
		beta = Integer.MAX_VALUE;
		int best = alpha;
		startTime = System.currentTimeMillis();

		for (int i = 0; i < board.getBoardLength(); i++) {
			for (int j = 0; j < board.getBoardLength(); j++) {
				if (board.getBoard()[i][j] == 0) {
					board.move(i, j, false);
					score = minimumVal(board, depth - 1);
					board.undoMove(i, j);
					if (score > best) {
						currentRow = i;
						currentCol = j;
						best = score;
					}
				}
			}
		}
		return new Action(currentRow, currentCol);
	}

	private int minimumVal(Board board, int d) {
		if (isCutoff()) {
			return evaluate(board);
		}
		if (board.getEmptySpaces() == 0) {
			return 0;
		}
		if (board.isWin() == -1) {
			return Integer.MIN_VALUE / 2;
		}
		if (board.isWin() == 1) {
			return Integer.MAX_VALUE / 2;
		}

		int best = beta;
		for (int i = 0; i < board.getBoardLength(); i++) {
			for (int j = 0; j < board.getBoardLength(); j++) {
				if (board.getBoard()[i][j] == 0) {
					board.move(i, j, false);
					best = Math.min(best, maximumVal(board, d - 1));
					board.undoMove(i, j);
				}
			}
		}
		return best;
	}

	private int maximumVal(Board board, int d) {
		if (isCutoff()) {
			return evaluate(board);
		}
		if (board.getEmptySpaces() == 0) {
			return 0;
		}
		if (board.isWin() == -1) {
			return Integer.MIN_VALUE / 2;
		}
		if (board.isWin() == 1) {
			return Integer.MAX_VALUE / 2;
		}

		int best = alpha;
		for (int i = 0; i < board.getBoardLength(); i++) {
			for (int j = 0; j < board.getBoardLength(); j++) {
				if (board.getBoard()[i][j] == 0) {
					board.move(i, j, true);
					best = Math.max(best, minimumVal(board, d - 1));
					board.undoMove(i, j);
				}
			}
		}
		return best;
	}

	private int evaluate(Board board) {
		int score = 0;

		for (int i = 0; i < board.getBoardLength(); i++) {
			for (int j = 0; j < board.getBoardLength(); j++) {
				score += heuristic(i, j, board);
			}
		}
		return score;
	}

	private int heuristic(int row, int column, Board board) {
		int check = board.getBoard()[row][column];
		int score = 0;
		int temperature = 0;

		if (!isAiFirst && check > 0) {
			check = -1;
			board.getBoard()[row][column] = -1;
			if (board.isWin() == -1) {
				score += 10000;
			}
			board.getBoard()[row][column] = 1;
		}

		if (!isAiFirst) {
			check = -1;
		}

		if (row >= 3) {
			for (int i = 1; i < 4; i++) {
				if (board.getBoard()[row - i][column] == check) {
					temperature += 5 - i;
				} else if (board.getBoard()[row - i][column] != 0) {
					temperature = -1;
					i = 4;
				}
			}
			if (row < board.getBoardLength() - 1) {
				if (temperature == 7 && board.getBoard()[row + 1][column] == 0) {
					temperature = 10000;
				}
			}
			if (temperature == 9 && !isAiFirst) {
				temperature = 9990;
			}
			score += temperature;
			temperature = 0;
		} else {
			score--;
		}

		if (row < board.getBoardLength() - 3) {
			for (int i = 1; i < 4; i++) {
				if (board.getBoard()[row + i][column] == check) {
					temperature += 5 - i;
				} else if (board.getBoard()[row + i][column] != 0) {
					temperature = -1;
					i = 4;
				}
			}
			if (row > 0) {
				if (temperature == 7 && board.getBoard()[row - 1][column] == 0) {
					temperature = 10000;
				}
			}
			if (temperature == 9 && !isAiFirst) {
				temperature = 9990;
			}
			score += temperature;
			temperature = 0;
		} else {
			score--;
		}

		if (column >= 3) {
			for (int i = 1; i < 4; i++) {
				if (board.getBoard()[row][column - i] == check) {
					temperature += 5 - i;
				} else if (board.getBoard()[row][column - i] != 0) {
					temperature = -1;
					i = 4;
				}
			}
			if (column < board.getBoardLength() - 1) {
				if (temperature == 7 && board.getBoard()[row][column + 1] == 0) {
					temperature = 10000;
				}
			}
			if (temperature == 9 && !isAiFirst) {
				temperature = 9990;
			}
			score += temperature;
			temperature = 0;
		} else {
			score--;
		}

		if (column < board.getBoardLength() - 3) {
			for (int i = 1; i < 4; i++) {
				if (board.getBoard()[row][column + i] == check) {
					temperature += 5 - i;
				} else if (board.getBoard()[row][column + i] != 0) {
					temperature = -1;
					i = 4;
				}
			}
			if (column > 0) {
				if (temperature == 7 && board.getBoard()[row][column - 1] == 0) {
					temperature = 10000;
				}
			}
			if (temperature == 9 && !isAiFirst) {
				temperature = 9990;
			}
			score += temperature;
		} else {
			score--;
		}

		if (!isAiFirst) {
			if (row >= 1 && row < board.getBoardLength() - 1 && column >= 1 && column < board.getBoardLength() - 1) {
				if (board.getBoard()[row + 1][column + 1] == check || board.getBoard()[row + 1][column - 1] == check
						|| board.getBoard()[row - 1][column + 1] == check
						|| board.getBoard()[row - 1][column - 1] == check) {
					score++;
				}
			}
			check = board.getBoard()[row][column];
		}

		return score * check;
	}

	private boolean isCutoff() {
		return (System.currentTimeMillis() - startTime > length);
	}
}
