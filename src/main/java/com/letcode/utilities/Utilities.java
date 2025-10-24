package com.letcode.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.letcode.baseclass.Basesteps;

public class Utilities extends Basesteps{
	
	
	public Utilities() {
		PageFactory.initElements(driver, this);
		
	}
	
	
	public static long PAGE_LOAD_TIMEOUT = 20 ;
	public static long IMPLICIT_WAIT = 20 ;
	public static long BUTTON_WAIT = 20;
	
	public static String TESTDATA_SHEET_PATH ="C:\\Users\\dell\\Documents\\"
    		+ "Letcode_TestNG\\Letcode_TestNGframework\\src\\main\\java\\com\\letcode\\Testdata\\Sample1.xlsx";
	
	public static WebElement WaitForElementPresence(WebDriver driver, By Locator, long timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.presenceOfElementLocated(Locator));
	}

	
    public static WebElement WaitUntilVisiblityOfElement(WebDriver driver, By Locator, long timeout) {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
    	return wait.until(ExpectedConditions.visibilityOfElementLocated(Locator));
		
    }
    
    
    static Workbook workbook;
    static Sheet sheet;
    
    
    
    public static Object[][] GetDataFromSheet(String SheetName){
    	
    	FileInputStream file = null;
    	Object[][] data;
    	
    	try {
    		file = new FileInputStream(TESTDATA_SHEET_PATH);
    		workbook = WorkbookFactory.create(file);
    		sheet = workbook.getSheet(SheetName);
    		
    		if(sheet==null) {
    			throw new RuntimeException("❌ Sheet '" + SheetName + "' not found in file: " + TESTDATA_SHEET_PATH);
    		}
			
		
    	
    	int TotalRows = sheet.getLastRowNum();
    	int TotalColumns = sheet.getRow(0).getLastCellNum();
    	
    	
    	 data = new Object[TotalRows][TotalColumns];
    	
    	for(int i=0;i<TotalRows;i++) {
    		for(int k=0;k<TotalColumns;k++) {
    			if(sheet.getRow(i+1)!= null && sheet.getRow(i+1).getCell(k)!=null) {
    				data[i][k] = sheet.getRow(i+1).getCell(k).toString();
    			}
    			else {
    				data[i][k]="";
    			}
    			
    			
    		//
    		}
    	}
    	}
    	
    	catch (FileNotFoundException e) {
            throw new RuntimeException("❌ Excel file not found at path: " + TESTDATA_SHEET_PATH, e);
        } catch (IOException e) {
            throw new RuntimeException("❌ Unable to read Excel file: " + e.getMessage(), e);
        } catch (Exception e) {
            throw new RuntimeException("❌ Unexpected error reading Excel: " + e.getMessage(), e);
        } finally {
            try {
                if (file != null) file.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    	return data;
    		
    	
    
    
    
    
    }


	public static void takeScreenshotAtEndOfTest() throws IOException  {
		
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}
    	
 

}
