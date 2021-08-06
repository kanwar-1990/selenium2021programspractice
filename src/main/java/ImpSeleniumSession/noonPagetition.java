package ImpSeleniumSession;

import java.util.List;

import javax.swing.plaf.synth.SynthSpinnerUI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class noonPagetition {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.noon.com/uae-en/");
		driver.manage().window().maximize();

		Thread.sleep(4000);
		while (true) {
			List<WebElement> Product_List = driver.findElements(By.cssSelector(".e3js0d-7.jULUCI span span span"));

			if (Product_List.size() > 7) {
				Thread.sleep(4000);
				driver.findElement(By.xpath("//div[@class='swiper-button-next custom-navigation swiper-nav-1628168272810']"))
						.click();
				Product_List = driver.findElements(By.cssSelector(".e3js0d-7.jULUCI span span span"));
				Product_List.stream().forEach(ele -> System.out.println(ele.getText()));
			} else {
				break;
			}

		}
	}

}
