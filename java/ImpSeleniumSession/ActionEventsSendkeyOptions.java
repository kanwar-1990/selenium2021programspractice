package ImpSeleniumSession;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionEventsSendkeyOptions {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		

		driver.get("https://demo.opencart.com/index.php?route=account/login");

		WebElement emailid = driver.findElement(By.name("email"));
		WebElement password = driver.findElement(By.name("password"));
		WebElement clickable = driver.findElement(By.xpath("//input[@type='submit']"));

		Actions action = new Actions(driver);

		// We can also use Actions class to do send key options , where actions help in
		// moving to the center of the element and then perform 

		action.sendKeys(emailid, "text@gmail.com").build().perform();
		action.sendKeys(password, "admin").build().perform();
		action.click(clickable).build().perform();

		
	
	}

}
