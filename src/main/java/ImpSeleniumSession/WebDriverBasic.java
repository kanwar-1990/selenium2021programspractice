package ImpSeleniumSession;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverBasic {

	public static void main(String[] args) {

		/*
		 * 
		 * to browser to launch we cannot directly interact eith them, so we need a
		 * server to interact time So chromedriver.exe---will act like server we will
		 * setup and configure... server will take the refquest from eclipse and launch
		 * the chrome browser,,,,anything like launching or clickimng abuttion my source
		 * code and chromedriver and its allowing to launch browser chromedriver.exe---
		 * or firefox.exe---are driver executables ---we cannot interact with browser
		 * directly we can setup server programitically as well---by using
		 * System.setproperty
		 */

		System.setProperty("webdriver,chrome.driver", "C:\\Users\\knwrp\\Downloads\\chromedriver_win32 (1)");// server
																												// is
																												// created
																												// to
																												// interact
																												// with
																												// browser

		WebDriver driver = new ChromeDriver();// Open the browser
		// Imp Points--- Webdriver is an interface, where chromedriver or firefoxdriver
		// class are implementing the methods of it and overridding them as per the
		// buisness logic
		// Since Webdriver is an interface we cannot create an object of it hence we
		// have done the topCasting--Which means child class object is getting referred
		// by parent class reference varaibles

		driver.get("https://www.google.com");// enter url

		String title = driver.getTitle();
		System.out.println(title);
		// before this is just an automation

		// Validation--Expected and actual outcome--this completes automation testing
		if (title.equals("Google")) {
			System.out.println("Correct Title");
		} else {
			System.out.println("In-Correct Title");
		}

		String PageURL = driver.getCurrentUrl();
		System.out.println(PageURL);
		// Validation--Checking Url

		if (PageURL.contains("google")) {
			System.out.println("Contains----Correct URL");
		} else {
			System.out.println("Contains-----Incorrect URL");
		}

		// System.out.println(driver.getPageSource());

		// Every time we try to connect with browser through server(in our case
		// chromedriver.exe) session id is sends , uniques sessio id which is used
		// through the code
		// In quit() method , session would have been termited and so the sesion id will
		// bcm null, post which if we use any other method no session id will be sent
		// and from the server itself the request will be sent back
		// in close()---- when the session id goes with the reuest session id would have
		// expired ,however u will be able to see session id
		// in both case u cannot to any action after close() or quit()

		driver.quit();//Session ID is null. Using WebDriver after calling quit()?
		driver.close();// org.openqa.selenium.NoSuchSessionException----invalid session
						// id-----0318da4a328fa07231eb1e5c68d20e21

		System.out.println(driver.getTitle());

	}

}
