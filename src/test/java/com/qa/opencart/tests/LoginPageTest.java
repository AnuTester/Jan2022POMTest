package com.qa.opencart.tests;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utils.Constants;

public class LoginPageTest extends BaseTest{
	
	@Test
	public void LoginPageTitleTest() {
		String actTitle = loginPage.getLoginPageTitle();
		Assert.assertEquals(actTitle, Constants.LOGIN_PAGE_TITLE);
	}
	
	@Test
	public void LoginPageURLTest() {
		String URLtest = loginPage.getLoginPageURL();
		Assert.assertTrue(URLtest.contains(Constants.LOGIN_PAGE_URL_PARTIAL));
	}
		@Test
	public void LoginPageLoginTest() {
		loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
		@Test
		public void LoginPageForgotPasswordLinkTest() {
			Assert.assertTrue(loginPage.isforgotpasswordlinkdisplayed());
		}
	
		
	}