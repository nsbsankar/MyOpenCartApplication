Feature: Validating Search functionality of the Open Cart Application

  Background: User opens the application URL
    Given User is on the Open Cart Home page for Search feature

  @SearchExistingProduct @Smoke
  Scenario: Validate searching with an existing Product Name
    When User enters existing product name "iMac" into the search text box field
    And Click on search icon button
    Then Searched product "iMac" should be displayed in the search results

  @SearchNonExistingProduct @Smoke
  Scenario: Validate searching with a non existing Product Name
    When User enters non existing product name "Fitbit" into the search text box field
    And Click on search icon button
    Then "There is no product that matches the search criteria." should be displayed

  @SearchWithoutProductName
  Scenario: Validate searching without providing any Product Name
    When User dont enters anything into the search text box field
    And Click on search icon button
    Then "There is no product that matches the search criteria." should be displayed

  @SearchAfterLogin
  Scenario: Validate searching for a product after login to the Application
    Given User is logged into the application with email "nsbsankar15696@gmail.com" and password "12345" for Search Functionality
    When User enters existing product name "iMac" into the search text box field
    And Click on search icon button
    Then Searched product "iMac" should be displayed in the search results


