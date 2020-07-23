package com.myPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver driver;
	By btnSignUp = By.cssSelector("div[class*='signup link']");
	//= By.xpath("['div.btn--content']");
	//By okBtn = By.cssSelector("div[class*='cookieBanner div']");
	By okBtn = By.xpath("//div[@class='ml3 sc-bZQynM cCLMsV sc-EHOje dXZRce']/div");
	
	public LandingPage(WebDriver driver) {
		
		this.driver=driver;
	}




	public WebElement getSignUp()
	{
		return driver.findElement(btnSignUp);
		
	}
	
	public WebElement getOkBtn()
	{
		return driver.findElement(okBtn);
		
	}
	
}

