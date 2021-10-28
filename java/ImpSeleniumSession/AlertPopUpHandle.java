package ImpSeleniumSession;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertPopUpHandle {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		driver.findElement(By.name("proceed")).click();

		Thread.sleep(5000);

		// Alert pop up are jacscript pop up which are not webelement ,hence we need to
		// use alert method to switch the window
		//alert doesnt have a pagesource any webelement hence need to switch the window

		Alert alert = driver.switchTo().alert();

		String text = alert.getText();
		System.out.println(text);

		// Testing validation

		if (text.equals("Please enter a valid user name")) {
			System.out.println("correct mesg");
		} else {
			System.out.println("incorrect mesg");
		}

		// alert.accept(); // to click on ok button

		// another option we have is
		alert.dismiss();

		// best example of alert pop in pagesource option 
		
		// 	var empty_string = /^\s*$/;
		
		
/*		if(empty_string.test(usr)){
			alert("Please enter a valid user name");
			document.getElementById("login1").focus();
			return false;*/
	}

}
