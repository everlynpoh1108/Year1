/* SELF ASSESSMENT 
   1. Did I use easy-to-understand meaningful variable names? 
       Mark out of 10: 10
   2. Did I format the variable names properly (in lowerCamelCase)? 
       Mark out of 5: 5
   3. Did I indent the code appropriately? 
       Mark out of 10: 10
   4. Did I input the numbers one at a time from the command line?
       Mark out of 10:  10
   5. Did I check the input to ensure that invalid input was handled appropriately?
       Mark out of 10:  10
   6. Did I use an appropriate while or do-while loop to allow the user to enter numbers until they entered exit/quit?
       Mark out of 20:  20
   7. Did I implement the loop body correctly so that the average and variance were updated and output appropriately?
       Mark out of 30:  30
   8. How well did I complete this self-assessment? 
       Mark out of 5: 5
   Total Mark out of 100 (Add all the previous marks): 100
*/


import java.util.Scanner ;

public class AverageAndVariance {
	
	public static void main(String[] args) {
		
		boolean finished = false ;
		double variance = 0;
		double average = 0 ;
		double currentAverage = 0 ;
		int numberCount = 1 ;
		
		System.out.print("Enter a number (or type 'exit') :") ;
		Scanner input = new Scanner(System.in) ;
	
		while (!finished)
		{         
			if (input.hasNextDouble())
			{
				String inputString = input.next() ;
				double inputNumber = Double.parseDouble(inputString) ;
				currentAverage = average + ( inputNumber - average)/ numberCount ;
				variance = ((variance*(numberCount-1)) + (inputNumber-currentAverage) * 
						(inputNumber-average)) / numberCount ;
				average = currentAverage ;
				
				System.out.println ("So far the average is " + average + " and the variance"
					+ "is " + variance + ".") ;
				
				numberCount++ ;
				
				System.out.println ("Enter another number (or type 'exit') :") ;
			}
		
			else if (input.hasNext("exit"))
			{
				finished = true ;
				input.close();
			}
			
			else if (!input.hasNextDouble() )
			{
				System.out.println ("Not a valid number.Try again.");
				finished = true ;
			}
			
		}	
		System.out.println ("finish");
		
	}

}
