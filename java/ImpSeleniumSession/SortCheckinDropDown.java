package ImpSeleniumSession;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SortCheckinDropDown {

	@SuppressWarnings("unchecked")
	public static void main(String args[]) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		WebElement animalList = driver.findElement(By.id("animals"));

		Select select = new Select(animalList);
		List<WebElement> listofElement = select.getOptions();
		List<String> originalList = new ArrayList<String>();

		for (WebElement e : listofElement) {

			originalList.add(e.getText());

		}
	System.out.println("Before sorting ::" + originalList);

		List<String> TempList = new ArrayList<String>();
		TempList = originalList;
		Collections.sort(TempList);
	System.out.println("After Sorting :: " + TempList);

		if (TempList.equals(originalList)) {
			System.out.println("The DropDown is Sorted");
		} else {
			System.out.println("Yet to be Sorted");
		}

		driver.quit();
	}

}
