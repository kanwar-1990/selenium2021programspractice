package ImpSeleniumSession;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CustomWaits {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.navigate().to("https://demo.opencart.com/index.php?route=account/login");

		By emailid = By.id("input-email");
		By password = By.id("input-password");
		By loginBttn = By.xpath("//input[@type='submit']");

		getElementfoundwithCustomWait(driver, emailid, 5).sendKeys("knwrpl.singh@gmail.com");
		;

		driver.findElement(password).sendKeys("Kanwar@77");
		driver.findElement(loginBttn).click();

	}

	/**
	 * this wrapper method helps in returning the element if found
	 * 
	 * @param driver
	 * @param locator
	 * @param timeout
	 * @return
	 */

	public static WebElement getElementfoundwithCustomWait(WebDriver driver, By locator, int timeout) {
		WebElement element = null;

		for (int i = 0; i < timeout; i++) {

			try {
				element = driver.findElement(locator);
				break;
			} catch (Exception e) {

				System.out.println("the Time to find in element in seconds is--> " + i + "sec");

				try {

					Thread.sleep(1000);
				} catch (InterruptedException e1) {
				}

			}

		}

		return element;
	}

	/**
	 * this genric method is an customWait and helps in finding element is displayed
	 * or not
	 * 
	 * @param driver
	 * @param locator
	 * @param timeout
	 * @return
	 */
	public static boolean CheckElementisDisplayed(WebDriver driver, By locator, int timeout) {
		WebElement element = null;
		boolean flag = false;

		for (int i = 0; i < timeout; i++) {

			try {
				element = driver.findElement(locator);
				flag = element.isDisplayed();
				break;
			} catch (Exception e) {

				System.out.println("the Time to find in element in seconds is--> " + i + "sec");

				try {

					Thread.sleep(1000);
				} catch (InterruptedException e1) {
				}

			}

		}

		return flag;
	}
}
