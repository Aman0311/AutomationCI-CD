@tag
Feature: Purchase the order from website
  I want to use this template for my feature file
  
  Background:
  Given I land on ecommerce website

  @Regression
  Scenario Outline: Positive test of completing an order.
    Given Logged in with username <name> and password <password>
    When Add product <productName> to cart
    And check product<productName> in cart and checkout
    Then Verify the success message appears or not

    Examples: 
      | name  					| password 			| productName |
      | snow@gmail.com  | Aman@0311     | ZARA COAT 3 |
      | jamie@gmail.com | Qwertykey@123 | ZARA COAT 3 |
