package ImpSeleniumSession;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownWithSelectMethod {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://en-gb.facebook.com/");

		driver.findElement(By.linkText("Create New Account")).click();

		Thread.sleep(3000);

		String day = "//select[@id='day']/option";
		String month = "//select[@id='month']/option";
		String year = "//select[@id='year']/option";

		DropDownUtil.GetSelectWithOutSelect(driver, "2", day);
		DropDownUtil.GetSelectWithOutSelect(driver, "Jul", month);
		DropDownUtil.GetSelectWithOutSelect(driver, "1990", year);

	}

}
