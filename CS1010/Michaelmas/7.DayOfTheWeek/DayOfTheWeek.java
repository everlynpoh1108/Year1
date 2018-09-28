/* SELF ASSESSMENT
 1. Did I use appropriate, easy-to-understand, meaningful CONSTANT names formatted correctly in UPPERCASE?
        Mark out of 5:  5
        Comment : Yes
 2. Did I use easy-to-understand meaningful variable names formatted properly (in lowerCamelCase)?
        Mark out of 5:  5
        Comment : Yes
 3. Did I indent the code appropriately?
        Mark out of 5: 5
        Comment : Yes
 4. Did I define the required function correctly (names, parameters & return type) and invoke them correctly?
       Mark out of 20:  20
       Comment : Yes
 5. Did I implement the dayOfTheWeek function correctly and in a manner that can be understood?
       Mark out of 20: 20
       Comment : Yes 
 6. Did I implement the other functions correctly, giving credit for any code that you take from elsewhere?
       Mark out of 20:  20
       Comment : Credits to code taken from ValidDate.java , LeapYears.java , and PrimeFinder.java 
 7. Did I obtain (and process) the input from the user in the correct format (dd/mm/yyyy), and deal with any invalid input properly?       Mark out of 10:
 8. Does the program produce the output in the correct format (e.g. Monday, 25th December 2017)?
       Mark out of 10:  10
       Comment : Yes, input was taken in the right format and output was in required format as well.
 9. How well did I complete this self-assessment?
        Mark out of 5: 5
        Comment : Perfect!
 Total Mark out of 100 (Add all the previous marks): 100
*/ 

import java.util.Scanner ;
import javax.swing.JOptionPane ;

public class DayOfTheWeek {
	
	public static final int DAYS_IN_APRIL_JUNE_SEPT_NOV = 30;
	public static final int DAYS_IN_FEBRUARY_NORMALLY = 28;
	public static final int DAYS_IN_FEBRUARY_IN_LEAP_YEAR = 29;
	public static final int DAYS_IN_MOST_MONTHS = 31;
	public static final int NUMBER_OF_MONTHS = 12;
	
	public static void main (String [] args) {
		String input = JOptionPane.showInputDialog("Enter date (DD/MM/YYYY) : " ) ;
		Scanner scanner = new Scanner (input) ;
		scanner.useDelimiter ("/" ) ;
		int day = scanner.nextInt() ;
		int month = scanner.nextInt() ;
		int year = scanner.nextInt() ;
	 
		if (validDate (day,month,year))
		{
			JOptionPane.showMessageDialog (null, dayOfTheWeek (day , month, year) + ", "  + day + 
	 			numberEnding (day) + " " + monthName (month) + " " + year) ;
		}
		else JOptionPane.showMessageDialog (null, "Date entered is not valid", "Error", JOptionPane.ERROR_MESSAGE) ;
	}
	
	public static boolean validDate( int day, int month, int year)
	{
		return ((year >= 0) && (month >= 1) && (month <= NUMBER_OF_MONTHS) &&
				(day >= 1) && (day <= daysInMonth( month, year )));
	}
	
	public static int daysInMonth( int month, int year )
	{
		int numberOfDaysInMonth = DAYS_IN_MOST_MONTHS;
		switch (month)
		{
		case 2:
			numberOfDaysInMonth = isLeapYear( year ) ? DAYS_IN_FEBRUARY_IN_LEAP_YEAR :
				                                       DAYS_IN_FEBRUARY_NORMALLY;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			numberOfDaysInMonth = DAYS_IN_APRIL_JUNE_SEPT_NOV;
			break;
		default:
			numberOfDaysInMonth = DAYS_IN_MOST_MONTHS;
			break;
		}
		return numberOfDaysInMonth;
	}
	
	public static boolean isLeapYear( int year )
	{
		return (((year%4 == 0) && (year%100 != 0)) || (year%400 == 0));
	}

 
	public static String numberEnding (int day) 
	{
		String ending = "" ;
		if(((day%100)/10) == 1)
			ending = "th" ;
		else
		{
			switch (day%10) 
			{
			case 1 :
				ending = "st" ;
				break ;
			case 2 : 
				ending = "nd" ;
				break ;
			case 3 :
				ending = "rd" ;
				break ;
			default :
				ending = "th" ;
				break ;	
			}
		}
		return ending ;
	}
 
	public static String monthName ( int month) 
	{
		String monthName = "" ;
		switch (month) 
		{
		case 1 :
			monthName = "January" ;
			break ;
		case 2 :
			monthName = "February" ;
			break ;
		case 3 :
			monthName = "March" ;
			break ;
		case 4 :
			monthName = "April" ;
			break ;
		case 5 :
			monthName = "May" ;
			break ;
		case 6 :
			monthName = "June" ;
			break ;
		case 7 :
			monthName = "July" ;
			break ;
		case 8 :
			monthName = "August" ;
			break ;
		case 9 :
			monthName = "September" ;
			break ;
		case 10 :
			monthName = "October" ;
			break ;
		case 11 :
			monthName = "November" ;
			break ;
		default :
			monthName = "December" ;
			break ;
		}
		return monthName ;
	}
 
	public static String dayOfTheWeek ( int day, int month, int year )
	{
		int Y = 0 ;
	 
		if (month == 1 || month == 2)
		{
			Y  = year - 1 ;
		}
		else {
			Y = year ;
		}
	 
		int last2DigitsOfY = Y % 100 ;
		int first2DigitsOfY = Y /100 ;
		double equationBeforeMod7 = ( day + Math.floor(2.6 * (((month + 9) % 12) +1) - 0.2) + last2DigitsOfY 
			             + Math.floor( last2DigitsOfY / 4) + Math.floor(first2DigitsOfY / 4) - (2*first2DigitsOfY) ) ;
	 
		double mod7 = 0 ;
		if (equationBeforeMod7 < 0 )
		{
			mod7 = (- equationBeforeMod7 % 7)  ;
		}
		else if (equationBeforeMod7 > 0 )
		{
			mod7 = equationBeforeMod7 % 7 ;
		}
	 
		String dayOfTheWeek = "" ;
		switch ( (int) mod7) 
		{
		case 0 :
			dayOfTheWeek = "Sunday" ;
			break ;
		case 1 :
			dayOfTheWeek = "Monday" ;
			break ;
		case 2 :
			dayOfTheWeek = "Tuesday" ;
			break ;
		case 3 :
			dayOfTheWeek = "Wednesday" ;
			break ;
		case 4 :
			dayOfTheWeek = "Thursday" ;
			break ;
		case 5 :
			dayOfTheWeek = "Friday" ;
			break ;
		case 6 :
			dayOfTheWeek = "Saturday" ;
			break ;
		}
	 
		return dayOfTheWeek ;
	}
}