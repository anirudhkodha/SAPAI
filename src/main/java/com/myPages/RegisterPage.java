package com.myPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage {
	
	public WebDriver driver;
	private By frame = By.id("IDS_UI_Window");
	private By txtFirstname = By.cssSelector("[name='firstName']");
	private By txtLastname = By.cssSelector("[name='lastName']");
	private By txtEmail = By.cssSelector("[id='mail']");
	private By txtPassword = By.cssSelector("[id='newPasswordInput']");
	private By txtRepassword = By.cssSelector("[id='retypeNewPasswordInput']");
	private By chkPrivstatement = By.cssSelector("[id='pdAccept']");
	private By chkTermscondition = By.cssSelector("[id='touAccept']");
	private By btnRegister = By.cssSelector("[id='sapStoreRegisterFormSubmit']");
	private By msgSuccess = By.xpath("//div[@class='ids-container']/h1");
	private By msgError = By.cssSelector("[id='touAccept.errors']");
	
public RegisterPage(WebDriver driver) {
		
		this.driver=driver;
	}

public WebElement getFrame()
{
	return driver.findElement(frame);
	
}

public WebElement geterroMsg()
{
	return driver.findElement(msgError);
	
}

public WebElement getFName()
{
	return driver.findElement(txtFirstname);
	
}

public WebElement getLName()
{
	return driver.findElement(txtLastname);
	
}

public WebElement geteMail()
{
	return driver.findElement(txtEmail);
	
}

public WebElement getPassword()
{
	return driver.findElement(txtPassword);
	
}

public WebElement getRePassword()
{
	return driver.findElement(txtRepassword);
	
}

public WebElement getprivStatement()
{
	return driver.findElement(chkPrivstatement);
	
}

public WebElement getTermsCondition()
{
	return driver.findElement(chkTermscondition);
	
}

public WebElement getRegister()
{
	return driver.findElement(btnRegister);
	
}

public WebElement getsuccessMsg()
{
	return driver.findElement(msgSuccess);
	
}
			
}
