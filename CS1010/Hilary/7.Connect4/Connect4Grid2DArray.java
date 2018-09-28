package connect4;

public class Connect4Grid2DArray implements Connect4Grid {

	private static final int NUMBER_OF_ROWS = 6;
	private static final int NUMBER_OF_COLUMNS = 7;
	private static final char BLANK = ' ';

	public static char[][] grid;

	Connect4Grid2DArray() {
		grid = new char[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS];
	}

	@Override
	public void emptyGrid() {
		for (int row = 0; row < NUMBER_OF_ROWS; row++) {
			for (int column = 0; column < NUMBER_OF_COLUMNS; column++) {
				grid[row][column] = BLANK;
			}
		}
		printBoard();
	}

	@Override
	public boolean isValidColumn(int column) {
		if (column >= 0 && column < NUMBER_OF_COLUMNS) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean isColumnFull(int column) {
		if (grid[0][column] != BLANK) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public void dropPiece(ConnectPlayer player, int column) {
		if (!isColumnFull(column)) {
			for (int i = NUMBER_OF_ROWS - 1; i >= 0; i--) {
				if (grid[i][column] == BLANK) {
					grid[i][column] = player.piece;
					printBoard();
					break;
				}
			}
		} else {
			System.out.println("This column is full");
		}
	}

	@Override
	public boolean didLastPieceConnect4() {
		for (int row = 0; row < grid.length; row++) {
			for (int col = 0; col < grid[row].length; col++) {
				if (grid[row][col] != BLANK) {
					if (((col + 3) < grid[row].length) && grid[row][col] == grid[row][col + 1]
							&& grid[row][col] == grid[row][col + 2] && grid[row][col] == grid[row][col + 3]) {
						return true;
					}
					if (((row + 3) < grid.length) && grid[row][col] == grid[row + 1][col]
							&& grid[row][col] == grid[row + 2][col] && grid[row][col] == grid[row + 3][col]) {
						return true;
					}
					if (((row + 3) < grid.length) && ((col + 3) < grid[row].length)
							&& grid[row][col] == grid[row + 1][col + 1] && grid[row][col] == grid[row + 2][col + 2]
							&& grid[row][col] == grid[row + 3][col + 3]) {
						return true;
					}
					if (((row - 3) > 0) && ((col - 3) > 0) && grid[row][col] == grid[row - 1][col - 1]
							&& grid[row][col] == grid[row - 2][col - 2] && grid[row][col] == grid[row - 3][col - 3]) {
						return true;
					}
				}
			}
		}
		return false;
	}

	@Override
	public boolean isGridFull() {
		int count = 0;
		for (int row = 0; row < grid.length; row++) {
			for (int column = 0; column < grid[row].length; column++) {
				if (grid[row][column] != BLANK) {
					count++;
				}
			}
		}
		if (count == (NUMBER_OF_ROWS * NUMBER_OF_COLUMNS)) {
			return true;
		} else {
			return false;
		}
	}

	private void printBoard() {
		System.out.println("---------------------------------------------------------------");
		for (int row = 0; row < grid.length; row++) {
			for (int column = 0; column < grid[row].length; column++) {
				System.out.print("|    " + grid[row][column] + "  |");
			}
			System.out.println();
			System.out.println("---------------------------------------------------------------");
		}
	}
}
