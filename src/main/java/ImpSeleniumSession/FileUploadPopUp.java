package ImpSeleniumSession;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileUploadPopUp {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://cgi-lib.berkeley.edu/ex/fup.html");
		
		driver.findElement(By.name("upfile")).sendKeys("C:\\Users\\knwrp\\OneDrive\\Desktop\\Everything");

		// Also do to this--type="file" is manadatory,if not availabe need to informe UI Dev to add it 
		
		
		// the only way to upload a file is using send keys because as soon as the
		// choose file comes it will open a file and selenium only deals with web
		// related not OS Related

	
		
		
	
	}

}
