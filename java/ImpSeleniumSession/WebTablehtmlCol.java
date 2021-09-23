package ImpSeleniumSession;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTablehtmlCol {

	static WebDriver driver;

	public static void main(String args[]) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/html/html_tables.asp");

	}

	public static void getColRow(String ContactName) {

		int rowcount = driver.findElements(By.xpath("//table[@id='customers']//tr")).size();
		int colcount = driver.findElements(By.xpath("//table[@id='customers']//th")).size();

		for (int i = 1; i < rowcount; i++) {
			for (int j = 1; j < colcount; j++) {
				String text = driver
						.findElement(By.xpath("//table[@id='customers']/tbody/tr[" + (i + 1) + "]/td[" + j + "]"))
						.getText();
				if (text.equals(ContactName)) {

					System.out.println(i + ":" + j);
					break;
				}
			}
		}
	}

}
