package ImpSeleniumSession;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class getLocationandgetSize {
	public static void main(String args[]) {

		WebDriverManager.chromiumdriver().setup();
		WebDriver driver = new ChromeDriver();

		RemoteWebDriver.class
		
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		driver.manage().window().maximize();
		WebElement logo = driver.findElement(By.xpath("//h1[1]"));

		System.out.println("The location of logo is ::" + logo.getLocation());
		System.out.println("The X size::" + logo.getRect().getX());
		System.out.println("The Y size::" + logo.getRect().getY());

	}

}
