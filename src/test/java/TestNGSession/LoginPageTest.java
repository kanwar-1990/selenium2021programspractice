package TestNGSession;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPageTest {

	WebDriver driver;

	@BeforeMethod

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

	@AfterMethod
	public void TearDown() {
		driver.quit();
	}

}
