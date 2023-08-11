package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.CommonUtils;
import utils.ElementUtils;

import java.util.Collection;

public class ProductDisplayPage extends BasePage{
    ElementUtils elementUtils;
    public ProductDisplayPage(WebDriver driver){
        super(driver);
        elementUtils = new ElementUtils(driver);
    }
    //WebElements
    @FindBy(xpath = "//a[text()='Description']")
    private WebElement tabDescription;

    @FindBy(xpath = "//i[@class='fa fa-home']")
    private WebElement lnkHomeIconInBreadCrumb;

    //ActionMethods
    public String getTextFromDescriptionTab(){
       return elementUtils.getTextFromElement(tabDescription, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }
    public void clickOnHomeIconInBreadCrumb(){
        elementUtils.clickOnElement(lnkHomeIconInBreadCrumb,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }
}
