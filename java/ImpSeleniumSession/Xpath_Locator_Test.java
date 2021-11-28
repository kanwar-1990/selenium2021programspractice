package ImpSeleniumSession;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Xpath_Locator_Test {

	public static void main(String args[]) {

		WebDriverManager.chromedriver().setup();

		ChromeOptions co = new ChromeOptions();
		co.addArguments("--incognito");

		WebDriver driver = new ChromeDriver(co);

		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//*[@name='search_query' or @id='search_query_top' ]")).sendKeys("t-shirts");
		// Absolute xpath starts with / slash, and relative xpath with //slash
		// Absolute xpath has a challenge where if there is any element added or removed
		// the DOM Structure will be effected and the element we
		// are looking for cannot be found
		// * is used as an regular expression ,it will search with all the tag name
		driver.findElement(By.name("submit_search")).click();
		// or
		// and ----//*[@name='search_query' and @id='search_query_top' ]
		// contains()
		// text()
		// starts-with
		driver.quit();

	}

}
