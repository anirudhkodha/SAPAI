package com.myPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	public WebDriver driver;
	private By lnkLogin = By.xpath("//a[@href='/login']");
	private By lnkSapService = By.cssSelector("[href='https://accounts.sap.com/']");
	private By txtUsername = By.cssSelector("[id='j_username']");
	private By txtPassword = By.cssSelector("[id='j_password']");
	private By btnLogOn = By.cssSelector("[id='logOnFormSubmit']");
	
	
public LoginPage(WebDriver driver) {
		
		this.driver=driver;
	}

public WebElement getLogin()
{
	return driver.findElement(lnkLogin);
	
}

public WebElement getSapService()
{
	return driver.findElement(lnkSapService);
	
}

public WebElement getUsername()
{
	return driver.findElement(txtUsername);
	
}

public WebElement getPassword()
{
	return driver.findElement(txtPassword);
	
}
	
public WebElement getLogon()
{
	return driver.findElement(btnLogOn);
	
}
	

}
