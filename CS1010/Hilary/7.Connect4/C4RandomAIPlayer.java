package connect4;

public class C4RandomAIPlayer extends ConnectPlayer {

	public C4RandomAIPlayer(char colour) {
		super(colour);

	}

	@Override
	void makeMove(Connect4Grid2DArray grid) {
		boolean moveMade = false;
		int column = (int) (Math.random() * 6);
		if (grid.isValidColumn(column) && (!grid.isGridFull())) {
			grid.dropPiece(this, column);
			moveMade = true;
		} else if (grid.isGridFull()) {
			System.out.println("The grid is full");
		}

	}
}