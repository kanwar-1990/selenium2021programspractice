package ImpSeleniumSession;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragandDropConcept {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/resources/demos/droppable/default.html");
		
		//Thread.sleep(2000);
		

		WebElement sourceelement=driver.findElement(By.id("draggable"));
		WebElement Targetelement=driver.findElement(By.id("droppable"));
		Actions action=new Actions(driver);

		
		
		//action.clickAndHold(sourceelement).moveToElement(Targetelement).release().build().perform();
		// build()-- is used to perform an action
		
		// one more way we have
		
		action.dragAndDrop(sourceelement,Targetelement).build().perform();
		
		
	}

}
