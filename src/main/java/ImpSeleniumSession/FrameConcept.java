package ImpSeleniumSession;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameConcept {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("http://www.londonfreelance.org/courses/frames/");

		WebElement Frame = driver.findElement(By.name("main"));
		driver.switchTo().frame(Frame);

		// Three ways of finding Frame frame is a webelement only
		// river.switchTo().frame(Frame);

		driver.switchTo().frame("main");// Frame by name

		// driver.switchTo().frame(2);// Frame by index----Frame is overloaded method

		String text = driver.findElement(By.cssSelector("body")).getText();
		System.out.println(text);

		// driver.switchTo().defaultContent();// to get back to default content or
		// window
		driver.switchTo().parentFrame();// can come to default frame

		// We do not use close(), method to switch back to default content--we rather
		// use defaultcontent

		// number of frames to find

		List<WebElement> Framelist = driver.findElements(By.tagName("frame"));

		System.out.println(Framelist.size());

	}

}
