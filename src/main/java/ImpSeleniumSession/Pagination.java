
package ImpSeleniumSession;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Pagination {
	static WebDriver driver;

	public static void selectContact(String name) {
		String checkBoxXpath = "//a[text()='" + name
				+ "']/parent::td/preceding-sibling::td/child::input[@type='checkbox' and @name='contact_id']";
		driver.findElement(By.xpath(checkBoxXpath)).click();
	}

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://classic.freecrm.com/");
		driver.findElement(By.name("username")).sendKeys("groupautomation");
		driver.findElement(By.name("password")).sendKeys("Test@12345");
		driver.findElement(By.xpath("//input[@value='Login']")).click();

		Thread.sleep(3000);

		driver.switchTo().frame("mainpanel");
		driver.findElement(By.linkText("CONTACTS")).click();
		Thread.sleep(3000);

		List<WebElement> pages = driver.findElements(By.xpath("(//div[@class='pagination'])[1]/a"));

		int i = 0;// counter
		while (true)  //infinite loop
		
		{
			if (driver.findElements(By.linkText("Varuns Peter")).size() == 1)// if varuns peter is found then ==1 inside if condition and execute
			
			{
				selectContact("Varuns Peter");
				break;
			}
			// pagination logic:
			else {
				try {
					pages.get(i).click(); //keep clicking till name is found
				} catch (Exception e) {
					System.out.println("pagination is over.....and dint find any contact");
					break;
				}
				pages = driver.findElements(By.xpath("(//div[@class='pagination'])[1]/a"));
			}
			i++; //increase the counter
		}

	}

}