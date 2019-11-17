package crossBrowser;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class TestNGMultiBrowser {
	
	WebDriver driver=null;
	
	@BeforeMethod
	@Parameters("browsername")
	public void setup(String browsername) {	
		
		System.out.println("Browser name is : "+browsername);
		System.out.println("Thread id : "+Thread.currentThread().getId());
		
		if(browsername.equalsIgnoreCase("firefox"))	{
			System.setProperty("webdriver.gecko.driver","C:\\Program Files\\Java\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else if(browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\chromedriver_win32\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(browsername.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver","C:\\Program Files\\Java\\IEDriverServer.exe");
			driver=new InternetExplorerDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.get("http://www.google.com");
	}
	
	@Test
	public void gettitle() {
		String title=driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Google");
	}
	
	@Test()//skip test cases:   (enabled=false)
	public void verifyurl() {
		String url=driver.getCurrentUrl();
		System.out.println(url);
		Assert.assertEquals(url, "https://www.google.com/");
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
		System.out.println("Test Completed Successfully");
	}

}
