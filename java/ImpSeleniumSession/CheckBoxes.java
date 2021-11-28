package ImpSeleniumSession;

import java.awt.Checkbox;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckBoxes {

	public static void main(String args[]) {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.get("https://itera-qa.azurewebsites.net/home/automation");
		driver.manage().window().maximize();

		List<WebElement> checkbox = driver
				.findElements(By.xpath("//input[@class='form-check-input' and contains(@id,'day')]"));
		// Selecting all the checkbox

		// 0 to 6
		for (int i = 0; i < checkbox.size(); i++) {
			checkbox.get(i).click();
		    continue;
		}
		/*
		
				// Selecting first two element
		for (int i = 0; i < checkbox.size(); i++) {

			if (i > 1) {
				checkbox.get(i).click();
			}
		}
		checkbox.clear();
		// Selecting last two element

		int check_box = checkbox.size();

		for (int i = check_box-2 ; i < check_box;) {
			checkbox.get(i).click();
			break;
		}
*/
	}

}
