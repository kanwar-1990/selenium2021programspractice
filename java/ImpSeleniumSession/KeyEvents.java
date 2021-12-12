package ImpSeleniumSession;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KeyEvents {
	public static void main(String args[])
	{
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://text-compare.com/");
		driver.manage().window().maximize();
		
		WebElement inputText=driver.findElement(By.id("inputText1"));
		inputText.sendKeys("i love automation");
        	
 	inputText.sendKeys(Keys.DOWN);
 	inputText.sendKeys(Keys.CONTROL);
 	
 	
	}
}
