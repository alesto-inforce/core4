package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.components.CommonComponentsAndActions;

import java.util.List;
import java.util.Map;

public class QuotesPage extends CommonComponentsAndActions {

    static WebDriver driver;

    public QuotesPage(WebDriver driver) {
        super(driver);
        QuotesPage.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//label[text()='contains']/../input")
    WebElement searchAgencyContainsField;
    @FindBy(xpath = "//input[@title='Effective Date']")
    WebElement effectiveDate;
    @FindBy(xpath = "//input[@title='DOB']")
    WebElement dob;
    @FindBy(xpath = "//select[@title='Select Risk State']")
    WebElement riskState;
    @FindBy(xpath = "//select[@title='Select Admitted or Surplus Lines']")
    WebElement admittedOrSurplusLine;
    @FindBy(xpath = "//div[@title='Ex-wind Homeowner']/..//input[@title='Yes']")
    WebElement exWindYes;
    @FindBy(xpath = "//div[@title='Ex-wind Homeowner']/..//input[@title='No']")
    WebElement exWindNo;
    @FindBy(xpath = "//div[@title='Has the client lived at this address for more than six months?']/..//input[@title='Yes']")
    WebElement atThisAddressMoreThan6MonthsYes;
    @FindBy(xpath = "//div[@title='Has the client lived at this address for more than six months?']/..//input[@title='No']")
    WebElement atThisAddressMoreThan6MonthsNo;
    @FindBy(xpath = "//div[contains(@title,'Media Personality')]/..//input[@title='Yes']")
    WebElement mediaPersonalityYes;
    @FindBy(xpath = "//div[contains(@title,'Media Personality')]/..//input[@title='No']")
    WebElement mediaPersonalityNo;
    @FindBy(xpath = "//div[contains(text(),'Are you quoting only')]/..//input[@title='Yes']")
    WebElement disclosureRequiredYes;
    @FindBy(xpath = "//div[contains(text(),'Are you quoting only')]/..//input[@title='No']")
    WebElement disclosureRequiredNo;
    @FindBy(xpath = "//div[contains(text(),'Have you')]/..//input[contains(@title,'Yes')]")
    WebElement disclosureMadeYes;
    @FindBy(xpath = "//div[contains(text(),'Have you')]/..//input[contains(@title,'No')]")
    WebElement disclosureMadeNo;
    @FindBy(xpath = "//select[@title='Licensed Producer']")
    WebElement licensedProducer;
    @FindBy(xpath = "//select[@title='Advisor / Servicer']")
    WebElement advisorServicer;
    @FindBy(xpath = "//input[@title='First Name']")
    WebElement firstName;
    @FindBy(xpath = "//input[@title='Last Name']")
    WebElement lastName;
    @FindBy(xpath = "//input[@title='Occupation']")
    WebElement memberOccupation;
    @FindBy(xpath = "//input[@title='Employer']")
    WebElement memberEmployer;
    @FindBy(xpath = "//select[@title='Spouse/Partner/Other to be named on the policy']")
    WebElement spouseOrPartner;
    @FindBy(xpath = "//input[contains(@title,'to be named on the policy- First Name')]")
    WebElement spouseOrPartnerFirstName;
    @FindBy(xpath = "//input[contains(@title,'to be named on the policy- Last Name')]")
    WebElement spouseOrPartnerLastName;
    @FindBy(xpath = "//input[@placeholder='Enter a location']")
    WebElement riskAddressLine1;
    @FindBy(xpath = "//b[text()='City']/../../../tr[2]//input")
    WebElement city;
    @FindBy(xpath = "//b[text()='State']/../../../tr[2]//select")
    WebElement state;
    @FindBy(xpath = "//b[text()='Zip']/../../../tr[2]//input")
    WebElement zip;
    @FindBy(xpath = "//select[@title='Residence Type']")
    WebElement residenceType;
    @FindBy(xpath = "//input[@title='Replacement Value']")
    WebElement replacementCost;
    @FindBy(xpath = "//select[@title='Windstorm Deductible']")
    WebElement windstormDeductible;
    @FindBy(xpath = "//select[@title='Personal Liability Limit']")
    WebElement personalLiabilityLimit;


    @FindBy(xpath = "//div[@title='Is this your Primary Residence?']/..//input[@title='Yes']")
    WebElement isThisAPrimaryResidenceYes;
    @FindBy(xpath = "//div[@title='Is the home unoccupied for 2 or more consecutive months?']/..//input[@title='No']")
    WebElement isTheHomeUnoccupiedFor2OrMoreConsecutiveMonthsNo;
    @FindBy(xpath = "//div[@title='Is the residence or part of the residence rented to others?']/..//input[@title='No']")
    WebElement isTheResidenceOrPartOfTheResidenceRentedToOthersNo;
    @FindBy(xpath = "//div[@title='Is the property vacant?']/..//input[@title='No']")
    WebElement isTheResidenceVacantNo;
    @FindBy(xpath = "//div[@title='Is the home under construction or major renovation?']/..//input[@title='No']")
    WebElement isTheResidenceUnderConstructionOrRenovationNo;

    @FindBy(xpath = "//div[@title='Is there, or will there be a mortgage on this location? (Excluding lines of credit)']/..//input[@title='No']")
    WebElement isThereOrWillThereBeAMortgageOnThisLocationNo;


    @FindBy(xpath = "//input[@title='Year']")
    WebElement yearBuilt;
    @FindBy(xpath = "//input[@title='Square Footage']")
    WebElement squareFootage;
    @FindBy(xpath = "//input[@title='Number of Floors at the risk location']")
    WebElement numberOfFloorsAtTheRiskLocation;
    @FindBy(xpath = "//select[@title='Protection Class']")
    List<WebElement> protectionClass;
    @FindBy(xpath = "//select[@title='Construction Type']")
    WebElement constructionType;
    @FindBy(xpath = "//select[@title='BCEG']")
        WebElement BCEG;


    @FindBy(xpath = "//select[@title='Roof Shape']")
    WebElement roofShape;
    @FindBy(xpath = "//select[@title='Roof Covering']")
    WebElement roofCovering;
    @FindBy(xpath = "//select[@title='Secondary Water Resistance']")
    WebElement secondaryWaterResistance;
    @FindBy(xpath = "//select[@title='Opening Protection']")
    WebElement openingProtection;






    public void searchForAgency(Map<String,String> data,String ENV) throws InterruptedException {
        String agency = "";
        switch (ENV){
            case "QA" : agency = data.get("AgencyQA"); break;
            case "STG" : agency = data.get("AgencySTG"); break;
            case "PROD" : agency = data.get("AgencyPROD"); break;
        }
        typeText(searchAgencyContainsField, agency);
        timeout(3);
        clickElement(driver.findElement(By.xpath("//div[contains(text(),'" + agency + "')]/../../td[1]/div/input[1]")));
        clickElement(selectAgency);
    }
    public void selectAdmittedLine(String line) {
        clickElement(driver.findElement(By.xpath("//span[contains(text(),'" + line + "')]/..//input")));
    }
    public void selectLicensedProducer(Map<String, String> data, String ENV){
        switch (ENV){
            case "QA" : select(licensedProducer,data.get("LicensedProducerQA")); break;
            case "STG" : select(licensedProducer,data.get("LicensedProducerSTG")); break;
            case "PROD" : select(licensedProducer,data.get("LicensedProducerPROD")); break;
        }
    }
    public void selectAdvisor(Map<String, String> data, String ENV){
        switch (ENV){
            case "QA" : select(advisorServicer,data.get("AdvisorServicerQA")); break;
            case "STG" : select(advisorServicer,data.get("AdvisorServicerSTG")); break;
            case "PROD" : select(advisorServicer,data.get("AdvisorServicerPROD")); break;
        }
    }
    public void initiateQuote(Map<String, String> data, String ENV) throws InterruptedException {
        typeText(effectiveDate, data.get("EffectiveDate"));
        timeout(3);
        typeText(dob, data.get("DateOfBirth"));
        select(riskState, data.get("RiskState"));
        timeout(3);
        select(admittedOrSurplusLine, data.get("AdmittedOrSurplus"));
        if (data.get("AdmittedOrSurplus").equalsIgnoreCase("Admitted")) {
            selectAdmittedLine(data.get("AdmittedOrSurplusLine"));
            choose(exWindYes, exWindNo, data.get("ExWind"));
        } else {
            selectAdmittedLine(data.get("AdmittedOrSurplusLine"));
        }
        choose(atThisAddressMoreThan6MonthsYes, atThisAddressMoreThan6MonthsNo, data.get("MoreThanSixMonths"));
        choose(mediaPersonalityYes, mediaPersonalityNo, data.get("EntertainerAthlete"));
        choose(disclosureRequiredYes, disclosureRequiredNo, data.get("DisclosureRequired"));
        choose(disclosureMadeYes, disclosureMadeNo, data.get("DisclosureMade"));
        selectLicensedProducer(data,ENV);
        timeout(3);
        selectAdvisor(data,ENV);
        timeout(3);
        typeText(firstName,data.get("FirstName"));
        typeText(lastName,data.get("LastName"));
        typeText(memberOccupation,data.get("MemberOccupation"));
        typeText(memberEmployer,data.get("MemberEmployer"));
        select(spouseOrPartner,data.get("SpousePartner"));
        if (data.get("SpousePartner").equalsIgnoreCase("Yes")){
            typeText(spouseOrPartnerFirstName,data.get("PartnerFirstName"));
            typeText(spouseOrPartnerFirstName,data.get("PartnerLastName"));
        }
        typeText(riskAddressLine1,data.get("PrimaryAddressLine"));
        typeText(city,data.get("City"));
        typeText(zip,data.get("ZIPCode"));
        timeout(5);
        select(state,data.get("State"));
        timeout(3);
        clickElement(next);
        clickElement(createNewCustomer);
    }
    public void addRiskAddress(Map<String,String> data){
        select(residenceType,"Homeowner");
        typeText(replacementCost,"");
        select(windstormDeductible,"");
    } //TODO
    public void setLiabilityCoveragePersonalLimit(String value){
        select(personalLiabilityLimit,"");
    }//TODO
    public void usage(){
        clickElement(isThisAPrimaryResidenceYes);
        clickElement(isTheHomeUnoccupiedFor2OrMoreConsecutiveMonthsNo);
        clickElement(isTheResidenceOrPartOfTheResidenceRentedToOthersNo);
        clickElement(isTheResidenceVacantNo);
        clickElement(isTheResidenceUnderConstructionOrRenovationNo);
    }
    public void mortgageeInformation(){
        clickElement(isThereOrWillThereBeAMortgageOnThisLocationNo);
    }
    public void constructionDetails(String value){
        typeText(yearBuilt,"");
        typeText(squareFootage,"");
        typeText(numberOfFloorsAtTheRiskLocation,"");
        select(protectionClass.get(0),"");
        select(constructionType,"");
        select(BCEG,"");
    }
    public void windMitigation(String value){
        select(roofShape,"");
        select(roofCovering,"");
        select(secondaryWaterResistance,"");
        select(openingProtection,"");


    }

}