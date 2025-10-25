import helper.LoginHelper;
import org.testng.annotations.Test;

public class TC407_Delete_Patient_Record extends BaseGUITest {

    @Test(priority = 1, description = "Verify user can login successfully")
    public void login() {
        LoginHelper.login(loginPage, menuPage, LOGGER);
    }

    @Test(priority = 2, description = "Verify doctor can find and open patient record")
    public void findAndOpenPatient() {
        menuPage.clickFindPatientRecord();
        LOGGER.info("Find Patient Record clicked");

        findPatientPage.verifyPageLoaded();
        LOGGER.info("Find Patient Record page loaded");

        String id1 = findPatientPage.getFirstPatientID();
        findPatientPage.patientSearch(id1);
        LOGGER.info("Patient searched with ID: {}", id1);

        findPatientPage.verifySearchedPatient();
        LOGGER.info("Searched patient found and clickable");

        findPatientPage.clickSearchedPatient();
        LOGGER.info("Patient record opened successfully");

        patientPage.verifyPatientPage();
        LOGGER.info("Patient page verified");
    }

    @Test(priority = 3, description = "Verify patient can be deleted successfully")
    public void deletePatient() {
        patientPage.clickDeletePatientLink();
        LOGGER.info("Delete Patient link clicked");

        deletePatientPage.enterDeleteReason(deleteReason);
        LOGGER.info("Delete reason entered");

        deletePatientPage.confirmDeletion();
        LOGGER.info("Delete confirmation submitted");

    }
}