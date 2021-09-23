package ImpSeleniumSession;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SpiceJetAssignment {
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.spicejet.com/");
driver.manage().window().maximize();		

By Linkname=	By.className("link");


     driver.findElement(By.className("link")).click();
     Util util=new Util(driver);
     util.WaitForElementPresent(Linkname, 15);
     
     
     
WebElement SpiceClubMov=driver.findElement(By.xpath("//*[@id=\"smoothmenu1\"]/ul/li[18]/ul/li[2]/a"));
     
        Actions action=new Actions(driver);
        action.moveToElement(SpiceClubMov);

		
	}

}
