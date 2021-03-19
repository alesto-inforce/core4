package tests.steps.underwriting.utilities;

import excel.ExcelUtilities;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import pages.*;
import selenium_core.DriverType;
import tests.Base;
import tests.listeners.AllureTestNGListener;

import java.io.IOException;
import java.util.Map;

@Listeners(AllureTestNGListener.class)
public class QuoteCreation extends Base {

    static final String ENV = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("ENV");
    static final String BROWSER = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("BROWSER");

    static final String QuoteCreationData = "src/test/test_data/QuoteCreation.xlsx";

    LoginPage loginpage;
    QuotesPage quotesPage;

    @Before
    public void setup(){
        init(BROWSER);
    }

    @After
    public void tearDown(){
        quit();
    }

    @Given("I am logged in to Pure as {string}")
    public void iAmLoggedInToPureAs(String user) {
        loginpage = new LoginPage(driver);
        loginpage.openApplication(ENV);
        loginpage.login(ENV,user);
    }

    @When("I navigate to Quotes")
    public void iNavigateToQuotes() {
        loginpage = new LoginPage(driver);
        loginpage.clickElement(loginpage.quotes);
    }

    @And("I initiate a new quote for a new customer with location in {string} {string} {string} {string}")
    public void iInitiateANewQuoteForANewCustomerWithLocationIn(String state, String primaryAddress, String city, String zip) throws IOException, InterruptedException {
        quotesPage = new QuotesPage(driver);
        quotesPage.clickElement(quotesPage.newQuote);

        Map<String,String> initiateQuoteData = ExcelUtilities.getData(QuoteCreationData,"InitiateQuote");
        initiateQuoteData.replace("EffectiveDate",getNextWeekDate());
        initiateQuoteData.replace("RiskState",state);
        initiateQuoteData.replace("State",state);
        initiateQuoteData.replace("PrimaryAddressLine",primaryAddress);
        initiateQuoteData.replace("City",city);
        initiateQuoteData.replace("ZIPCode",zip);

        quotesPage.searchForAgency(initiateQuoteData,ENV);
        quotesPage.initiateQuote(initiateQuoteData,ENV);
    }

    @And("I create a quote")
    public void iCreateAQuote() {
        System.out.println("Helloo");
    }

    @And("I accept underwriting referrals")
    public void iAcceptUnderwritingReferrals() {

    }

    @And("I create required forms")
    public void createRequiredForms() {

    }
}