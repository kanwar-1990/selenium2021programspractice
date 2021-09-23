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
			driver.get("https://app.hubspot.com/login?__cf_chl_jschl_tk__=pmd_jkYPh2lNbJLn9pmhZHn9kKiM1Nb40qxcNi3viGURFl8-1630318751-0-gqNtZGzNAhCjcnBszQgl");
			driver.manage().window().maximize();
			driver.findElement(By.cssSelector("div[class=' css-yk16xz-control'] div[class=' css-1hwfws3']")).click();

		}
	}
	public void GitConflict()
	{
		
	}
}
