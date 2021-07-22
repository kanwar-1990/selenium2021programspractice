package ImpSeleniumSession;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableHandle {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.w3schools.com/html/html_tables.asp");

		int rowcount = driver.findElements(By.xpath("//table[@id='customers']//tr")).size() - 1; // Since it will take
																									// Company also

		System.out.println(rowcount);

		// Breaking xpath
		//// *[@id="customers"]/tbody/tr[2]/td[1]

		//// *[@id="customers"]/tbody/tr[7]/td[1]

		String Beforexpath = "//*[@id=\'customers\']/tbody/tr[";
		String Afterxpath = "]/td[1]";

		for (int rownumber = 2; rownumber <= rowcount + 1; rownumber++) {

			String Actualxpath = Beforexpath + rownumber + Afterxpath; // //*[@id=\'customers\']/tbody/tr[
																		// rownumber]/td[1] which is
																		// //*[@id=\'customers\']/tbody/tr[2]/td[1]

			// System.out.println(Actualxpath);
			/*
			 * /*[@id='customers']/tbody/tr[2]/td[1] //*[@id='customers']/tbody/tr[3]/td[1]
			 * //*[@id='customers']/tbody/tr[4]/td[1] //*[@id='customers']/tbody/tr[5]/td[1]
			 * //*[@id='customers']/tbody/tr[6]/td[1] //*[@id='customers']/tbody/tr[7]/td[1]
			 */

			String Tablevaluetext = driver.findElement(By.xpath(Actualxpath)).getText();
			System.out.println(Tablevaluetext);

		}

	}

}
