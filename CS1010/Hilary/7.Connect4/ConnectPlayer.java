package connect4;

public abstract class ConnectPlayer {
	public char piece;

	public ConnectPlayer(char piece) {
		// super();
		this.piece = piece;
	}

	abstract void makeMove(Connect4Grid2DArray grid);

	public boolean didPlayerWin(Connect4Grid2DArray grid) {
		if (grid.didLastPieceConnect4()) {
			return true;
		}
		return false;

	}

}