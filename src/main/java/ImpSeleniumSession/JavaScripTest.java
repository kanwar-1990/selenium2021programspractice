package ImpSeleniumSession;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScripTest {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.navigate().to("https://demo.opencart.com/index.php?route=account/login");
		driver.manage().window().maximize();
		String title = JavaScriptutil.getTitleByJS(driver);
		System.out.println(title);

		// JavaScriptutil.refreshBrowserByJS(driver);
		// JavaScriptutil.generateAlert(driver, "I am Testing");
		// JavaScriptutil.refreshBrowserByJS(driver);

		// JavaScriptutil.sendKeysUsingJSWithID(driver,
		// "input-email","knwrpl.singh@gmail.com");
		// JavaScriptutil.sendKeysUsingJSWithID(driver, "input-password","Kanwar@77");

		// WebElement LoginBttn =
		// driver.findElement(By.cssSelector("input.btn-primary"));

		// JavaScriptutil.clickElementByJS(LoginBttn, driver);

		// WebElement ForgotLinkText = driver.findElement(By.linkText("Forgotten
		// Password"));

		// JavaScriptutil.drawBorder(ForgotLinkText, driver);

		// WebElement FullLoginTextHighlight =
		// driver.findElement(By.cssSelector(".col-sm-6 form[method=post]"));

		// JavaScriptutil.drawBorder(FullLoginTextHighlight, driver);

		// JavaScriptutil.flash(FullLoginTextHighlight, driver);
		// JavaScriptutil.flash(ForgotLinkText, driver);
		// JavaScriptutil.flash(LoginBttn, driver);

		driver.navigate().to("https://classic.crmpro.com/index.html");

		// String TextPrinted = JavaScriptutil.getPageInnerText(driver);
		// System.out.println(TextPrinted);

		WebElement ForgotLink = driver.findElement(By.linkText("Forgot Password?"));

		JavaScriptutil.scrollIntoView(ForgotLink, driver);

	}

}
