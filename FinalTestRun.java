
public class FinalTestRun {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scenario1 scenario1 = new Scenario1();
		Scenario2 scenario2 = new Scenario2("75000","150000");
		
		scenario1.Searchresult();
		try {
			scenario1.Verifyresult();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		scenario2.Searchresult();
		scenario2.Verifyprice();
	
	}

}
