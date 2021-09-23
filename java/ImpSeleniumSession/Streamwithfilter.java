package ImpSeleniumSession;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Streamwithfilter {
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver =new ChromeDriver();
		driver.navigate().to("https://www.amazon.in/");
	
	By Tagname=By.tagName("a");
	
	List<WebElement> AmazonLinkList=driver.findElements(Tagname);
	System.out.println(AmazonLinkList.size());
	
	List<String> collectorlist=AmazonLinkList.stream()
	      .filter(ele->!ele.getText().equals("") && ele.getText().contains("Amazon")) // filter method to remove blank 
	                .map(ele->ele.getText())// And then mapping to get the remaining text
                    	.collect(Collectors.toList());// with the help of collector is as List
	
	collectorlist.stream().forEach(ele->System.out.println(ele)); // Since its already in string
	
	AmazonLinkList.stream()
	.filter(ele->!ele.getText().isEmpty()) // filtering list any empty
    	.filter(ele->!ele.getText().startsWith(""))// starts with an empty space 
	        .map(ele->ele.getText().trim()) // trimed 
	              .collect(Collectors.toList());
	
	
	AmazonLinkList.stream().forEach(ele->System.out.println(ele));
	
	
	}

}
