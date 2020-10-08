package Selenium;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;

public class Topic_06_Handle_Dropdown_button {
	WebDriver driver;
	Select select;

	@BeforeClass
	public void beforeClass() {

		driver = new FirefoxDriver();
		driver.get("");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		//04:50

	}

	@Test
	public void TC_01() {

	}

	@Test
	public void TC_02() {

	}

	@Test
	public void TC_03() {

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
