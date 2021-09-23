package ImpSeleniumSession;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverMangerImp {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		
		// We are using WebDriverManager-- utility , which internally goes back and check os compatibilty and chromedriver check the version of chrome browser used and keep on updating automatically 
		// its a better usage since we dont have to be worried about chrome browser getting updating and we dont have to keep on downloading chromdriver versions
		// add the dependency -- in pom.xml file if not using maven , download jar---of WebDriverManager
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("http://google.com");
	}

}
