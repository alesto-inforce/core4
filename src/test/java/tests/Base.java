package tests;

import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium_core.DriverManager;
import selenium_core.DriverManagerFactory;
import selenium_core.DriverType;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Hashtable;
import java.util.concurrent.TimeUnit;

/**
 * This is a Base Test class, extend it in order to use init() and quit() methods
 * and for taking screenshots
 */

public class Base {
    public static WebDriver driver;
    DriverManager driverManager;

    /**
     * Initialize driver
     * @param driverType Driver Type
     */
    public void init(String driverType) {
        driverManager = DriverManagerFactory.getDriverManager(driverType);
        driver = driverManager.getWebDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    /**
     * Quit driver
     */
    public void quit(){
        try {
            driverManager.quitWebDriver();
        }
        catch (Exception e){
            System.out.println("Driver was already null or quited.");
        }
    }

    /**
     * Call this method to take a screenshot
     * @param fileName File Name
     */
    public void takeScreenshot(String fileName) {
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, new File("src/test/screenshots/" + fileName + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Call this method if you want to take a screenshot and attach it to Allure reporter
     * @param screenshotName Name of the screenshot file shown in Allure
     * @param screenshotDesc Description of the screenshot shown in Allure
     */
    public void reportScreenshot(String screenshotName, String screenshotDesc){
        takeScreenshot(screenshotName);
        Path content = Paths.get("src/test/screenshots/"+screenshotName+".png");
        try(InputStream is = Files.newInputStream(content)){
            Allure.addAttachment(screenshotDesc,is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method returns String representation of next weeks date
     * @return Returns date as a String in following format dd/MM/yyyy
     */
    public String getNextWeekDate(){
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 7);
        return dateFormat.format(cal.getTime());
    }

    /**
     * This method returns String representation of current date
     * @return Returns date as a String in following format dd/MM/yyyy
     */
    public String getCurrentDate(){
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal = Calendar.getInstance();
        return dateFormat.format(cal.getTime());
    }
}