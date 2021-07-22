package ImpSeleniumSession;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetandNavigateto {

	public static void main(String[] args) {

		System.setProperty("webdriver.driver.chrome", "C:\\Users\\knwrp\\OneDrive\\Documents\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("http://www.amazon.in");

		/*
		 * the reason why get method is more preferable, in get method once the page is
		 * completely loaded only then get() allows to do any further
		 * action(gettitle,getpageurl) in navigate ()method it allows to do the action
		 * despite page not bing completely loaded
		 * 
		 */
		driver.navigate().to("http://www.amazon.in");

	}

}
