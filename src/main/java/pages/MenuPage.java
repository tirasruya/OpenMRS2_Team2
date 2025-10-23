package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MenuPage extends BasePage {

    @FindBy(css = "a[href*='home.page']")
    private WebElement homeButton;

    @FindBy(css = "#navbarSupportedContent > ul > li.identifier")
    private WebElement adminText;

    @FindBy(id = "selected-location")
    private WebElement locationText;

    @FindBy(css = "li.nav-item.logout > a")
    private WebElement logoutButton;

    @FindBy(css = "i.icon-user")
    private WebElement profileIcon;

    @FindBy(css = "#user-account-menu > li > a")
    private WebElement myAccountsLink;

    @FindBy(css = "#tasks > a:nth-child(1) > div")
    private WebElement changePasswordButton;

    @FindBy(css = "#tasks > a:nth-child(2) > div")
    private WebElement myLanguagesButton;


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

    public void clickLogoutButton() {
        clickElement(logoutButton);
        LOGGER.info("Logout button clicked");
    }

    public void clickRegisterPatientButton() {
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

    public void hoverOverProfileIcon() {
        Actions actions = new Actions(driver);
        actions.moveToElement(profileIcon).perform();
        LOGGER.info("Hovered over profile icon");
    }

    public void clickMyAccountsLink() {
        clickElement(myAccountsLink);
        LOGGER.info("[My Accounts] link clicked");
    }

    public void verifyChangePasswordButton() {
        verifyDisplayed(changePasswordButton, "Change Password");
        wait.until(ExpectedConditions.elementToBeClickable(changePasswordButton));
        LOGGER.info("Change Password button is visible and clickable");
    }

    public void verifyMyLanguagesButton() {
        verifyDisplayed(myLanguagesButton, "My Languages");
        wait.until(ExpectedConditions.elementToBeClickable(myLanguagesButton));
        LOGGER.info("My Languages button is visible and clickable");
    }
}