package stepDefinitions;

import factory.DriverFactory;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageObjectModel.AccountPage;
import pageObjectModel.HomePage;
import pageObjectModel.LoginPage;
import pageObjectModel.SearchResultsPage;

import java.util.List;

public class Search {

    WebDriver driver;
    HomePage homePage;

    SearchResultsPage searchResultsPage;
    LoginPage loginPage;
    AccountPage accountPage;

    @Given("User is on the Open Cart Home page for Search feature")
    public void user_is_on_the_open_cart_home_page_for_search_feature() {
         driver = DriverFactory.getDriver();
         homePage = new HomePage(driver);
    }
    @When("User enters existing product name {string} into the search text box field")
    public void user_enters_existing_product_name_into_the_search_text_box_field(String existingProductName) {
        homePage.enterTextIntoSearchField(existingProductName);
    }
    @When("Click on search icon button")
    public void click_on_search_icon_button() {
        searchResultsPage = homePage.clickOnSearchIconButton();
    }
    @Then("Searched product {string} should be displayed in the search results")
    public void searched_product_should_be_displayed_in_the_search_results(String searchedProduct) {
        Assert.assertEquals(searchResultsPage.getTextFromSearchResult(),searchedProduct);
    }
    @When("User enters non existing product name {string} into the search text box field")
    public void user_enters_non_existing_product_name_into_the_search_text_box_field(String nonExistingProductName) {
        homePage.enterTextIntoSearchField(nonExistingProductName);
    }
    @Then("{string} should be displayed")
    public void should_be_displayed(String noProductMatchText) {
        Assert.assertEquals(searchResultsPage.getTextFromNoProductMatchText(),noProductMatchText);
    }
    @When("User dont enters anything into the search text box field")
    public void User_dont_enters_anything_into_the_search_text_box_field(){
        //No java code because user dont enters anything
    }
    @Given("User is logged into the application with email {string} and password {string} for Search Functionality")
    public void User_is_logged_into_the_application_with_email_and_password_for_Search_Functionality(String email,String password){
        homePage.clickOnMyAccountDropdownMenu();
        loginPage = homePage.clickOnLoginOption();
        loginPage.enterEmailAddress(email);
        loginPage.enterPassword(password);
        accountPage = loginPage.clickOnLoginButton();
        homePage = accountPage.clickOnHomeSymbolInBreadCrumb();

    }
    @When("User enter {string} in the search text box field which can result in multiple products")
    public void user_enter_search_criteria_in_the_search_text_box_field_which_can_result_in_multiple_products(String searchText) {
        homePage.enterTextIntoSearchField(searchText);
    }
    @Then("More than one product should be displayed")
    public void more_than_one_product_should_be_displayed() {
        Assert.assertNotEquals(1,searchResultsPage.getMultipleProducts().size());
    }
    @When("Enter any existing product name {string} into the search criteria text box field")
    public void enter_any_existing_product_name_into_the_search_criteria_text_box_field(String existingProductName) {
       searchResultsPage.enterProductNameIntoSearchCriteriaTextBox(existingProductName);
    }
    @When("Click on search button")
    public void click_on_search_button() {
        searchResultsPage.clickOnSearchButton();
    }
}
