package ImpSeleniumSession;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenShotConcept {

	public static void main(String[] args) throws IOException {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://demo.opencart.com/index.php?route=account/login");

		GetScreenshot(driver, "PageName");

		/*
		 * IN SELENIUM 4 WE CAN TAKE THE SCREENSHOT OF THE WEBELEMENT AS WELL --NEED TO
		 * ADD IN MAVEN DEPENDENCY OF SELENIUM 4
		 * 
		 */

	}

	public static void GetScreenshot(WebDriver driver, String fileName) {

		File SrcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);// typercasting driver with
																					// TajeScreenshot

		// ./ will guide to the current class file
		try {
			FileUtils.copyFile(SrcFile, new File("./target/screenshots/" + fileName + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
