package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class MenuPage extends BasePage {

    @FindBy(css = "a[href*='home.page']")
    private WebElement homeButton;

    @FindBy(css = "#navbarSupportedContent > ul > li.identifier")
    private WebElement adminText;

    @FindBy(id = "selected-location")
    private WebElement locationText;

    @FindBy(css = "li.nav-item.logout > a")
    private WebElement logoutButton;

    @FindBy(id = "referenceapplication-registrationapp-registerPatient-homepageLink-referenceapplication-registrationapp-registerPatient-homepageLink-extension")
    private WebElement registerPatientButton;

    @FindBy(id = "coreapps-activeVisitsHomepageLink-coreapps-activeVisitsHomepageLink-extension")
    private WebElement findPatientRecordButton;

    @FindBy(id = "coreapps-datamanagement-homepageLink-coreapps-datamanagement-homepageLink-extension")
    private WebElement dataManagementButton;

    @FindBy(id = "coreapps-mergePatientsHomepageLink-app")
    private WebElement mergePatientRecordsButton;


    public MenuPage(final WebDriver driver) {
        super(driver);
    }

    public void navigateHome() {
        clickElement(homeButton);
        LOGGER.info("Navigated back to the homepage");
    }

    public void verifyAdminLogin() {
        verifyDisplayed(adminText, "admin");
        LOGGER.info("Login successful");
    }

    public void verifyLocation() {
        verifyDisplayed(locationText, "Inpatient Ward");
        LOGGER.info("Location is correct");
    }

    public void verifyLogout() {
        verifyDisplayed(logoutButton, "Logout");
        LOGGER.info("Logout is displayed");
    }

    public void clickLogoutButton(){
        clickElement(logoutButton);
        LOGGER.info("Logout button clicked");
    }

    public void clickRegisterPatientButton(){
        clickElement(registerPatientButton);
        LOGGER.info("Register a Patient button clicked");
    }

    public void clickFindPatientRecord() {
        clickElement(findPatientRecordButton);
        LOGGER.info("Find Patient Record button clicked");
    }

    public void clickDataManagementLink() {
        clickElement(dataManagementButton);
        LOGGER.info("Data Management button clicked");
    }

    public void clickMergePatientRecordsButton() {
        clickElement(mergePatientRecordsButton);
        LOGGER.info("Merge Patient Electronic Records button clicked");
    }
}