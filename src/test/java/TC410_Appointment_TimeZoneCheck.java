import helper.LoginHelper;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;

public class TC410_Appointment_TimeZoneCheck extends BaseGUITest {

    private MenuPage menuPage;
    private AppointmentPage appointmentPage;
    private FindPatientPage findPatientPage;
    private LoginPage loginPage;

    @BeforeClass
    public void pages() {
        menuPage = new MenuPage(driver);
        appointmentPage = new AppointmentPage(driver);
        findPatientPage = new FindPatientPage(driver);
        loginPage = new LoginPage(driver);
    }

    @Test(priority = 1, description = "Verify user can login successfully")
    public void login() {
        LoginHelper.login(loginPage, menuPage, LOGGER, username, password);
    }

    @Test(priority = 2, description = "Verify appointment scheduling error for wrong timezone")
    public void verifyAppointmentTimeZoneError() {
        menuPage.clickFindPatientRecord();
        LOGGER.info("Find Patient Record clicked");

        findPatientPage.verifyPageLoaded();
        LOGGER.info("Find Patient Record page loaded");

        String id1 = findPatientPage.getFirstPatientID();
        LOGGER.info("Patient with ID: {}", id1);

        menuPage.navigateHome();
        LOGGER.info("Navigated back to homepage");

        menuPage.clickAppointmentScheduling();
        LOGGER.info("Appointment Scheduling clicked");

        appointmentPage.clickManageAppointments();
        LOGGER.info("Manage Appointments clicked");

        appointmentPage.searchPatient(id1);
        LOGGER.info("Patient searched with ID: {}", id1);

        appointmentPage.selectSearchedPatient();
        LOGGER.info("Patient selected from search results");

        appointmentPage.verifyTimeZoneErrorMessage();
        LOGGER.info("Time zone error message verified successfully");
    }
}
