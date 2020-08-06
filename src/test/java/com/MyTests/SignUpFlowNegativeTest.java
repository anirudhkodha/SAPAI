package com.MyTests;



import java.io.IOException;
//import java.util.logging.Logger;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.myPages.LandingPage;
import com.myPages.RegisterPage;
import com.resources.TestBase;

import junit.framework.Assert;
import org.apache.logging.log4j.Logger;
import com.utils.ExcelData;


public class SignUpFlowNegativeTest extends TestBase {
	public static Logger log = LogManager.getLogger(TestBase.class.getName());
	public WebDriver driver;
	
@BeforeTest
	public void intitalize() throws IOException
	{
	driver = initializeDriver();
	driver.get(prop.getProperty("url"));
	//driver.manage().window().maximize();
		
	}
	
	@Test
	public void signUpNegative() throws IOException, InterruptedException
	{
		 ExcelData ed = new ExcelData();
		 //com.resources.ExcelData ed = new com.resources.ExcelData();
		 ArrayList<String> data = ed.getExcelData("signup");
		 LandingPage lp = new LandingPage(driver);
		 RegisterPage rp = new RegisterPage(driver);	
		 driver.manage().window().maximize();
		 log.info("Naviagted to homepage");
		 lp.getOkBtn().click();
		 lp.getSignUp().click();
		 WebDriverWait wait = new WebDriverWait(driver,20);
		 wait.until((ExpectedConditions.frameToBeAvailableAndSwitchToIt(rp.getFrame())));
		 //driver.switchTo().frame(rp.getFrame());
		 rp.getFName().sendKeys(data.get(1));
		 rp.getLName().sendKeys(data.get(2));
		 rp.geteMail().sendKeys(data.get(3));
		 rp.getPassword().sendKeys(data.get(4));
		 rp.getRePassword().sendKeys(data.get(4));
		 rp.getprivStatement().click();
		 //rp.getTermsCondition().click();
		 rp.getRegister().click();
		 Thread.sleep(1000);
		 String error = rp.geterroMsg().getText();
		 Assert.assertEquals("To accept the terms of use, check the boxes", error);
		 log.info("Account not created ");		
	}

	@AfterTest
	public void tearDown()
	{
		driver.close();
		log.info("Browser closed");
	}
}
