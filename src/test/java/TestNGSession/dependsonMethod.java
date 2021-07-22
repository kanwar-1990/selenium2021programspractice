package TestNGSession;

import org.testng.annotations.Test;

public class dependsonMethod {
	
	/*
	dependsonMEthod-- are used if we are dependent on the previous test case
	Since the previous test only failed then there is no point in driving further
	IT WILL SKIP THE OTHER TEST
	
	*/
	

	@Test(priority = 1)
	public void loginPage() {
		System.out.println("Run LoginPage....");
	}

	@Test(priority = 2, dependsOnMethods = "loginPage")
	public void homePage() {
		System.out.println("Run homepage....");
		//int i = 7 / 0;
	}

	@Test(priority = 3, dependsOnMethods = { "loginPage", "homePage" })
	public void SearchPage() {
		System.out.println("Run searchPagde....");
	}
}
