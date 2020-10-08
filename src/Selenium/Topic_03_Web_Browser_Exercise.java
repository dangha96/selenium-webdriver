package Selenium;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class Topic_03_Web_Browser_Exercise {
	WebDriver driver; 
	By emailBy= By.xpath(//input[@id="mail"]);
		    By EduBy= By.xpath(//textarea [@id="edu"]);
		    By AgeBy= By.xpath(//input [@id="under_18"]);
		    By Jobrole01By = By.CssSelector(#job1);
		    By InterestsDevelopmentBy= By.cssSelector("#development");
		    By slider01By = Byte.CssSelector(#slider-1);
		    By Jobrole01By = By.CssSelector(#job2);
		    By InterestsCheckboxBy= By.xpath(//label [@for = "check-disbaled"]);

		    By PasswordBy= By.CssSelector (#password);
		    By RadioDisableBy= By.xpath (//label[contains(text (), 'Radio button is disable')]);
		    By BioBy= By.CssSelector (#bio);
		    By Job03By= By.xpath (//select [@id="job3"]);
		    By InterestDisableBy= By.xpath (//label[contains(text (), 'Checkbox is disable')]);
		    By Slide02By= By.CssSelector (#slider-2);
	@BeforeClass
	  public void beforeClass() {
		//khởi tạo trình duyệt
		driver=new FirefoxDriver();
	}		
	@BeforeMethod	// run for all testcase
		public void beforeMethod() {
		driver.get ("http://live.demoguru99.com/index.php/customer/account/login/");
		driver.findElement(By.xpath("//div[@class='footer'] //a[text()='My Account']")).click();
		
	  }
	
	@Test
  public void TC_01_GetCurrentURL() throws Exception {
		if (isElementDisplayed(emailBy)) {
            email.sendKeys ("dangha@gmail.com");
        }

    
        if (isElementDisplayed(EduBy)){
            edu.sendKeys("abs");
        }

        if (isElementDisplayed(AgeBy)){
           clickToElement (AgeBy);
        }
       
	
 }
	public void TC_02_Enabled (){
        driver.navigate().refresh ();

        Assert.assertTrue (isElementEnabled(PasswordBy));
        Assert.assertTrue (isElementEnabled(RadioDisableBy));
        Assert.assertTrue (isElementEnabled(EduBy));
        Assert.assertTrue (isElementEnabled(Jobrole01By));
        Assert.assertTrue (isElementEnabled(InterestsDevelopmentBy));
        Assert.assertTrue (isElementEnabled(slider01By));



        Assert.assertFalse (isElementEnabled(PasswordBy));
        Assert.assertTrue (isElementEnabled(RadioDisableBy));
        Assert.assertTrue (isElementEnabled(BioBy));
        Assert.assertTrue (isElementEnabled(Job03By));
        Assert.assertTrue (isElementEnabled(InterestDisableBy));
        Assert.assertTrue (isElementEnabled(Slide02By));
}

public void TC_03_Selected (){
    driver.navigate().refresh ();
    clickToElement(AgeBy);
    clickToElement(InterestsDevelopmentBy);
    sleepInsecond(2);
    Assert.assertTrue (isSelected(AgeBy));
    Assert.assertTrue (isSelected(InterestsDevelopmentBy));
    clickToElement(InterestsDevelopmentBy);
    Assert.assertFalse (isSelected(InterestsDevelopmentBy));



}

private void sleepInsecond(int i) {
	// TODO Auto-generated method stub
	
}
public void checkTrue(boolean status) {
    checkTrue (status);

}
public void checkFalse(boolean status) {
    checkTrue (status);

}


public void find (By by){
    return driver.findElement (by);
}

public void clickToElement(By by){
    WebElement element = find (by);
    
    element.click ();
}

public void sendKeysToElement (By by, String value){
    WebElement element= find(by);
    element.sendKeys(value);


}
public boolean isElementDisplayed (By by){
    WebElement element= find (by);
    if (element.isDisplayed()){
        System.out.println ("element with by [" + by " ]is displayed);
        return true;
    }else {
        System.out.println ("element with by [" + by " ]is un displayed);
        return false;
    }
}

public boolean isElementEnabled (By by){
    WebElement element= find (by);
    if (element.isEnable()){
        System.out.println ("element with by [" + by " ]is enabled);
        return true;
    }else {
        System.out.println ("element with by [" + by " ]is un enabled);
        return false;
    }
}


public boolean isSelected (By by){
    WebElement element= find (by);
    if (element.isSelected()){
        System.out.println ("element with by [" + by " ] is selected);
        return true;
    }else {
        System.out.println ("element with by [" + by " ]is un selected);
        return false;
    }
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
