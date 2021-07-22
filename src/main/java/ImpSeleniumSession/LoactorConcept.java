package ImpSeleniumSession;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoactorConcept {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://demo.opencart.com/index.php?route=account/login");

		// locator----By id

		// <input type="text" ---input is the tag name , type is an attribute and text
		// is an attribute id

		/*
		 * WebElement email = driver.findElement(By.id("input-email"));
		 * email.sendKeys("test@gmail.com");
		 * 
		 * WebElement password = driver.findElement(By.id("input-password"));
		 * password.sendKeys("admin");
		 */
		// Locator--By name --2 priority

		driver.findElement(By.name("email")).sendKeys("test@gmail.com");
		driver.findElement(By.name("password")).sendKeys("admin");

		// locator--Xpath --3rd priority---is not an attribute and works as an locator

		/*
		 * driver.findElement(By.xpath("//*[@id=\'input-email\']")).sendKeys(
		 * "test@gmail.com");
		 * driver.findElement(By.xpath("//*[@id=\'input-password\']")).sendKeys("admin")
		 * ;
		 */

		// locator--CssSelector --3rd priority
		/*
		 * driver.findElement(By.cssSelector("#input-email")).sendKeys("test@gmail.com")
		 * ; driver.findElement(By.cssSelector("#input-password")).sendKeys("admin");
		 */

		// locator--linkTest----4th priority

		// driver.findElement(By.linkText("Forgotten Password")).click();

		// locator--partial linktest----5th priority

		// driver.findElement(By.partialLinkText("Forgotten")).click();

		// locator--tagName
		// driver.findElement(By.tagName(tagName)).click();

		// locator--ClassName--Helps in having the look an feel of the dom--styles and
		// fonts
		// Class Name--form-control
		// class Name--form-control

		// driver.findElement(By.className("form-control")).sendKeys("test@gmail.com");

	}

}
