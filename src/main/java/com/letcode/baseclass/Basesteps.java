package com.letcode.baseclass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;

import com.letcode.utilities.Utilities;
import com.letcode.utilities.WebEventListener;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Basesteps {

	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringDecorator<WebDriver> e_driver;
	public static WebEventListener eventListener;


	


	public Basesteps() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\Users\\dell\\Documents\\Letcode_TestNG\\Letcode_TestNGframework"
					+ "\\src\\main\\java\\com\\letcode\\configuration\\config.properties");
			prop.load(ip);
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();	
		}
		catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("❌ Could not load config.properties file");
		}
	}
		
	public static void initialization() {
			String browsername = prop.getProperty("browser");
			String defaulturl = prop.getProperty("Url");
			
			
			switch (browsername) {
			case "chrome":
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				break;
			case "internetexplorer":
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();
				break;

			default:
				throw new IllegalArgumentException("Unsupported browser:"  + browsername);
			}
			
			eventListener = new WebEventListener();
			
			e_driver = new EventFiringDecorator<WebDriver>(eventListener);
			
			driver = e_driver.decorate(driver);

			
						
			driver.get(defaulturl);
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.PAGE_LOAD_TIMEOUT));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.PAGE_LOAD_TIMEOUT));
		}
	
	public void TearDown() {
		driver.quit();
	}
	
	}

	
//	 public static WebDriver driver;
//	    public static Properties prop;
//
//	    // ✅ Constructor - loads config file
//	    public Basesteps() {
//	        try {
//	            prop = new Properties();
//	            FileInputStream ip = new FileInputStream(
//	                    "C:\\Users\\dell\\Documents\\Letcode_TestNG\\Letcode_TestNGframework\\src\\main\\java\\com\\letcode\\configuration\\config.properties");
//	            prop.load(ip);
//	            System.out.println("✅ Config file loaded successfully");
//	        } catch (IOException e) {
//	            throw new RuntimeException("❌ Could not load config.properties file", e);
//	        }
//	    }
//
////	    // ✅ Initialize WebDriver
////	    public static void initialization() {
////	        String browsername = prop.getProperty("browser");
////	        String defaulturl = prop.getProperty("Url");
////	        
////	        System.out.println(browsername);
////	        System.out.println(defaulturl);
////
////	        if (browsername.equalsIgnoreCase("chrome")) {
////	            WebDriverManager.chromedriver().setup();
////	            driver = new ChromeDriver(); // ✅ This line was missing earlier
////	            System.out.println("✅ Chrome Browser launched successfully");
////	        } else {
////	            throw new RuntimeException("❌ Unsupported browser: " + browsername);
////	        }
////
////	        driver.manage().window().maximize();
////	        driver.manage().deleteAllCookies();
////	        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.PAGE_LOAD_TIMEOUT));
////	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.IMPLICIT_WAIT));
////	        driver.get(defaulturl);
////	        System.out.println("✅ Navigated to: " + defaulturl);
////	    }
////	
////	}
	
	
	
		
		
	

