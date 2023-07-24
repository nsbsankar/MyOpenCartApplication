package stepDefinitions;

import factory.DriverFactory;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageObjectModel.AccountLogoutPage;
import pageObjectModel.AccountPage;
import pageObjectModel.HomePage;
import pageObjectModel.LoginPage;

public class Logout {

    WebDriver driver;
    HomePage homePage;
    LoginPage loginPage;
    AccountPage accountPage;
    AccountLogoutPage accountLogoutPage;

    @Given("User is logged into the application with email {string} and password {string}")
    public void user_is_logged_into_the_application_with_email_and_password(String email, String password) {
         driver = DriverFactory.getDriver();
         homePage = new HomePage(driver);
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

}
