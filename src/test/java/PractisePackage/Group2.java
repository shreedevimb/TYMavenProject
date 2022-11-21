package PractisePackage;

import org.testng.annotations.Test;

public class Group2 {

	@Test(groups="Smoke")
	public void Script11()
	{
		System.out.println("----Group Exec Script1-----");
		
	}
	@Test(groups="Regression")
	public void Script22()
	{
		System.out.println("----Group Exec Script2----");
		
	}

}
