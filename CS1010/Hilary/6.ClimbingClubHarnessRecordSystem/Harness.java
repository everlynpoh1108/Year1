public class Harness {
	private static final int MAX_NUM_OF_USES = 25;
	private String make ;
	private long modelNumber ;
	private int noOfTimeUsed ;
	private String lastCheckedInstructor ;
	private boolean onLoan ;
	private String clubMemberBorrowing ;
	
	public Harness(String make, long modelNumber, int noOfTimeUsed, String lastCheckedInstructor,
			boolean onLoan, String clubMemberBorrowing) 
	{
		this.make = make ;
		this.modelNumber = modelNumber ;
		this.noOfTimeUsed = noOfTimeUsed ;
		this.lastCheckedInstructor = lastCheckedInstructor ;
		this.onLoan = onLoan ;
		this.clubMemberBorrowing = clubMemberBorrowing ;
	}
	
	public Harness(String make, long modelNumber, String lastCheckedInstructor)
	{
		this.make = make ;
		this.modelNumber = modelNumber ;
		this.lastCheckedInstructor = lastCheckedInstructor ;
	}
	
	public void checkHarness(String lastCheckedInstructor) {
		if (isHarnessOnLoan() == false)
		{
			this.noOfTimeUsed = 0 ;
			this.lastCheckedInstructor = lastCheckedInstructor ;
			System.out.println("Harness has been checked by " + lastCheckedInstructor);
		}
		else
			System.out.println("Harness is currently out on loan. ");
	}
	
	public boolean isHarnessOnLoan()
	{
		if (this.onLoan == true)
		{
			return true ;
		}
		else return false ;
	}
	
	public boolean canHarnessBeLoaned()
	{
		if (this.onLoan == false)
		{
			if (this.noOfTimeUsed >= MAX_NUM_OF_USES)
			{
				return false ;
			}
			else return true ;
		}
		else return false ;
	}
	
	public void loanHarness(String clubMemberBorrowing )
	{
		this.clubMemberBorrowing = clubMemberBorrowing ;
		this.onLoan = true ;
		this.noOfTimeUsed += 1 ;
	}
	
	public void returnHarness()
	{
		if (isHarnessOnLoan() == true)
		{
			this.onLoan = false ;
			this.clubMemberBorrowing = " " ;
			System.out.println("Harness of make " + this.getMake() + " and model number " + this.getModelNumber() +
							" has been returned ");
		}
		else
			System.out.println("This harness is not on loan.");
	}
	
	@Override
	public String toString() {
		return "Make = " + make + ", Model Number = " + modelNumber + ", Times Used = " + noOfTimeUsed
				+ ", Last Checked Instructor = " + lastCheckedInstructor + ", Loan Status = " + onLoan +
				", Club Member Borrowing = " + clubMemberBorrowing ;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public long getModelNumber() {
		return modelNumber;
	}
	public void setModelNumber(long modelNumber) {
		this.modelNumber = modelNumber;
	}
	public int getNoOfTimeUsed() {
		return noOfTimeUsed;
	}
	public void setNoOfTimeUsed(int noOfTimeUsed) {
		this.noOfTimeUsed = noOfTimeUsed;
	}
	public String getLastCheckedInstructor() {
		return lastCheckedInstructor;
	}
	public void setLastCheckedInstructor(String lastCheckedInstructor) {
		this.lastCheckedInstructor = lastCheckedInstructor;
	}
	public boolean isOnLoan() {
		return onLoan;
	}
	public void setOnLoan(boolean onLoan) {
		this.onLoan = onLoan;
	}
	public String getClubMemberBorrowing() {
		return clubMemberBorrowing;
	}
	public void setClubMemberBorrowing(String clubMemberBorrowing) {
		this.clubMemberBorrowing = clubMemberBorrowing;
	}
}
