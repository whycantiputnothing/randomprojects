
public class Action {
	private int row;
	private int column;

	public Action(int r, int c) {
		row = r;
		column = c;
	}

	public int getRow() {
		return row;
	}

	public int getCol() {
		return column;
	}

	public String toString() {
		return "" + (char) (row + 65) + (column + 1);
	}
}
