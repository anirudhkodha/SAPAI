package com.myPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver driver;
	private By btnSignUp = By.cssSelector("div[class*='signup link']");
	private By btnOk = By.xpath("//div[@class='ml3 sc-bZQynM cCLMsV sc-EHOje dXZRce']/div");
	private By optPlatform = By.cssSelector("[class='navbar__link']");
	private By potions = By.cssSelector("p[class='menu-item__title']");
	
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
	
	public WebElement getPlatform()
	{
		return driver.findElement(optPlatform);
		
	}
	
	public List<WebElement> getOptions()
	{
		return driver.findElements(potions);
		
	}
}

