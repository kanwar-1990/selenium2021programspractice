package ImpSeleniumSession;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class xpath_part_2 {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://classic.crmpro.com/index.html");

		/*
		 * absolute xpath absolute location path or absolute
		 * hirechy
		 * ---//html//div[0]//div[1]//div[2]//div[4]/span bit risky, tomorow UI
		 * has been changed or something is added in between div, then the xpath gets
		 * disturbed, this happens a lot hence we should use relative xpath 
		 * 
		 * 
		 * 
		 * relative xpath //span[id='test']---if id is changed then only something happens we can directly use it
		 * 
		 */

		// below--- are called xpath axes
		
		
		// input[@type='text']//following::div -- following keyword can be used to next
		// sibling--child or non child
		// input[@type='text']//preceding-sibling---for the below siblings--child or non
		// child--for parallel sibling
		// (//div[@class='input-group']//preceding::div)[3]

		// div[@class='input-group']//child::input---to get into child
		// input[@type='password']//parent::div--to get into the parent

		// input[@type='password']//ancestor::div[@class='container']-- to get ancestor

	}

}
