package ImpSeleniumSession;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class practive {
	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://www.amazon.com/");
		ArrayList<String> PrintEle = getAppleProductListAmazon(driver, "Apple");

		System.out.println(PrintEle);
	}

	public static ArrayList<String> getAppleProductListAmazon(WebDriver driver, String ProductName) {
		driver.findElement(By.cssSelector("input[type='text']")).sendKeys(ProductName);
		driver.findElement(By.cssSelector("#nav-search-submit-button")).click();

		List<WebElement> AppleListItem = driver
				.findElements(By.cssSelector(".a-size-medium.a-color-base.a-text-normal"));

		System.out.println("The total number of the products are : " + AppleListItem.size());

		ArrayList<String> ListitOut = new ArrayList<String>();

		for (WebElement webElement : AppleListItem) {
			String ListofItems = webElement.getText();

			ListitOut.add(ListofItems);
		}
		System.out.println("List of the Items are");
		return ListitOut;
	}
	public void CheckingGitCommit()
	{
				System.out.println("Checking git conflict--other team member is working on the same and same method which u are working and already pushed the code");

	}
	

	public void CheckingGitCommit(String TestingAgain)
	{
				System.out.println("Checking git conflict--other team member is working on the same and same method which u are working and already pushed the code");

	}

}
