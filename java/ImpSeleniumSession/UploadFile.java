package ImpSeleniumSession;

import java.awt.RenderingHints.Key;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UploadFile {

	public static void main(String args[]) throws Exception {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.monsterindia.com/");
		driver.manage().window().maximize();
		// First method-- where type="file" , We can use send Keys
		driver.findElement(By.xpath("//a[@class='btn block resume-btn btn-orange mt20']")).click();
		// driver.findElement(By.id("file-upload")).sendKeys("C:\\geckodriver-v0.29.0-win64");

		WebElement button = driver.findElement(By.xpath("(//input[@id='file-upload'])[2]"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", button);

		Robot rb = new Robot();

		// Coping from Clipboard

		StringSelection ss = new StringSelection("C:\\geckodriver-v0.29.0-win64");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);

		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);
	}

}
