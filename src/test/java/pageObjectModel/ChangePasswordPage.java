package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.CommonUtils;
import utils.ElementUtils;

public class ChangePasswordPage extends BasePage {

    ElementUtils elementUtils;
    public ChangePasswordPage(WebDriver driver){
        super(driver);
        elementUtils = new ElementUtils(driver);
    }

    //Elements
    @FindBy(id = "input-password")
    private WebElement txtPassword;

    @FindBy(id = "input-confirm")
    private WebElement txtPasswordConfirm;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement btnContinue;

    @FindBy(xpath = "//span[text()='My Account']")
    private WebElement lnkMyAccountMenu;

    @FindBy(linkText = "Logout")
    private WebElement lnkLogoutOption;

    //Action Methods
    public void enterNewPassword(String newPassword){
        elementUtils.enterTextIntoElement(txtPassword, newPassword ,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }

    public void enterNewPasswordConfirm(String newPasswordConfirm){
        elementUtils.enterTextIntoElement(txtPasswordConfirm,newPasswordConfirm,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }

    public void clickOnContinue(){
        elementUtils.clickOnElement(btnContinue,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }

    public void clickOnMyAccountMenu(){
        elementUtils.clickOnElement(lnkMyAccountMenu,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }

    public AccountLogoutPage clickOnLogoutOption(){
        elementUtils.clickOnElement(lnkLogoutOption,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
        return new AccountLogoutPage(driver);
    }
}
