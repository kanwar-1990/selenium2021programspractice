package ImpSeleniumSession;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowTab {
	
	 int i;
	
	public static void main(String args[])
	{
		
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.get("https://www.w3schools.com/html/html_tables.asp");
	//driver.switchTo().newWindow(WindowType.TAB);
	driver.get("https://www.google.com");
	//We can do this to open it in new window rather than it getting used in the same one
	WindowTab wt=new WindowTab();
	wt.testing();
	}
	
	public final void testing()
	{
		
	this.i=20;
	i=30;
	System.out.println(i);
	}

}
