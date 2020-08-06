package com.resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public WebDriver driver;
	public Properties prop;
	
@BeforeSuite
@org.testng.annotations.Parameters("browser")
public WebDriver initializeDriver(String browser) throws IOException
{
	prop = new Properties();
	FileInputStream fis = new FileInputStream(".\\src\\main\\java\\com\\resources\\Data.properties");
	prop.load(fis);
	//String browserName=prop.getProperty("browser");

	
	//System.out.println(browserName);
	if (browser.equalsIgnoreCase("chrome"))
	{
		//System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();	
		driver = new ChromeDriver();
	}
	else if(browser.equals("firefox"))
	{
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
			
		
	}
	else if(browser.equals("IE"))
	{
		WebDriverManager.iedriver().setup();
		//driver = new IE
	}
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	return driver;	
}/*
	 * public String getScreenShot(String testcaseName, WebDriver driver) throws
	 * IOException { TakesScreenshot ts =(TakesScreenshot) driver; File source =
	 * ts.getScreenshotAs(OutputType.FILE); String destinationFile =
	 * System.getProperty("user.dir")+"\\reports\\"+testcaseName+".png";
	 * FileUtils.copyFile(source, new File(destinationFile)); return
	 * destinationFile;
	 * 
	 * }
	 */
}
