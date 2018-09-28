/* SELF ASSESSMENT 
   1. Did I use appropriate CONSTANTS instead of numbers within the code? 
       Mark out of 5: 5
       Comment : Yes
   2. Did I use easy-to-understand, meaningful CONSTANT names formatted correctly in UPPERCASE? 
       Mark out of 5: 5
       Comment : Yes
   3. Did I use easy-to-understand meaningful variable names formatted properly (in lowerCamelCase)? 
       Mark out of 10: 10
       Comment : Yes
   4. Did I indent the code appropriately? 
       Mark out of 10: 10
       Comment : Yes
   5. Did I use an appropriate loop (or loops) to produce the different verses? 
       Mark out of 20:  20
       Comment  Yes. I implemented a for loop.
   6. Did I use a switch to build up the verses? 
       Mark out of 25:  25
       Comment : Yes. I used two switches
   7. Did I avoid duplication of code and of the lines which make up the verses (each line should be referred to in the code only once (or twice))? 
       Mark out of 10:  10
       Comment : Yes. Each line was referred to once only
   8. Does the program produce the correct output? 
       Mark out of 10:  10
       Comment : Yes
   9. How well did I complete this self-assessment? 
       Mark out of 5: 5
       Comment : Perfect!
   Total Mark out of 100 (Add all the previous marks): 100
*/

public class TwelveDaysOfChristmas {
	public static final int NUMBER_OF_DAYS = 12 ;

	public static void main(String[] args) {
		
		String previousGift = "" ;
		String gift = "" ;
	
		for (int count = 1 ; count <= NUMBER_OF_DAYS ; count++ )
		{
			System.out.print ("\nOn the") ;
			switch (count)
			{
			case 1 :
				System.out.print (" first " );
				break ;
			case 2 :
				System.out.print (" second " ) ;
				break ;
			case 3 :
				System.out.print (" third " ) ;
				break ;
			case 4 :
				System.out.print (" fourth" ) ;
				break ;
			case 5 :
				System.out.print (" fifth " ) ;
				break ;
			case 6 :
				System.out.print ( " sixth " ) ;
				break ;
			case 7 :
				System.out.print ( " seventh " ) ;
				break ;
			case 8 :
				System.out.print ( " eighth " ) ;
				break ;
			case 9 :
				System.out.print ( " ninth " ) ;
				break ;
			case 10 :
				System.out.print ( " tenth " ) ;
				break ;
			case 11 :
				System.out.print ( " eleventh " ) ;
				break ;
			default :
				System.out.print ( " twelfth " ) ;
				break ;
			}
			
			System.out.print (" day of Christmas" + "\nMy true love sent to me : " ) ;
			
			
			
			switch (count)
			{
			
			case 1 :
				gift =  "a Patridge in a Pear Tree." ;
				break ;
			case 2 :
				gift = "\nTwo Turtle Doves. \nand " ;
				break ;
			case 3 :
				gift = "\nThree French Hens." ;
				break ;
			case 4 :
				gift = "\nFour Calling Birds." ;
				break ;
			case 5 :
				gift = "\nFive Golden Rings." ;
				break ;
			case 6 :
				gift = "\nSix Geese a Laying." ;
				break ;
			case 7 :
				gift = "\nSeven Swans a Swimming." ;
				break ;
			case 8 :
				gift = "\nEight Maids a Milking." ;
				break ;
			case 9 :
				gift = "\nNine Ladies Dancing." ;
				break ;
			case 10 :
				gift = "\nTen Lords a Leaping." ;
				break ;
			case 11 :
				gift = "\nEleven Pipers Piping." ;
				break ;
			default :
				gift = "\nTwelve Drummers Drumming." ;
				break ;
			
			}
			gift = gift + previousGift ;
			System.out.print ( gift) ;
			previousGift = gift ;
			
			
		}

	}

}
