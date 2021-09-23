package ImpSeleniumSession;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetdropDownList {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://en-gb.facebook.com/");

		driver.findElement(By.linkText("Create New Account")).click();

		Thread.sleep(3000);

		WebElement day = driver.findElement(By.id("day"));

		WebElement month = driver.findElement(By.id("month"));
		WebElement year = driver.findElement(By.id("year"));

		GetDropDownList(day);

		GetDropDownList(month);
		GetDropDownList(year);

	}

	/**
	 * Generic method to get the dropdownlist--Using getoptions
	 * 
	 * @param element
	 */

	public static void GetDropDownList(WebElement element) {
		Select select = new Select(element);
		List<WebElement> Dropdownlist = select.getOptions();
		System.out.println("the number of values in a dropdown " + Dropdownlist.size());

		for (int i = 0; i < Dropdownlist.size(); i++) {
			String text = Dropdownlist.get(i).getText();
			System.out.println(text);
		}

	}

}
