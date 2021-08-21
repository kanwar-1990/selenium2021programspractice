package ImpSeleniumSession;


import org.openqa.selenium.By;

public class SigupPage {

	private By Name = By.name("SignUp");

	public SigupPage() {
		// TODO Auto-generated constructor stub
		System.out.println("I am the SignUpPage");
	}

	public void clickSignupLink() {
		System.out.println("Clicking Singup Link");
	}

}
