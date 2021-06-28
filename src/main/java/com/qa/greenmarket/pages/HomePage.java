package com.qa.greenmarket.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.greenmarker.utils.ElementUtil;

public class HomePage {
	
	public WebDriver driver;
	CartPage cartPage;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	
	By cartCount=By.cssSelector("span.cart-count");
	
	@FindBy(css="a.cart-icon")
	WebElement CartIcon;
	
	@FindBy(xpath="//button[text()='PROCEED TO CHECKOUT']")
	WebElement proceedToCheckout;
	
	@FindBy(xpath="//input[@type='search']")
	WebElement search;
	
	@FindBy(xpath="//a[text()='+']")
	WebElement addItem;
	
	@FindBy(xpath="//button[text()='ADD TO CART']")
	WebElement addToCart;
	
	@FindBy(xpath="//h4[contains(@class,'product-name')]")
	WebElement resultProductName;
	
	

	
	public void getSearch(String searchText) throws InterruptedException
	{
		
		ElementUtil.sendKeys(driver, search, 4000, searchText);
		
		
	}
	
	public String validateResults() throws InterruptedException
	
	{
		Thread.sleep(4000);
		String value=ElementUtil.retrieveText(driver, resultProductName, 4000);
		System.out.println("Value is " +value); 
		
		return value;
		
	}
	
	
	
	public String AddItems() throws InterruptedException
	
	{
		
		ElementUtil.click(driver, addItem, 4000);
		ElementUtil.click(driver, addToCart, 4000);
		String count=cartCount();
		return count;
		
	}
	
	public CartPage navigatetoCartPage() throws InterruptedException
	{
		ElementUtil.click(driver, CartIcon, 4000);
		ElementUtil.click(driver, proceedToCheckout, 4000);
		
		return new CartPage(driver);
		
	}
	
	public String cartCount() throws InterruptedException
	{
		
		WebDriverWait wait=new WebDriverWait(driver,4000);
		wait.until(ExpectedConditions.visibilityOf(CartIcon));
		String count=driver.findElement(cartCount).getText();
		
		//int count1=Integer.parseInt(count);
		System.out.println("Count is" +count);	
		return count;
		
	}
	
}
