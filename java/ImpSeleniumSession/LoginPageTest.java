package ImpSeleniumSession;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPageTest {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://demo.opencart.com/index.php?route=account/login");

		// Since i have not created Util method with static i need to call by creating
		// object

		By emailname = By.name("email");
		By Password = By.name("password");
		By LoginClick = By.xpath("//input[@type='submit']");

		Util util = new Util(driver); // Taking the control of the driver from here
		/*
		 * util.getElement(emailname); util.getElement(Password);
		 * util.getElement(LoginClick);
		 */
		util.GetSendKeys(emailname, "test@gmail.com");
		util.GetSendKeys(Password, "admin");
		util.doclick(LoginClick);

	}

}
