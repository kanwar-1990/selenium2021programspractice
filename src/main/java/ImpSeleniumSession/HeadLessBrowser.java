package ImpSeleniumSession;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HeadLessBrowser {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		ChromeOptions CO = new ChromeOptions();
		/*
		 * HeadLess :No UI testing is happening behind the scene faster than normal UI
		 */
		//CO.addArguments("--headless");
		CO.addArguments("--incognito");
		 WebDriver driver = new ChromeDriver(CO);
		// phantom JS and ghost driver, Is not used anymore--It was used for getting the headless browser
		// driver.get("https://www.google.com/");
		
//		no major difference is found in get() and navigate().to() method since to() indirectly calls get() only
//		benfit i believe is navigate.to(), refresh(), back(),forward() option are available 
//		
		
		//FirefoxOptions FO = new FirefoxOptions();

		//FO.addArguments("--headless");
		//FO.addArguments("--incognito");
		//WebDriver driver = new FirefoxDriver(FO);
		driver.get("https://www.google.com/");
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
	}

}
