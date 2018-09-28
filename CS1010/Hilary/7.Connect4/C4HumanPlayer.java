package connect4;

import java.util.Scanner;

public class C4HumanPlayer extends ConnectPlayer {

	public C4HumanPlayer(char colour) {
		super(colour);
		// TODO Auto-generated constructor stub
	}

	@Override
	void makeMove(Connect4Grid2DArray grid) {
		boolean moveMade = false;
		while (!moveMade) {
			System.out.println("Pick a column between 1 and 7.");
			Scanner scanner = new Scanner(System.in);
			if (scanner.hasNextInt()) {
				int column = scanner.nextInt() - 1;
				if (grid.isValidColumn(column) && (!grid.isGridFull())) {
					grid.dropPiece(this, column);
					moveMade = true;
				} else if (grid.isGridFull()) {
					System.out.println("The grid is full");
				} else {
					System.out.println("This is not a valid column");
				}
			} else {
				System.out.println("Place input as a number");
			}
		}
	}
}
