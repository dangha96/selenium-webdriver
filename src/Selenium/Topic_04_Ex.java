package Selenium;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;


//User ID : mngr285271  Pass: zAzUpYv
public class Topic_04_Ex {
	WebDriver driver;
    String emailAddress, name, gender, dob,address, city, state, pin, tele, password, customerID;
    String editEmail, editAdd, editCity, editState, editPin, editTele;
	By nameTextboxBy = By.xpath("//input[@name='name']");
    By genderRadioBy = By.xpath("//input[@value= 'f']");
    By genderTextbox = By.name("gender");
	By DobBy = By.xpath("//input[@name='dob']");
	By AddBy = By.name("addr");
	By CityBy = By.name("city");
	By StateBy = By.name("state");
	By PinBy = By.name("pinno");
	By TeleBy = By.name("telephoneno");
	By EmailBy = By.name("emailid");
    By PassBy = By.name("password");
    By SubmitBy= By.name ("sub");
    By successMessageBy = By.xpath ("//p [@class= 'heading3']");
    By EditBy= By.name("cusid");

	@BeforeClass
	public void beforeClass() {
        //data test
		emailAddress = "autofc" + randomNumber() + "@gmail.com";
		name = "Ha";
		gender = "female";
		dob = "03-11-1996";
		address = "Abc";
		city = "Hanoi";
		state = "A";
		pin = "123654";
		tele = "0342095064";
		password = "111222";
		// data edit
		editEmail="testfc" + randomNumber() + "@hot.com";
		editAdd="absdf";
		editCity="HCm";
		editState="HCM"; 
		editPin="123532";
		editTele="222346577";

		driver = new FirefoxDriver();
		driver.get("http://demo.guru99.com/v4/");
	}
//31:59
	@Test
	public void TC_01() {

		String loginUrl = driver.getCurrentUrl();
		//Register
		driver.findElement(By.xpath("//a[text()= 'here']")).click();
//		Assert.assertEquals(driver.getCurrentUrl(), "http://demo.guru99.com/");				
		driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys(emailAddress);
		driver.findElement(By.xpath("//input[@name='btnLogin']")).click(); 
		
		//18:20
		String userID = driver.findElement(By.xpath("//td[text() = 'User ID:']/following-sibling::td")).getText();
		String password = driver.findElement(By.xpath("//td[text() = 'Password :']/following-sibling::td")).getText();
		//Login
		driver.get(loginUrl);
		
		driver.findElement(By.name("uid")).sendKeys(userID);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//marquee[@class= 'heading3']")).getText(), "Welcome To Manager's Page of Guru99 Bank");
		// New customer
		driver.findElement(By.xpath("//a[text() ='New Customer']")).click();
		driver.findElement (nameTextboxBy).sendKeys(name);
        driver.findElement (genderRadioBy).click();
		driver.findElement (DobBy).sendKeys(dob);
		driver.findElement (AddBy).sendKeys(address);
        driver.findElement (CityBy).sendKeys(city);
        driver.findElement (StateBy).sendKeys(state);
        driver.findElement (PinBy).sendKeys(pin);
        driver.findElement (TeleBy).sendKeys(tele);
        driver.findElement (EmailBy).sendKeys(emailAddress);
        driver.findElement (PassBy).sendKeys(password);
        driver.findElement (SubmitBy) .click();


        // Verify customer regis success
        Assert.assertEquals (driver.findElement(successMessageBy).getText(), "Customer Registered Successfully!!!");
        Assert.assertEquals (driver.findElement(By.xpath("//td[text() = 'Customer Name']/following-sibling::td")).getText(),name);
        Assert.assertEquals (driver.findElement(By.xpath("//td[text() = 'Gender']/following-sibling::td")).getText(),gender);
        Assert.assertEquals (driver.findElement(By.xpath("//td[text() = 'Birthdate ']/following-sibling::td")).getText(),dob);
        Assert.assertEquals (driver.findElement(By.xpath("//td[text() = 'Address']/following-sibling::td")).getText(),address);
        Assert.assertEquals (driver.findElement(By.xpath("//td[text() = 'City']/following-sibling::td")).getText(),city);
        Assert.assertEquals (driver.findElement(By.xpath("//td[text() = 'State']/following-sibling::td")).getText(),state);
        Assert.assertEquals (driver.findElement(By.xpath("//td[text() = 'Pin']/following-sibling::td")).getText(),pin);
        Assert.assertEquals (driver.findElement(By.xpath("//td[text() = 'Mobile No.']/following-sibling::td")).getText(),tele);
        Assert.assertEquals (driver.findElement(By.xpath("//td[text() = 'Email']/following-sibling::td")).getText(),emailAddress);
   
        customerID =driver.findElement (By.xpath("//td[text() = 'Customer ID']/following-sibling::td")).getText();
    }

