package ImpSeleniumSession;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.collect.Lists;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TotalPageLinks {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("http://www.amazon.in");

		// this will return all the list of webelements
		List<WebElement> lists = driver.findElements(By.tagName("a"));

		System.out.println("Total number of links: " + lists.size());

		for (int i = 0; i < lists.size(); i++) {

			if (lists.get(i).getText().equals("")) {

			} else {
				String text = lists.get(i).getText();

				System.out.println(text);
			}

		}

	}
}
