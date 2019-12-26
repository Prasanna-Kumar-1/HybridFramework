package com.qa.TestCases;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.BaseClass.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
//import com.relevantcodes.extentreports.model.Log;

public class LoginPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest()
	{
		super();
	}
	
	//Inside @BeforeMethod, We Create Objects.
	@Parameters("Browser")
	@BeforeMethod
	public void setUp(String Browser)
	{
		initialization(Browser);
//		Log.info("Application Launched Successfully");
		
		loginPage = new LoginPage(); //Here we create objects to access methods from other Class.
	}
	
	@Test(priority=1)
	public void loginPageTitleTest(Method method)
	{
		extentTest = extent.startTest(method.getName());
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals("Cogmento CRM", title);
		Log.info("Login Page Title Verified");
	}
	
	@Test(priority=2, invocationCount = 1) 
	public void loginTest(Method method)
	{
		extentTest = extent.startTest(method.getName());
		homePage = loginPage.login(property.getProperty("Username"),property.getProperty("Password"));
		Log.info("Successfully Logged into CRM Application");
	}

}
