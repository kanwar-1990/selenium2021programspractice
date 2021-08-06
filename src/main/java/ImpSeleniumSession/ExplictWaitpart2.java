package ImpSeleniumSession;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplictWaitpart2 {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		// We have applied explicit wait--Since implicit wait only works on webelements
		// Explicit wait works on both webelement and other things like url,title

		driver.get("https://demo.opencart.com/index.php?route=account/login");

		WebDriverWait wait = new WebDriverWait(driver, 10);

		wait.until(ExpectedConditions.titleIs("Account Login"));

		System.out.println(driver.getTitle());

		WebElement login_id = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("input-email")));

		login_id.sendKeys("finefine");
	}

}
