package ImpSeleniumSession;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RightClickConcept {

	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");

		String RightClickWeb = "//ul/li[contains(@class,'context-menu-item')]/span";

		System.out.println(GetRightClicKOption(RightClickWeb));

	}

	public static ArrayList<String> GetRightClicKOption(String locator) {

		// String
		// TextDetails=driver.findElement(By.xpath("//ul/li[contains(@class,'context-menu-icon-copy')]/span")).getText();

		Actions action = new Actions(driver);

		WebElement RightClickElement = driver.findElement(By.className("context-menu-one"));

		action.contextClick(RightClickElement).build().perform();

		List<WebElement> RightClickList = driver.findElements(By.xpath(locator));

		ArrayList<String> ar = new ArrayList<String>();

		for (int i = 0; i < RightClickList.size(); i++) {

			String text = RightClickList.get(i).getText();
			ar.add(text);

		}

		return ar;
	}

}
