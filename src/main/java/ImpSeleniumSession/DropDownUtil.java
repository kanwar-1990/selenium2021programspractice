package ImpSeleniumSession;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropDownUtil {

	/**
	 * By creating generic method these are easy to call
	 * 
	 * @param element
	 * @param value
	 */

	public static void FindDatesByselectbyVisibleText(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByVisibleText(value);

	}

	public static void FindDatesByselectbyindex(WebElement element, int indexvalue) {
		Select select = new Select(element);
		select.selectByIndex(indexvalue);

	}

	/**
	 * Generic method to get the dropdownlist--Using getoptions
	 * 
	 * @param element
	 * @return
	 */

	public static ArrayList<String> GetDropDownList(WebElement element) {
		Select select = new Select(element);
		List<WebElement> Dropdownlist = select.getOptions();
		System.out.println("the number of values in a dropdown " + Dropdownlist.size());

		ArrayList<String> ar = new ArrayList<String>();

		for (int i = 0; i < Dropdownlist.size(); i++) {
			String text = Dropdownlist.get(i).getText();
			ar.add(text);

		}
		return ar;
	}

	/**
	 * to create a method using without creating an object of select class
	 * 
	 * @param driver
	 * @param value
	 * @param locator
	 */

	public static void GetSelectWithOutSelect(WebDriver driver, String value, String locator) {

		List<WebElement> selectlist = driver.findElements(By.xpath(locator));

		for (int i = 0; i < selectlist.size(); i++) {

			String text = selectlist.get(i).getText();/////// get text will give the value

			if (text.equals(value)) {
				selectlist.get(i).click();
			}

		}

	}

}
