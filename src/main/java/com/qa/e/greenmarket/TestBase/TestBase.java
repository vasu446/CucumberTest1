package com.qa.e.greenmarket.TestBase;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.qa.greenmarker.utils.WebEventListener;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public static WebDriver getDriver() throws IOException
	
	{
		System.out.println("Checking");
		 prop=new Properties();
		 
		 FileInputStream fis=new FileInputStream("src/main/java/com/qa"
		 		+ "/greenmarket/properties/config.properties");
		 
		 prop.load(fis);
		 
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
		driver.get(prop.getProperty("url"));
		
		
		// EventFiring WebDriver ==== create object for this class
		
		EventFiringWebDriver edriver=new EventFiringWebDriver(driver);
		
		//create an object for WebEventListener to register it with EventFiringWebDriver
		
		WebEventListener listener=new WebEventListener();
		edriver.register(listener);
		driver=edriver;
		
		
		
		return driver;
	}

}
