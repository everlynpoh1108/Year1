/* SELF ASSESSMENT 
   1. clearBoard:
Did I use the correct method definition?
Mark out of 5: 5
Comment: There is no value to be returned here except for the array
Did I use loops to set each position to the BLANK character?
Mark out of 5: 5
Comment: I used nested loop to fill in ' ' for the 2D array
   2. printBoard
Did I use the correct method definition?
Mark out of 5: 5
Comment: There is no value to be returned here so void is used
Did I loop through the array and prints out the board in a way that it looked like a board?
Mark out of 5: 5
Comment: I had coordinates of spaces printed out as a guide for players as well
   3. canMakeMove
Did I have the correct function definition and returned the correct item?
Mark out of 5: 5
Comment: Function return true is the current value in array is ' ' and false if it is occupied
Did I check if a specified location was BLANK?
Mark out of 5: 5
Comment: If specified location was BLANK, true is returned
   4. makeMove
Did I have the correct function definition?
Mark out of 5: 5
Comment: The parameters currentPlayerPiece, row, column and board were passed in and array is updated.
Did I set the  currentPlayerPiece in the specified location?
Mark out of 5: 5
Comment: currentPlayerPiece is placed in board[row][column]
   5. isBoardFull
Did I have the correct function definition and returned the correct item?
Mark out of 5: 5
Comment: The function return true if board has no empty spaces left and false otherwise   
Did I loop through the board to check if there are any BLANK characters?
Mark out of 5: 5
Comment: A count for empty spaces is set up in the loop to check for BLANK characters.
   6. winner
Did I have the correct function definition and returned the winning character
Mark out of 5: 5
Comment: currentPlayerPiece and board array is passed in and checked if there are any wins. If there are no wins
         , ' ' is returned. Winning character is returned otherwise.
Did I identify all possible horizontal, vertical and diagonal winners  
Mark out of 15: 15
Comment: I've listed all the 8 possible winning combinations in if statements.
   7.main

Did I create a board of size 3 by 3 and use the clearBoard method to set all the positions to the BLANK character ('  ')?
Mark out of 3: 3 
Comments: Before the game begun, board array was setup with blank characters
Did I loop asking the user for a location until wither the board was full or there was a winner?
Mark out of 5: 5
Comments: I used while loops to repeat asking the user and only stops when the board was full or had a winner.
Did I call all of the methods above?
Mark out of 5: 5
Comments: All methods were used.
Did I handle incorrect locations provided by the user (either occupied or invalid locations)?
Mark out of 3: 3
Comments: A message is printed if player chose occupied locations.
Did I switch the current player piece from cross to nought and vice versa after every valid move?
Mark out of 3: 3
Comments: Using if statements, if current player piece was nought, it'll change to cross the next game and vice versa
Did I display the winning player piece or a draw at the end of the game?
Mark out of 3: 3
Comments: Winning player piece is printed out at end of game

   8. Overall
Is my code indented correctly?
Mark out of 3: 3
Comments: All code were indented correctly.
Do my variable names and Constants (at least four of them) make sense?
Mark out of 3: 3
Comments: All made sense.
Do my variable names, method names and class name follow the Java coding standard
Mark out of 2: 2
Comments: All followed the coding standards.
      Total Mark out of 100 (Add all the previous marks): 100
*/
import java.util.Scanner ;

public class NoughtsAndCrosses {
	public static void main (String[]args) {
		char nought = 'O' ;
		char cross = 'X' ;
		char currentPlayer ;
		char nextPlayer = nought ;
		char[][]board = new char [3][3] ;
		clearBoard(board) ;
		printBoard(board) ;
		
		boolean restart = false ;
		boolean gameOver = false ;
		boolean isBoardFull = isBoardFull(board) ;
		
		while (!restart )	
		{
			
			while (isBoardFull == false && gameOver == false)
			{
				System.out.print("Enter your coordinates(row,column)separated by space for placing piece :");
				Scanner scanner = new Scanner(System.in) ;
				
				int row = scanner.nextInt() ;
				int column = scanner.nextInt();
			
				boolean canMakeMove = canMakeMove(board,row,column) ;
		
				if (canMakeMove)
				{
					currentPlayer = nextPlayer ;
					makeMove(board,currentPlayer,row,column) ;
						
					char winner = winner(board, currentPlayer) ;
				
					if (currentPlayer == nought)
					{
						nextPlayer = cross ;
					}
					else if (currentPlayer == cross)
					{
						nextPlayer = nought ;
					}
					
					if (winner == 'X') 
					{
						System.out.println ("X won!") ;
						gameOver = true ;
						
					}
					else if(winner== 'O')
					{
						System.out.println ("O won!") ;
						gameOver = true ;
						
					}
					else if(winner == ' ')
					{
						isBoardFull = isBoardFull(board) ;
						restart = true ;
					}
					
				}
				else
				{
					System.out.println("Space is filled. Make another move.");
					isBoardFull = isBoardFull(board) ;
					restart = true ;
				}	
				
				isBoardFull = isBoardFull(board) ;
			}
		}
		
		if (isBoardFull)
		{
			System.out.println("All spaces have been filled. There are no winners.");
		}
	}
	
	public static void clearBoard(char[][]board) {
		for (int i=0 ; i<board.length ; i++)
		{
			for (int j=0 ; j<board[i].length ; j++)
			{
				board[i][j] = ' ' ;
			}
		}
	}
	
	public static void printBoard(char[][]board) {
		System.out.println ("    0   1   2" ) ;
		for (int i=0 ; i<board.length ; i++)
		{
			System.out.print(i + " | ") ;
		
			for (int j=0 ; j<board[i].length ; j++) 
			{
				System.out.print(board[i][j] + " | ");
			}
			System.out.println(" ") ;
			System.out.println("  --------------") ;
		}
	}
	
	public static boolean canMakeMove(char[][]board, int row,int column) {
		if (board[row][column]== ' ')
		{
			return true ;
		}
		else return false ;	
	}
	
	public static void makeMove(char[][]board, char currentPlayerPiece, int row, int column) {
		board[row][column] = currentPlayerPiece ;
		printBoard(board) ;
	}
	
	public static boolean isBoardFull (char[][]board) {
		int emptySpace = 0 ;
		for (int i=0 ; i<board.length ; i++)
		{
			for (int j=0 ; j<board[i].length ; j++)
			{
				if (board[i][j]==' ') 
				{
					emptySpace++ ;
				}
			}
		}
		if (emptySpace==0)
		{
		 return true ;
		}
		else return false ;
	}
		
	
	public static char winner (char[][]board, char currentPlayer) {
		if ((board[0][0] == currentPlayer && board[0][1] == currentPlayer && board[0][2] == currentPlayer)
			|| (board[1][0] == currentPlayer && board[1][1] == currentPlayer && board[1][2] == currentPlayer)
			|| (board[2][0] == currentPlayer && board[2][1] == currentPlayer && board[2][2] == currentPlayer))
		{
			return currentPlayer ;
		}
		else if ((board[0][0] == currentPlayer && board[1][0] == currentPlayer && board[2][0] == currentPlayer)
				|| (board[0][1] == currentPlayer && board[1][1] == currentPlayer && board[2][1] == currentPlayer)
				|| (board[0][2] == currentPlayer && board[1][2] == currentPlayer && board[2][2] == currentPlayer))
		{
			return currentPlayer ;
		}
		else if ((board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer)
				|| (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer))
		{
			return currentPlayer ;
		}
				
		else return ' ' ;
	}
	
	
}
