package ImpSeleniumSession;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePickerpart1 {

	static WebDriver driver;

	public static void main(String args[]) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.redbus.in/");
		driver.manage().window().maximize();
		driver.findElement(By.id("onward_cal")).click();

		DatePickerpart1 d1 = new DatePickerpart1();
		d1.datePickers("2022", "Feb", "16");

	}

	public void datePickers(String year, String month, String date) {

		while (true) {
			String monthDetails = driver.findElement(By.xpath("//td[@class='monthTitle']")).getText();
			System.out.println(monthDetails);
			String de[] = monthDetails.split(" ");
			String mon = de[0];
			String yr = de[1];
			if (month.equalsIgnoreCase(mon) && year.equalsIgnoreCase(yr))
				break;
			else
				driver.findElement(By.xpath("//button[normalize-space()='>']")).click();
		}
		List<WebElement> details = driver.findElements(By.xpath("//table[@class='rb-monthTable first last']//td"));

		for (WebElement e : details) {

			String detail = e.getText();
			if (detail.equals(date)) {
				e.click();
				break;
			}
		}

	}

}
