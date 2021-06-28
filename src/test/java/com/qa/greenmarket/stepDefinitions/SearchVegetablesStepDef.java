package com.qa.greenmarket.stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.qa.e.greenmarket.TestBase.TestBase;
import com.qa.greenmarket.pages.CartPage;
import com.qa.greenmarket.pages.HomePage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class SearchVegetablesStepDef {
	WebDriver driver;
	HomePage homePage;
	CartPage cartPage=new CartPage(driver);
	
	@Given("^User is on GreenKart Page$")
    public void user_is_on_greenkart_page() throws Throwable {
		driver=TestBase.getDriver();
       
    }

    @When("^User searched for vegetable (.+)$")
    public void user_searched_for_vegetable_something(String strArg1) throws Throwable {
    	
    	homePage=new HomePage(driver);
    	homePage.getSearch(strArg1 );
 
    		
    }

    @Then("^(.+) result is displayed$")
    public void something_result_is_displayed(String strArg1) throws Throwable {
    	
    	String retrievedText= homePage.validateResults();
    	System.out.println(strArg1);
    	Assert.assertTrue(retrievedText.contains(strArg1));
      
    }
    

    @And("^Add item to the cart$")
    public void add_item_to_the_cart() throws Throwable {
    	
    	       String addedItemsCount=homePage.AddItems();
    	     System.out.println(addedItemsCount);
    	       
    }

    @And("^Go to cart page and proceed to Checkout$")
    public void go_to_cart_page_and_proceed_to_checkout() throws Throwable {
    	
    	cartPage=homePage.navigatetoCartPage();
    }
    
    @And("^Validate that user is navigated to cart page$")
    public void validate_that_user_is_naviagated_to_cart_page() throws Throwable {
    	
    	boolean value=cartPage.validateCartPage();
    	Assert.assertTrue(value);	
    	System.out.println("User Navigated");
    }

    
    @Then("^Validate selected item (.+) is displayed in checkout page$")
    public void validate_selected_item_something_is_displayed_in_cart_page(String strArg1) throws Throwable {
    	
    	String checkoutPageText=cartPage.selectedItemValidation();
    	
    	Assert.assertTrue(checkoutPageText.contains(strArg1));
    	
    	
    	
        
    }

}
