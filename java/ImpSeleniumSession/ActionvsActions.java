package ImpSeleniumSession;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionvsActions {

	public static void main(String args[]) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php");
		WebElement WomenLink = driver.findElement(By.linkText("http://automationpractice.com/index.php"));
		// difference between Action and Actions
		// Action is an interface---difference would be that ,it has a build()
		// So, it is not compulsary to call build method.perform() is enough

		Actions action = new Actions(driver);
		Action action1 = action.moveToElement(WomenLink).build();
		action1.perform();

	}

}
