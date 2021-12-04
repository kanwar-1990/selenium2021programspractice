package ImpSeleniumSession;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Datepicker_part2 {

	public static void main(String args[]) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--incognito");

		WebDriver driver = new ChromeDriver(co);
		driver.get("https://www.dummyticket.com/dummy-ticket-for-visa-application/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@id='departon']")).click();
		Select month = new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-month']")));
		month.selectByVisibleText("Jan");

		Select year = new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-year']")));

		year.selectByVisibleText("2022");

		driver.findElement(By.xpath("//a[normalize-space()='5']")).click();

	}
}
