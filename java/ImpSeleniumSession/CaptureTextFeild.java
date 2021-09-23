package ImpSeleniumSession;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CaptureTextFeild {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://register.rediff.com/register/register.php?FormName=user_details");

		// We Can Also u this to add specific input which in common, since tag input
		// text are ther 9 times

		List<WebElement> Listdetails = driver.findElements(By.xpath("//input[@type='text']"));

		System.out.println(Listdetails.size());

		for (int i = 0; i < Listdetails.size(); i++) {
			 Listdetails.get(i).sendKeys("kanwar");
		//where ever the input field is text--kanwar is added	
		}

	}

}
