package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.CommonUtils;
import utils.ElementUtils;

import java.util.List;

public class SearchResultsPage extends BasePage{
    ElementUtils elementUtils;
    public SearchResultsPage(WebDriver driver){
        super(driver);
        elementUtils = new ElementUtils(driver);
    }

    //Elements

    @FindBy(xpath = "//div[@class='caption']/h4/a")
    private WebElement lnkProduct;

    @FindBy(xpath = "//p[contains(text(),'There is no product that matches the search criter')]")
    private WebElement textNoProductMatch;

    @FindBy(xpath = "//div[@id='content']//div[@class='row'][3]//div[@class='product-thumb']")
    private List<WebElement> multipleProducts;

    @FindBy(id = "input-search")
    private WebElement txtBxSearchCriteria;

    @FindBy(id = "button-search")
    private WebElement btnSearch;
    //Action Methods
    public String getTextFromSearchResult(){
        return elementUtils.getTextFromElement(lnkProduct, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }
    public String getTextFromNoProductMatchText(){
        return elementUtils.getTextFromElement(textNoProductMatch,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }
    public List<WebElement> getMultipleProducts(){
        return elementUtils.getListofElements(multipleProducts,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }
    public void enterProductNameIntoSearchCriteriaTextBox(String productName){
        elementUtils.enterTextIntoElement(txtBxSearchCriteria,productName,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }
    public void clickOnSearchButton(){
        elementUtils.clickOnElement(btnSearch,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }
}
