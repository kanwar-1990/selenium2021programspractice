package ImpSeleniumSession;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class doodle {

	public static void main(String[] args) {

		{

			WebDriverManager.chromedriver().setup();

			WebDriver driver = new ChromeDriver();
			driver.get("https://www.demoqa.com/automation-practice-form");
			driver.manage().window().maximize();
			driver.findElement(By.cssSelector("div[class=' css-yk16xz-control'] div[class=' css-1hwfws3']")).click();

		}
	}
}
