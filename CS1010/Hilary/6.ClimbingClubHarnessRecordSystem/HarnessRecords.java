import java.util.ArrayList;

public class HarnessRecords {
	private ArrayList<Harness> harnessList ;
	Harness harness ;
	
	public HarnessRecords() {
		
	}
	
	public ArrayList<Harness> getHarnessList() {
		return harnessList;
	}

	public void addHarness(ArrayList<Harness> harnessList) {
		this.harnessList = harnessList;
	}
	
	public boolean isEmpty() {
		if (harnessList.size()==0)
		{
			return true ;
		}
		else return false ;
	}
	
	public Harness findHarness(String make, long modelNumber) {
		boolean harnessFound = false ;
		int counter = 0 ;
		while (!harnessFound && counter<this.harnessList.size())
		{
			harness = harnessList.get(counter) ;
			if (harness.getMake().equals(make) && harness.getModelNumber() == modelNumber)
			{
				harnessFound = true ;
			}
			else
				counter++ ;
		}
		if (!harnessFound)
		{
			return null ;
		}
		else return harness ;
		
	}
	
	public void checkHarness(String make, long modelNumber, String lastCheckedInstructor) {
		Harness harnessFound = findHarness(make, modelNumber) ;
		if (harnessFound == null)
		{
			System.out.println("The harness you are looking for does not exist.");
		}
		else
		{
			harnessFound.checkHarness(lastCheckedInstructor);	
		}

	}
	
	public void loanHarness(String memberName) {
		boolean harnessFound = false ;
		int counter = 0 ;
		
		if (isEmpty() == true)
		{
			System.out.println("There are no harnesses available at the moment. ");
		}
		else
		{
			while (!harnessFound && counter<harnessList.size())
			{
				harness = harnessList.get(counter) ;
				if (harness.canHarnessBeLoaned() == true)
				{
					harness.loanHarness(memberName);
					System.out.println("Harness of make " + harness.getMake() + " and model number " + harness.getModelNumber() +
							" is current out on loan to " + memberName );
					harnessFound = true ;
				}
				else 
				{
					counter++ ;
				}
			}
			if (!harnessFound)
			{
				System.out.println("There are no harnesses available at the moment. ");
			}
		}
	}
	
	public void returnHarness(String make, long modelNumber) {
		Harness harnessFound = findHarness(make, modelNumber) ;
		if (harnessFound == null)
		{
			System.out.println("The harness you are looking for does not exist.");
		}
		else
		{
			harnessFound.returnHarness() ;
		}
	}
	
	public void removeHarness(String make, long modelNumber) {
		boolean harnessFound = false ;
		int counter = 0 ;
		while (!harnessFound && counter<this.harnessList.size())
		{
			harness = harnessList.get(counter) ;
			if (harness.getMake().equals(make) && harness.getModelNumber() == modelNumber)
			{
				harnessList.remove(counter) ;
				System.out.println("Harness successfully removed. ");
				harnessFound = true ;
			}
			else
				counter++ ;
		}
		if (!harnessFound)
		{
			System.out.println("The harness you are looking for does not exist. ");
		}
	}

	@Override
	public String toString() {
		String output = "" ;
		int number = 1 ;
		for(int i=0 ; i<harnessList.size(); i++)
		{
			output = number + ". " + harnessList.get(i) ;
			number++ ;
			System.out.println(output);
		}
		return output ;
	}
	
	
	
}