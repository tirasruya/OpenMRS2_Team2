import helper.LoginHelper;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;

public class TC406_Find_Patience_Records_N extends BaseGUITest {

    private MenuPage menuPage;
    private FindPatientPage findPatientPage;
    private LoginPage loginPage;
    
    @BeforeClass
    public void pages() {
        menuPage = new MenuPage(driver);
        findPatientPage = new FindPatientPage(driver);
        loginPage = new LoginPage(driver);
    }

    @Test(priority = 1, description = "Verify user can login successfully")
    public void login() {
        LoginHelper.login(loginPage, menuPage, LOGGER, username, password);
    }

    @Test(priority = 2, description = "Verify patient record page opened")
    public void verifyFindPatientPage() {
        menuPage.clickFindPatientRecord();
        LOGGER.info("Find Patient Record clicked");

        findPatientPage.verifyPageLoaded();
        LOGGER.info("Find Patient Record page loaded successfully");
    }

    @Test(priority = 3, description = "Search patient records and verify No matching records found warning")
    public void findPatientRecord() {
        findPatientPage.patientSearch(patientID1);
        LOGGER.info("Patient searched successfully");

        findPatientPage.verifyNoRecordsFoundWarning();
        LOGGER.info("No matching records found warning is displayed");
    }
}