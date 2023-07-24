package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.CommonUtils;
import utils.ElementUtils;

public class AccountSuccessPage extends BasePage{
    ElementUtils elementUtils;

    public AccountSuccessPage(WebDriver driver) {
        super(driver);
        elementUtils = new ElementUtils(driver);
    }

    //Elements
    @FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
    private WebElement msgAccountCreated;

    @FindBy(linkText = "Continue")
    private WebElement btnContinue;

    //Action Methods

    public String getSuccessMsg(){
        return elementUtils.getTextFromElement(msgAccountCreated, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
      // return msgAccountCreated.getText();
    }

    public AccountPage clickOnContinue(){
        elementUtils.clickOnElement(btnContinue,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
       // btnContinue.click();
        return new AccountPage(driver);
    }
}
