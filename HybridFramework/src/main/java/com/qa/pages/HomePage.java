package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.BaseClass.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath="//span[@class='user-display'][contains(.,'Prasanna M')]")
	@CacheLookup
	WebElement userNameLabel;
	
	@FindBy(xpath="//span[@class='item-text'][contains(.,'Calendar')]")
	WebElement calenderLink;
	
	@FindBy(xpath="//span[@class='item-text'][contains(.,'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath="//span[@class='item-text'][contains(.,'Companies')]")
	WebElement companiesLink;
	
	@FindBy(xpath = "//button[contains(.,'New')]")
	WebElement newContactsLink;
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyCorrectUserName()
	{
		return userNameLabel.isDisplayed();
	}
	
	public String verifyHomePageTitle()
	{
		return driver.getTitle();
	}
	
	public CalenderPage clickOnCalenderLink()
	{
		calenderLink.click();
		return new CalenderPage();
	}
	
	public ContactsPage clickOnContactsLink()
	{
		contactsLink.click();
		return new ContactsPage();
	}
	
	public CompaniesPage clickOnCompaniesLink()
	{
		companiesLink.click();
		return new CompaniesPage();
	}
	
	public void clickOnNewContactLink()
	{
		Actions action = new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		newContactsLink.click();
	}
}
