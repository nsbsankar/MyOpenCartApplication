package stepDefinitions;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.checkerframework.checker.units.qual.C;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageObjectModel.*;
import utils.CommonUtils;

import java.util.Map;

public class Register {

    WebDriver driver;
    HomePage homePage;
    RegisterPage registerPage;
    AccountSuccessPage accountSuccessPage;
    AccountPage accountPage;
    NewsletterPage newsletterPage;
    LoginPage loginPage;

    @Given("User is on the Open Cart Home page")
    public void user_is_on_the_open_cart_home_page() {

        driver = DriverFactory.getDriver();
        homePage = new HomePage(driver);
    }

    @When("User clicks on the My Account dropdown menu and clicks on Register option")
    public void user_clicks_on_the_my_account_dropdown_menu_and_clicks_on_register_option() {
        try {
            homePage.clickOnMyAccountDropdownMenu();
            registerPage = homePage.clickOnRegisterOption();
        } catch (Throwable e) {
            e.printStackTrace();
        }

    }

    @When("Enters new account details into the mandatory fields")
    public void enters_new_account_details_into_the_mandatory_fields() {
        try {
            registerPage.enterFirstName(CommonUtils.generateRandomdata().name().firstName());
            registerPage.enterLastName(CommonUtils.generateRandomdata().name().lastName());
            registerPage.enterEmail(CommonUtils.generateRandomdata().internet().emailAddress());
            registerPage.enterTelephone(String.valueOf(CommonUtils.generateRandomdata().phoneNumber().cellPhone()));
            String Password = CommonUtils.generateRandomdata().internet().password(4, 10, true, true, true);
            registerPage.enterPassword(Password);
            registerPage.enterConfirmPassword(Password);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    @When("Clicks on privacy policy checkbox")
    public void clicks_on_privacy_policy_checkbox() {
        try {
            registerPage.clickOnPolicyChkBox();
        } catch (Throwable e) {
            e.printStackTrace();
        }

    }

    @When("Clicks on Continue")
    public void clicks_on_continue() throws InterruptedException {
        try {
            accountSuccessPage = registerPage.clickOnContinue();
        } catch (Throwable e) {
            e.printStackTrace();
        }

    }

    @Then("User should be logged in, taken to account success page and {string} should be displayed")
    public void user_should_be_logged_in_taken_to_account_success_page_and_should_be_displayed(String successMsg) throws InterruptedException {


        Assert.assertEquals(successMsg, accountSuccessPage.getSuccessMsg());
    }

    @When("User clicks on Continue in the account success page")
    public void user_clicks_on_continue_in_the_account_success_page() {

        accountPage = accountSuccessPage.clickOnContinue();
    }

    @Then("User should be taken to account page and {string} text should be displayed")
    public void user_should_be_taken_to_account_page_and_text_should_be_displayed(String headingMyAccount) {

        Assert.assertEquals(headingMyAccount, accountPage.getHeadingMyAccount());
    }

    @When("Select Yes for Newsletter")
    public void select_yes_for_newsletter() {
        registerPage.clickOnNewsletterYes();
    }

    @When("Select No for Newsletter")
    public void select_no_for_newsletter() {
        registerPage.clickOnNewsletterNo();
    }

    @Then("Below warning messages should be displayed for the respective fields")
    public void below_warning_messages_should_be_displayed_for_the_respective_fields(DataTable dataTable) {

        Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
        try {
            Assert.assertEquals(dataMap.get("First Name"), registerPage.getFirstNameWarningMsg());
            Assert.assertEquals(dataMap.get("Last Name"), registerPage.getLastNameWarningMsg());
            Assert.assertEquals(dataMap.get("Email"), registerPage.getEmailWarningMsg());
            Assert.assertEquals(dataMap.get("Telephone"), registerPage.getTelephoneWarningMsg());
            Assert.assertEquals(dataMap.get("Password"), registerPage.getPasswordWarningMsg());
            Assert.assertEquals(dataMap.get("Privacy Policy"), registerPage.getPrivacyPolicyWarningMsg());
        }catch (Throwable t){
            t.printStackTrace();
        }

    }

    @Then("User should be taken to account page and clicks on Subscribe or unsubscribe to newsletter")
    public void user_should_be_taken_to_account_page_and_clicks_on_subscribe_unsubscribe_to_newsletter() {

        try {
            Assert.assertEquals("My Account",driver.getTitle());
            newsletterPage = accountPage.clickOnSubscribeOrUnsubscribeToNewsletter();
        }catch (Throwable t){
            t.printStackTrace();
        }


    }
    @Then("Yes option should be selected in the newsletter page")
    public void yes_option_should_be_selected_in_the_newsletter_page() {

        Assert.assertEquals(true,newsletterPage.isSelectedYesForNewsletter());

    }
    @Then("No option should be selected in the newsletter page")
    public void no_option_should_be_selected_in_the_newsletter_page() {

        Assert.assertEquals(true,newsletterPage.isSelectedNoForNewsletter());

    }
    @Then("User should navigate to Register Account page")
    public void user_should_navigate_to_register_account_page() {

        Assert.assertEquals("Register Account",driver.getTitle());
    }
    @When("User clicks on the My Account dropdown menu and clicks on Login Option")
    public void user_clicks_on_the_my_account_dropdown_menu_and_clicks_on_login_option() {

        homePage.clickOnMyAccountDropdownMenu();
        loginPage = homePage.clickOnLoginOption();

    }
    @When("Clicks on Continue inside New Customer Box")
    public void clicks_on_continue_inside_new_customer_box() {
       loginPage.clickOnContinueInsideNewCustomerBox();
    }
    @When("Clicks on Register option from the right coloumn options")
    public void clicks_on_register_option_from_the_right_coloumn_options() {

        loginPage.clickOnRegisterFromTheRightColumnOptions();
    }

    @When("Enters new account details into the mandatory fields except password and password confirm fields")
    public void enters_new_account_details_into_the_mandatory_fields_except_password_and_password_confirm_fields() {
        registerPage.enterFirstName(CommonUtils.generateRandomdata().name().firstName());
        registerPage.enterLastName(CommonUtils.generateRandomdata().name().lastName());
        registerPage.enterEmail(CommonUtils.generateRandomdata().internet().emailAddress());
        registerPage.enterTelephone(CommonUtils.generateRandomdata().phoneNumber().cellPhone());
        registerPage.clickOnPolicyChkBox();
    }
    @When("Enter Different passwords in both password and password confirm fields")
    public void enter_different_passwords_in_both_password_and_password_confirm_fields() {

        registerPage.enterPassword(CommonUtils.generateRandomdata().internet().password());
        registerPage.enterConfirmPassword(CommonUtils.generateRandomdata().internet().password());
    }
    @Then("User should see {string} warning message")
    public void user_should_see_warning_message(String passwordConfirmWarningMsg) {

       Assert.assertEquals(passwordConfirmWarningMsg,registerPage.getPasswordConfirmWarningMsg());
    }

    @When("Enters new account details with existing Email id {string}")
    public void enters_new_account_details_with_existing_email_id(String existingEmail) {
        registerPage.enterFirstName(CommonUtils.generateRandomdata().name().firstName());
        registerPage.enterLastName(CommonUtils.generateRandomdata().name().lastName());
        registerPage.enterEmail(existingEmail);
        registerPage.enterTelephone(CommonUtils.generateRandomdata().phoneNumber().cellPhone());
        String password = CommonUtils.generateRandomdata().internet().password();
        registerPage.enterPassword(password);
        registerPage.enterConfirmPassword(password);
    }
    @Then("User should see the {string} warning message")
    public void user_should_see_the_warning_message(String existingEmailWarningMsg) {

        Assert.assertEquals(existingEmailWarningMsg,registerPage.getExistingEmailWarningMsg());
    }
    @When("Enters new account details into the mandatory fields with {string}")
    public void enters_new_account_details_into_the_mandatory_fields_with(String invalidEmail) {

        registerPage.enterFirstName(CommonUtils.generateRandomdata().name().firstName());
        registerPage.enterLastName(CommonUtils.generateRandomdata().name().lastName());
        registerPage.enterEmail(invalidEmail);
        registerPage.enterTelephone(CommonUtils.generateRandomdata().phoneNumber().cellPhone());
        String password = CommonUtils.generateRandomdata().internet().password();
        registerPage.enterPassword(password);
        registerPage.enterConfirmPassword(password);
    }
    @Then("User should see Proper {string}")
    public void user_should_see_proper(String warningMsg) {

        Assert.assertEquals(warningMsg,registerPage.getTextFromEmailTooltip());
    }
    @When("Enters new account details using keyboard keys")
    public void enters_new_account_details_using_keyboard_keys() {

        registerPage.enterFirstName(CommonUtils.generateRandomdata().name().firstName());
        registerPage.switchToNextElementFromFirstName();
        registerPage.enterLastName(CommonUtils.generateRandomdata().name().lastName());
        registerPage.switchToNextElementFromLastName();
        registerPage.enterEmail(CommonUtils.generateRandomdata().internet().emailAddress());
        registerPage.switchToNextElementFromEmail();
        registerPage.enterTelephone(CommonUtils.generateRandomdata().phoneNumber().cellPhone());
        registerPage.switchToNextElementFromTelephone();
        String password = CommonUtils.generateRandomdata().internet().password();
        registerPage.enterPassword(password);
        registerPage.switchToNextElementFromPassword();
        registerPage.enterConfirmPassword(password);
//        registerPage.switchToNextElementFromConfirmPassword();
//        registerPage.switchToNextElementFromNewsletter();
//        registerPage.switchToNextElementFromPrivacyPolicyLink();

    }

}
