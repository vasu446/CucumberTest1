package com.qa.greenmarker.utils;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {
	
	public static void sendKeys(WebDriver driver, WebElement ele,int timeout,String value)
	{
		new WebDriverWait(driver,timeout).until(ExpectedConditions.visibilityOf(ele));
		ele.sendKeys(value);
	}
	
	public static void click(WebDriver driver, WebElement ele,int timeout)
	{
		new WebDriverWait(driver,timeout).until(ExpectedConditions.elementToBeClickable(ele));
		ele.click();
	}
	
	public static String retrieveText(WebDriver driver,WebElement ele,int timeout)
	{
		new WebDriverWait(driver,timeout).until(ExpectedConditions.visibilityOf(ele));
		String text=ele.getText();
		System.out.println("text is " +text);
		return text;
	}

}
