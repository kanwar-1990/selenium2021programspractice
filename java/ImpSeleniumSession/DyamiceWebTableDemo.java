package ImpSeleniumSession;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DyamiceWebTableDemo {

	WebDriver driver;

	public void ClickonTable(String ComName) {
		driver.findElement(
				By.xpath("//td[contains(text(),'" + ComName + "')]//preceding-sibling::td/input[@type='checkbox']"))
				.click();

	}

	public List<WebElement> HeadersList() {
		List<WebElement> HeaderList = driver.findElements(By.xpath("//table[contains(@id,'cust')]//tr//th"));
		HeaderList.stream().forEach(e -> System.out.println(e.getText()));
		return HeaderList;

	}

	@BeforeMethod
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("http://seleniumpractise.blogspot.com/");
	}

	@Test()
	public void HeaderListTest() {
		HeadersList();
	}

	@Test(priority = 0)
	public void ClickMethodTest() {
		ClickonTable("FlipKart");
	}

	@AfterMethod
	public void TearDown() {
		driver.quit();
	}

}
