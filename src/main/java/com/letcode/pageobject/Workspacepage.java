package com.letcode.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.letcode.baseclass.Basesteps;
import com.letcode.utilities.Utilities;

public class Workspacepage extends Basesteps{
	
	
	//WebElements 
	@FindBy(xpath = "//a[@class='card-footer-item' and contains(text(),' Page Object Model ')]")
	WebElement Pombtn;
	
	@FindBy(xpath = "//a[contains(@class,'card-footer-item') and contains(text(),'Edit')]")
	WebElement  Inputpagebtn;
	
	@FindBy(xpath = "//a[@class='card-footer-item' and contains(text(),' Click ')]")
	WebElement Clickbtn;
	
	
	
	
	//Pagefactory initialization
	public Workspacepage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public FakeStorePage ClickonPageObjectModelbtn() {
		Pombtn.click();
		return new FakeStorePage();	                                                                      
	}
	
	public InputPage ClickonEditBtnToOpenInputPage() {
		Utilities.WaitForElementPresence(driver, By.xpath("//a[contains(@class,'card-footer-item') "
				+ "and contains(text(),'Edit')]"), Utilities.BUTTON_WAIT).click();
		return new InputPage();
		
	}
	
	public ButtonPage ClickonClickButtonToOpenButtonpage() {
		Utilities.WaitForElementPresence(driver, By.xpath("//a[@class='card-footer-item' and"
				+ " contains(text(),' Click ')]"), Utilities.BUTTON_WAIT).click();
		return new ButtonPage();
	}



	
	
}
