package ImpSeleniumSession;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TotalImageCount {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.amazon.in/");

		List<WebElement> ImgCount = driver.findElements(By.tagName("img"));

		System.out.println(ImgCount.size());

		/*
		 * <img alt="Everyday essentials" src="https://images-eu.>
		 * 
		 * img is a tag src is attribute-- Anywhere if we cannot use gettext , we can
		 * get the attribute of it
		 * 
		 * this concept is called webScraping
		 * 
		 */

		for (int i = 0; i < ImgCount.size(); i++) {

			String PrintCount = ImgCount.get(i).getAttribute("src");

			System.out.println(PrintCount);
		}

	}
}
