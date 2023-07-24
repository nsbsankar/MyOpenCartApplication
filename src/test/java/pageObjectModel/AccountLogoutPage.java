package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.CommonUtils;
import utils.ElementUtils;

public class AccountLogoutPage extends BasePage{

    ElementUtils elementUtils;
    public AccountLogoutPage(WebDriver driver){
        super(driver);
        elementUtils = new ElementUtils(driver);

    }

    //Elements
    @FindBy(xpath = "//span[text()='My Account']")
    private WebElement lnkMyAccountMenu;

    @FindBy(linkText = "Login")
    private WebElement lnkLoginOption;

    @FindBy(linkText = "Continue")
    private WebElement btnContinue;

    //Action Methods
    public void clickOnMyAccountMenu(){
        elementUtils.clickOnElement(lnkMyAccountMenu, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }

    public void clickOnLoginOption(){
        elementUtils.clickOnElement(lnkLoginOption, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }

    public boolean isDisplayedLoginOptionInMyAccountDropmenu(){
        return elementUtils.displayStatusOfElement(lnkLoginOption,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }

    public HomePage clickOnContinue(){
        elementUtils.clickOnElement(btnContinue, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
        return new HomePage(driver);
    }
}
