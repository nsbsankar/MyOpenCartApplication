package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.CommonUtils;
import utils.ElementUtils;

import java.nio.file.WatchEvent;
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

    @FindBy(name = "category_id")
    private WebElement drpdwnAllCategories;

    @FindBy(xpath = "//input[@name='sub_category']")
    private WebElement chkbxSubCategories;

    @FindBy(id = "list-view")
    private WebElement btnListView;

    @FindBy(xpath = "//div[contains(@class,'product-list')]/div")
    private WebElement singleProductInList;

    @FindBy(xpath = "//div[contains(@class,'product-list')]//div/a")
    private WebElement imgSingleProductInList;

    @FindBy(id = "grid-view")
    private WebElement btnGridView;

    @FindBy(xpath = "//div[contains(@class,'product-grid')]/div")
    private WebElement singleProductInGrid;

    @FindBy(xpath = "//div[contains(@class,'product-grid')]//div/h4/a")
    private WebElement singleProductNameInGrid;
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

    public void clickOnAllCategoriesDropDown(){
        elementUtils.clickOnElement(drpdwnAllCategories,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }

    public void selectOptionInCategoryDropdownUsingValue(String categoryOptionValue){
        elementUtils.selectOptionInDropdownByValue(drpdwnAllCategories,categoryOptionValue,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }
    public void selectOptionInCategoryDropdown(String categoryOption){
        elementUtils.selectOptionInDropdownByVisibleText(drpdwnAllCategories,categoryOption,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }
    public void clickOnSubCategoriesCheckBox(){
        elementUtils.clickOnElement(chkbxSubCategories,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }
    public void clickOnListViewButton(){
        elementUtils.clickOnElement(btnListView,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }
    public boolean isSingleProductDisplayedInList(){
        return elementUtils.displayStatusOfElement(singleProductInList,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }
    public ProductDisplayPage clickOnImageOfTheSingleProductInList(){
        elementUtils.clickOnElement(imgSingleProductInList,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
        return new ProductDisplayPage(driver);
    }
    public void clickOnGridViewButton(){
        elementUtils.clickOnElement(btnGridView,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }
    public boolean isSingleProductDisplayedInGrid(){
       return elementUtils.displayStatusOfElement(singleProductInGrid,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }
    public void clickOnNameOfThenSingleProductInGrid(){
        elementUtils.clickOnElement(singleProductNameInGrid,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }
}
