package ImpSeleniumSession;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TakesScreenshots {

	public static void main(String args[]) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
        WebElement logo=driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']")); 
		/*TakesScreenshot ts = (TakesScreenshot) driver;
		File Sr = ts.getScreenshotAs(OutputType.FILE);
		File tr = new File(".\\Screenshot\\Loginpage.png");
		FileUtils.copyFile(Sr, tr);*/
		//TakesScreenshot ts = (TakesScreenshot) driver;
		File Sr = logo.getScreenshotAs(OutputType.FILE);
		File tr = new File(".\\Screenshot\\Logo.png");
		FileUtils.copyFile(Sr, tr);
		
		
		
		
		

	}

}
