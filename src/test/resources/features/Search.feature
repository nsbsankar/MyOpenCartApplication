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

  @SearchAfterLogin @Smoke
  Scenario: Validate searching for a product after login to the Application
    Given User is logged into the application with email "nsbsankar15696@gmail.com" and password "12345" for Search Functionality
    When User enters existing product name "iMac" into the search text box field
    And Click on search icon button
    Then Searched product "iMac" should be displayed in the search results

  @MultipleProducts
  Scenario: Validate searching by providing a search criteria which results in multiple products
    When User enter "Mac" in the search text box field which can result in multiple products
    And Click on search icon button
    Then More than one product should be displayed

  @SearchWithSearchCriteria
  Scenario: Validate searching using 'Search Criteria' field
    When User dont enters anything into the search text box field
    And Click on search icon button
    And Enter any existing product name "iPhone" into the search criteria text box field
    And Click on search button
    Then Searched product "iPhone" should be displayed in the search results

  @CorrectCategory
  Scenario: Validate Search by selecting the correct category of product
    When User dont enters anything into the search text box field
    And Click on search icon button
    And Enter any existing product name "iMac" into the search criteria text box field
    And Select the correct category of the given product name into All Categories dropdown "27" is the value
    And Click on search button
    Then Searched product "iMac" should be displayed in the search results

  @WrongCategory
  Scenario: Validate Search by selecting the wrong category of product
    When User dont enters anything into the search text box field
    And Click on search icon button
    And Enter any existing product name "iMac" into the search criteria text box field
    And Select the wrong category of the given product name into All Categories dropdown "26" is the value
    And Click on search button
    Then "There is no product that matches the search criteria." should be displayed

  @SearchInSubCategories
  Scenario: Validate Search by selecting  to search in subcategories
    When User dont enters anything into the search text box field
    And Click on search icon button
    And Enter any existing product name "iMac" into the search criteria text box field
    And Select the Parent Category of the given product name "Desktops" into All Categories dropdown
    And Click on search button
    Then "There is no product that matches the search criteria." should be displayed
    And Select Search in subcategories check box field
    And Click on search button
    Then Searched product "iMac" should be displayed in the search results










