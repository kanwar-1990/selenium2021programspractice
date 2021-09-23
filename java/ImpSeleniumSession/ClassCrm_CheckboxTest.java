package ImpSeleniumSession;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClassCrm_CheckboxTest {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://classic.crmpro.com/index.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.name("username")).sendKeys("groupautomation");
		driver.findElement(By.name("password")).sendKeys("Test@12345");
		driver.findElement(By.xpath("//input[@type='submit']")).click();

		Thread.sleep(4000);

		// frame was there ---

		driver.switchTo().frame("mainpanel");

		GetContactName(driver, "Alex Wonder");
		GetContactName(driver,"Axil Patel");

	}

	public static void GetContactName(WebDriver driver, String Name) {
		WebElement moveto = driver.findElement(By.xpath("//a[@title='Contacts']"));
		moveto.click();

		driver.findElement(By.xpath("//a[contains(text(),'"+ Name
				+"')]//parent::td[@class='datalistrow']//preceding-sibling::td/input[@type='checkbox']")).click();

	}

}
