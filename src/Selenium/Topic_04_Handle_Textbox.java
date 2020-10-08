package Selenium;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class Topic_04_Handle_Textbox {
	WebDriver driver; 
	
	String address = "123 add\n 345";
	@BeforeClass
	  public void beforeClass() {
		
		driver=new FirefoxDriver();
		driver.get ("https://automationfc.github.io/basic-form/index.html");
	  }
	
	@Test
  public void TC_01_Textbox_() {
		driver.findElement(By.xpath("//input[@id='mail']")).sendKeys("abc");
		sleepInSecond (2);
		
		driver.findElement(By.xpath("//textarea[@id='edu']").sendKeys(address);	
		
  }
	@Test
	  public void TC_04_button() {
		driver.findElement(By.xpath("//button[@id='button-enabled']")).click();
		Assert.assertEquals (driver.getCurrentUrl(), "https://automationfc.com/");
			
	  }


  @AfterClass
  public void afterClass() {
	  driver.quit();
	  
	  public void sleepInSecond(long second) {
		  try {
			  Thread.sleep(second  *1000);
		  }catch  (InterruptedException e) {
			  e.printStackTrace ();
		  }		  		  
		  
	  }
	  
  }

}
