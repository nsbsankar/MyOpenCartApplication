package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.CommonUtils;
import utils.ElementUtils;

public class SearchResultsPage extends BasePage{
    ElementUtils elementUtils;
    public SearchResultsPage(WebDriver driver){
        super(driver);
        elementUtils = new ElementUtils(driver);
    }

    //Elements

    @FindBy(linkText = "iMac")
    private WebElement lnkiMac;

    @FindBy(xpath = "//p[contains(text(),'There is no product that matches the search criter')]")
    private WebElement textNoProductMatch;

    //Action Methods
    public String getTextFromSearchResultiMac(){
        return elementUtils.getTextFromElement(lnkiMac, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }
    public String getTextFromNoProductMatchText(){
        return elementUtils.getTextFromElement(textNoProductMatch,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }
}
