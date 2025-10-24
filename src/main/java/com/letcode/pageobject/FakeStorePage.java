package com.letcode.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.letcode.baseclass.Basesteps;

public class FakeStorePage extends Basesteps{

	
	@FindBy(xpath = "//i[@class='fas fa-user']")
	WebElement Loginicon;
	
	
	
	
	
	
	public FakeStorePage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public LoginPage ClickProfileicon() {
		Loginicon.click();
		return new LoginPage();
	}
	
	public String VerifyCurrentUrl() {
	return	driver.getCurrentUrl();
	}
}
