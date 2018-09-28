
/*  SELF ASSESSMENT
   1. Did I use appropriate CONSTANTS instead of numbers within the code?
       Mark out of 10:   10
   2. Did I use easy-to-understand, meaningful CONSTANT names?
       Mark out of 5:  5
    3. Did I format the CONSTANT names properly (in UPPERCASE)?
       Mark out of 5:  5
   4. Did I use easy-to-understand meaningful variable names?
       Mark out of 10:  10
   5. Did I format the variable names properly (in lowerCamelCase)?
       Mark out of 10:  10
   6. Did I indent the code appropriately?
       Mark out of 10:  10
   7. Did I read the input correctly from the user using (an) appropriate question(s)?
       Mark out of 10:  10
   8. Did I compute the answer correctly for all cases?
       Mark out of 20:  20
   9. Did I output the correct answer in the correct format (as shown in the examples)?
       Mark out of 10:  10
   10. How well did I complete this self-assessment?
       Mark out of 10:  10
   Total Mark out of 100 (Add all the previous marks):  100
*/

import javax.swing.JOptionPane ;
import java.util.Scanner ;
public class PoundShillingPenny {
	public static final double NEWPENNIES_PER_OLDPENNY = 67.00 ;
	public static final double OLDPENNIES_PER_OLDSHILLING = 12.00 ;
	public static final double OLDSHILLINGS_PER_OLDPOUND = 20.00 ;
	public static final double NEWPENNIES_PER_NEWPOUND = 100.00 ;

	public static void main(String[] args) {
		String input = JOptionPane.showInputDialog("Enter amounts of old Sterling pounds,"
				+ "shillings and pennies separated by space" ) ;
		Scanner inputScanner = new Scanner (input) ;
		double oldPounds = inputScanner.nextDouble() ;
		double oldShillings = inputScanner.nextDouble() ;
		double oldPennies = inputScanner.nextDouble() ;
		inputScanner.close() ;
		
		double oldPoundsToOldShillings = oldPounds*OLDSHILLINGS_PER_OLDPOUND ;
		double oldShillingsToOldPennies = (oldShillings + oldPoundsToOldShillings)*
				                               OLDPENNIES_PER_OLDSHILLING ;
		double totalOldPennies = oldPennies + oldShillingsToOldPennies ;
		double oldPenniestoNewPennies = totalOldPennies*NEWPENNIES_PER_OLDPENNY ;
		double totalNewPoundPennies = oldPenniestoNewPennies/NEWPENNIES_PER_NEWPOUND ;
		
		JOptionPane.showMessageDialog (null, "The conversion of " + oldPounds + " old pound ,"
				+ oldShillings + " old shilling and " + oldPennies + " old penny = £" 
				+ totalNewPoundPennies ) ;
		
	}

}
