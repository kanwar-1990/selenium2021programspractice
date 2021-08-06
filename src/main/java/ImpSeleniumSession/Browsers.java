package ImpSeleniumSession;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Browsers {
	public static void main(String[] args) {

		WebDriver driver = null;
		String browser = "firefox";
		switch (browser) {
		case "chrome":

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.chromedriver().setup();

			driver = new FirefoxDriver();
			break;

		case "Safari":
			WebDriverManager.chromedriver().setup();
			driver = new SafariDriver();
			break;
<<<<<<< HEAD
			
		case "ie":
			WebDriverManager.chromedriver().setup();
			driver = new InternetExplorerDriver();
			break;
			
			
=======
				
			case "ie":
			WebDriverManager.chromedriver().setup();
			driver = new InternetExplorerDriver();
			break;	
>>>>>>> 10382e02337156f0461f4dacc5efa45e8c78521d

		default:
			System.out.println("Please type the correct browser Name");
			break;
		}

		driver.get("https://www.google.com/");
	}
}
