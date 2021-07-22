package TestNGSession;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SoftAssertsvsHardAsserts {

	WebDriver driver;
	SoftAssert softassert;

	@BeforeMethod

	public void SetUp() {
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get("https://s1.demo.opensourcecms.com/opencart/index.php?route=account/login");
		softassert = new SoftAssert();
	}

	@Test
	public void LoginPageTest() {

		driver.findElement(By.id("input-email")).sendKeys("knwrpl" + ".singh@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("Kanwar@77");
		driver.findElement(By.xpath("//input[@value='Login']")).click();

		softassert.assertTrue(driver.findElement(By.linkText("Your Store")).isDisplayed());

		String header = driver.findElement(By.linkText("Your Store")).getText();
		System.out.println("Header of homePage is " + header);

		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.titleContains("My Account"));
		softassert.assertEquals(header, "Your Store", " The header is incorrect");
		
		String title = driver.getTitle();
		System.out.println("The HomePage title is " + title);
		
		softassert.assertEquals(title, "My Account");

		softassert.assertAll(); // Mandatory function to be used in the end when softassert is used//
		/*
		hardAssert vs SoftAssert or Assert vs verify
		In hardAssert--any of the assert in a single test case gets failed remaining asserts will not be executed
		In SoftAssert-- any of the assert in a single test case gets failed, the failed case will be added into buffer
		and in final report it will showcase that 1 assert is failed , assertAll() we need to use
		
		It depends on a usecase--hardAsserts is used for ex login only doesnt happen then hardAsserts can be used 
		where soft Asserts are required we can use SoftAssert
		
		*/
		
	}

	@AfterMethod
	public void TearDown() {
		driver.quit();
	}

}
