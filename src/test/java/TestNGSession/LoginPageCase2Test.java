package TestNGSession;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPageCase2Test {
/*
 *  We have used beforeTest Since, there are less number of test cases and we can have browser launched only once and have all the cases executed
 *  
 * However BeforeMethod is much more prefered since if at a enterprise level, you will have 500 test cases and ur test cases will take around 4-5 hrs,
 * if the application crashes, then remaining cases will be skipped and the total test case will be a failure
*/	
	
	
	WebDriver driver;

	@BeforeTest

	public void SetUp() {
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get("https://s1.demo.opensourcecms.com/opencart/index.php?route=account/login");

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
