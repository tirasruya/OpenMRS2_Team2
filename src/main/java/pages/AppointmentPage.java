package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AppointmentPage extends BasePage {

    @FindBy(id = "appointmentschedulingui-manageAppointments-app")
    private WebElement manageAppointmentsButton;

    @FindBy(id = "patient-search")
    private WebElement patientSearchInput;

    @FindBy(css = "#patient-search-results-table tbody tr")
    private WebElement searchedPatient;

    @FindBy(xpath = "//*[@id='time-zone-warning']/div/div/p")
    private WebElement timeZoneErrorMessage;

    public AppointmentPage(WebDriver driver) {
        super(driver);
    }

    public void clickManageAppointments() {
        clickElement(manageAppointmentsButton);
        LOGGER.info("Manage Appointments button clicked");
    }

    public void searchPatient(String patientID) {
        sendKeysToElement(patientSearchInput, patientID);
        LOGGER.info("Patient searched: " + patientID);
    }

    public void selectSearchedPatient() {
        clickElement(searchedPatient);
        LOGGER.info("Searched patient selected");
    }

    public void verifyTimeZoneErrorMessage() {
        verifyDisplayed(timeZoneErrorMessage, "Your computer is not set to the right time zone. Please change to Coordinated Universal Time and then close and restart your browser to assure proper scheduling functionality.");
        LOGGER.info("Time zone error message verified");
    }
}
