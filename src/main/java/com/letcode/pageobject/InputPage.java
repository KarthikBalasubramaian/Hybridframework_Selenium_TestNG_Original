package com.letcode.pageobject;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.letcode.baseclass.Basesteps;
import com.letcode.utilities.Utilities;

public class InputPage extends Basesteps {
	
	
	
	
	@FindBy(xpath = "//input[@id='fullName' and contains (@placeholder,'Enter first & last name')]")
	WebElement EnterFullNameInputField;
	
	@FindBy(xpath = "//input[@id='join' and contains (@placeholder,'Enter ')]")
	WebElement AppendTextInputField;
	
	@FindBy(xpath = "//input[@id='getMe' and contains (@placeholder,'Enter ')]")
	WebElement WhatIsInsideTheTextBox;
	
	@FindBy(xpath = "//input[@id='clearMe' and contains (@placeholder,'Enter ')]")
	WebElement ClearTheTextBox;
	
	@FindBy(xpath = "//input[@id='noEdit' and contains (@placeholder,'Enter')]")
	WebElement EditFieldDisabled;
	
	@FindBy(xpath = "//input[@id='dontwrite' and contains (@value,'This text is readonly')]")
	WebElement TextIsReadOnly;
	
	
	public InputPage() {
		PageFactory.initElements(driver, this);
	}
	
	

	
	public void FillTheFirstTwoTextBoxes(String Fullname, String Append) {
		EnterFullNameInputField.sendKeys(Fullname);
		AppendTextInputField.sendKeys(Append, Keys.TAB);
	}
	
	public void FillTheFirstTextBoxes(String Fullname) {
		EnterFullNameInputField.sendKeys(Fullname);
	}
	
	public void FillTheSecondTextBoxes(String Append) {
		AppendTextInputField.sendKeys(Append, Keys.TAB);
	}
	
	public String VerifyTheTextInsideTheBox() {
	return WhatIsInsideTheTextBox.getAttribute("value");
	}
	
	public void ClearTheTextInsideTheBox() {
		ClearTheTextBox.clear();
	}
	
	public boolean VerifyIfTheFieldIsEditable() {
		return EditFieldDisabled.isEnabled();
	}
	
	public String VerifyIfTheFieldIsReadonly() {
		return Utilities.WaitForElementPresence(driver, By.xpath("//input[@id='dontwrite' and contains (@value,'This text is readonly')]"), 10).getAttribute("readonly");
	}
	
	public String VerifyTheValueEnteredInFullNameTextBox() {
		return	Utilities.WaitForElementPresence(driver, By.xpath("//input[@id='fullName' and contains (@placeholder,'Enter first & last name')]"), 10).getAttribute("value");
		
	}
	
	public String VerifyTheValueEnteredInAppendTextBox() {
		return	Utilities.WaitForElementPresence(driver, By.xpath("//input[@id='join' and contains (@placeholder,'Enter ')]"), 10).getAttribute("value");
	}
	
	public String VerifyTheBoxIsCleared() {
		return Utilities.WaitForElementPresence(driver, By.xpath("//input[@id='clearMe' and contains (@placeholder,'Enter ')]"), 10).getAttribute("value");
	}

}
