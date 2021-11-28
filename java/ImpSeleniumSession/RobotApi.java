package ImpSeleniumSession;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RobotApi {

	public static void main(String args[]) throws Exception {
		WebDriverManager.firefoxdriver().setup();

		WebDriver driver = new FirefoxDriver();

		driver.get("https://spreadsheetpage.com/planner/daily-to-do-holidays/");

		driver.manage().window().maximize();
		driver.findElement(By.linkText("Download this template for free")).click();

		Robot robot = new Robot();
		Thread.sleep(2000);

         robot.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(2000);

		 robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(2000);

		 robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(2000);

		Thread.sleep(2000);
		 robot.keyPress(KeyEvent.VK_ENTER);

	}

}
