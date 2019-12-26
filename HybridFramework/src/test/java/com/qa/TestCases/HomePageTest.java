package com.qa.TestCases;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.BaseClass.TestBase;
import com.qa.Utilities.TestUtility;
import com.qa.pages.ContactsPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
//import com.relevantcodes.extentreports.model.Log;

public class HomePageTest extends TestBase{
	
	LoginPage    loginPage;
	HomePage     homePage;
	TestUtility  testUtil;
	ContactsPage contactsPage;
		
	public HomePageTest()
	{
		super();
	}
	
	@Parameters("Browser")
	@BeforeMethod
	public void setUp(String Browser)
	{
		initialization(Browser);
		Log.info("Application Launched Successfully");
		
		testUtil      = new TestUtility();
		loginPage     = new LoginPage();
		contactsPage  = new ContactsPage();
		homePage      = loginPage.login(property.getProperty("Username"),property.getProperty("Password"));
	}
	
	//Test Cases Should be Separated - All Test Cases are independent.
	//@BeforeMethod - Every Test Case - Launch the Browser and Login.
	//@Test - Execute Test Cases.
	//@AfterMethod - Every Test Case - Close the Browser.
	
	@Test(priority=1)
	public void verifyHomePageTitleTest(Method method)
	{
		extentTest = extent.startTest(method.getName());
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals("Cogmento CRM", homePageTitle,"Home Page Title is not Matched");
		Log.info("Home Page Title Verified");
	}
	
	@Test(priority=2)
	public void verifyUserNameTest(Method method)
	{
		extentTest = extent.startTest(method.getName());
		Assert.assertTrue(homePage.verifyCorrectUserName());
		Log.info("UserName Verified");
	}
	
	@Test(priority=3)
	public void verifyContactsLinkTest(Method method)
	{
		extentTest = extent.startTest(method.getName());
		contactsPage = homePage.clickOnContactsLink();
		Log.info("Clicked on Contacts Link");
	}
	
}
