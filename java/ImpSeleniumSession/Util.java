package ImpSeleniumSession;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Util {

	WebDriver driver; // intializeing driver here only

	/**
	 * To take control and create an constructor
	 * 
	 * @param driver
	 */

	public Util(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * to get the webelements
	 * 
	 * @param locator
	 * @return
	 */
	public WebElement getElement(By locator) {

		WebElement element = null;

		// Since element is local variable inside the method we need to intialize it
		// hence null is the default value of webelement

		try {
			element = driver.findElement(locator);
			JavaScriptutil.flash(element, driver);

		} catch (Exception e) {

			System.out.println("Some exception occured will finding the webelement");
			System.out.println(e.getMessage());
		}

		return element;
	}

	/**
	 * Explicit wait for specific Element Present
	 * 
	 * @param locator
	 * @param value
	 */

	public void WaitForElementPresent(By locator, long value) {
		WebDriverWait wait = new WebDriverWait(driver, value);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));

	}

	/**
	 * To get the dynamic wait to for getting the Tittle
	 * 
	 * @param title
	 */

	public void WaitForTittlePresent(String title) {
		WebDriverWait wait1 = new WebDriverWait(driver, 10);
		wait1.until(ExpectedConditions.titleContains(title));
		System.out.println(driver.getTitle());

	}

	/**
	 * To Sendkeys option
	 * 
	 * @param locator
	 * @param Typevalue
	 */

	public void GetSendKeys(By locator, String Typevalue) {

		try {
			getElement(locator).sendKeys(Typevalue);

		} catch (Exception e) {

			System.out.println("Check if any error found");
		}

	}

	/**
	 * To click option---these are either called generic methods or wrapper
	 * 
	 * @param locator
	 */

	public void doclick(By locator) {

		getElement(locator).click();
	}

}
