package ImpSeleniumSession;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Explictwait {

	public static void main(String[] args) {

		WebDriverManager.firefoxdriver().setup();

		WebDriver driver = new FirefoxDriver();

		driver.get("https://s1.demo.opensourcecms.com/opencart/index.php?route=account/login");

		By ename = By.name("email");

		By password = By.name("password");

		Util util = new Util(driver);

		
		util.WaitForElementPresent(ename, 10);
		util.WaitForTittlePresent("Account Login");

		util.GetSendKeys(ename, "test@gmail.com");
		util.GetSendKeys(password, "admin");

		/*
		 * Explicit wait--is also dynamic wait however its not a global wait, since its
		 * elements specific implicity wait is global wait since it is applicable to all
		 * the elements Error-- if i give 3 secs and element is not found in 10 secs on
		 * the load given TimeoutException comes waiting for the presence of element
		 * location , for every 500 milisecond eplicit wait will go an try to find the
		 * elements for 10 secs every 0.5 seconds we need to go and check the element ,
		 * if not found will try every .5 sec ---this is called interval dyme one more
		 * benefit is that apart from elements we can also handle non webelement ---
		 * things like finding title,url
		 */

	}

}
