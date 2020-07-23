package com.myPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage {
	
	public WebDriver driver;
	By frame = By.id("IDS_UI_Window");
	By txtFirstname = By.cssSelector("[name='firstName']");
	By txtLastname = By.cssSelector("[name='lastName']");
	By txtEmail = By.cssSelector("[id='mail']");
	By txtPassword = By.cssSelector("[id='newPasswordInput']");
	By txtRepassword = By.cssSelector("[id='retypeNewPasswordInput']");
	By chkPrivstatement = By.cssSelector("[id='pdAccept']");
	By chkTermscondition = By.cssSelector("[id='touAccept']");
	By btnRegister = By.cssSelector("[id='sapStoreRegisterFormSubmit']");
	By msgSuccess = By.xpath("//div[@class='ids-container']/h1");
	By msgError = By.cssSelector("[id='touAccept.errors']");
	
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
