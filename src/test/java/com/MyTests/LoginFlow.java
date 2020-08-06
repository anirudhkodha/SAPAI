package com.MyTests;



import java.io.IOException;
//import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.Iterator;

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
import com.myPages.LoginPage;
import com.myPages.RegisterPage;
import com.resources.TestBase;

import junit.framework.Assert;
import org.apache.logging.log4j.Logger;
import com.utils.ExcelData;


public class LoginFlow extends TestBase {
	public static Logger log = LogManager.getLogger(TestBase.class.getName());
	public WebDriver driver;
	
@BeforeTest
	public void intitalize() throws IOException
	{
	driver = initializeDriver();
	driver.get(prop.getProperty("login"));
	//driver.manage().window().maximize();
		
	}
	
	@Test
	public void loginFlow() throws IOException, InterruptedException
	{
		 ExcelData ed = new ExcelData();
		 //com.resources.ExcelData ed = new com.resources.ExcelData();
		 ArrayList<String> data = ed.getExcelData("Login");
		 LoginPage loginPage = new LoginPage(driver);
		 loginPage.getSapService().click();
		 java.util.Set<String> set =driver.getWindowHandles();
		 Iterator<String> itr= set.iterator();
		 while(itr.hasNext()){
		 String parentWindow=itr.next();
		 String childWindow=itr.next();
		 System.out.println(childWindow);
		    // Compare whether the main windows is not equal to child window. If not equal, we will close.
		 driver.switchTo().window(childWindow);
		 WebDriverWait wait = new WebDriverWait(driver,20);
		 wait.until((ExpectedConditions.visibilityOf(loginPage.getUsername())));
		 loginPage.getUsername().sendKeys(data.get(1));
		 loginPage.getPassword().sendKeys(data.get(1));
		 loginPage.getLogon().click();
		 Thread.sleep(1000);
		 
		 
		 }	 
		
	}

	@AfterTest
	public void tearDown()
	{
		driver.close();
		log.info("Browser closed");
	}
}
