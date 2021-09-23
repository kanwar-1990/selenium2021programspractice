package ImpSeleniumSession;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class footerLinkswithstream {

	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.navigate().to("https://www.freshworks.com/marketing-automation/?gspk=anVzdGFzZXplcnNraXM5MTg2&gsxid=xUC8qKiyLRUN&utm_campaign=Growsumo&utm_medium=justasezerskis9186-Growsumo&utm_source=Growsumo&utm_tactic_id=3667549");
		driver.findElements(By.cssSelector(".footer-nav li a"))
		        .stream()
		          .filter(ele->!ele.getText().isEmpty())
                      		    .forEach(ele->System.out.println(ele.getText().trim()));
				
		
				
	}
}
