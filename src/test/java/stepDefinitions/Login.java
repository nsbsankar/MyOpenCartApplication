package stepDefinitions;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageObjectModel.*;

import java.util.List;

public class Login {

    WebDriver driver;
    HomePage homePage;
    LoginPage loginPage;
    AccountPage accountPage;
    ForgotPasswordPage forgotPasswordPage;
    ChangePasswordPage changePasswordPage;
    AccountLogoutPage accountLogoutPage;
    @Given("User clicks on the My Account dropdown and clicks on Login option")
    public void user_clicks_on_the_my_account_dropdown_and_clicks_on_login_option() {
        driver = DriverFactory.getDriver();
        homePage = new HomePage(driver);
        homePage.clickOnMyAccountDropdownMenu();
        loginPage = homePage.clickOnLoginOption();
    }
    @Then("User should see Login page")
    public void user_should_see_login_page() {

       Assert.assertEquals("Account Login", driver.getTitle());
        //Assert.assertTrue(loginPage.isDisplayedLoginLinkInBreadCrumb());
    }
    @When("User enters Valid Email id {string}")
    public void user_enters_valid_email_id(String email) {

        loginPage.enterEmailAddress(email);
    }
    @When("User enters Valid Password {string}")
    public void user_enters_valid_password(String password) {

        loginPage.enterPassword(password);
    }
    @When("Clicks on Login")
    public void clicks_on_login() {

         accountPage = loginPage.clickOnLoginButton();
    }
    @Then("User should get logged in and taken to Account page")
    public void user_should_get_logged_in_and_taken_to_account_page() {

       Assert.assertEquals("Login unsuccessful","My Account",accountPage.getHeadingMyAccount());
    }

    @When("User enters Invalid Email id {string}")
    public void user_enters_invalid_email_id(String invalidEmail) {
        loginPage.enterEmailAddress(invalidEmail);
    }
    @When("User enters Invalid Password {string}")
    public void user_enters_invalid_password(String invalidPassword) {

        loginPage.enterPassword(invalidPassword);
    }
    @Then("User should get {string} warning message")
    public void user_should_get_warning_message(String loginWarningMsg) {

        Assert.assertEquals("login warning not displayed",loginWarningMsg,loginPage.getLoginWarningMsg());
    }

    @When("User clicks on login without entering Email and Password")
    public void User_clicks_on_login_without_entering_Email_and_Password(){
        loginPage.clickOnLoginButton();
    }

    @Then("Forgotten Password link should be displayed")
    public void forgotten_password_link_should_be_displayed() {

        Assert.assertTrue(loginPage.isDisplayedForgotPasswordLink());
    }
    @When("User clicks on the Forgotten Password link")
    public void user_clicks_on_the_forgotten_password_link() {
         forgotPasswordPage = loginPage.clickOnForgotPasswordLink();
    }
    @Then("User should navigate to forgot password page")
    public void user_should_navigate_to_forgot_password_page() {

        Assert.assertEquals("Forgot password text not displayed","Forgot Your Password?",forgotPasswordPage.getTextForgotPassword());
    }

    @Then("User should see Place holder text for E-Mail Address and Password text fields")
    public void user_should_see_place_holder_text_for_e_mail_address_and_password_text_fields() {

        Assert.assertEquals("E-Mail Address",loginPage.getEmailPlaceholder());
        Assert.assertEquals("Password",loginPage.getPasswordPlaceholder());
    }
    @When("Clicks on Login for {int} times")
    public void clicks_on_login_for_times(Integer attemps) {
       for(int i=0; i<=attemps;i++){
           loginPage.clickOnLoginButton();
       }
    }
    @Then("User should see {string} warning msg.")
    public void user_should_see_warning_msg(String unsuccessfulLoginattempsWarning) {
        Assert.assertEquals(unsuccessfulLoginattempsWarning,loginPage.getUnsuccesfulLoginWarningmsg());
    }

    @When("User login into the application below valid credentials")
    public void user_login_into_the_application_below_valid_credentials(DataTable dataTable) throws InterruptedException {
        List<List<String>> credentials = dataTable.asLists();
        loginPage.enterEmailAddress(credentials.get(0).get(0));
        loginPage.enterPassword(credentials.get(0).get(1));
         accountPage = loginPage.clickOnLoginButton();
        Thread.sleep(2000);
    }
    @When("Clicks on Change your Password")
    public void clicks_on_change_your_password() {

         changePasswordPage = accountPage.clickOnChangePassword();
    }
    @When("Enters new password {string} into Password and Confirm Password fields")
    public void enters_new_password_into_password_and_confirm_password_fields(String newPassword) {
        changePasswordPage.enterNewPassword(newPassword);
        changePasswordPage.enterNewPasswordConfirm(newPassword);
    }
    @When("Clicks on Continue button")
    public void clicks_on_continue_button() {
        changePasswordPage.clickOnContinue();
    }
    @When("User clicks on the My Account dropdown and clicks on Logout option")
    public void user_clicks_on_the_my_account_dropdown_and_clicks_on_logout_option() {
        changePasswordPage.clickOnMyAccountMenu();
        accountLogoutPage = changePasswordPage.clickOnLogoutOption();

    }
    @When("User login into the application with old password")
    public void user_login_into_the_application_with_old_password(DataTable dataTable) {
        accountLogoutPage.clickOnMyAccountMenu();
        accountLogoutPage.clickOnLoginOption();

        List<List<String>> oldPasswordCred = dataTable.asLists();
        loginPage.enterEmailAddress(oldPasswordCred.get(0).get(0));
        loginPage.enterPassword(oldPasswordCred.get(0).get(1));
        loginPage.clickOnLoginButton();
    }
    @Then("User should not login into the application")
    public void user_should_not_login_into_the_application() {
        Assert.assertEquals("Warning: No match for E-Mail Address and/or Password.",loginPage.getUnsuccesfulLoginWarningmsg());
    }
    @When("User login into the application with new password")
    public void user_login_into_the_application_with_new_password(DataTable dataTable) {
        List<List<String>> newPasswordCred = dataTable.asLists();
        loginPage.enterEmailAddress(newPasswordCred.get(0).get(0));
        loginPage.enterPassword(newPasswordCred.get(0).get(1));
        loginPage.clickOnLoginButton();
    }
    @Then("User should login into the application")
    public void user_should_login_into_the_application() {

        Assert.assertEquals("My Account",accountPage.getHeadingMyAccount());
    }

}
