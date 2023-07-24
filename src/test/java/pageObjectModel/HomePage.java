package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.CommonUtils;
import utils.ElementUtils;

public class HomePage extends BasePage{

    ElementUtils elementUtils;
    public HomePage(WebDriver driver){
        super(driver);
        elementUtils = new ElementUtils(driver);
    }

    // Elements
    @FindBy(xpath = "//a[@title='My Account']")
    private WebElement lnkMyAccount;

    @FindBy(linkText = "Register")
    private WebElement lnkRegister;

    @FindBy(linkText = "Login")
    private WebElement lnkLogin;

    //Action methods

    public void clickOnMyAccountDropdownMenu(){
        elementUtils.clickOnElement(lnkMyAccount, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
        //lnkMyAccount.click();
    }

    public RegisterPage clickOnRegisterOption(){
        elementUtils.clickOnElement(lnkRegister,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
       // lnkRegister.click();
        return new RegisterPage(driver);
    }

    public LoginPage clickOnLoginOption(){
        elementUtils.clickOnElement(lnkLogin,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
        return new LoginPage(driver);
    }

}
