package com.letcode.testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.letcode.baseclass.Basesteps;
import com.letcode.pageobject.ButtonPage;
import com.letcode.pageobject.Homepage;
import com.letcode.pageobject.Workspacepage;

public class ButtonPageTest extends Basesteps{
	
	
	Homepage homepage;
	Workspacepage workspacepage;
	ButtonPage buttonpage;
	
	
	public ButtonPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		buttonpage = new ButtonPage();
		homepage = new Homepage();
		workspacepage = new Workspacepage();
	}
	
	@Test(priority = 1)
	public void VerifyGotoHomepageButton() {
		workspacepage = homepage.ClickonWorkSpaceOption();
		buttonpage = workspacepage.ClickonClickButtonToOpenButtonpage();
		buttonpage.ClickonGotoHomePageButton();
		assertTrue(homepage.ValidatePageTitle().contains("LetCode with Koushik"), "The Button does not redirect to Homepage");
		
	}
	
	@Test(priority = 2)
	public void verifyFindLocationButton() {
		workspacepage = homepage.ClickonWorkSpaceOption();
		buttonpage = workspacepage.ClickonClickButtonToOpenButtonpage();
		assertEquals(buttonpage.GetLocationOfTheButton(), "(123, 336)","The location is not displayed");
		
	}
	
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}

}
