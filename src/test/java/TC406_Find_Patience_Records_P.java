import helper.LoginHelper;
import org.testng.annotations.Test;

public class TC406_Find_Patience_Records_P extends BaseGUITest {
    /** TODO */

    @Test(priority = 1, description = "Verify user can login successfully")
    public void login() {
        LoginHelper.login(loginPage, menuPage, LOGGER);
    }

    @Test(priority = 2, description = "Verify patient record page opened")
    public void verifyFindPatientPage() {
        menuPage.clickFindPatientRecord();
        LOGGER.info("Find Patient Record clicked");

        findPatientPage.verifyPageLoaded();
        LOGGER.info("Find Patient Record page loaded successfully");
    }

    @Test(priority = 3, description = "Find patient records")
    public void findPatientRecord() {
        patientID1 = "100J9R";
        findPatientPage.patientSearch(patientID1);
        LOGGER.info("Patient searched successfully");

        findPatientPage.verifySearchedPatient();
        LOGGER.info("Searched patient is visible and clickable");

        findPatientPage.clickSearchedPatient();
        LOGGER.info("Searched patient clicked to access detailed information");

        patientPage.verifyPatientPage();
        LOGGER.info("Patient page opened successfully after registration");

        patientPage.verifyPatientNameAndIdDisplayed();
        LOGGER.info("Patient name and ID verified on patient page");
    }
}