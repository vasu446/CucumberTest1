Feature: Search for vegetables and add to cart

@Smoke

Scenario: Search for Vegetable 

Given User is on GreenKart Page
When User searched for vegetable Cucumber
Then Cucumber result is displayed 

@Smoke
Scenario Outline: Search for Vegetable and add to cart

Given User is on GreenKart Page
When User searched for vegetable <Name>
Then <Name> result is displayed 
And Add item to the cart
And Go to cart page and proceed to Checkout
And Validate that user is navigated to cart page  
Then Validate selected item <Name> is displayed in checkout page 

Examples:

|Name|
|Cucumber|
|Beetroot|
|Tomato|


