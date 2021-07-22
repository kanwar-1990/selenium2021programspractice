package ImpSeleniumSession;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownHandle {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://en-gb.facebook.com/");

		driver.findElement(By.linkText("Create New Account")).click();

		Thread.sleep(3000);

		WebElement day = driver.findElement(By.id("day"));

		WebElement month = driver.findElement(By.id("month"));
		WebElement year = driver.findElement(By.id("year"));

		// Since select doesnt have default constructor we need to pass the arguments

		// We have two ways to figure this out for this now since tag--select , we can
		// find by visiblebytext or slectbyindex
		/*
		 * Select select = new Select(day); // select.selectByVisibleText("5");
		 * select.selectByIndex(2);
		 * 
		 * Select select1 = new Select(month); select1.selectByIndex(2);
		 * 
		 * // select1.selectByVisibleText("May"); Select select2 = new Select(year); //
		 * select2.selectByVisibleText("1990"); select2.selectByIndex(2);
		 */

		// creating a generic method for easy way out
		FindDatesByselectbyVisibleText(day, "2");
		FindDatesByselectbyVisibleText(month, "Jul");
		FindDatesByselectbyVisibleText(year, "1990");

		// FindDatesByselectbyindex(element, indexvalue);

	}

	/**
	 * By creating generic method these are easy to call
	 * @param element
	 * @param value
	 */

	public static void FindDatesByselectbyVisibleText(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByVisibleText(value);

	}

	public static void FindDatesByselectbyindex(WebElement element, int indexvalue) {
		Select select = new Select(element);
		select.selectByIndex(indexvalue);

	}

}
