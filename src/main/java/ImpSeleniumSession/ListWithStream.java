package ImpSeleniumSession;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ListWithStream
{
public static void main(String[] args) {
	
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.navigate().to("https://www.orangehrm.com/hris-hr-software-demo/");
	driver.navigate().to("");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	
	List<WebElement> CountryList=driver.findElements(By.xpath("//select[@name='Country']/option"));
	System.out.println(CountryList.size());
	List<WebElement> AmazonLinkList=driver.findElements(By.tagName("a")); //In Stream--it took 4940,in parallel stream--4560

	
//	Stream--was introduced from java.8
//		basically it work on one collection-- list on , since they are in order
//below List--is of sequential stream, list of WebElement is converted to stream,in sequentail order 	
//where in lambda -> function is used the get the details from thr details
//	
	
	System.out.println("Start time" + System.currentTimeMillis());
		CountryList.stream().forEach(ele -> System.out.println(ele.getText()));
		System.out.println("end time" + System.currentTimeMillis());

//	parallelStream, is another option, Where in the list is converted in parallel stream , every element is in single parallel line
// An data is stored. though it is bit faster ,but the list wont be in sequential order	
		
		System.out.println("Start time" + System.currentTimeMillis());
		CountryList.parallelStream().forEach(ele -> System.out.println(ele.getText()));
		System.out.println("end time" + System.currentTimeMillis());


}
}
