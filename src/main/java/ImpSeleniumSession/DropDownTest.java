package ImpSeleniumSession;

import java.lang.reflect.Array;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownTest {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://en-gb.facebook.com/");

		driver.findElement(By.linkText("Create New Account")).click();

		Thread.sleep(3000);

		WebElement day = driver.findElement(By.id("day"));

		WebElement month = driver.findElement(By.id("month"));
		WebElement year = driver.findElement(By.id("year"));

		String str = "2-Jul-1990";
		String d[] = str.split("-");

		DropDownUtil.FindDatesByselectbyVisibleText(day, d[0]);
		DropDownUtil.FindDatesByselectbyVisibleText(month, d[1]);

		DropDownUtil.FindDatesByselectbyVisibleText(year, d[2]);

		ArrayList<String> dayList = DropDownUtil.GetDropDownList(day);
		System.out.println(dayList);

		ArrayList<String> monthList = DropDownUtil.GetDropDownList(month);
		System.out.println(monthList);

		ArrayList<String> yearlist = DropDownUtil.GetDropDownList(year);
		System.out.println(yearlist);

	}

}
