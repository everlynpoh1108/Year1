/* SELF ASSESSMENT 

Class Rational 
I declared two member variables: numerator and denominator (marks out of 4: 4).
Comment: I declared both num and den.

Constructor 1 
My program takes take two integers as parameters (for numerator and denominator) and initialises the member variables with the corresponding values . If the denominator is equal to 0 I throw an exception (marks out of 5:5 ).
Comment: My program takes in two integers as parameters

Constructor 2 
My program takes only one integer as parameter (numerator), and set the numerator to this value . I set the denominator to 1 in this case, as the resulting rational number in this case is an integer (marks out of 3: 3).
Comment: My second constructor takes in the numerator as the parameter and the denominator is set to 1.

Add Method 
My program takes only a rational number as a parameter and returns a new rational number which has a numerator and denominator which the addition of the two objects - this and the parameter. My program does not overwrite any of the other two rational numbers (marks out of 8: 8).
Comment: My program takes only a rational number as a parameter and returns a new rational number which has a numerator and denominator which the addition of the two objects

Subtract Method 
I have implemented this the same as add method, except it implements subtraction (marks out of 8: 8 ).
Comment: I have implemented this the same as add method

Multiply Method 
I have implemented this the same as add method, except it implements multiplication (marks out of 8: 8 ).
Comment: I have implemented this the same as add method

Divide Method 
I have implemented this the same as add method, except it implements divide (marks out of 8: ).
Comment: 

Equals Method 
My program takes a rational number as a parameter and compares it to the reference object. I only use multiplication between numerators/denominators for the purpose of comparison, as integer division will lead to incorrect results. I return a boolean value ((marks out of 8: 8).
Comment: My program takes a rational number as a parameter and compares it to the reference object

isLessThan 
My program takes a rational number as a parameter and compares it to the reference object. I only use multiplication as integer division will lead to incorrect results. I return a boolean value (marks out of 8:8 ).
Comment: My program takes a rational number as a parameter and compares it to the reference object.

Simplify Method 
My program returns a rational number but not a new rational number, instead it returns the current reference which is this. It doesn't take any parameters as it works only with the reference object. I first find the greatest common divisor (GCD) between the numerator and denominator, and then obtain the new numerator and denominator by dividing to the GCD (marks out of 8:8 ).
Comment: My program returns a rational number but not a new rational number, instead it returns the current reference which is this.

gcd function 
My program returns the greatest common divider of two integers: the numerator and the denominator (marks out of 6: 6).
Comment: My program returns the greatest common divider of two integers: the numerator and the denominator

toString Method 
My program returns a string showing the fraction representation of the number, eg. "1/2". It takes no parameters (marks out of 4: 4).
Comment:My program returns a string showing the fraction representation of the number 

Test Client Class 
My program asks the user for two rational numbers, creates two rational objects using the constructor and passing in the provided values, calls addition, subtraction, multiplication, division, comparison and simplification and prints out the results (marks out of 22: 22).
Comment:  (marks out of 22: 22).

 Total Mark out of 100 (Add all the previous marks): 100
*/
import java.util.Scanner ;

public class RationalNumbers {
	public static void main (String[]args) {
		System.out.print ("Enter first rational number (separated by space): ") ;
		Scanner scanner = new Scanner(System.in) ;
		int num1 = scanner.nextInt() ;
		int den1 = scanner.nextInt() ;
		Rational rational1 = new Rational (num1, den1) ;
		System.out.print ("Enter second rational number (separated by space): ") ;
		scanner = new Scanner(System.in) ;
		int num2 = scanner.nextInt() ;
		int den2 = scanner.nextInt() ;
		Rational rational2 = new Rational (num2, den2) ;
		
		if (rational1.equals(rational2))
		{
			System.out.println("The two rationals are equal." );
		}
		else if (rational1.equals(rational2)==false)
		{
			if (rational1.isLessThan(rational2))
			{
				System.out.println(rational1.getNum() + "/" + rational1.getDen()
				+ " is less than " + rational2.getNum() + "/" + rational2.getDen());
			}
			else
				System.out.println(rational1.getNum() + "/" + rational1.getDen()
				+ " is greater than " + rational2.getNum() + "/" + rational2.getDen());
		}
		Rational sum = rational1.add(rational2) ;
		System.out.println("Addition : " + sum );
		rational1 = new Rational (num1, den1) ;
		rational2 = new Rational (num2, den2) ;
		Rational diff = rational1.subtract(rational2) ;
		System.out.println("Difference : " + diff );
		rational1 = new Rational (num1, den1) ;
		rational2 = new Rational (num2, den2) ;
		Rational prod = rational1.multiply(rational2) ;
		System.out.println("Product : " + prod );
		rational1 = new Rational (num1, den1) ;
		rational2 = new Rational (num2, den2) ;
		Rational quot = rational1.divide(rational2) ;
		System.out.println("Quotient : " + quot );
		
	}
