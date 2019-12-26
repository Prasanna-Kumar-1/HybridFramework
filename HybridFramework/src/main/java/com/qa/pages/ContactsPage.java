package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.BaseClass.TestBase;

public class ContactsPage extends TestBase{
	
	@FindBy(xpath="//input[@name='first_name'][@type='text']")
	WebElement firstName;
	
	@FindBy(xpath="//input[@name='last_name'][@type='text']")
	WebElement lastName;
	
	@FindBy(xpath = "//input[@name='middle_name']")
	WebElement middleName;
	
	@FindBy(xpath = "//div[@class='ui header item mb5 light-black'][contains(.,'Contacts')]")
	WebElement Contactlabel;
	
	@FindBy(xpath = "//button[contains(.,'New')]")
	WebElement newContactBtn;
	
	@FindBy(xpath="//button[@class='ui linkedin button'][contains(.,'Save')]")
	WebElement saveButton;
	
	public ContactsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyContactsLabel()
	{
		return Contactlabel.isDisplayed();
	}

	public void createNewContact(String fName, String lName, String mName)
	{
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		middleName.sendKeys(mName);
		saveButton.click();
	}
	
}
