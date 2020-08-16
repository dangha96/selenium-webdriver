package Selenium;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class Topic_00_Firefox_Template {
	WebDriver driver; 
	@BeforeClass
	  public void beforeClass() {
		
		driver=new FirefoxDriver();
		
	  }
	
	@Test
  public void TC_01_ID() throws Exception {
	driver.get ("http://live.demoguru99.com/index.php/customer/account/login/");	
	driver.findElement(By.id("email")).sendKeys ("danghongha96@gmail.com");
	driver.findElement(By.id("pass")).sendKeys ("danghongha96");	
	Thread.sleep(3000);
	driver.findElement(By.id("send2")).click();
 }
//	@Test
//	  public void TC_02_ClassName() throws InterruptedException { 
//		driver.get ("http://live.demoguru99.com/index.php/customer/account/login/");	
//		driver.findElement(By.className("email")).sendKeys ("");
//		driver.findElement(By.className("pass")).sendKeys ("");
//		Thread.sleep(3000);
//		driver.findElement(By.id("send2")).click();
//		driver.findElement(By.className("validation-advice")).sendKeys("This is a required field");
//	  }

	@Test
	  public void TC_04_LinkText() throws Exception { 
		driver.get ("http://live.demoguru99.com/index.php/customer/account/login/");	
		//click to Contact us
		driver.findElement(By.linkText("CONTACT US")).click();
		//click to Advanced search
		driver.findElement(By.linkText("ADVANCED SEARCH")).click() ;
		
		Thread.sleep(3000);
		driver.findElement(By.id("send2")).click();
	  }

	@Test
	  public void TC_04_PartialLinkText() throws Exception { 
		driver.get ("http://live.demoguru99.com/index.php/customer/account/login/");	
		//click to Contact us(not need write full) 
		driver.findElement(By.partialLinkText("CONTACT ")).click();
		//click to Privacy(not need write full) 
		driver.findElement(By.partialLinkText("PRIVACY")).click() ;
		
		Thread.sleep(3000);
		driver.findElement(By.id("send2")).click();
	  }
	
	
  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
