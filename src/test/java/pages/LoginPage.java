package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.components.CommonComponentsAndActions;

public class LoginPage extends CommonComponentsAndActions {

    static WebDriver driver;

    public LoginPage(WebDriver driver){
        super(driver);
        LoginPage.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@title='Carrier assigned agency number.']")
    WebElement brokerNumberInput;
    @FindBy(xpath = "//input[@title='Username']")
    WebElement usernameInput;
    @FindBy(xpath = "//input[@title='Password']")
    WebElement passwordInput;
    @FindBy(xpath = "//a[text()='>>> login']")
    WebElement loginButton;

    public void openApplication(String env){
        switch (env){
            case "QA"   : {
                driver.get("https://privqa.purehnw.com/");
            }
            break;
            case "STG"  : {
                driver.get("https://corestaging.purehnw.com/");
            }
            break;
            case "PROD" : {
                driver.get("https://www.purehnw.com/");
            }
            break;
        }
    }

    public void login(String env,String user) {
        String username;
        String password;
        String brokerNumber = "0";

        switch (user){
            case "Zonal" :             { username = "automationuw2";  password = "automationuw2";  } break;
            case "Field" :             { username = "automationuw3";  password = "automationuw3";  } break;
            case "RUM" :               { username = "automationuw4";  password = "automationuw4";  } break;
            case "Specialist1" :       { username = "automationuw5";  password = "automationuw5";  } break;
            case "Specialist2" :       { username = "automationuw6";  password = "automationuw6";  } break;
            case "SeniorUnderwriter" : { username = "automationuw7";  password = "automationuw7";  } break;
            case "Analyst" :           { username = "automationuw8";  password = "automationuw8";  } break;
            case "Underwriter1" :      { username = "automationuw9";  password = "automationuw9";  } break;
            case "Underwriter2" :      { username = "automationuw10"; password = "automationuw10"; } break;
            case "UWSA1" :             { username = "automationuw11"; password = "automationuw11"; } break;
            case "UWSA2" :             { username = "automationuw12"; password = "automationuw12"; } break;
            case "UWSSA" :             { username = "automationuw13"; password = "automationuw13"; } break;
            case "UWSRM" :             { username = "automationuw14"; password = "automationuw14"; } break;
            //TODO add new users

            default:
                throw new IllegalStateException("Unexpected value: " + user);
        }

        switch (env){
            case "QA"  :{
                setBrokerNumber(brokerNumber);
                setUsername(username);
                setPassword(password);
                clickLoginButton();
            }
            break;
            case "STG" : {
                System.out.println("Staging");
                setBrokerNumber(brokerNumber);
                setUsername(username);
                setPassword(password);
                clickLoginButton();
            }
            break;
            case "PROD" : {
                System.out.println("Production");
                setBrokerNumber(brokerNumber);
                setUsername(username);
                setPassword(password);
                clickLoginButton();
            }
            break;
        }
    }

    public void setBrokerNumber(String value) {
        typeText(brokerNumberInput,value);
    }
    public void setUsername(String value) {
        typeText(usernameInput,value);
    }
    public void setPassword(String value) {
        typeText(passwordInput,value);
    }
    public void clickLoginButton(){
        clickElement(loginButton);
    }

}