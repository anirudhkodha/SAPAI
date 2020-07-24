package com.myPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver driver;
	private By btnSignUp = By.cssSelector("div[class*='signup link']");
	private By btnOk = By.xpath("//div[@class='ml3 sc-bZQynM cCLMsV sc-EHOje dXZRce']/div");
	
	public LandingPage(WebDriver driver) {
		
		this.driver=driver;
	}




	public WebElement getSignUp()
	{
		return driver.findElement(btnSignUp);
		
	}
	
	public WebElement getOkBtn()
	{
		return driver.findElement(btnOk);
		
	}
	
}

