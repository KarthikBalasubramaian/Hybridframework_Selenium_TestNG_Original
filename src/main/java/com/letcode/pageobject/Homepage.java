package com.letcode.pageobject;




import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.letcode.baseclass.Basesteps;

public class Homepage extends Basesteps {
	
	
	//Page Factory - OR (Object Repository)
	//WebElement for Work-space button
	@FindBy(xpath = "//a[@class='navbar-item' and contains(text(),'Work-Space')]")
	WebElement WorkSpaceOption;
	
	//WebElement for Courses button
	@FindBy(xpath = "//a[@class='navbar-item' and contains(text(),'Courses')]")
	WebElement Coursesbtn;
	
	//WebElement for Contact button
	@FindBy(xpath = "//a[@class='navbar-item' and contains(text(),'Contact')]")
	WebElement Contactsbtn;
	
    //WebElement for Theme icon
	@FindBy(xpath = "//i[@id='theme-icon']")
	WebElement Themebtn;
	
	//WebElement for Page Heading
	@FindBy(xpath = "//app-main//h1[contains(text(),' LetCode with Koushik ')]")
	WebElement Pageheadline;
	
    //WebElement for Playwright Quiz button
	@FindBy(xpath = "//app-main//div//a[contains(@class,'button is-primary') and contains(text(),' NEW! Playwright Quiz ')]")
	WebElement Playwrightquizbtn;
	
	//WebElement for Test automation tools button
	@FindBy(xpath = "//span[contains(text(),'Test automation tools')]")
	WebElement Testautomationtoolbtn;
	//WebElement for Test automation training button
	@FindBy(xpath = "(//span[contains(text(),'Test automation training')])[1]")
	WebElement Testautomationtrainingbtn1;
	
	// initializing the Page Object:
	public Homepage() {
		PageFactory.initElements(driver,this);
	}
	
	//Actions
	//Click on Work-space option
	public Workspacepage ClickonWorkSpaceOption() {
		WorkSpaceOption.click();
		return new Workspacepage();
	}
	
	//Click on courses option
	public coursespage ClickonCoursesOption() {
		Coursesbtn.click();
		return new coursespage();
	}
	
	//Validate page Title
	public String ValidatePageTitle() {
	return driver.getTitle();
	}
	
	//Validate the Current Page URL
	public String ValidateCurrentPageUrl() {
		return driver.getCurrentUrl();
	}
	
	//Validate the Heading of the Homepage
	public String ValidateHeadingofTheHomePage() {
		return Pageheadline.getText();
	}
	
	
	
	
	
	
	

}
