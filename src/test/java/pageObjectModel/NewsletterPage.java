package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.ElementUtils;

public class NewsletterPage extends BasePage{

    ElementUtils elementUtils;
    public NewsletterPage(WebDriver driver) {
        super(driver);
        elementUtils = new ElementUtils(driver);
    }
    //Elements
    @FindBy(xpath = "//div[@id='content']//div[@class='col-sm-10']/label[1]/input")
    private WebElement radioYes;

    @FindBy(xpath = "//div[@id='content']//div[@class='col-sm-10']/label[2]/input")
    private WebElement radioNo;

    public boolean isSelectedYesForNewsletter(){
       return radioYes.isSelected();
    }

    public boolean isSelectedNoForNewsletter(){
        return radioNo.isSelected();
    }

}
