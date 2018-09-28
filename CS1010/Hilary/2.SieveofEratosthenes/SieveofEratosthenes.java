/* SELF ASSESSMENT 
   1. createSequence:
Did I use the correct method definition?
Mark out of 5: 5
Comment: There is no value to return , so I used void.
Did I create an array of size n (passed as the parameter) and initialise it?
Mark out of 5: 5
Comment: I created an array with input n value and initialised with the numbers 2 to n
Did I return the correct item?
Mark out of 5: 5
Comment: I used void so there is no return
   2. crossOutMultiples
Did I use the correct method definition?
Mark out of 5: 5
Comment: I used this method to return the number of prime numbers for my use later in another function.
Did I ensure the parameters are not null and one of them is a valid index into the array
Mark out of 2: 1
Comment: My parameters include user input (n) and a boolean array for prime numbers
Did I loop through the array using the correct multiple?
Mark out of 5: 3
Comment: I did not use an array to store prime numbers in this function but in the sieve function.
Did I cross out correct items in the array that were not already crossed out?
Mark out of 3: 3
Comment: Yes the for loop increases to the next prime numbers and cross out its multiples.
   3. sieve   
Did I have the correct function definition?
Mark out of 5: 4
Comment: I used this function to create an array of only prime numbers.
Did I make calls to other methods?
Mark out of 5: 4
Comment: Yes, to the nonCrossedOutSubseqToStr function to print out the array.     
Did I return an array with all non-prime numbers are crossed out?
Mark out of 2: 2
Comment: The array (primeNumberSequence) consist of only prime numbers.
   4. sequenceTostring  
Did I have the correct function definition?
Mark out of 5: 4
Comment: This function added brackets to the crossed out numbers.
Did I ensure the parameter to be used is not null?
Mark out of 3: 3
Comment: The parameter include the integer of crossed out numbers.
Did I Loop through the array updating the String variable with the non-crossed out numbers and the crossed numbers in brackets? 
Mark out of 10: 0
Comment:  I did not use an array for this part.  
   5. nonCrossedOutSubseqToString  
Did I have the correct function definition
Mark out of 5: 3
Comment: I used this function to convert the array of prime numbers to its String representation.     
Did I ensure the parameter to be used is not null?  
Mark out of 3: 3
Comment: The parameter consist of the array of prime numbers (int[]primeNumberSequence)
Did I loop through the array updating the String variable with just the non-crossed out numbers? 
Mark out of 5: 0
Comment: Nope, didn't use an array here.
   6. main  
Did I ask  the user for input n and handles input errors?  
Mark out of 5: 3
Comments: Did not handle input errors.
Did I make calls to other methods (at least one)?
Mark out of 5: 5
Comment:  Yes, called 3 methods.
Did I print the output as shown in the question?  
Mark out of 5: 3
Comment:  Same multiples of prime numbers were printed repeatedly. But results are still correct. 
   7. Overall
Is my code indented correctly?
Mark out of 4: 4
Comments: All code were indented correctly.
Do my variable names make sense?
Mark out of 4: 4
Comments: All made sense.
Do my variable names, method names and class name follow the Java coding standard
Mark out of 4: 4
Comments: All were up to coding standards
      Total Mark out of 100 (Add all the previous marks): 71 
*/
import java.util.Arrays;
import java.util.Scanner; ;

public class SieveofEratosthenes {
	public static void main (String[]args) {
		Scanner scanner = new Scanner(System.in) ;
		System.out.print("Enter a positive integer (>=2) : ") ;
		int N = scanner.nextInt() ;
		boolean[]isPrime = new boolean [N] ;
		isPrime[0] = false ;
		for (int count=1 ; count<N ; count++) 
		{
			isPrime[count] = true ;
		}
		createSequence(N) ;
		int numberOfPrimeNumber = crossOutHigherMultiples(N, isPrime) ;
		sieve (numberOfPrimeNumber, isPrime, N) ;
		
		
	}
	
	public static void createSequence (int N) {
		int[]numberSequence = new int[N-1] ;
		int sum = 1 ;
		
		for (int index=0 ; index < numberSequence.length ; index++) 
		{ 
			sum = sum + 1 ;
			numberSequence[index] = sum  ;		
		}
		
		System.out.println (Arrays.toString(numberSequence)) ;
	}
	
	public static int crossOutHigherMultiples (int N , boolean isPrime[]) {
		
		int numberOfPrimes = 0 ;
		
		
		for (int index=2 ; index<=N ; index++)
		{
			
			if (isPrime[index-1])
			{
				System.out.print(index + ", ") ;
				numberOfPrimes = numberOfPrimes + 1 ;
	
				for (int index2 = index*index ; index2<=N ; index2+=index)
				{
					isPrime[index2-1] = false ;
					sequenceToString(index2) ;
				}
			}
			
		}
		
		return numberOfPrimes ;
		
	}
	
	public static void sieve (int numberOfPrimes , boolean[]isPrime, int N) {
		int[]primeNumberSequence = new int [numberOfPrimes] ;
		int count = 0 ;
		for (int index=2 ; index<=N ; index++)
		{
			
			if (isPrime[index-1])
			{
				primeNumberSequence[count] = index ;
				count++ ;
			}
		
		}
		
		nonCrossedOutSubseqToSt(primeNumberSequence) ;
	
	}
	
	public static void sequenceToString ( int nonPrime) {
		System.out.print("[" + nonPrime + "] ,") ;
		
	}
	
	public static void nonCrossedOutSubseqToSt (int[]primeNumberSequence) {
		System.out.println ("\n" + Arrays.toString(primeNumberSequence)) ;
		
	}
}
