package com.Parralel.tests;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RegisterTest {

	WebDriver driver;

	By RegisterText = By.xpath("//h1[contains(text(),'Register Account')]");

	By PersonDetails = By.xpath("//fieldset[@id='account']/legend[contains(text(),'Your Personal Details')]");

	By NewCustButtonClick = By.xpath("//a[@class='btn btn-primary']");

	@BeforeTest
	@Parameters({ "url", "browser" })

	// Give value to hold up since u need to use the Paramater from TestNG.XML
	public void SetUp(String url, String BrowserName) throws Exception {

		if (BrowserName.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (BrowserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else {
			System.out.println("Please type the correct browser......");
			throw new Exception("NoBrowserException"); // Throw keyqord helps in creating our own exception
		}

		driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get(url);

	}

	@Test(priority = 1)
	public void RegisterTextTest() {

		// driver.findElement(NewCustButtonClick).click();

		String text = driver.findElement(RegisterText).getText();

		System.out.println("The New Customer Account Register Text is " + text);

		Assert.assertEquals(text, "Register Account");

	}

	@Test(priority = 2)

	public void PersonalDetailsTest() {
		// driver.findElement(NewCustButtonClick).click();

		Assert.assertTrue(driver.findElement(PersonDetails).isDisplayed());

	}

	@AfterTest
	public void TearDown() {
		driver.quit();
	}

}
