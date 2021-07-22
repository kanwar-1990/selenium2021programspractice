package ImpSeleniumSession;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Custom_xpath_1 {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://demo.opencart.com/index.php?route=account/login");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		// Single xpath

		// htmtag[@prop1='value']
		// input[@name='email']

		// we Can have multiple xpath as well
		// input[@name='email' and @id='input-email']

		// below xpath consist of 3 class, we can chose a text and use it , it will not
		// work
		// button[@class='currency-select btn btn-link btn-block']

		// ex
		// //button[@class='btn-block']--- this cannot work

		// for this we can use contains(), function

		// // htmltag[contains(@propt,'value')]

		// //button[contains(@class,'btn-block')], contains function helps in getting
		// the text , we can also retrive a class from multiple class in a text

		// //input[contains(@id,'email')] --hint--only to get atributes id
		// //input[contains(@name,'email') and @id='input-email']
		// //input[contains(@name,'email') and @id='']

		// <input type="text" name="email" value="" placeholder="E-Mail Address"
		// id="input-email" class="form-control">
		// contains function , can get any text in attribute id

		// contains also used to find dynamic id

		/*
		 * <input id="test_123"> <input id="test_342"> <input id="test_456"> we can see
		 * that the ids are not unique so we can use contains()
		 */
		// input[contains(@id,'test_')] since test_ is unique, every time a website is
		// launch the unique id can be stored

		// if there multiple inputs in a tag, we want to find particular one we can use
		// below xpath

		// (//button[contains(@class,'btn-block')])[2] --close the xpath --with() and
		// add the number

		// (//button[contains(@class,'btn-block')])[position()=1]--- we can also use
		// position function
		// (//button[contains(@class,'btn-block')])[position()=2]
		// (//button[contains(@class,'btn-block')])[position()=3]
		// (//button[contains(@class,'btn-block')])[position()=4]

		// we have one more function --(//button[contains(@class,'btn-block')])[last()]
		// suppose we have 10 elements u want to go to the last one we can use last()

		// text(), function is used to get the text---

		// htmltag[text()='value']
		// //h5[text()="This doesn't look right."]--hint-works like a linked text

		// //i18n-string[text()='Remember me']
		// ////i18n-string[contains(text(),'Remember')]--hint- works like partial link
		// text

		// a[starts-with(text(),'Your Store')]-- starts-with function can be used as
		// well to get the

		// a[starts-with(text(),'Your ')]

		// label[starts-with(@class,'control-label')]
		// label[starts-with(@class,'control')]

		// *id[@name='password']-- will check all the elements and give the relevant
		// htmltag

		// div//input--indirect child+direct child

		// div/input---direct child

		// reverse xpath

		// Usally xpath travese from top of thr DOM, however we can use below way to
		// traverse reverselly to parent

		// input[@id='username']//..//..//..//..//..

		driver.findElement(By.xpath("		//input[@id='username']//..//..//..//..//")).getAttribute("id");
		// we can use this to get the required attribute
		// interview question, however we do not use it

		/**********************************************************************************/

		WebElement email_id = driver.findElement(By.xpath("//input[contains(@name,'email')]"));

		WebElement Password = driver.findElement(By.xpath("//input[contains(@name,'password')]"));

		email_id.sendKeys("naveenanimation20@gmail.com");
		Password.sendKeys("Selenium12345");

		driver.findElement(By.xpath("//input[contains(@type,'submit')]")).click();

		String YourStoreValue = driver.findElement(By.xpath("//a[contains(text(),'Your Store')]")).getText();
		System.out.println(YourStoreValue);

		Thread.sleep(2000);
		Boolean value = driver.findElement(By.xpath("//a[contains(text(),'Your Store')]")).isDisplayed();
		System.out.println(value);
	}
}
