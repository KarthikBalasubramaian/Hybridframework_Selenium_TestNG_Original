package com.letcode.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.letcode.baseclass.Basesteps;
import com.letcode.pageobject.Homepage;

public class HomePageTests extends Basesteps {
	
	Homepage homepage;
	
	//Created a Homepage constructor to access the property and initialize the driver.
	public HomePageTests() {
		super();
	}
	
/*
 * Nothng	
 */
	// create a Setup to access driver and pre-requsitesz
	@BeforeMethod
	public void Setup() {
		initialization();
		homepage = new Homepage();
	}
	
	@Test
	public void ValidatingPageTitleTest() {
		assertEquals(homepage.ValidatePageTitle(), "LetCode with Koushik", "Title Name Does not Match");
	}
	
	@Test
	public void ValidatePageCurrentUrlTest() {
		assertEquals(homepage.ValidateCurrentPageUrl(), "https://letcode.in/","The Page Url does not match");
	}
	
	@Test
	public void ValidatePageHeadingTest() {
		assertEquals(homepage.ValidateHeadingofTheHomePage(), "LetCode with Koushik", "The Heading of the page does not match");
	}
	
	
	
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}
	

}
