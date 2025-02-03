package com.qa.opencart.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.LoginPage;

public class BaseTest {
	
	public LoginPage loginPage;
	public DriverFactory df1;
	public WebDriver driver;
	public Properties prop;
	
	@BeforeTest
	public void setup() {
		df1 = new DriverFactory() ; 
		prop = df1.init_prop();
		driver = df1.init_driver(prop);
		loginPage = new LoginPage(driver);
	}
	
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
	
}
