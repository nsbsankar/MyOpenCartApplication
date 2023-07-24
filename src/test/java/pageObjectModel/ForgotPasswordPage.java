package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.CommonUtils;
import utils.ElementUtils;

public class ForgotPasswordPage extends BasePage{

    ElementUtils elementUtils;
    public ForgotPasswordPage(WebDriver driver) {
        super(driver);
        elementUtils = new ElementUtils(driver);

    }

    //Elements

    @FindBy(xpath = "//div[@id='content']/h1")
    private WebElement headingForgotPassword;

    //Action Methods

    public String getTextForgotPassword(){
      return  elementUtils.getTextFromElement(headingForgotPassword, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }
}
