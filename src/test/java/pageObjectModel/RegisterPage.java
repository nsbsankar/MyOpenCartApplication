package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.CommonUtils;
import utils.ElementUtils;

import java.util.List;

public class RegisterPage extends BasePage{

    ElementUtils elementUtils;
    public RegisterPage(WebDriver driver) {
        super(driver);
        elementUtils = new ElementUtils(driver);
    }

    //Elements
    @FindBy(id = "input-firstname")
    private WebElement txtFirstName;

    @FindBy(id = "input-lastname")
    private WebElement txtLastName;

    @FindBy(id = "input-email")
    private WebElement txtEmail;

    @FindBy(id = "input-telephone")
    private WebElement txtTelephone;

    @FindBy(id = "input-password")
    private WebElement txtPassword;

    @FindBy(id = "input-confirm")
    private WebElement txtConfirmPassword;

    @FindBy(xpath = "//label[text()='Yes']")
    private WebElement radioNewsletterYes;

    @FindBy(xpath = "//label[text()='No']")
    private WebElement radioNewsletterNo;

    @FindBy(xpath = "//input[@name='agree']")
    private WebElement chkPolicy;

    @FindBy(xpath = "//a[@class='agree']")
    private WebElement lnkPrivacyPolicy;

    @FindBy(xpath = "//input[@value='Continue']")
    private WebElement btnContinue;

    @FindBy(xpath = "//input[@id='input-firstname']/following-sibling::div")
    private WebElement msgFirstNameWarning;

    @FindBy(xpath = "//input[@id='input-lastname']/following-sibling::div")
    private WebElement msgLastNameWarning;

    @FindBy(xpath = "//input[@id='input-email']/following-sibling::div")
    private WebElement msgEmailWarning;

    @FindBy(xpath = "//input[@id='input-telephone']/following-sibling::div")
    private WebElement msgTelephoneWarning;

    @FindBy(xpath = "//input[@id='input-password']/following-sibling::div")
    private WebElement msgPasswordWarning;

    @FindBy(xpath = "//input[@id='input-confirm']/following-sibling::div")
    private WebElement msgPasswordConfirmWarning;

    @FindBy(xpath = "//div[contains(@class,'alert-danger')]")
    private WebElement msgPrivacyPolicyWarning;

    @FindBy(xpath = "//div[@id='account-register']/div[contains(@class,'alert-danger')]")
    private WebElement msgExistingEmailWarning;

    @FindBy(xpath = "//div[@class='list-group']/a")
    private List<WebElement> rightColumnOptions;

    //Action methods

    public void enterFirstName(String firstName){
        elementUtils.enterTextIntoElement(txtFirstName,firstName, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
        //txtFirstName.sendKeys(firstName);
    }
    public void switchToNextElementFromFirstName(){

        elementUtils.switchingToNextElement(txtFirstName,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }
    public void enterLastName(String lastName){
        elementUtils.enterTextIntoElement(txtLastName,lastName,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
        //txtLastName.sendKeys(lastName);
    }

    public void switchToNextElementFromLastName(){

        elementUtils.switchingToNextElement(txtLastName,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }

    public void enterEmail(String email){
        elementUtils.enterTextIntoElement(txtEmail,email,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
       // txtEmail.sendKeys(email);
    }
    public void switchToNextElementFromEmail(){

        elementUtils.switchingToNextElement(txtEmail,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }

    public void enterTelephone(String telephone){
        elementUtils.enterTextIntoElement(txtTelephone,telephone,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
       // txtTelephone.sendKeys(telephone);
    }

    public void switchToNextElementFromTelephone(){

        elementUtils.switchingToNextElement(txtTelephone,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }

    public void enterPassword(String password){
        elementUtils.enterTextIntoElement(txtPassword,password,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
        //txtPassword.sendKeys(password);
    }
    public void switchToNextElementFromPassword(){

        elementUtils.switchingToNextElement(txtPassword,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }

    public void enterConfirmPassword(String confirmPassword){
        elementUtils.enterTextIntoElement(txtConfirmPassword,confirmPassword,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
        //txtConfirmPassword.sendKeys(confirmPassword);
    }
    public void switchToNextElementFromConfirmPassword(){

        elementUtils.switchingToNextElement(txtConfirmPassword,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }

    public void clickOnNewsletterYes(){
        elementUtils.clickOnElement(radioNewsletterYes,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
        //radioNewsletterYes.click();
    }

    public void clickOnNewsletterNo(){
        elementUtils.clickOnElement(radioNewsletterNo,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
        //radioNewsletterNo.click();
    }
    public void switchToNextElementFromNewsletter(){

        elementUtils.switchingToNextElement(radioNewsletterNo,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }
    public void switchToNextElementFromPrivacyPolicyLink(){

        elementUtils.switchingToNextElement(lnkPrivacyPolicy,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }

    public void clickOnPolicyChkBox(){
        elementUtils.clickOnElement(chkPolicy,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
        //chkPolicy.click();
    }


    public AccountSuccessPage clickOnContinue(){
        elementUtils.clickOnElement(btnContinue,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
        //btnContinue.click();
        return new AccountSuccessPage(driver);
    }

    public String getFirstNameWarningMsg(){
        return elementUtils.getTextFromElement(msgFirstNameWarning,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }

    public String getLastNameWarningMsg(){
        return elementUtils.getTextFromElement(msgLastNameWarning,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }

    public String getEmailWarningMsg(){
        return elementUtils.getTextFromElement(msgEmailWarning,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }

    public String getTelephoneWarningMsg(){
        return elementUtils.getTextFromElement(msgTelephoneWarning,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }

    public String getPasswordWarningMsg(){
        return elementUtils.getTextFromElement(msgPasswordWarning,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }

    public String getPrivacyPolicyWarningMsg(){
        return elementUtils.getTextFromElement(msgPrivacyPolicyWarning,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }

    public String getPasswordConfirmWarningMsg(){
        return elementUtils.getTextFromElement(msgPasswordConfirmWarning,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }

    public String getExistingEmailWarningMsg(){
        return elementUtils.getTextFromElement(msgExistingEmailWarning,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }

    public String getTextFromEmailTooltip(){
        return elementUtils.getTextFromHTMLInfoTooltip(txtEmail);
    }

    public boolean isOptionDisplayedOnRightColumnOption(String option){
       return elementUtils.isOptionDisplayed(rightColumnOptions,CommonUtils.EXPLICIT_WAIT_BASIC_TIME,option);
    }
}
