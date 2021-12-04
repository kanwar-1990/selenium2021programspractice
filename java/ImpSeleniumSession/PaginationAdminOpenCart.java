package ImpSeleniumSession;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PaginationAdminOpenCart {
	static WebDriver driver;
	private By username = By.id("input-username");
	private By password = By.id("input-password");
	private By loginBttn = By.xpath("//button[@type='submit']");
	private By saleToggle = By.xpath("//a[normalize-space()='Sales']");
	private By ordersLink = By.xpath("//a[normalize-space()='Orders']");
	private By resultText = By.cssSelector(".col-sm-6.text-right");
	private By active_Page = By.xpath("//ul[@class='pagination']//li//span");

	public void loginMethod(String givePageNumber) {
		driver.findElement(username).clear();
		driver.findElement(username).sendKeys("demo");
		driver.findElement(password).clear();
		driver.findElement(password).sendKeys("demo");
		driver.findElement(loginBttn).click();
		driver.findElement(saleToggle).click();
		driver.findElement(ordersLink).click();
		String result = driver.findElement(resultText).getText();
		System.out.println(result);
		int intel = Integer.valueOf(result.substring(result.indexOf("(") + 1, result.indexOf("Pages") - 1));

		for (int i = 1; i <= intel; i++) {

			WebElement details = driver.findElement(active_Page);
			System.out.println("The Current active Page::" + details.getText());
			WebElement clickPage = driver
					.findElement(By.xpath("//ul[@class='pagination']//li//a[text()='" + givePageNumber + "']"));

			clickPage.click();

		}

	}

	public static void main(String args[]) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--incognito");
		driver = new ChromeDriver(co);
		driver.get("https://demo.opencart.com/admin/");
		driver.manage().window().maximize();
		PaginationAdminOpenCart pg = new PaginationAdminOpenCart();
		pg.loginMethod("5");

	}

}
