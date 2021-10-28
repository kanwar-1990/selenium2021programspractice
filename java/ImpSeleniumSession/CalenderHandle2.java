package ImpSeleniumSession;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalenderHandle2 {

	public static void main(String args[]) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();

		driver.get("https://www.phptravels.net/flights");

		driver.findElement(By.id("autocomplete")).sendKeys("Bangalore");
		driver.findElements(By.xpath("//div[@class='autocomplete-result']/div[2]")).get(0).click();

		driver.findElement(By.xpath("//*[@id=\"onereturn\"]/div[1]/div/div[2]/div/div/div/input")).sendKeys("Amritsar");
		List<WebElement> lists = driver.findElements(
				By.xpath("(//div[@class='autocomplete-results troll intro in'])[2]/div[@class='autocomplete-result']"));

		for (WebElement e : lists) {
			if (e.getText().contains("Amritsar")) {
				e.click();
				break;
			}

		}
		Thread.sleep(4000);

		driver.findElement(By.id("departure")).click();

		List<WebElement> DateList = driver.findElements(By.xpath("/html/body/div[3]/div[1]/table/tbody/tr/td"));

		for (WebElement e : DateList) {
			if (e.getText().equals("28")) {
				e.click();
				break;
			}
		}

	}

}
