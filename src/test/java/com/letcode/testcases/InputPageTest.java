package com.letcode.testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.letcode.baseclass.Basesteps;
import com.letcode.pageobject.Homepage;
import com.letcode.pageobject.InputPage;
import com.letcode.pageobject.Workspacepage;
import com.letcode.utilities.Utilities;


public class InputPageTest extends Basesteps {
	
	 String Sheetname = "Sheet1";
	
	Homepage homepage;
	Workspacepage workspacepage;
	InputPage inputPage;
	
	public InputPageTest () {
		super();
	}
	@BeforeMethod
	public void Setup() {
		initialization();
		homepage = new Homepage();
		workspacepage = new Workspacepage();
		inputPage = new InputPage();
		
	}
	
	
	@Test(priority = 1)
	public void FirstTextBoxInputTest() {
		workspacepage = homepage.ClickonWorkSpaceOption();
		inputPage = workspacepage.ClickonEditBtnToOpenInputPage();
		inputPage.FillTheFirstTextBoxes("Karthik Balasubramanian");
		assertEquals(inputPage.VerifyTheValueEnteredInFullNameTextBox(), "Karthik Balasubramanian", "The First Column is not filled");
		
	}
	@Test(priority = 2)
	public void SecondTextBoxInputTest() {
		workspacepage = homepage.ClickonWorkSpaceOption();
		inputPage = workspacepage.ClickonEditBtnToOpenInputPage();
		inputPage.FillTheSecondTextBoxes("  Human Being");
		assertEquals(inputPage.VerifyTheValueEnteredInAppendTextBox(), "I am good  Human Being", "The sColumn is not filled");
		
	}

	@Test(priority = 3)
	public void Verifythetextinsidethirdbox() {
		workspacepage = homepage.ClickonWorkSpaceOption();
		inputPage = workspacepage.ClickonEditBtnToOpenInputPage();
		assertTrue(inputPage.VerifyTheTextInsideTheBox().contains("ortonikc"), "The Text Inside the Third box does not match with the Expected Text");
		
	}
	@Test(priority = 4)
	public void VerifyTextClearTest() {
		workspacepage = homepage.ClickonWorkSpaceOption();
		inputPage = workspacepage.ClickonEditBtnToOpenInputPage();
		inputPage.ClearTheTextInsideTheBox();
		assertTrue(inputPage.VerifyTheBoxIsCleared().contains(""),"The Text box was not Cleared");
	}
	@Test(priority = 5)
	public void VerifyTheTextBoxIsEnabled() {
		workspacepage = homepage.ClickonWorkSpaceOption();
		inputPage = workspacepage.ClickonEditBtnToOpenInputPage();
		assertEquals(inputPage.VerifyIfTheFieldIsEditable(), false, "The Field is editable");
		
	}
	
	@DataProvider
	public Object[][] getdata() {
		Object[][] data = Utilities.GetDataFromSheet(Sheetname);
		return data;
	}
	
	@Test(priority = 6,dataProvider = "getdata")
	public void TwoTextBoxInputTest(String Firstname, String Append) {
		workspacepage = homepage.ClickonWorkSpaceOption();
		inputPage = workspacepage.ClickonEditBtnToOpenInputPage();
		inputPage.FillTheFirstTwoTextBoxes(Firstname, Append);
		assertEquals(inputPage.VerifyTheValueEnteredInFullNameTextBox(), Firstname, "The value is not matching");
	
		
	
	}
	

	
	
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}

}
