package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

public class FindPatientPage extends BasePage {

    @FindBy(xpath = "//*[@id='patient-search-results-table']/tbody/tr[1]/td[1]")
    private WebElement id1Element;

    @FindBy(xpath = "//*[@id='patient-search-results-table']/tbody/tr[2]/td[1]")
    private WebElement id2Element;

    @FindBy(css = "#content > h2")
    private WebElement pageTitle;

    @FindBy(id = "patient-search")
    private WebElement patientSearch;

    @FindBy(css = "#patient-search-results-table > tbody > tr")
    private WebElement searchedPatient;

    @FindBy(css = "#patient-search-results-table > tbody > tr > td")
    private WebElement noRecordsFound;

    @FindBy(id = "patient-search-results-table_info")
    private WebElement tableInfo;

    @FindBy(css = "#patient-search-results-table > tbody > tr")
    private List<WebElement> patientRows;

    @FindBy(id = "patient-search-results-table_next")
    private WebElement nextPageButton;

    public FindPatientPage(final WebDriver driver) {
        super(driver);
    }

    public void verifyPageLoaded() {
        verifyDisplayed(pageTitle, "Find Patient Record");
        LOGGER.info("Find Patient Record page loaded successfully");
    }

    public String getFirstPatientID() {
        String id1 = id1Element.getText().replace("Recent", "").trim();
        LOGGER.info("First patient ID captured: " + id1);
        return id1;
    }

    public String getSecondPatientID() {
        String id2 = id2Element.getText().replace("Recent", "").trim();
        LOGGER.info("Second patient ID captured: " + id2);
        return id2;
    }

    public void patientSearch(String patientID) {
        sendKeysToElement(patientSearch, patientID);
        LOGGER.info("Patient searched successfully");
    }

    public void verifySearchedPatient(){
        wait.until(ExpectedConditions.visibilityOf(searchedPatient));
        wait.until(ExpectedConditions.elementToBeClickable(searchedPatient));
        Assert.assertTrue(searchedPatient.isDisplayed(), "Searched patient is not visible or clickable");
        LOGGER.info("Searched patient is visible and clickable");
    }

    public void clickSearchedPatient() {
        clickElement(searchedPatient);
        LOGGER.info("Searched patient clicked to access detailed information");
    }

    public void verifyNoRecordsFoundWarning(){
        verifyDisplayed(noRecordsFound, "No matching records found");
        LOGGER.info("No matching records found warning is displayed");
    }

    public int getTotalPatientsFromFooter() {
        String infoText = tableInfo.getText();
        LOGGER.info("Footer info text: " + infoText);
        String totalStr = infoText.split("of")[1].replaceAll("[^0-9]", "").trim();
        return Integer.parseInt(totalStr);
    }

    public int getPatientTableRowCount() {
        return patientRows.size();
    }

    public boolean clickNextPageIfAvailable() {
        try {
            if (nextPageButton.isDisplayed() && nextPageButton.isEnabled() &&
                    !nextPageButton.getAttribute("class").contains("disabled")) {

                clickElement(nextPageButton);
                LOGGER.info("Navigated to next page");
                wait.until(ExpectedConditions.visibilityOfAllElements(patientRows));
                return true;
            }
        } catch (Exception e) {
            LOGGER.info("No next page available: " + e.getMessage());
        }
        return false;
    }
}