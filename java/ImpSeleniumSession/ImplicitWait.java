package ImpSeleniumSession;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImplicitWait {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://s1.demo.opensourcecms.com/opencart/index.php?route=account/login");
		/*
		 * Static wait Thread.sleep--- is used in Java, if u have given 20 sec on
		 * thread.sleep it will wait for 20 sec and allow script to run even if the
		 * element is found in 5 sec, script will have to wait for 20 secs, which means
		 * it will consume 15secs out of 20 for no reason
		 * 
		 * dynamicwait/global wait to avoid the challenges of Thread.sleep. we can use
		 * implicit wait, if u have given 20 sec and element is found in 5sec it will
		 * allow directly to run the script Implicit wait --only should be used to find
		 * the webelement. Its is applicable for all the elements
		 */
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		WebElement emailname = driver.findElement(By.name("email"));// --Implicit wait for 20 sec will be applied wheren
																	// ever driver is used ,since with driver we have
																	// accum;ated implicit wait
		WebElement password = driver.findElement(By.name("password"));// --Implicit wait for 20 sec

		// Thread.sleep(20000);--- Will wait for 20 sec-- even if the element is found ,
		// mostly used in java

		System.out.println(driver.getTitle());// here implicit wait is not applied since it only for all the elements

		emailname.sendKeys("test@gmail.com");

		// We can change the implcit wait here also, if we require to nullyfy or reduce
		// to wait time for remaining elements to search we can do that

		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);

	}

}
