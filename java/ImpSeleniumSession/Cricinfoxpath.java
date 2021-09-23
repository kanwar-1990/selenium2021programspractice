package ImpSeleniumSession;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Cricinfoxpath {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(
				"https://www.espncricinfo.com/series/south-africa-tour-of-west-indies-2021-1263140/west-indies-vs-south-africa-1st-t20i-1263151/full-scorecard");
		Thread.sleep(5000);
		/*
		tr=table rowA
		td=table coloum
		*/
		
		System.out.println(getPlayersDetails(driver, "David Miller"));

		
	}

	public static ArrayList<String> getPlayersDetails(WebDriver driver,String PlayerName)
	
	{
		List<WebElement> ScoreList = driver
				.findElements(By.xpath("//a[contains(text(),'"+PlayerName+"')]//parent::td//following-sibling::td"));
		System.out.println(ScoreList.size());
ArrayList<String> ar=new ArrayList<String>();

		for (int i = 0; i < ScoreList.size(); i++) {
			String text = ScoreList.get(i).getText();
         ar.add(text);
		}
		return ar;
	}
	
}
