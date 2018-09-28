/* SELF ASSESSMENT 
   1. Did I use appropriate CONSTANTS instead of numbers within the code? 
       Mark out of 5: 5 
       Comment: 
   2. Did I use easy-to-understand, meaningful CONSTANT names formatted correctly in UPPERCASE? 
       Mark out of 5: 5
       Comment: 
   3. Did I use easy-to-understand meaningful variable names? 
       Mark out of 10: 10
       Comment:  
   4. Did I format the variable names properly (in lowerCamelCase)? 
       Mark out of 5: 5 
       Comment:  
   5. Did I indent the code appropriately? 
       Mark out of 10: 10 
       Comment:  
   6. Did I use an appropriate loop to allow the user to enter their guesses until they win or lose? 
       Mark out of 20: 20
       Comment:  
   7. Did I check the input to ensure that invalid input was handled appropriately? 
       Mark out of 10: 5
       Comment:  Invalid input was not handled appropriately
   8. Did I generate the cards properly using random number generation (assuming all cards are equally likely each time)? 
       Mark out of 10: 10
       Comment:  
   9. Did I output the cards correctly as 2, 3, 4, ... 9, 10, Jack, Queen, King? 
       Mark out of 10: 8
       Comment:  I printed numbers 1, 11, 12, 13 and labelled them after as Ace, Jack, Queen and King respectively.
   10. Did I report whether the user won or lost the game before the program finished? 
       Mark out of 10: 10
       Comment:  
   11. How well did I complete this self-assessment? 
       Mark out of 5: 5
       Comment:  
   Total Mark out of 100 (Add all the previous marks): 93
*/
import java.util.Scanner ;
import java.util.Random ;

public class HiLoGame {
	public static final int CORRECT_GUESSES_TO_WIN = 4 ;
	public static final int CARD_RANKS = 13 ;

	public static void main(String[] args) {
		int correctAnswerCount = 0 ;
		boolean wrong = false ;
		
		Random generator = new Random() ;
		int currentCard = generator.nextInt(CARD_RANKS) + 1 ;
	
		
		
		while (correctAnswerCount < CORRECT_GUESSES_TO_WIN && !wrong )
			
		{
			System.out.print ( "The card is a " + currentCard  ) ;
			
			switch (currentCard)
			{
			case 1 :
				System.out.print (" which is an Ace. ") ;
				break ;
			case 11 :
				System.out.print (" which is a Jack. ") ;
				break ;
			case 12 :
				System.out.print (" which is a Queen. ") ;
				break ;
			case 13 : 
				System.out.print (" which is a King. ") ;
				break ;
			}
			

			System.out.println ( "\nDo you think the next card will be higher, lower or equal?" ) ;
			Scanner scanner = new Scanner(System.in) ;
			int nextCard = generator.nextInt( CARD_RANKS) + 1 ;
			
			if (nextCard>currentCard)
			{
				if (scanner.hasNext("higher") )
				{
					correctAnswerCount++ ;
					System.out.println ("You got it right! Your current score is " + correctAnswerCount) ;
				}
				else wrong = true ;
			}

		
			if (currentCard>nextCard )
			{
				if (scanner.hasNext("lower") )
				{
				correctAnswerCount++ ;
				System.out.println ("You got it right! Your current score is " + correctAnswerCount) ;
			   	}
				else wrong = true ;
			}
			
		
			if (currentCard==nextCard ) 
			{
				if (scanner.hasNext("equal") )
				{
				correctAnswerCount++ ;
				System.out.println ("You got it right! Your current score is " + correctAnswerCount) ;
				}
				else wrong = true ;
			}
			
			
			if (correctAnswerCount == 4)
			{
				System.out.println ("Congratulations! You got them all correct") ;
			}
			
			if (wrong == true )
			{
				wrong = false ;
				System.out.println ("You got it wrong. Please try again.") ;
				correctAnswerCount = 0 ;
			}
			
			currentCard = nextCard ;
		
		}
		
		
	}

}