package ImpSeleniumSession;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FluentWaitConcept {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://classic.crmpro.com/index.html");

		By Username = By.name("username");

		By password = By.name("password");

		By loginBttn = By.xpath("//input[@type='submit']");
		// Explicit wait of two type
		// WebDriver Wait
		// Fluent wait
		// fluent wait --3 types
		// a- u can give timeout b- polling time c- ignoring exceptions d-
		// fluent wait is used in ajax method
		// ajax components--are  

		WaitforelementwithfluentWait(driver, Username).sendKeys("groupautomation");
		driver.findElement(password).sendKeys("Test@12345");
		driver.findElement(loginBttn).click();
		

	}
	
	//type--1, without the concept of innerclass
	public static WebElement WaitforelementwithfluentWait(WebDriver driver, By locator) {

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)

				.withTimeout(Duration.ofSeconds(15)) // given the duration to check the element
				.pollingEvery(Duration.ofSeconds(3)) // unlike explicit wait u can give manual duration, And every 3 sec
														// it will go and check the element
				.ignoring(NoSuchElementException.class); // Also , u can write multiple exception which u need to ignore

		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		
	}
// type--2
	public static WebElement WaitforelementwithfluentWaitaninnerclass(WebDriver driver, By locator) {

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)

				.withTimeout(Duration.ofSeconds(15)) // given the duration to check the element
				.pollingEvery(Duration.ofSeconds(3)) // unlike explicit wait u can give manual duration, And every 3 sec
														// it will go and check the element
				.ignoring(NoSuchElementException.class); // Also , u can write multiple exception which u need to ignore

		WebElement element = wait.until(new Function<WebDriver, WebElement>() {

			@Override
			public WebElement apply(WebDriver driver) {
				return driver.findElement(locator);
			}
		});
		return element;

	}

}
