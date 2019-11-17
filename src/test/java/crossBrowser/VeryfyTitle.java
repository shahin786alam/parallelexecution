package crossBrowser;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class VeryfyTitle {
	
	WebDriver driver;
	
	@Test
	@Parameters("browser")
	public void verifyPageTitle(String browsername) {
		
	if(browsername.equalsIgnoreCase("firefox"))	{
		System.setProperty("webdriver.gecko.driver","C:\\Program Files\\Java\\geckodriver.exe");
		driver=new FirefoxDriver();
	}
	else if(browsername.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
	}
	else if(browsername.equalsIgnoreCase("IE")) {
		System.setProperty("webdriver.InternetExplorer.driver","C:\\Program Files\\Java\\MicrosoftWebDriver.exe");
		driver=new InternetExplorerDriver();
	}
	
	driver.manage().window().maximize();
	driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	driver.get("https://www.google.com");
	System.out.println(driver.getTitle());
	System.out.println(driver.getCurrentUrl());
	driver.quit();
	}

}
