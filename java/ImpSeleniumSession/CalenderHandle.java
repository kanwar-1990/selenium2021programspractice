package ImpSeleniumSession;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalenderHandle {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.ixigo.com/");
		driver.manage().window().maximize();

		CalenderHandle c1 = new CalenderHandle();

		c1.SelectingDatesforFlight(driver, "12", "December 2021", "23", "January 2022");// give your choice

	}

	
	
	
	
	
	
	
	
	
	public void SelectingDatesforFlight(WebDriver driver, String Start_Date, String Start_Month, String Return_Date,
			String Return_month)

			throws InterruptedException {

		driver.findElement(By.xpath("//input[@placeholder='Depart' and @type='text']")).click(); // to click on button

		String Start_Month_details = driver.findElement(By.xpath("(//div[@class='rd-month-label'])[1]")).getText();

		while (!Start_Month_details.contains(Start_Month))

		{
			driver.findElement(By.xpath("(//button[@class='ixi-icon-arrow rd-next'])[1]")).click();
			Start_Month_details = driver.findElement(By.xpath("(//div[@class='rd-month-label'])[1]")).getText();
		}

		driver.findElement(
				By.xpath("(//table[@class='rd-days']//div[@class='day has-info' and text()='" + Start_Date + "'])[1]"))
				.click();

		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@placeholder='Return' and @type='text']")).click();

		Thread.sleep(2000);

		String End_Month_details = driver.findElement(By.xpath("(//div[@class='rd-month-label'])[4]")).getText();

		while (!End_Month_details.contains(Return_month)) {
			driver.findElement(By.xpath("(//button[@class='ixi-icon-arrow rd-next'])[2]")).click();
			End_Month_details = driver.findElement(By.xpath("(//div[@class='rd-month-label'])[4]")).getText();
		}

		driver.findElement(
				By.xpath("(//table[@class='rd-days']//div[@class='day has-info' and text()='" + Return_Date + "'])[4]"))
				.click();

	}

}
