package com.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.BaseClass.TestBase;

public class LoginPage extends TestBase{
	
	//Page Factory or Object Repository Where we store all WebElements.
	//Here, @FindBy =  driver.findElement(By.name(""));
	
	@FindBy(xpath = "//input[@name='email']")
	WebElement username;
	
	@FindBy(xpath = "//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath="//div[@class='ui fluid large blue submit button'][contains(.,'Login')]")
	WebElement loginButton;
	
	@FindBy(xpath = "//a[@href='https://api.cogmento.com/register'][contains(.,'Sign Up')]")
	WebElement signUpButton;
	
	//Initializing [Page Objects] all Object Repository Elements with help of Page Factory in Constructor.
	//We initialize Page Factory Using initElements(driver, this) //This refers to Current Class Object.
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String validateLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public HomePage login(String uname, String pword)
	{
		username.sendKeys(uname);
		password.sendKeys(pword);
		
		//LoginButton.click();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", loginButton);
				
		return new HomePage(); //Since Login Page is Landing on HomePage
	}
}