    public void TC_Edit_customer() {
        //open edit customer
        driver.findElement (By.xpath("//a[contains (text(), 'Edit Customer')]")).click();

		driver.findElement(EditBy).sendKeys(customerID);
        driver.findElement (By.name("AccSubmit")).click();

        //Verify Name/Gender/DOF disable
        Assert.assertFalse(driver.findElement(nameTextboxBy).isEnabled());
        Assert.assertFalse(driver.findElement(genderTextbox).isEnabled());
        Assert.assertFalse(driver.findElement(DobBy).isEnabled());
        //Edit Customer 
		//47:23
		// Added 16/9
		driver.findElement (AddBy).clear();
		driver.findElement (AddBy).sendKeys(editAdd);
		driver.findElement (CityBy).clear();
		driver.findElement (CityBy).sendKeys(editCity);
		driver.findElement (StateBy).clear();
        driver.findElement (StateBy).sendKeys(editState);
		driver.findElement (PinBy).clear();
		driver.findElement (PinBy).sendKeys(editPin);
		driver.findElement (TeleBy).clear();
		driver.findElement (TeleBy).sendKeys(editTele);
		driver.findElement (EmailBy).clear();
		driver.findElement (EmailBy).sendKeys(editEmail); 
		driver.findElement (SubmitBy).click();

	// Verify customer edit success
 // Verify customer regis success
		Assert.assertEquals (driver.findElement(successMessageBy).getText(), "Customer details updated Successfully!!!" );
		Assert.assertEquals (driver.findElement(By.xpath("//td[text() = 'Customer ID']/following-sibling::td")).getText(),customerID);
		Assert.assertEquals (driver.findElement(By.xpath("//td[text() = 'Customer Name']/following-sibling::td")).getText(),name);
		Assert.assertEquals (driver.findElement(By.xpath("//td[text() = 'Gender']/following-sibling::td")).getText(),gender);
		Assert.assertEquals (driver.findElement(By.xpath("//td[text() = 'Birthdate ']/following-sibling::td")).getText(),dob);
		Assert.assertEquals (driver.findElement(By.xpath("//td[text() = 'Address']/following-sibling::td")).getText(),editAdd);
		Assert.assertEquals (driver.findElement(By.xpath("//td[text() = 'City']/following-sibling::td")).getText(),editCity);
		Assert.assertEquals (driver.findElement(By.xpath("//td[text() = 'State']/following-sibling::td")).getText(),editState);
		Assert.assertEquals (driver.findElement(By.xpath("//td[text() = 'Pin']/following-sibling::td")).getText(),editPin);
		Assert.assertEquals (driver.findElement(By.xpath("//td[text() = 'Mobile No.']/following-sibling::td")).getText(),editTele);
		Assert.assertEquals (driver.findElement(By.xpath("//td[text() = 'Email']/following-sibling::td")).getText(),editEmail);



    }

	@Test
	public int randomNumber() {
		Random rand = new Random();
		// 0-999
		int number = rand.nextInt(10000);
		return number;
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
