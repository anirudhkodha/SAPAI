package com.MyTests;


import java.io.IOException;
//import java.util.logging.Logger;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.myPages.LandingPage;
import com.myPages.RegisterPage;
import com.resources.BaseTest;
import com.resources.ExcelData;

import junit.framework.Assert;
import org.apache.logging.log4j.Logger;


public class SignUpFlowPositiveTest extends BaseTest {
	public static Logger log = LogManager.getLogger(BaseTest.class.getName());
	public WebDriver driver;
	
@BeforeTest
	public void intitalize() throws IOException
	{
	driver = initializeDriver();
	driver.get(prop.getProperty("url"));
	//driver.manage().window().maximize();
		
	}
	
	@Test
	public void signUpPositive() throws IOException, InterruptedException
	{
		
		 ExcelData ed = new ExcelData();
		 ArrayList<String> data = ed.getExcelData("signup");
		 LandingPage lp = new LandingPage(driver);
		 driver.manage().window().maximize();
		 log.info("Naviagted to homepage");
		 lp.getOkBtn().click();
		 lp.getSignUp().click();
		 RegisterPage rp = new RegisterPage(driver);		 
		 driver.switchTo().frame(rp.getFrame());
		 rp.getFName().sendKeys(data.get(1));
		 rp.getLName().sendKeys(data.get(2));
		 rp.geteMail().sendKeys(data.get(3));
		 rp.getPassword().sendKeys(data.get(4));
		 rp.getRePassword().sendKeys(data.get(4));
		 rp.getprivStatement().click();
		 Thread.sleep(1000);
		 rp.getTermsCondition().click();
		 rp.getRegister().click();
		 String success = rp.getsuccessMsg().getText();
		 Assert.assertEquals("Thank you for registering with SAP Conversational AI", success);
		 log.info("Successfully created account");		
	}

	@AfterTest
	public void tearDown()
	{
		driver.close();
		log.info("Browser closed");
	}
}
