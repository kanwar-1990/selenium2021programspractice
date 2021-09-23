package ImpSeleniumSession;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UserLogin_HashMap {

	public static void main(String[] args) {

		Map<String, String> userMap = new HashMap<String, String>();
		userMap.put("admin", "admin_admin");
		userMap.put("doctor", "tom@gmail.com_test@123");
		userMap.put("professor", "peter@gmail.com_test@3456");

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://demo.opencart.com/index.php?route=account/login");

		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		dologin(driver, getuserData(), "professor");

	}

	/**
	 * userMap is return with username and password
	 * 
	 * @return
	 */
	public static Map<String, String> getuserData() {
		Map<String, String> userMap = new HashMap<String, String>();
		userMap.put("admin", "admin_admin");
		userMap.put("doctor", "tom@gmail.com_test@123");
		userMap.put("professor", "peter@gmail.com_test@3456");
		return userMap;
	}

	/**
	 * Generic method is created to give driver, username data based on key given
	 * and value returned
	 * 
	 * @param driver
	 * @param userMap
	 * @param UserKey
	 */

	public static void dologin(WebDriver driver, Map<String, String> userMap, String UserKey) {
		driver.findElement(By.id("input-email")).sendKeys(userMap.get(UserKey).split("_")[0]);
		driver.findElement(By.id("input-password")).sendKeys(userMap.get(UserKey).split("_")[1]);
	}

}
