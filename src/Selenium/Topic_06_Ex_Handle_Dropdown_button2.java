package Selenium;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

@Test
public class Topic_06_Ex_Handle_Dropdown_button2 {
	WebDriver driver;
	Select select;

	@BeforeClass
	public void beforeClass() {

		driver = new FirefoxDriver();
		driver.get("https://automationfc.github.io/basic-form/index.html");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

	}

	public void TC_01() {
		//WebElement job_1 = (driver.findElement(By.id("job1")));
		select = new Select(driver.findElement(By.id("job1")));
//not support multi
		boolean status= select.isMultiple();
		System.out.println("Job role 01=" +status);
		Assert.assertFalse (status);
// Step 3: Select value Mobile Testing		
		select.selectByVisibleText("Mobile Testing");
		SleepInSecond (2);
// Verify 		
		//select.getFirstSelectedOption().getText();
		Assert.assertEquals(select.getFirstSelectedOption().getText(), "Mobile Testing");
    
    // Verify index
    select.selectByIndex(1);
    SleepInSecond (2);
    Assert.assertEquals(select.getFirstSelectedOption().getText(), "Manual Testing");

    //Verify by value 
    select.selectByValue("function ");
    SleepInSecond (2);
    Assert.assertEquals(select.getFirstSelectedOption().getText(), "Function UI Testing");
// Verify dropdow có 10 gtri
    
    Assert.assertEquals(select.getOptions().size(), 10);

// có support multi select
    select = new Select(driver.findElement(By.id("job2")));
    status= select.isMultiple();
    System.out.println("Job role 01=" +status);
    Assert.assertTrue (status);

// select 3 value
select.selectByVisibleText("Automation");
select.selectByVisibleText("Mobile");
select.selectByVisibleText("Desktop");
// dropdow has 3 selected item
List<WebElement> allSelectedItems= this.select.getAllSelectedOptions();
Assert.assertEquals(allSelectedItems.size(),3);
//in giá tr? dã ch?n 
for (WebElement item: allSelectedItems){
    System.out.print(item.getText());
  
this.select.deselectAll();
// verify 
Assert.assertEquals(select.getAllSelectedOptions.size(),0); 
		


}


    }
//17:15
	public void TC_02() {
		driver = new FirefoxDriver();
		driver.get("https://demo.nopcommerce.com/register");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		// click Regiter link in Header
		findByCss(".ico-register").click();
		//Gender
		findByCss("#gender-male").click();
		// first name
		findByCss("#FirstName").sendKeys("John");
		//last name
		findByCss("#LastName").sendKeys("Wick");
		// DOB
		select = new Select (findByCss("select[@name='DateOfBirthDay']"));
		select.selectByVisibleText ("10");
		Assert.assertEquals(select.getOptions().size(), 33);
		
		select = new Select (findByCss("select[@name='DateOfBirthMonth']"));
		select.selectByVisibleText ("May");
		Assert.assertEquals(select.getOptions().size(), 13);

		select = new Select (findByCss("select[@name='DateOfBirthYear']"));
		select.selectByVisibleText ("112");
		//Email
		findByCss ("#Email").sendKeys("dangha" + randomNumber ()+ "@gmail.com");

		// Company
		findByCss("#Company").sendKeys("Wick");
	
		//pass
		findByCss("#Password").sendKeys("123456");
		findByCss("#ConfirmPassword").sendKeys("123456");
		findByCss("#register-button").click();

		//verify register success
		Assert.assertEquals(findByCss(".ico-account")).isDisplayed());
		Assert.assertEquals(findByCss(".ico-logout")).isDisplayed());
		Assert.assertEquals(findByCss(".result")).getText(),"Your registration completed" );

	}
	public int randomNumber(){
		Random rand = new Random();
		return rand.nextInt(100000);
	}

	public WebElement findByCss (String value ) {
		return driver.findElement (By.cssSelector(value));

//30:36


	}
public void SleepInSecond(long Timeout) {
	try {
		Thread.sleep (Timeout * 1000);
		
	} catch (InterruptedException e) {
	e.printStackTrace(); 
}
}


	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
