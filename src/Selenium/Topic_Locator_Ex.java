package Selenium;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Topic_Locator_Ex {
	WebDriver driver; 
	By emailTextboxBy=By.id("email");
	By passwordTextboxBy=By.id("pass");
	By loginButtonBy=By.name("send");
	
			
	@BeforeClass // run 1 times
	  public void beforeClass() {
		
		driver=new FirefoxDriver();
	}
	@BeforeMethod  // Run for each testcase
	public void beforeMethod  () {
		driver.get ("http://live.demoguru99.com/index.php/customer/account/login/");
	  }
	
	@Test
	public void TC_01_LoginWithEmptyEmailandPassword(){
//Input to email
		driver.findElement(emailTextboxBy).sendKeys("");	
//Input to password
		driver.findElement(passwordTextboxBy).sendKeys("");
//Click		
		driver.findElement(loginButtonBy).click();
		
		//driver.findElement(By.class/id/XPath.class.. ).click/sendkeys/ac
		//driver found locator with id/class/name...
		// found with locator id/class/name
		//sau khi tìm đc thì có sự kiện nào thao tác lên element này
		//click/input/gettext/
		
		// Verify Email error message
		//get dữ liệu error mess
		String emailErrorMessage= driver.findElement(By.xpath("//div [@id='advice-required-entry-email']")).getText();
		//khi dùng các hàm get getText, getTitle, get luôn trả về dữ liệu 
		//Phải có biến để lưu lại 
		
		Assert.assertEquals(emailErrorMessage, "This is a required field.");
//		Assert.assertTrue(emailErrorMessage.equals ("This is a required field"));
// 		Assert.assertTrue(emailErrorMessage.contains ("This is a required field"));
	
		// 3 hàm hay dùng để verify data
		//Assert.assert.true(condition)
		///Assert.assert.false(condition)
		//Assert.assertequals (actual, expected)
		
		// Verify password error message 
		
 		String passwordErrorMessage= driver.findElement(By.xpath("//div[@id='advice-required-entry-pass']")).getText();
 		Assert.assertEquals(passwordErrorMessage, "This is a required field.");
//		Assert.assertTrue(passwordErrorMessage.equals ("This is a required field"));
// 		Assert.assertTrue(passwordErrorMessage.contains ("This is a required field"));
 }

	 @Test
		 public void TC_01_LoginWithInvalidEmail(){
			//Input to email
					driver.findElement(emailTextboxBy).sendKeys("124@123");	
			//Input to password
					driver.findElement(passwordTextboxBy).sendKeys("123456");
			//Click		
					driver.findElement(loginButtonBy).click();
			//Verify invalid error
					String InvalidErrorMessage= driver.findElement(By.xpath("//div[@id='advice-validate-email-email']")).getText();
					Assert.assertEquals(InvalidErrorMessage, "Please enter a valid email address. For example johndoe@domain.com.");
					

		 }
	 
	 @Test
		 public void TC_01_LoginWithInvalidPassword(){
				//Input to email
						driver.findElement(emailTextboxBy).sendKeys("automation@gmail.com");	
				//Input to password
						driver.findElement(passwordTextboxBy).sendKeys("132");
				//Click		
						driver.findElement(loginButtonBy).click();
				//Verify invalid password
						String InvalidErrorPassword= driver.findElement(By.xpath("//div[@id='advice-validate-password-pass']")).getText();
						Assert.assertEquals(InvalidErrorPassword, "Please enter 6 or more characters without leading or trailing spaces.");	
		 }
 
	 @Test
	 public void TC_01_LoginWithInCorrectPassword(){
			//Input to email
					driver.findElement(emailTextboxBy).sendKeys("automation@gmail.com");	
			//Input to password
					driver.findElement(passwordTextboxBy).sendKeys("123123123");
			//Click		
					driver.findElement(loginButtonBy).click();
			//Verify incorrect password
					String IncorrectErrorPassword= driver.findElement(By.xpath("//li[@class='error-msg']//span")).getText();
					System.out.println(IncorrectErrorPassword);
					Assert.assertEquals(IncorrectErrorPassword, "Invalid login or password.");	
	 } 
	 
	 
	 
	 @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
