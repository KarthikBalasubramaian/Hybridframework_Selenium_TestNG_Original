package com.letcode.pageobject;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.letcode.baseclass.Basesteps;
import com.letcode.utilities.Utilities;

public class LoginPage extends Basesteps{
	
	//WebElements - Object Repository
	
	@FindBy(xpath = "//input[@placeholder='Enter Username' and contains(@class,'input')]")
	WebElement UsernameInputField;
	
	@FindBy(xpath = "//input[@placeholder='Enter Password' and contains(@class,'input')]")
	WebElement PasswordInputField;
	
	@FindBy(xpath = "//button[contains(@class,'button ') and contains(text(),'Login')]")
	WebElement Loginbtn;
	
	@FindBy(xpath = "//h1[contains(@class,'title') and contains(text(),'Fake Store')]")
	WebElement FakeProductHeading;
	
	@FindBy(xpath = "//img[@alt='letcode']")
	WebElement LetcodeLogo;
	
	
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public String VerifyPageTitle() {
		return driver.getTitle();
	}
	
	public String VerifyCurrentUrl() {
		return driver.getCurrentUrl();
	}
	
	public void LoginWithvalidCredentials(String Username, String Password) {
		UsernameInputField.sendKeys(Username);
		PasswordInputField.sendKeys(Password);
		Loginbtn.click();
	}
	
	public void LoginWithInvalidCredentials(String Username, String Password) {
		UsernameInputField.sendKeys(Username);
		PasswordInputField.sendKeys(Password);
		Loginbtn.click();
	}
	
	public boolean LetcodeLogoverification() {
		return LetcodeLogo.isDisplayed();
	}
	
	public String ValidateSuccessMessage() {
		return Utilities.WaitForElementPresence(driver, By.xpath("//div[contains(text(),' Login Successful')]"), 20).getText();
	}
	
	public String ValidateFailedMessage() {
		return Utilities.WaitForElementPresence(driver, By.xpath("//div[contains(text(),'Login Failed')]"), 20).getText();
	}
	
	
	

}
