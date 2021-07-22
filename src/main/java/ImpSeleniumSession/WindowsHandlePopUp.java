package ImpSeleniumSession;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowsHandlePopUp {
	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.seleniumeasy.com/test/window-popup-modal-demo.html");

		driver.findElement(By.linkText("Follow On Twitter")).click();

		Set<String> handles = driver.getWindowHandles();// to handle window and get windows ID

		Iterator<String> Windowid_Ref = handles.iterator();// Since Set is not like array or arraylist windows id init
															// is not followed as
		// per indexing hence iterator method is used
		// intaily interactor will be pointing to top of the windows ID

		String Parent_id = Windowid_Ref.next();// Now it will be pointing to parent id

		System.out.println(Parent_id);

		String child_id = Windowid_Ref.next();
		System.out.println(child_id);

		// now iterator is referring to child id so we will move to child window

		driver.switchTo().window(child_id);

		System.out.println("Child Window ID IS " + child_id);

		// we are not using quit() method here for two reason
		// Session id will become null and also quit will close parent and child window

		driver.close();// it will close the window which has the current hold of driver

		// now driver handle is lost , to get back to parent we will use switch to

		driver.switchTo().window(Parent_id);

		System.out.println("parent_id " + Parent_id);

		// driver.quit();

		// Will handle second pop now

		// Second window handle--refer screenshot

		driver.findElement(By.linkText("Like us On Facebook")).click();

		Set<String> handlessec = driver.getWindowHandles();

		Iterator<String> Ref = handlessec.iterator(); // to point at reference above the ids

		String ParentID1 = Ref.next();

		System.out.println("PARENT ID 1" + ParentID1);

		String Child_ID1 = Ref.next();

		System.out.println("Child_id1" + Child_ID1);

		// kNOW WE WILL SWITCH

		driver.switchTo().window(Child_ID1);
		System.out.println(driver.getTitle());

		driver.close();
		driver.switchTo().window(ParentID1);
		System.out.println(driver.getTitle());

	}
}
