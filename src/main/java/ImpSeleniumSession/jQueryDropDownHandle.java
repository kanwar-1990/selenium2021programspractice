package ImpSeleniumSession;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class jQueryDropDownHandle {

	public static void main(String[] args) {

		// https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/-- use to to practice
		// most important

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.findElement(By.id("justAnInputBox")).click();

		// Baoundry Value Analysis
		// this can be used for single Value
		// SelectChoiceValue(driver, "choice 7");
		// for Selecting multi value---- We can use String as String...(With three dot)
		// and it will be considered as Array
		// So need interate these value hence for loop for array we need to consider

		// SelectChoiceValue(driver, "choice 7", "choice 1", "choice 2");

		// For Selecting all the values
		SelectChoiceValue(driver, "ALL");

	}

	public static void SelectChoiceValue(WebDriver driver, String... value) {
		List<WebElement> choiceList = driver.findElements(
				By.xpath("//div[@class='comboTreeDropDownContainer']//ul//li/span[@class='comboTreeItemTitle']"));

		// if----SelectChoiceValue(driver, "choice 7", "choice 1", "choice 2"); if
		// statement becomes false then ! is used to make it true it will come inside
		// the for loop
		//

		if (!value[0].equalsIgnoreCase("all")) {
			for (int i = 0; i < choiceList.size(); i++) {
				String text = choiceList.get(i).getText();
				System.out.println(text);

				for (int j = 0; j < value.length; j++) {

					if (text.equals(value[j])) {
						choiceList.get(i).click();
						break;
					}

				}
			}
		} else {

			try // ---Element not interactable error is coming hence using it to catch the
				// exception, since there are hidden element

			{
				for (int all = 0; all < choiceList.size(); all++) // this is an list--super class of arrayList hence we
																	// will
				// use it to select all

				{

					choiceList.get(all).click();
				}

			} catch (Exception e) {
			}

		}

	}

}
