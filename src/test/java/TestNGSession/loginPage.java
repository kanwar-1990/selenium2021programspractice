package TestNGSession;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class loginPage {

	/*
	 * TestNG--Unit testing framework which was basically used by developers and qa
	 * have started using it it provides testing framework to write the test cases
	 * sytematically how to maintain test case priority of the test cases
	 * testNG--JAVA UNIT FRAMEWORK, which can only used by java junit and
	 * testNG--FOR JAVA FRAMEWORK TestNG, WE NEED TO USE BOTH PLUGIN AND
	 * DEPENDENCY-- Since it will replace Javaa apllication option in run time
	 * 
	 * //BEFORE- BS BT BC BM //TEST-TEST //AFTER- AM AM AT AS
	 * 
	 * BeforeTest/AfterTest vs BeforeMethod /AfterMethod
	 * 
	 * beforeTest and after Test..this will executed only once BeforeMethod and
	 * AfterMethod they pair with the TestCases and execute each time though they
	 * are Time Consuming efficeny of Test case is 95%
	 * 
	 * Suppose we add Before/After Test-- And we have 100 cases to execute, And in
	 * 5th TestCase, We See that browser stops responding or blank browser showes up
	 * What will happen is remaining 95 Test Cases will fail or Skip , which will be
	 * the challenge
	 *
	 * Suppose we add Before/AfterMethod--- And we are executing 100 Cases, Even if
	 * there is an issue in the browser that parituclar test case will not impact
	 * others As the Browser will start again, Just like we used to do in Manual
	 * Testing--- Clear the Catche and do test Case Again
	 *
	 */
	
	/*
	*
	*TEST SEQUENCE ---ALL ARE PREREQUISTIVE --AND WILL BE EXECUTED BEFORE METHOD AND AFTER TEST METHOD
	*
	*BS
	*BT
	*BC
	*
	*BM
	*T1
	*AM
	*
	*BM
	*T2
	*AM
	*
	*
	*AC
	*AT
	*AS
	*
	*/
	

	WebDriver driver;

	By username = By.id("input-email");
	By Password = By.id("input-password");
	By LoginBtn = By.xpath("//input[@type='submit']");
	By ForgPass = By.linkText("Forgotten Password");

	@BeforeSuite

	public void beforeSuite() {
		System.out.println("beforeSuite---Preparing the Test Data");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("before test--DB Connection");
	}

	@BeforeClass
	public void BeforeClass() {
		System.out.println("before class----Get the value from DB");
	}

	// @BeforeTest
	@BeforeMethod
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://s1.demo.opensourcecms.com/opencart/index.php?route=account/login");
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	// if the Test annotations are not given priority , test cases will execute as
	// per alphabetic order

	@Test(priority = 1)
	public void LoginPageTittleTest() {

		String title = driver.getTitle();
		// Assertion are provided by TestNG--to validate the test Case and is necessary

		Assert.assertEquals(title, "Account Login");
	}

	@Test(priority = 2, enabled = false) // Any test case which u dont want to execute we may disable the test
											// annotation
	public void ForgottenOptionTest() {
		Assert.assertTrue(driver.findElement(ForgPass).isDisplayed());
	}

	@Test(priority = 3, enabled = false)
	public void LoginTest()

	{
		driver.findElement(username).sendKeys("knwrpl.singh@gmail.com");
		driver.findElement(Password).sendKeys("Kanwar@77");
		driver.findElement(LoginBtn).click();
		String HomePageHeader = driver.findElement(By.linkText("Your Store")).getText();
		Assert.assertEquals(HomePageHeader, "Your Store");
	}

	// @AfterTest
	@AfterMethod
	public void Teardown() {
		driver.quit();
	}

	@AfterClass

	public void Afterclass() {
		System.out.println("after class----delete the user");
	}

	@AfterTest

	public void AfterTest() {
		System.out.println("after test---disconnect the DB");

	}

	@AfterSuite

	public void afterSuite() {
		System.out.println("after Suite--delete test data");
	}

}
