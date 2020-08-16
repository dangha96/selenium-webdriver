package Selenium;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class Topic_02_Firefox_WebElement_Command {
	WebDriver driver; 
	@BeforeClass
	  public void beforeClass() {
		
		driver=new FirefoxDriver();
		driver.get ("http://google.com.vn");
	  }
	
	@Test
  public void TC_01() {
		
  }
	@Test
	  public void TC_02() {
			
	  }


  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
