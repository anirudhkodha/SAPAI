package com.MyTests;

import java.io.File;
import javax.imageio.ImageIO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.yandex.qatools.ashot.AShot;
//import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class Screenshot {
	 public static void main(String args[]) throws Exception{
	     //Modify the path of the GeckoDriver in the below step based on your local system path
	            System.setProperty("webdriver.chrome.driver",".\\\\drivers\\\\chromedriver.exe");
	            // Instantiation of driver object. To launch Firefox browser
	     WebDriver driver = new ChromeDriver();
	            // To oepn URL "http://softwaretestingmaterial.com"
	     driver.get("https://www.softwaretestingmaterial.com");
	     Thread.sleep(2000);
	     ru.yandex.qatools.ashot.Screenshot fpScreenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
	     ImageIO.write(fpScreenshot.getImage(),"PNG",new File(".\\FullPageScreenshot.png"));
	     driver.close();
	        }
	}


