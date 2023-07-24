Feature: Validating logout functionality

  Background: User opens the application URL
    Given User is on the Open Cart Home page

  @Logout
  Scenario: Validate Logging out by selecting Logout option from 'My Account' dropmenu
    Given User is logged into the application with email "nsbsankar15696@gmail.com" and password "12345"
    When User clicks on the My Account dropdown and clicks on Logout option on Account page
    Then User should should be taken to "Account Logout" page
    And User should see Login option in My Account dropmenu
    When User clicks on continue in the logout page
    Then User should taken to Home page