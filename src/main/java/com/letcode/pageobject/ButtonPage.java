package com.letcode.pageobject;



import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.letcode.baseclass.Basesteps;

public class ButtonPage extends Basesteps {
	
	@FindBy(xpath = "//button[@id='home' and contains(text(),'Goto Home')]")
	WebElement GoHomeButton;
	
	@FindBy(xpath = "//button[@id='position' and contains(text(),'Find Location')]")
	WebElement FindLocationButton;
	
	@FindBy(xpath = "//button[@id='color' and contains(text(),'What is my color')]")
	WebElement WhatisMyColorButton;
	
	
	public ButtonPage() {
		PageFactory.initElements(driver, this);
		
	}
	
	public void ClickonGotoHomePageButton() {
		GoHomeButton.click();
	}
	
	public String GetLocationOfTheButton() {
		Point location =  FindLocationButton.getLocation();
		return location.toString();
		
	}

	

}
