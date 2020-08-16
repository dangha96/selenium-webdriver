package Selenium;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class Topic_03_Web_Browser_API_02 {
	WebDriver driver; 
	
	@BeforeClass
	  public void beforeClass() {
		//khởi tạo trình duyệt
		driver=new FirefoxDriver();
		
	  }
	
	@Test
  public void TC_01_WebBrower() throws Exception {
		driver.
	
 }


	@Test
	  public void TC_02() throws Exception { 
		
	  }

	@Test
	  public void TC_03() throws Exception { 
		
	  }
	
	
  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
