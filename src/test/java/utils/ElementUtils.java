package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ElementUtils {

    WebDriver driver;

    public ElementUtils(WebDriver driver) {
        this.driver = driver;
    }

    //wait for element to be clickable
    public WebElement waitForElementClickable(WebElement element, long DurationInSeconds) {

        WebElement webElement = null;
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DurationInSeconds));
            webElement = wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return webElement;
    }

    // Wait for element to be visible
    public WebElement waitForElementVisible(WebElement element, long DurationInSeconds) {

        WebElement webElement = null;
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DurationInSeconds));
            webElement = wait.until(ExpectedConditions.visibilityOf(element));
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return webElement;
    }

    public List<WebElement> waitForAllElementsVisible(List<WebElement> elementList, long DurationInSeconds){
        List<WebElement> webElements = null;
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DurationInSeconds));
            webElements = wait.until(ExpectedConditions.visibilityOfAllElements(elementList));
        }catch (Throwable t){
            t.printStackTrace();
        }
        return webElements;
    }

    // Wait for alert to be present
    public Alert waitForAlert(long DurationInSeconds){
        Alert alert = null;
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DurationInSeconds));
             alert = wait.until(ExpectedConditions.alertIsPresent());
        }catch (Throwable e){
            e.printStackTrace();
        }
        return alert;
    }

    // Method to click on Element
    public void clickOnElement(WebElement element,long DurationInSeconds){
        WebElement webElement = waitForElementClickable(element, DurationInSeconds);
        webElement.click();
    }

    // Method to enter text into an Element
    public void enterTextIntoElement(WebElement element,String textToBeTyped , long DurationInSeconds){

        WebElement webElement = waitForElementClickable(element, DurationInSeconds);
        webElement.click();
        webElement.clear();
        webElement.sendKeys(textToBeTyped);
    }

    // Method to select an option from select class dropdown
    public void selectOptionInDropdown(WebElement element,String dropdownOption,long DurationInSeconds){

        WebElement webElement = waitForElementClickable(element, DurationInSeconds);
        Select select = new Select(webElement);
        select.selectByVisibleText(dropdownOption);
    }

    // Method to click OK(Accept) on alert
    public void acceptAlert(long DurationInSeconds){
        Alert alert = waitForAlert(DurationInSeconds);
        alert.accept();
    }

    // Method to click Cancel(Dismiss) on alert
    public void dismissAlert(long DurationInSeconds){
        Alert alert = waitForAlert(DurationInSeconds);
        alert.dismiss();
    }

    // Method to mouseHover on an element
    public void mouseHoverOnElement(WebElement element, long DurationInSeconds){

        WebElement webElement = waitForElementVisible(element, DurationInSeconds);
        Actions actions = new Actions(driver);
        actions.moveToElement(webElement).build().perform();

    }

    // Method to mouseHover on an element and click on displayed any one element
    public void mouseHoverAndClickOnOtherElement(WebElement mouseHoverElement, WebElement clickElement, long DurationInSeconds){
        WebElement webElement = waitForElementVisible(mouseHoverElement, DurationInSeconds);
        Actions actions = new Actions(driver);
        actions.moveToElement(mouseHoverElement).click(clickElement).build().perform();
    }

    // Method to click on an element using javascriptexecutor
    public void javaScriptClick(WebElement element,long DurationInSeconds){
        WebElement webElement = waitForElementVisible(element, DurationInSeconds);
        JavascriptExecutor jse = ((JavascriptExecutor)driver);
        jse.executeScript("arguments[0].click();", webElement);
    }

    // Method to type text into an element using JavascriptExecutor
    public void javaScriptType(WebElement element,String textTobeTyped, long DurationInSeconds){

        WebElement webElement = waitForElementVisible(element, DurationInSeconds);
        JavascriptExecutor jse = ((JavascriptExecutor)driver);
        jse.executeScript("arguments[0].value='"+textTobeTyped+"'",webElement);
    }

    // Method to get text from an element
    public String getTextFromElement(WebElement element, long DurationInSeconds){
        WebElement webElement = waitForElementVisible(element, DurationInSeconds);
        return webElement.getText();
    }

    public boolean displayStatusOfElement(WebElement element,long DurationInSeconds){
        try {
            WebElement webElement = waitForElementVisible(element, DurationInSeconds);
            return webElement.isDisplayed();
        }catch (Throwable e){
            e.printStackTrace();
            return false;
        }
    }

    public void switchingToNextElement(WebElement element, long DurationInSeconds){

        WebElement webElement = waitForElementVisible(element, DurationInSeconds);
        webElement.sendKeys(Keys.TAB);
    }

    public String getTextFromHTMLInfoTooltip(WebElement element){
        return element.getAttribute("validationMessage");
    }

    public String getPlaceholderTextFromElement(WebElement element, long DurationInSeconds){
        WebElement webElement = waitForElementVisible(element, DurationInSeconds);
        return webElement.getAttribute("placeholder");
    }

    public void navigateBack(){
        driver.navigate().back();
    }
    public void navigationAction(String navigationType){
        if (navigationType.equalsIgnoreCase("Forward")) {
            driver.navigate().forward();
        } else if (navigationType.equalsIgnoreCase("Backward")) {
            driver.navigate().back();
        } else if(navigationType.equalsIgnoreCase("Refresh")){
            driver.navigate().refresh();
        }else{
            throw new IllegalArgumentException("Invalid navigation type provided ");
        }
    }

    public boolean isOptionDisplayed(List<WebElement> optionsList, long DurationInSeconds, String option){
        List<WebElement> webElements = waitForAllElementsVisible(optionsList, DurationInSeconds);
        for(WebElement element :webElements){
            if(element.getText().equalsIgnoreCase(option)){
                return element.isDisplayed();
            }
        }
        return false;
    }
}
