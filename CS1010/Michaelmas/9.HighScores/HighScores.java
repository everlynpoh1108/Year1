/* SELF ASSESSMENT
 1. Did I use easy-to-understand meaningful variable names formatted properly (in lowerCamelCase)?
        Mark out of 5:  5 
        Comment : Yes, all variables names are in lower camel case.
 2. Did I indent the code appropriately?
        Mark out of 5: 5
        Comment : Yes, all code were indented correctly.
 3. Did I write the initialiseHighScores function correctly (parameters, return type and function body) and invoke it correctly?
       Mark out of 15:   15
       Comment : Yes, every index of the array is initialized to 0.
 4. Did I write the printHighScores function correctly (parameters, return type and function body) and invoke it correctly?
       Mark out of 15:  10
       Comment : I didn't use the function to print the array but just the String.
 5. Did I write the higherThan function correctly (parameters, return type and function body) and invoke it correctly?
       Mark out of 15:  15
       Comment : I set the return to boolean and the function works fine.
 6. Did I write the insertScore function correctly (parameters, return type and function body) and invoke it correctly?
       Mark out of 20:  20
       Comment : Yes, the function works fine.
 7. Did I write the main function body correctly (first asking for the number of scores to be maintained and then repeatedly asking for scores)?
       Mark out of 20:  10
       Comment : The program does asked the numbers of scores to be maintained and repeatedly ask for scores.
 8. How well did I complete this self-assessment?
        Mark out of 5: 5 
 Total Mark out of 100 (Add all the previous marks): 85
*/ 
import java.util.Arrays;
import java.util.Scanner ;
import java.util.Collections ;

public class HighScores {

	public static void main(String[] args) {
		System.out.println("How many scores would you like to maintain? ") ;
		Scanner scanner = new Scanner ( System.in ) ;
		Integer numberOfHighScores = scanner.nextInt() ;
		Integer [] highScores = new Integer [numberOfHighScores] ;
		initialiseHighScores (highScores) ;
		boolean finished = false ;
		
		while (!finished)
		{
			for (int index = 0 ; index < highScores.length ; index++)
			{
				System.out.println("\nEnter your score or enter (quit) : ") ;
				scanner = new Scanner (System.in) ;
				if (scanner.hasNextInt() )
				{
					Integer currentScore = scanner.nextInt();
					highScores[index] = currentScore ;
					printHighScores (highScores) ;
					if (higherThan (highScores, currentScore)) 
					{ 
						insertScore(highScores, currentScore) ;
					}
					else
					{
						highScores[index] = highScores[index] ;
						insertScore(highScores, currentScore) ;
					}
				
				}
				else if (scanner.hasNext("quit" ))
				{
					finished = true ;
				}
			}
						
		}
		
		
	}

	public static void initialiseHighScores (Integer[]highScores)
	{
		for (int index = 0 ; index < highScores.length ; index++)
		{
			highScores [index] = 0 ;
		}
	}
	
	public static void printHighScores ( Integer[]highScores)
	{
		System.out.println("The high scores are ");
		
	}
	
	public static boolean higherThan ( Integer[]highScores , Integer currentScore )
	{
		
		boolean higherThan = false ;
		for (int index = 0 ; index < highScores.length ; index++)
		{
			if ( currentScore > highScores[index] )
			{
				return true ;		
			}
		}
		return higherThan ;
	
	}
	
	public static void insertScore ( Integer[]highScores , Integer currentScore )
	{
		Arrays.sort(highScores, Collections.reverseOrder() ) ;
		System.out.print (Arrays.toString(highScores)) ;
		
	}
}
