package Selenium;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.List;

import org.apache.jasper.tagplugins.jstl.core.Set;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class Topic_03_Web_Browser_API {
	WebDriver driver; 
	@BeforeClass
	  public void beforeClass() {
		//khởi tạo trình duyệt
//		driver=new FirefoxDriver();
//		driver= new ChromeDriver();
//		driver= new SafarDriver ();
//		
	  }
	
	@Test
  public void TC_01_WebBrowser() throws Exception {
	//ddongs tab trình duyệt đang active
		driver.close();
	//đóng toàn bộ trình duyệt	
		driver.quit();
		//thao tác với 1 element	
		
//cach 1://WebElement emailTextbox = driver.findElements(By.id("email"));
		//emailTextbox= clear;
		//emailTextbox.sendKeys("dangha@gmail.com"); 
//cach 2		
	driver.findElements(By.id("email"))).sendKeys("dangha@gmail.com");
	
	//thao tác với nhiều elements 
	List<WebElement> homePageLinks= driver.findElements(By.tagName("a"));
	for (WebElement link:homePageLinks ) {
		System.out.println("homePageLinks= " + link.getAttribute("href"));
	}
	driver.get("http://demo.guru99.com/v4/");
	
	//lấy ra source code của page hiện tại
	String homePageSource= driver.getPageSource();
	Assert.assertTrue(homePageSource.contains("This is demo site for"));
	
	//lấy ra title của page hiện tại
	String homePageTitle= driver.getTitle();
	Assert.assertEquals (homePageTitle, "Home page" );
	
	//xử lý window/tab
	//lấy ra ID của tab hiện tại
	String homepageTabID =driver.getWindowHandle();
	System.out.println ("TabID=" + homepageTabID );
	//lấy ra ID của tất cả các tab
	Set <String> allIDs =  driver.getWindowHandles();
	
	
	
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
