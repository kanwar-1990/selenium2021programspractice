 package ImpSeleniumSession;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MoveToElementConcept {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		// perfect example of get()-- it waits for website to get loaded fully and then
		// allow to perform actions

		driver.get("http://mrbool.com/");

		WebElement Contentwl = driver.findElement(By.className("menulink"));

		/*
		 * Actions class---user actions we are performing---real time customers are doing these actions 
		 * for Select class---we need to provide webelement for Actions class-- we need
		 * to provide the driver control Actions class helps to perform en number of
		 * actions on webelements,like to
		 * movetoelement,draganddrop,doubleclick,rightclick
		 */
		Actions action = new Actions(driver);
		action.moveToElement(Contentwl).build().perform();

		WebElement Courseclick = driver.findElement(By.linkText("Courses"));
		Courseclick.click();

		
	}
}
