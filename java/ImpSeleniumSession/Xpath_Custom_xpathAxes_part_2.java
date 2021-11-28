package ImpSeleniumSession;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Xpath_Custom_xpathAxes_part_2 {

	public static void main(String args[]) {
		WebDriverManager.chromedriver().setup();

		ChromeOptions co = new ChromeOptions();

		co.addArguments("--incognito");
		WebDriver driver = new ChromeDriver(co);
		/**
		 * XPath Axes ----- Self Parent Child Ancestor Descendant Following
		 * Following-sibling Preceding preceding-sibling
		 */
		driver.get("https://money.rediff.com/gainers/bse/daily/grouppa");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// self
		String TopGainersname = driver.findElement(By.xpath("//a[contains(text(),'IndiaNivesh')]/self::a")).getText()
				.toUpperCase();

		System.out.println(TopGainersname);

		List<WebElement> element_list = driver.findElements(
				By.xpath("//a[contains(text(),'Capital Trade Links')]/parent::td/ancestor::tr/preceding::td"));

		
		for (WebElement e : element_list) {
			// System.out.print(e.getText());
		}
		
		// driver.quit();

		// following --preceding
		int sizofFollowingEle = driver
				.findElements(By.xpath("//a[contains(text(),'Ajanta Pharma Lt')]/ancestor::tr/following::tr")).size();
		System.out.println("The following preceding" + sizofFollowingEle);

		// Following sibling
		int Following_preceding = driver
				.findElements(By.xpath("//a[contains(text(),'SBC Exports')]/ancestor::tr/following-sibling::tr"))
				.size();

		System.out.println("Following preceding count:: " + Following_preceding);
		// Following
		int Following = driver.findElements(By.xpath("//a[contains(text(),'SBC Exports')]/ancestor::tr/following::tr"))
				.size();
		System.out.println("Following count::" + Following);
		// preceding sibling

		int Precding_Sibling = driver
				.findElements(By.xpath("//a[contains(text(),'SBC Exports')]/ancestor::tr/preceding-sibling::tr"))
				.size();

		System.out.println("Preceding-sibling count:: " + Precding_Sibling);

		// Preceding
		int preceding = driver.findElements(By.xpath("//a[contains(text(),'SBC Exports')]/ancestor::tr/preceding::tr"))
				.size();
		System.out.println("Preceding count :: " + preceding);

	}

}
