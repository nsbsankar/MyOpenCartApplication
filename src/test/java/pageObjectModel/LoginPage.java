package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.CommonUtils;
import utils.ElementUtils;

public class LoginPage extends BasePage{

    ElementUtils elementUtils;
    public LoginPage(WebDriver driver){
        super(driver);
        elementUtils = new ElementUtils(driver);
    }

    //Elements
    @FindBy(xpath = "//a[@class='btn btn-primary'][normalize-space()='Continue']")
    private WebElement lnkContinue;

    @FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Register']")
    private WebElement lnkRegister;

    @FindBy(id = "input-email")
    private WebElement txtEmailAddress;

    @FindBy(id = "input-password")
    private WebElement txtPassword;

    @FindBy(xpath = "//input[@value='Login']")
    private WebElement btnLogin;

    @FindBy(linkText = "Login")
    private WebElement lnkLoginBreadCrumb;

    @FindBy(xpath = "//div[contains(@class,'alert-danger')]")
    private WebElement msgLoginWarning;

    @FindBy(linkText = "Forgotten Password")
    private WebElement lnkForgotPassword;

    @FindBy(xpath = "//div[contains(@class,'alert-danger')]")
    private WebElement msgUnsuccesfulLoginWarning;

    //Action Methods
    public void clickOnContinueInsideNewCustomerBox(){
        elementUtils.clickOnElement(lnkContinue, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }

    public void clickOnRegisterFromTheRightColumnOptions(){
        elementUtils.clickOnElement(lnkRegister,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }

    public void enterEmailAddress(String email){
        elementUtils.enterTextIntoElement(txtEmailAddress,email,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }

    public void enterPassword(String password){
        elementUtils.enterTextIntoElement(txtPassword,password,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }

    public AccountPage clickOnLoginButton(){
        elementUtils.clickOnElement(btnLogin,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
        return new AccountPage(driver);
    }
    public boolean isDisplayedLoginLinkInBreadCrumb(){
       return elementUtils.displayStatusOfElement(lnkLoginBreadCrumb,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }

    public String getLoginWarningMsg(){
       return elementUtils.getTextFromElement(msgLoginWarning,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }

    public boolean isDisplayedForgotPasswordLink(){
       return elementUtils.displayStatusOfElement(lnkForgotPassword,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }

    public ForgotPasswordPage clickOnForgotPasswordLink(){
        elementUtils.clickOnElement(lnkForgotPassword,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
        return new ForgotPasswordPage(driver);
    }

    public String getEmailPlaceholder(){
        return elementUtils.getPlaceholderTextFromElement(txtEmailAddress,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }

    public String getPasswordPlaceholder(){
        return elementUtils.getPlaceholderTextFromElement(txtPassword,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }

    public String getUnsuccesfulLoginWarningmsg(){
        return elementUtils.getTextFromElement(msgUnsuccesfulLoginWarning,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }

}
