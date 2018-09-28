/* SELF ASSESSMENT

Connect4Game class (35 marks)35
My class creates references to the Connect 4 Grid and two Connect 4 Players. It asks the user whether he/she would like to play/quit inside a loop. If the user decides to play then: 1. Connect4Grid2DArray is created using the Connect4Grid interface, 2. the two players are initialised - must specify the type to be ConnectPlayer, and 3. the game starts. In the game, I ask the user where he/she would like to drop the piece. I perform checks by calling methods in the Connect4Grid interface. Finally a check is performed to determine a win. 
Comment:My class creates references to the Connect 4 Grid and two Connect 4 Players. It asks the user whether he/she would like to play/quit inside a loop. If the user decides to play then: 1. Connect4Grid2DArray is created using the Connect4Grid interface, 2. the two players are initialised - must specify the type to be ConnectPlayer, and 3. the game starts. In the game, I ask the user where he/she would like to drop the piece. I perform checks by calling methods in the Connect4Grid interface. Finally a check is performed to determine a win. 


Connect4Grid interface (10 marks)10
I define all 7 methods within this interface.
Comment:I define all 7 methods within this interface.


Connect4Grid2DArray class (25 marks) 25
My class implements the Connect4Grid interface. It creates a grid using a 2D array Implementation of the method to check whether the column to drop the piece is valid. It provides as implementation of the method to check whether the column to drop the piece is full. It provides as implementation of the method to drop the piece.  It provides as implementation of the method to check whether there is a win.
Comment:My class implements the Connect4Grid interface. It creates a grid using a 2D array Implementation of the method to check whether the column to drop the piece is valid. It provides as implementation of the method to check whether the column to drop the piece is full. It provides as implementation of the method to drop the piece.  It provides as implementation of the method to check whether there is a win.


ConnectPlayer abstract class (10 marks)10
My class provides at lest one non-abstract method and at least one abstract method. 
Comment:My class provides at lest one non-abstract method and at least one abstract method. 


C4HumanPlayer class (10 marks)10
My class extends the ConnectPlayer class and overrides the abstract method(s). It provides the Human player functionality.
Comment:My class extends the ConnectPlayer class and overrides the abstract method(s). It provides the Human player functionality.


C4RandomAIPlayer class (10 marks)10
My class extends the ConnectPlayer class and overrides the abstract method(s). It provides AI player functionality. 
Comment:My class extends the ConnectPlayer class and overrides the abstract method(s). It provides AI player functionality. 

Total Marks out of 100:100

*/package connect4;

import java.util.Scanner;

public class Connect4Game {
	public static final char O = 'O';
	public static final char X = 'X';

	public static void main(String[] args) {
		Connect4Grid2DArray grid;
		ConnectPlayer user;
		ConnectPlayer computer;
		
		boolean finished = false;
		while (!finished) {
			System.out.println("Select (1-2) : \n1. Play \n2. Quit");
			Scanner inputScanner = new Scanner(System.in);
			int select = inputScanner.nextInt() ;
			if (select == 2) {
				finished = true;
			} else if (select == 1) {
				grid = new Connect4Grid2DArray();
				grid.emptyGrid();
				user = new C4HumanPlayer(O);
				computer = new C4RandomAIPlayer(X);
				if(isGameFinished(grid, user, computer)) {
					finished = true;
				}
			}
		}
	}

	private static boolean isGameFinished(Connect4Grid2DArray grid, ConnectPlayer user, ConnectPlayer computer) {
		boolean gameFinished = false;
		while (!gameFinished) {
			user.makeMove(grid);
			if (user.didPlayerWin(grid)) {
				System.out.println("You won the game!");
				gameFinished = true;
				break;
			}
			computer.makeMove(grid);
			if (computer.didPlayerWin(grid)) {
				System.out.println("The computer won the game!");
				gameFinished = true;
				break;
			}
			
			if(grid.isGridFull()&&(!gameFinished)) {
				grid.emptyGrid();
				System.out.println("There is no winner! Game will now restart.");
				break;
			}
		}
		return gameFinished;

	}

}