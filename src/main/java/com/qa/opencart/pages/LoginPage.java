package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	private WebDriver driver ; 
	
	/** Private by - encapsulation**/
	
	private By emailId = By.id("input-email");
	private By password = By.id("input-password") ;
	private By loginBtn =By.xpath("//input[@value='Login']") ;
	private By forgotPwd = By.linkText("Forgotten Password");
	
	/** public actions constructor**/
	
	public LoginPage(WebDriver driver) {
		this.driver = driver ; 
	}
	
	public String getLoginPageTitle() {
		return driver.getTitle();
	}
	public String getLoginPageURL() {
		System.out.println("url " + driver.getCurrentUrl());
		
		return driver.getCurrentUrl();
	}
	
	public boolean isforgotpasswordlinkdisplayed() {
		return driver.findElement(forgotPwd).isDisplayed();
	}
	
	public void doLogin(String un,String pwd) {
		driver.findElement(emailId).sendKeys(un);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(loginBtn).click();
	
	}
	
}
