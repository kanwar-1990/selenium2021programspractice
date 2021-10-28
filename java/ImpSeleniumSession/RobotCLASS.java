package ImpSeleniumSession;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RobotCLASS {

	public static void main(String args[]) throws AWTException, InterruptedException {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		// driver.get("https://www.pdfdrive.com");
		//
		// driver.findElement(By.id("q")).sendKeys("Selenium CookBook");
		// driver.findElement(By.xpath("//[@id='search-form']/button/i"));

		driver.navigate().to(
				"https://www.pdfdrive.com/selenium-testing-tools-cookbook-2nd-edition-over-90-recipes-to-help-you-build-and-run-automated-tests-for-your-web-applications-with-selenium-webdriver-e167360250.html");
		driver.manage().window().maximize();

		Thread.sleep(7000);
		driver.findElement(By.cssSelector("#download-button-link")).click();
JavascriptExecutor js=((JavascriptExecutor)driver);
		
		js.executeScript("document.querySelector(\"#alternatives > div.text-center > div > a\")");

		Actions action = new Actions(driver);
		WebElement downloadlinl = driver
				.findElement(By.xpath("/html/body/div[3]/div[1]/div[2]/center/div[2]/div[1]/div/a"));

		action.moveToElement(downloadlinl);
		downloadlinl.click();

		
		
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);

	}

}
