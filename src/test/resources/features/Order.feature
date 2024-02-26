Feature: Order feature

 Scenario: Create an order using registered account
  Given I log in with a created account
  When I fill in my basket and proceed to checkout
  Then I can complete shipping details and successfully place an order

 Scenario: Verify my order details in my account
  Given I log in with a created account
  When I navigate to My Orders
  Then Latest order from My Orders details are correct
  And View order action opens the right order