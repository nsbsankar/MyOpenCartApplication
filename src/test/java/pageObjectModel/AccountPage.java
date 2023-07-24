package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.CommonUtils;
import utils.ElementUtils;

public class AccountPage extends BasePage{
    ElementUtils elementUtils;
    public AccountPage(WebDriver driver) {
        super(driver);
        elementUtils = new ElementUtils(driver);
    }

    //Elements
    @FindBy(xpath = "//h2[text()='My Account']")
    private WebElement headingMyAccount;

    @FindBy(linkText = "Subscribe / unsubscribe to newsletter")
    private WebElement lnkSubscribeOrUnsubscribeToNewsletter;

    @FindBy(linkText = "Change your password")
    private WebElement lnkChangePassword;

    @FindBy(xpath = "//span[text()='My Account']")
    private WebElement lnkMyAccountDropmenu;

    @FindBy(linkText = "Logout")
    private WebElement lnkLogoutOption;

    //Action Methods
    public String getHeadingMyAccount(){
        return elementUtils.getTextFromElement(headingMyAccount, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
       // return headingMyAccount.getText();
    }

    public NewsletterPage clickOnSubscribeOrUnsubscribeToNewsletter(){
        elementUtils.clickOnElement(lnkSubscribeOrUnsubscribeToNewsletter,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
        return new NewsletterPage(driver);
    }

    public ChangePasswordPage clickOnChangePassword(){
        elementUtils.clickOnElement(lnkChangePassword,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
        return new ChangePasswordPage(driver);
    }

    public void clickOnMyAccountDropmenu(){
        elementUtils.clickOnElement(lnkMyAccountDropmenu,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }

    public AccountLogoutPage clickOnLogoutOption(){
        elementUtils.clickOnElement(lnkLogoutOption,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
        return new AccountLogoutPage(driver);
    }
}
