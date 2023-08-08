package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.CommonUtils;
import utils.ElementUtils;

import java.util.List;

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

    @FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']/li")
    private List<WebElement> drpdwnMyaccount;

    @FindBy(name = "search")
    private WebElement txtSearchField;

    @FindBy(xpath = "//span[@class='input-group-btn']/button")
    private WebElement btnSearchIcon;

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
    public boolean isOptionDisplayed(String option){
       return elementUtils.isOptionDisplayed(drpdwnMyaccount,CommonUtils.EXPLICIT_WAIT_BASIC_TIME,option);
    }
    public void enterTextIntoSearchField(String productName){
        elementUtils.enterTextIntoElement(txtSearchField,productName,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }

    public SearchResultsPage clickOnSearchIconButton(){
        elementUtils.clickOnElement(btnSearchIcon,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
        return new SearchResultsPage(driver);
    }

}
