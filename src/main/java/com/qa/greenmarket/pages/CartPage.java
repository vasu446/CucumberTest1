package com.qa.greenmarket.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {
	WebDriver driver;
	
	
	
	public CartPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath="//button[contains(text(),'Place Order')]")
	WebElement validateCartPage;
	
	@FindBy(css="p.product-name")
	WebElement getProductName;
	
	
	
	public boolean validateCartPage()
	{
		System.out.println("Cart Page");
		WebDriverWait wait=new WebDriverWait(driver,4000);
		wait.until(ExpectedConditions.visibilityOf(validateCartPage));
		boolean flag=false;
		
		if(validateCartPage.isDisplayed())
		{
			System.out.println("Displayed");
			flag=true;
		}
		return flag;
		
	}
	
	public String selectedItemValidation()
	{
		String checkoutPageText=getProductName.getText();
    	System.out.println(checkoutPageText);
    	return checkoutPageText;
	}
}
