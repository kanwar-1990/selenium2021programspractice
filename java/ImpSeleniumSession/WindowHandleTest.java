package ImpSeleniumSession;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandleTest {

	public static void main(String args[]) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		driver.findElement(By.linkText("OrangeHRM, Inc")).click();

		/*
		 * String ChildwindowID = driver.getWindowHandle();
		 * System.out.println("Child window id is ::" + ChildwindowID);
		 */

		Set<String> windowIds = driver.getWindowHandles();
		/*
		 * Iterator<String> It = windowIds.iterator(); String parentIDs = It.next();
		 * String childID = It.next();
		 * 
		 * System.out.println("Parent id is ::" + parentIDs);
		 * System.out.println("Parent window page title:: " + driver.getTitle());
		 * System.out.println("Child id is ::" + childID);
		 * System.out.println("Child window page title:: " + driver.getTitle());
		 */
		// Second way:::
		List<String> it = new ArrayList<String>(windowIds);

		/*
		 * String parentId= it.get(0); String childId=it.get(1);
		 * System.out.println("parent id ::"+parentId);
		 * driver.switchTo().window(parentId);
		 * System.out.println("Parent page title::  "+driver.getTitle());
		 * System.out.println("child id::"+childId); driver.switchTo().window(childId);
		 * System.out.println("child page title::  "+driver.getTitle());
		 */
	    //foreach
		
		for (String string : it) {
			String titles = driver.switchTo().window(string).getTitle();
			System.out.println(titles);
			
			//closing window based on choices 
			if (titles.equals("OrangeHRM HR Software | Free HR Software | HRMS | HRIS") || titles.equals("OrangeHRM")) {
				driver.close();
			}
		}

	}

}
