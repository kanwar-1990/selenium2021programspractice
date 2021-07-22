package ImpSeleniumSession;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AppHubspot {
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://app.hubspot.com/login/?loginRedirectUrl=https%3A%2F%2Fapp.hubspot.com%2Fcontacts%2F5473739%2Fdeal%2F5324895121&loginPortalId=5473739&__cf_chl_jschl_tk__=0c6d69c745ca23058b3703d07fcb5c9303fb9d06-1625480126-0-AQyBnpXN-UwqzFDiVoFGNZrp5B8m-uQSVCJfWsLIos7Q_4pM7-EKfe_Hls3gn785N-z3QN8MoeHNn2r-VUucNwkArkWC2wQSLI2irZLgpMTWSkldmB5sSFSHi4ImXgKmqg-8Nt7BnIReTcluWhAxO-PC4J8NVFwCEUSR-aqiCxBHQJI4w_1lL-_fmf6oSprHyJyRvrpEulteCPi1fLoNHn6e3f5hdC615yTGmoHJeK7unz2jnlpbTxvzperZzPqzb8OomurrLsMeb_G81reFW2eS9JHsojEa3wys2QlIBakKxscDSjCD-eqkgo2h9XMv-TYGDTJJDgpsdGWusZx1-e36YrqHKHLJuho2PRhijtkeJJ0ipR6w1abzsRr7vSVKt7T_W7l9-KxG9alM7TU8FSVSnpnNCVjzkbkTyznT9nWgYjbUvR1ibfTiAxTNHwiEF_6OkqkH5ZU9pZHiigmxp33UF_9TZtMwaS-Jl7iLfdHm8Txsi1lLUwu75WwhjGXKbl9gabumtXN-54EC6b0Gg9Cwi83rNrcxI18cMGyq_Ofq6udTOqSMTcOE_Jf5wcbH7sudukWd1J_vAGNPRqfzNLeKng0JV6WP3v40VzsZvcyH");
		
	}

}
