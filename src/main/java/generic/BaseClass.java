package generic;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	
	static
	{
	
		WebDriverManager.chromedriver().setup();
		WebDriverManager.firefoxdriver().setup();	

	}
  public static WebDriver driver;

  @Parameters("browser")
  @BeforeTest
  public void openBrowser(@Optional("chrome") String browser)
  {
	  if(browser.equals("chrome"))
	  {
	  driver= new ChromeDriver();
	  }
	  else if(browser.equals("firefox"))
	  {
		  
		driver=new FirefoxDriver() ;
	  }
	  
  }
  
  @BeforeMethod
  public void openApplication() throws IOException
  {

	  driver.get("https://blazedemo.com/");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }
  
  @AfterTest
  public void closeBrowser()
  {
	  driver.quit();
  }
  
  
  
}
