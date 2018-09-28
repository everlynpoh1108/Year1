/* SELF ASSESSMENT
 1. Did I use easy-to-understand meaningful variable names formatted properly (in lowerCamelCase)?
        Mark out of 5:   5      Comment: Yes, the variable names were related and relevant to what the program is doing.
 2. Did I indent the code appropriately?
        Mark out of 5:   5      Comment: Yes, all code were indented accordingly.
 3. Did I write the determineStarNumber or determineTriangleNumber function correctly (parameters, return type and function body) and invoke it correctly?
       Mark out of 20:  20        Comment: Yes, determineStarNumber had the parameter of index and returned starNumber.
 4. Did I write the isStarNumber function correctly (parameters, return type and function body) and invoke it correctly?
       Mark out of 20:   20       Comment: Yes, isStarNumber had the parameter of triangleNumber and returned boolean if triangleNumber is equal to starNumber.
 5. Did I calculate and/or check triangle numbers correctly?
       Mark out of 15:   15       Comment: The program shows the 4 correct answers in the beginning but after a while adds a fifth answer.
 6. Did I loop through all possibilities in the program using system defined constants to determine when to stop?
       Mark out of 10:   10       Comment: Yes, when the maximum integer value minus the triangleNumber is less than the triangleIndex, the program will stop.
 7. Does my program compute and print all the correct triangular star numbers?
       Mark out of 20:   18     Comment: Yes all 4 answers and an additional 5th answer.
 8. How well did I complete this self-assessment?
        Mark out of 5:    5    Comment: Perfect!
 Total Mark out of 100 (Add all the previous marks): 98
*/ 

public class TriangularStars {
	public static void main (String [] args) {
		int triangleNumber = 0 ;
		int triangleIndex = 1 ;
		
		while ( java.lang.Integer.MAX_VALUE - triangleNumber >= triangleIndex)
		{
			triangleNumber = triangleNumber + triangleIndex ;
			if (isStarNumber (triangleNumber))
			{
				System.out.println (" The value that are simultaneously a star number and a triangle number = "
						+ triangleNumber ) ;
			}	
			triangleIndex++ ;
		}
		
	}
	
	// Function : Determine if triangleNumber is equal to starNumber. If equal, isStarNumber is returned as
	//            true.
	public static boolean isStarNumber (int number)
	{
		int starNumberIndex = 0 ;
		int starNumber = determineStarNumber (starNumberIndex) ;
		while ( (number > starNumber) && (starNumber != -1) )
		{
			starNumberIndex++ ;
			starNumber = determineStarNumber ( starNumberIndex ) ;
		}
		return (number == starNumber) ;
	}
	
	// Function : Returns starNumber of a passed index.
	public static int determineStarNumber ( int index)
	{
		if (index == 0) 
			return 1 ;
		int starNumber = 0 ;
		if ((index > 0) && ((java.lang.Integer.MAX_VALUE / 6) > index))
		{ 
			starNumber = 6 * index ;
			
			if ((java.lang.Integer.MAX_VALUE / starNumber) >= (index - 1))
			{
				starNumber = starNumber*(index - 1) ;
				
				if ((java.lang.Integer.MAX_VALUE - 1) >= starNumber)
				{
					starNumber = starNumber + 1 ;
					return starNumber ;
				}
				
			}
		}
		return -1 ;
	}
}
