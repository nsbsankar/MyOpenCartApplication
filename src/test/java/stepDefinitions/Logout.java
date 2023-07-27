package stepDefinitions;

import factory.DriverFactory;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageObjectModel.*;
import utils.ConfigReader;
import utils.ElementUtils;

public class Logout {

    WebDriver driver;
    HomePage homePage;
    LoginPage loginPage;
    AccountPage accountPage;
    AccountLogoutPage accountLogoutPage;
    RegisterPage registerPage;

    @Given("User is on the Open Cart Home page for logout feature")
    public void user_is_on_the_open_cart_home_page_for_logout_feature() {
        driver = DriverFactory.getDriver();
        homePage = new HomePage(driver);
    }

    @Given("User is logged into the application with email {string} and password {string}")
    public void user_is_logged_into_the_application_with_email_and_password(String email, String password) {

         homePage.clickOnMyAccountDropdownMenu();
         loginPage = homePage.clickOnLoginOption();
         loginPage.enterEmailAddress(email);
         loginPage.enterPassword(password);
         accountPage = loginPage.clickOnLoginButton();
    }
    @When("User clicks on the My Account dropdown and clicks on Logout option on Account page")
    public void user_clicks_on_the_my_account_dropdown_and_clicks_on_logout_option_on_Account_page() {

        accountPage.clickOnMyAccountDropmenu();
        accountLogoutPage = accountPage.clickOnLogoutOption();

    }
    @Then("User should should be taken to {string} page")
    public void user_should_should_be_taken_to_page(String pageTitle) {

        Assert.assertEquals(pageTitle,driver.getTitle());
    }
    @Then("User should see Login option in My Account dropmenu")
    public void user_should_see_login_option_in_my_account_dropmenu() {
        accountLogoutPage.clickOnMyAccountMenu();
        Assert.assertTrue(accountLogoutPage.isDisplayedLoginOptionInMyAccountDropmenu());
    }
    @When("User clicks on continue in the logout page")
    public void user_clicks_on_continue_in_the_logout_page() {
         homePage = accountLogoutPage.clickOnContinue();
    }
    @Then("User should taken to Home page")
    public void user_should_taken_to_home_page() {
       Assert.assertEquals("Your Store",driver.getTitle());
    }

    @When("User clicks on Logout from the Right Column option")
    public void user_clicks_on_logout_from_the_right_column_option() {
         accountLogoutPage = accountPage.clickOnLogoutInRightColumn();
    }

    @When("User closes the browser without logout and opens the browser and navigate to the application")
    public void user_closes_the_browser_without_logout_and_opens_the_browser_and_navigate_to_the_application() {
        String accountPageURL = driver.getCurrentUrl();
        System.out.println("URL = "+accountPageURL);
        driver.close();
        WebDriver driver1 = DriverFactory.intializeBrowser(ConfigReader.intializeProperties().getProperty("Browser"));
       driver1.get(accountPageURL);
    }
    @Then("Application should not get logged out")
    public void application_should_not_get_logged_out() {
       // Assert.assertTrue(accountPage.isDisplayedLogoutOptionInRightColumn());
    }

    @When("User clicks on Browser back button")
    public void user_clicks_on_browser_back_button() {
        accountLogoutPage.navigate("backward");
    }
    @Then("User should not get logged in")
    public void user_should_not_get_logged_in() {
        Assert.assertEquals("User should navigate to home page","Your Store",driver.getTitle());
    }

    @When("User clicks on the My Account dropdown in home page")
    public void user_clicks_on_the_my_account_dropdown_in_home_page() {
         driver = DriverFactory.getDriver();
        homePage = new HomePage(driver);
      homePage.clickOnMyAccountDropdownMenu();
    }
    @Then("{string} option should not be displayed")
    public void logout_option_should_not_be_displayed(String option) throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertFalse(homePage.isOptionDisplayed(option));
    }

    @When("User clicks on the My Account dropdown menu and clicks on Register option for logout feature")
    public void user_clicks_on_the_my_account_dropdown_menu_and_clicks_on_register_option_for_logout_feature() {
        homePage.clickOnMyAccountDropdownMenu();
        registerPage = homePage.clickOnRegisterOption();
    }
    @Then("{string} option should not be displayed in the right column options")
    public void option_should_not_be_displayed_in_the_right_column_options(String option) {
        Assert.assertFalse(registerPage.isOptionDisplayedOnRightColumnOption(option));
    }

    @When("clicks on Login option in the My Account menu")
    public void clicks_on_login_option_in_the_my_account_menu() {
        accountLogoutPage.clickOnMyAccountMenu();
        loginPage = accountLogoutPage.clickOnLoginOption();
    }
    @Then("Login should be successful")
    public void login_should_be_successful() {
       Assert.assertEquals("My Account",accountPage.getHeadingMyAccount());
    }
}
