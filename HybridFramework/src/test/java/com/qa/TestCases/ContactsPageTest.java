package com.qa.TestCases;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.BaseClass.TestBase;
import com.qa.Utilities.TestUtility;
import com.qa.pages.ContactsPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;

public class ContactsPageTest extends TestBase{
	
	LoginPage     loginPage;
	HomePage      homePage;
	TestUtility   testUtil;
	ContactsPage  contactsPage;
		
	String sheetName = "Contacts"; //Passing Excel Sheet Name
	
	public ContactsPageTest()
	{
		super();
	}
	
	@Parameters("Browser")
	@BeforeMethod
	public void setUp(String Browser)
	{
		initialization(Browser);
		testUtil = new TestUtility();
		Log.info("Application Launched Successfully");
		
		loginPage      = new LoginPage();
		contactsPage   = new ContactsPage();
		homePage       = loginPage.login(property.getProperty("Username"),property.getProperty("Password"));
		contactsPage   = homePage.clickOnContactsLink();
	}
	
	@Test(priority=1)
	public void verifyContactsPageLabelTest(Method method)
	{
		extentTest = extent.startTest(method.getName());
		Assert.assertTrue(contactsPage.verifyContactsLabel(), "Contacts Label is Missing in the Page");
		Log.info("Verified Contacts Page Label");
	}
	
	//Using Data Provider here to Access Data from Excel Sheet
	@DataProvider
	public Object[][] getCRMContactsTestData() //To Access Sheet from Test Data Sheet
	{
		Object data [][] = TestUtility.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=2, dataProvider="getCRMContactsTestData")
	public void validateCreateNewContactTest(Method method, String FirstName, String LastName, String middleName)
	{
		extentTest = extent.startTest(method.getName());
		homePage.clickOnNewContactLink();
		contactsPage.createNewContact(FirstName, LastName, middleName);
		Log.info("New Contacts Created Successfully");
	}

}
