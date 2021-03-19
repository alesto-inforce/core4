package pages.components;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class CommonComponentsAndActions {

    static WebDriver driver;

    static final int WAIT_TIME = Integer.parseInt(Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("WAIT_TIME"));

    public CommonComponentsAndActions(WebDriver driver){
        CommonComponentsAndActions.driver = driver;
        PageFactory.initElements(driver,this);
    }

    // Header component elements - START
    @FindBy(xpath = "//a[text()='home']")
    public WebElement home;
    @FindBy(xpath = "//a[text()='quotes']")
    public WebElement quotes;
    // Header component elements - END

    // Footer component elements - START
    @FindBy(xpath = "//a[text()='new quote']")
    public WebElement newQuote;
    @FindBy(xpath = "//a[text()='>>> select agency ']")
    public WebElement selectAgency;
    @FindBy(xpath = "//a[text()='>>> next']")
    public WebElement next;
    @FindBy(xpath = "//a[text()='>>> create  new customer']")
    public WebElement createNewCustomer;




    /**
     * Use this method to click a WebElement
     * @param element WebElement
     */
    public void clickElement(WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, WAIT_TIME);
            wait.until(ExpectedConditions.visibilityOf(element));
            wait.until(ExpectedConditions.elementToBeClickable(element));
            try{
                Actions actions = new Actions(driver);
                actions.moveToElement(element);
                actions.build().perform();
                element.click();
            }
            catch(StaleElementReferenceException e) {
                element.click();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * Types text into WebElement
     * @param element WebElement
     * @param text Text
     */
    public void typeText(WebElement element, String text) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, WAIT_TIME);
            wait.until(ExpectedConditions.visibilityOf(element));
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.clear();
            element.sendKeys(text);
            element.sendKeys(Keys.ENTER);
        }  catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * Types keys into WebElement
     * @param element WebElement
     * @param keys Keys
     */
    public void typeKeys(WebElement element, Keys keys) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, WAIT_TIME);
            wait.until(ExpectedConditions.visibilityOf(element));
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.sendKeys(keys);
        }  catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * Given a Web element it sets desired attributes value.
     * @param element String
     * @param attribute String
     * @param value String
     */
    public void setAttributeValue(WebElement element, String attribute, String value){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].setAttribute(arguments[1], arguments[2]);",element,attribute,value);
    }
    public void timeout(int time) throws InterruptedException {
        Thread.sleep(1000*time);
    }
    public void select(WebElement element, String visableText){
        WebDriverWait wait = new WebDriverWait(driver, WAIT_TIME);
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        Select select = new Select(element);
        select.selectByVisibleText(visableText);
        typeKeys(element,Keys.ENTER);
    }
    public void choose(WebElement elementYes, WebElement elementNo, String yesOrNo){
        if (yesOrNo.equalsIgnoreCase("Yes")){
            clickElement(elementYes);
        } else {
            clickElement(elementNo);
        }
    }
}