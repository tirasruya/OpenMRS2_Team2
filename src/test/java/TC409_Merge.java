import helper.LoginHelper;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;

public class TC409_Merge extends BaseGUITest {

    private MenuPage menuPage;
    private FindPatientPage findPatientPage;
    private MergePatientPage mergePatientPage;
    private LoginPage loginPage;

    private String id1;
    private String id2;

    private String username = "admin";
    private String password = "Admin123";

    @BeforeClass
    public void pages() {
        menuPage = new MenuPage(driver);
        findPatientPage = new FindPatientPage(driver);
        mergePatientPage = new MergePatientPage(driver);
        loginPage = new LoginPage(driver);
    }

    @Test(priority = 1, description = "Verify user can login successfully")
    public void login() {
        LoginHelper.login(loginPage, menuPage, LOGGER, username, password);
    }

    @Test(priority = 2, description = "Find two patients and record their IDs")
    public void findPatientIDs() {
        menuPage.clickFindPatientRecord();
        LOGGER.info("Find Patient Record clicked");

        id1 = findPatientPage.getFirstPatientID();
        id2 = findPatientPage.getSecondPatientID();
        LOGGER.info("Patient IDs recorded: " + id1 + ", " + id2);

        menuPage.navigateHome();
        LOGGER.info("Navigated back to homepage");
    }

    @Test(priority = 3, description = "Merge the two patient records")
    public void mergePatients() {
        menuPage.clickDataManagementLink();
        LOGGER.info("Data Management link clicked");

        menuPage.clickMergePatientRecordsButton();
        LOGGER.info("Merge Patient Electronic Records button clicked");

        mergePatientPage.enterPatientIDs(id1, id2);
        LOGGER.info("Entered patient IDs: " + id1 + ", " + id2);

        mergePatientPage.clickPage();

        mergePatientPage.clickContinueButton();
        LOGGER.info("Clicked Continue button");

        mergePatientPage.verifyWarningMessage();
        LOGGER.info("Merge warning message displayed");

        mergePatientPage.selectPatientToKeep();
        LOGGER.info("Selected patient to merge into");

        mergePatientPage.clickYesContinue();
        LOGGER.info("Clicked Yes, Continue button");

        mergePatientPage.verifyMergedIDs(id1, id2);
        LOGGER.info("Verified both patient IDs are displayed after merge");
    }
}