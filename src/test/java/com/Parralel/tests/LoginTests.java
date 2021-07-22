package com.Parralel.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTests {

	WebDriver driver;

	By username = By.id("input-email");
	By Password = By.id("input-password");
	By LoginBtn = By.xpath("//input[@type='submit']");

	@BeforeTest
	@Parameters({"url", "browser"})
	// After Taking the Paramaters need to add the value in String format for hold
	// up
	public void SetUp(String AppUrl, String BrowserName) throws Exception {

		if (BrowserName.equals("Chrome")) {
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
		driver.get(AppUrl);

	}

	@Test(priority = 3)

	@Parameters({ "username", "password" })
	public void LoginTest(String Emailid, String pwd)

	{
		driver.findElement(username).sendKeys(Emailid);
		driver.findElement(Password).sendKeys(pwd);
		driver.findElement(LoginBtn).click();
		String HomePageHeader = driver.findElement(By.linkText("Your Store")).getText();
		Assert.assertEquals(HomePageHeader, "Your Store");
	}

	@Test(priority = 1)
	public void LoginPageTitleTest() {
		// Since implicit wait only works on webElement we have used explicit wait
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.titleContains("Account"));

		String title = driver.getTitle();
		System.out.println("Page title is: " + title);

		/* NEED TO VALIDATION */
		Assert.assertEquals(title, "Account Login");

	}

	@Test(priority = 2)
	public void ForgottenPasswordLinkTest() {
		Boolean flag = driver.findElement(By.linkText("Forgotten Password")).isDisplayed();

		/* Need to validate as Tester */
		Assert.assertTrue(flag);

	}

	@AfterTest
	public void TearDown() {
		driver.quit();
	}

}
