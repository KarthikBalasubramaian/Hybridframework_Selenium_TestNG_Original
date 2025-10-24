package com.letcode.testcases;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.letcode.baseclass.Basesteps;
import com.letcode.pageobject.FakeStorePage;
import com.letcode.pageobject.Homepage;
import com.letcode.pageobject.LoginPage;
import com.letcode.pageobject.Workspacepage;

public class LoginTest extends Basesteps{
	
	Homepage homepage;
	Workspacepage workspacepage;
	FakeStorePage fakeStorePage;
	LoginPage loginPage;
	
	
	public LoginTest() {
		super();
	}
	
	@BeforeMethod
	public void Setup() {
		initialization();
		homepage = new Homepage();
		workspacepage = new Workspacepage();
		loginPage = new LoginPage();
		fakeStorePage = new FakeStorePage();
		
	}
	
	@Test(priority = 1)
	public void LoginWithValidCredentialsTest() {
		workspacepage = homepage.ClickonWorkSpaceOption();
		fakeStorePage = workspacepage.ClickonPageObjectModelbtn();
		loginPage = fakeStorePage.ClickProfileicon();
		loginPage.LoginWithvalidCredentials(prop.getProperty("Username"), prop.getProperty("Password"));
		assertTrue(loginPage.ValidateSuccessMessage().contains("Successful"), "Login is not Successful");
		
	}
	
	@Test(priority = 2)
	public void LoginWithInvalidCredentialsTest() {
		workspacepage = homepage.ClickonWorkSpaceOption();
		fakeStorePage = workspacepage.ClickonPageObjectModelbtn();
		loginPage = fakeStorePage.ClickProfileicon();
		loginPage.LoginWithvalidCredentials("Nousername", "NoPassword");
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//		WebElement Snackbar = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'Login Failed')]")));
		assertTrue(loginPage.ValidateFailedMessage().contains("Failed"), "Login is not failed");
	
	}
	
	@Test(priority = 3)
	public void LetcodeLogoVisiblity() {
		assertTrue(false, "Letcode Logo is not Visible");
	}
	

	
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}
	

}
