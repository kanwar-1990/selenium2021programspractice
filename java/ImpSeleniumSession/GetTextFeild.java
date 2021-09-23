package ImpSeleniumSession;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetTextFeild {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");

		driver.findElement(By.id("login1")).sendKeys("test@gmail.com");
		String text = driver.findElement(By.id("login1")).getAttribute("value");
		System.out.println(text);
		// We Can use the value to get the attribute

	}

}
