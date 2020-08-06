package com.MyTests;



import static org.testng.Assert.assertEquals;

import java.io.IOException;
//import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.myPages.LandingPage;
import com.myPages.LoginPage;
import com.myPages.RegisterPage;
import com.resources.TestBase;

import junit.framework.Assert;
import org.apache.logging.log4j.Logger;
import com.utils.ExcelData;


public class PlatformTest extends TestBase {
	public static Logger log = LogManager.getLogger(TestBase.class.getName());
	public WebDriver driver;
	
@BeforeTest
	public void intitalize() throws IOException
	{
	driver = initializeDriver();
	driver.get(prop.getProperty("url"));
	driver.manage().window().maximize();
		
	}
	
	@Test
	public void loginFlow() throws IOException, InterruptedException
	{
		 LandingPage landingPage = new LandingPage(driver);
		 Actions action = new Actions(driver);
		 action.moveToElement(landingPage.getPlatform()).perform();		 
		 List<WebElement> opt=landingPage.getOptions();
		 for(WebElement option :opt)
		 {
			 if(option.getText().equalsIgnoreCase("Bot Builder"))
			 {
				 option.click();
				 break;
			 }
		 
		 }
		 Thread.sleep(10000);
		 String currUrl = driver.getCurrentUrl();
		 String expected = "https://cai.tools.sap/bot-builders";
		 Assert.assertEquals(currUrl, expected);
		 
		
	}

	@AfterTest
	public void tearDown()
	{
		driver.close();
		log.info("Browser closed");
	}
}
