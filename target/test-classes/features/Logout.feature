Feature: Validating logout functionality

  Background: User opens the application URL
    Given User is on the Open Cart Home page for logout feature


  Scenario: Validate Logging out by selecting Logout option from 'My Account' dropmenu
    Given User is logged into the application with email "nsbsankar15696@gmail.com" and password "12345"
    When User clicks on the My Account dropdown and clicks on Logout option on Account page
    Then User should should be taken to "Account Logout" page
    And User should see Login option in My Account dropmenu
    When User clicks on continue in the logout page
    Then User should taken to Home page

  @Logout
  Scenario: Validate Logging out by selecting Logout option from 'Right Column' options
    Given User is logged into the application with email "nsbsankar15696@gmail.com" and password "12345"
    When User clicks on Logout from the Right Column option
    Then User should should be taken to "Account Logout" page
    And User should see Login option in My Account dropmenu
    When User clicks on continue in the logout page
    Then User should taken to Home page

#  @SessionStatus
#  Scenario: Validate the Application session status, after logging and closing the Browser without logging out
#    Given User is logged into the application with email "nsbsankar15696@gmail.com" and password "12345"
#    When User closes the browser without logout and opens the browser and navigate to the application
#    Then Application should not get logged out
  @BrowsingBack
  Scenario: Validate logging out and browsing back
    Given User is logged into the application with email "nsbsankar15696@gmail.com" and password "12345"
    When User clicks on the My Account dropdown and clicks on Logout option on Account page
    And User clicks on Browser back button
    Then User should not get logged in

  @LogoutOption
  Scenario: Validate Logout option is not displayed under 'My Account' menu before logging in
    When User clicks on the My Account dropdown in home page
    Then "Logout" option should not be displayed

  @LogoutOptionRightColumn
  Scenario: Validate Logout option is not displayed under 'Right Column' options before logging in
    When User clicks on the My Account dropdown menu and clicks on Register option for logout feature
    Then "Logout" option should not be displayed in the right column options

  @LoginLogoutLogin
  Scenario: Validate logging out and logging in immediately after logout
    Given User is logged into the application with email "nsbsankar15696@gmail.com" and password "12345"
    When User clicks on the My Account dropdown and clicks on Logout option on Account page
    And clicks on Login option in the My Account menu
    And User is logged into the application with email "nsbsankar15696@gmail.com" and password "12345"
    Then Login should be successful











