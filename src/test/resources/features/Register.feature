Feature: Validating account registration for open cart

  @Smoke @Sanity
  Scenario: Validate Registering an account by providing only the mandatory fields
    Given User is on the Open Cart Home page
    When User clicks on the My Account dropdown menu and clicks on Register option
    And Enters new account details into the mandatory fields
    And Clicks on privacy policy checkbox
    And Clicks on Continue
    Then User should be logged in, taken to account success page and "Your Account Has Been Created!" should be displayed
    When User clicks on Continue in the account success page
    Then User should be taken to account page and "My Account" text should be displayed

  Scenario: Validate Registering an account by providing all fields
    Given User is on the Open Cart Home page
    When User clicks on the My Account dropdown menu and clicks on Register option
    And Enters new account details into the mandatory fields
    And Select Yes for Newsletter
    And Clicks on privacy policy checkbox
    And Clicks on Continue
    Then User should be logged in, taken to account success page and "Your Account Has Been Created!" should be displayed
    When User clicks on Continue in the account success page
    Then User should be taken to account page and "My Account" text should be displayed

  @Negative
  Scenario: Validate Error messages when user registering an account without providing mandatory fields
    Given User is on the Open Cart Home page
    When User clicks on the My Account dropdown menu and clicks on Register option
    And Clicks on Continue
    Then Below warning messages should be displayed for the respective fields
      | First Name     | First Name must be between 1 and 32 characters! |
      | Last Name      | Last Name must be between 1 and 32 characters!  |
      | Email          | E-Mail Address does not appear to be valid!     |
      | Telephone      | Telephone must be between 3 and 32 characters!  |
      | Password       | Password must be between 4 and 20 characters!   |
      | Privacy Policy | Warning: You must agree to the Privacy Policy!  |

  @NewsletterYes
  Scenario: Validate Registering an Account when Yes option is selected for Newsletter field
    Given User is on the Open Cart Home page
    When User clicks on the My Account dropdown menu and clicks on Register option
    And Enters new account details into the mandatory fields
    And Select Yes for Newsletter
    And Clicks on privacy policy checkbox
    And Clicks on Continue
    Then User should be logged in, taken to account success page and "Your Account Has Been Created!" should be displayed
    When User clicks on Continue in the account success page
    Then User should be taken to account page and clicks on Subscribe or unsubscribe to newsletter
    And Yes option should be selected in the newsletter page

  @NewsletterNo
  Scenario: Validate Registering an Account when No option is selected for Newsletter field
    Given User is on the Open Cart Home page
    When User clicks on the My Account dropdown menu and clicks on Register option
    And Enters new account details into the mandatory fields
    And Select No for Newsletter
    And Clicks on privacy policy checkbox
    And Clicks on Continue
    Then User should be logged in, taken to account success page and "Your Account Has Been Created!" should be displayed
    When User clicks on Continue in the account success page
    Then User should be taken to account page and clicks on Subscribe or unsubscribe to newsletter
    And No option should be selected in the newsletter page

  @RegisterAccountPage
  Scenario: Validating Different ways of navigating to Register Account page
    Given User is on the Open Cart Home page
    When User clicks on the My Account dropdown menu and clicks on Register option
    Then User should navigate to Register Account page
    When User clicks on the My Account dropdown menu and clicks on Login Option
    And Clicks on Continue inside New Customer Box
    Then User should navigate to Register Account page
    When User clicks on the My Account dropdown menu and clicks on Login Option
    And Clicks on Register option from the right coloumn options
    Then User should navigate to Register Account page

  @DifferentPasswords
  Scenario: Validate Registering an Account by entering different passwords into 'Password' and 'Password Confirm' fields
    Given User is on the Open Cart Home page
    When User clicks on the My Account dropdown menu and clicks on Register option
    And Enters new account details into the mandatory fields except password and password confirm fields
    And Enter Different passwords in both password and password confirm fields
    And Clicks on Continue
    Then User should see "Password confirmation does not match password!" warning message

  @ExistingEmail
  Scenario: Validating Registering an account with Existing Email
    Given User is on the Open Cart Home page
    When User clicks on the My Account dropdown menu and clicks on Register option
    And Enters new account details with existing Email id "nsbsankar15696@gmail.com"
    And Clicks on privacy policy checkbox
    And Clicks on Continue
    Then User should see the "Warning: E-Mail Address is already registered!" warning message

  @InvalidEmails
  Scenario Outline: Validating Registering an account with Invalid Emails
    Given User is on the Open Cart Home page
    When User clicks on the My Account dropdown menu and clicks on Register option
    And Enters new account details into the mandatory fields with "<Invalid Emails>"
    And Clicks on privacy policy checkbox
    And Clicks on Continue
    Then User should see Proper "<Warning messages>"
    Examples:
      | Invalid Emails | Warning messages                                                        |
      | sankar         | Please include an '@' in the email address. 'sankar' is missing an '@'. |
      | sankar@        | Please enter a part following '@'. 'sankar@' is incomplete.             |

  @KeyboardKeys
  Scenario: Validating Registering an account by using the keyboard keys
    Given User is on the Open Cart Home page
    When User clicks on the My Account dropdown menu and clicks on Register option
    And Enters new account details using keyboard keys
    And Clicks on privacy policy checkbox
    And Clicks on Continue
    Then User should be logged in, taken to account success page and "Your Account Has Been Created!" should be displayed




    
    
    
    
    