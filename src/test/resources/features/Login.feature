Feature: Validate the Working of Login Functionality

  Background: User opens the application URL
    Given User is on the Open Cart Home page

  @Valid
  Scenario: Validate logging into the application using Valid credentials
    Given User clicks on the My Account dropdown and clicks on Login option
    Then User should see Login page
    When User enters Valid Email id "nsbsankar15696@gmail.com"
    And User enters Valid Password "12345"
    And Clicks on Login
    Then User should get logged in and taken to Account page

  @Invalid
  Scenario: Validate logging into the application using Invalid email and password
    Given User clicks on the My Account dropdown and clicks on Login option
    When User enters Invalid Email id "nsbsankarxyz@gmail.com"
    And User enters Invalid Password "54321"
    And Clicks on Login
    Then User should get "Warning: No match for E-Mail Address and/or Password." warning message

  @Invalid
  Scenario: Validate logging into the application using Invalid email and Valid password
    Given User clicks on the My Account dropdown and clicks on Login option
    When User enters Invalid Email id "nsbsankarxyz@gmail.com"
    And User enters Valid Password "12345"
    And Clicks on Login
    Then User should get "Warning: No match for E-Mail Address and/or Password." warning message

  @Invalid
  Scenario: Validate logging into the application using Valid email and Invalid password
    Given User clicks on the My Account dropdown and clicks on Login option
    When User enters Valid Email id "nsbsankar15696@gmail.com"
    And User enters Invalid Password "54321"
    And Clicks on Login
    Then User should get "Warning: No match for E-Mail Address and/or Password." warning message

  @Invalid
  Scenario: Validate logging into the application without providing credentials
    Given User clicks on the My Account dropdown and clicks on Login option
    When User clicks on login without entering Email and Password
    Then User should get "Warning: No match for E-Mail Address and/or Password." warning message

  @Forgot
  Scenario: Validate 'Forgotten Password' link is available in the Login page and is working
    Given User clicks on the My Account dropdown and clicks on Login option
    Then Forgotten Password link should be displayed
    When User clicks on the Forgotten Password link
    Then User should navigate to forgot password page

  @Placeholder
  Scenario: Validate E-Mail Address and Password text fields in the Login page have the place holder text
    Given User clicks on the My Account dropdown and clicks on Login option
    Then User should see Place holder text for E-Mail Address and Password text fields

  @NoOfLoginAttempts
  Scenario: Validate the number of unsucessful login attemps
    Given User clicks on the My Account dropdown and clicks on Login option
    When User enters Invalid Email id "nsbshankar15696@gmail.com"
    And User enters Invalid Password "54321"
    And Clicks on Login for 5 times
    Then User should see "Warning: Your account has exceeded allowed number of login attempts. Please try again in 1 hour." warning msg.

    @ChangePassword
    Scenario: Validate Logging into the Application after changing the password
      Given User clicks on the My Account dropdown and clicks on Login option
      When User login into the application below valid credentials
      | nsbsankar15696@gmail.com | 123456 |
      And Clicks on Change your Password
      And Enters new password "12345" into Password and Confirm Password fields
      And Clicks on Continue button
      And User clicks on the My Account dropdown and clicks on Logout option
      When User login into the application with old password
      | nsbsankar15696@gmail.com | 123456 |
      Then User should not login into the application
      When User login into the application with new password
      | nsbsankar15696@gmail.com | 12345 |
      Then User should login into the application







