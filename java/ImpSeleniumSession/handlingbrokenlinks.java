package ImpSeleniumSession;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class handlingbrokenlinks {

	public static void main(String args[]) throws Exception {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		int brokenLink = 0;
		driver.get("http://www.deadlinkcity.com/");
		driver.manage().window().maximize();

		List<WebElement> url = driver.findElements(By.tagName("a"));
		for (int i = 0; i < url.size(); i++) {

			String urlList = url.get(i).getAttribute("href");

			if (urlList == null || urlList.isEmpty()) {
				System.out.println("The link is empty");
				continue;
			} else {
				System.out.println(urlList);
			}
			URL Links = new URL(urlList); // Changing String into url connection
			HttpURLConnection httpconnect = (HttpURLConnection) Links.openConnection();
			httpconnect.connect();
			if (httpconnect.getResponseCode() >= 400) {
				System.out.println(httpconnect.getResponseCode() + urlList + " is Broken Link");

				brokenLink++;
			} else {
				System.out.println(httpconnect.getResponseCode() + urlList + "   is valid");
			}
			System.out.println("Count of Broken Link:: " + brokenLink);

		}
		driver.quit();

		
		JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("return alert(this is me)",driver);
	
	}

}