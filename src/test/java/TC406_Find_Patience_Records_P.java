import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;

public class TC406_Find_Patience_Records_P extends BaseGUITest {

    private MenuPage menuPage;
    private FindPatientPage findPatientPage;
    private LoginPage loginPage;
    private PatientPage patientPage;

    private String username = "admin";
    private String password = "Admin123";
    private String patientID1 = "100J9R";

    @BeforeClass
    public void pages() {
        menuPage = new MenuPage(driver);
        findPatientPage = new FindPatientPage(driver);
        loginPage = new LoginPage(driver);
        patientPage = new PatientPage(driver);
    }

    @Test(priority = 1, description = "Verify user can login successfully")
    public void login() {
        loginPage.verifyLoginPage();
        LOGGER.info("Login page opened");
        loginPage.fillLoginForm(username, password);
        LOGGER.info("Username and password entered");
        loginPage.clickLocationButton();
        LOGGER.info("Location button clicked");
        loginPage.clickLoginButton();
        LOGGER.info("Login button clicked");
        menuPage.verifyAdminLogin();
        LOGGER.info("Login successful");
    }

    @Test(priority = 2, description = "Verify patient record page opened")
    public void verifyFindPatientPage() {
        menuPage.clickFindPatientRecord();
        LOGGER.info("Find Patient Record clicked");

        findPatientPage.verifyPageLoaded();
        LOGGER.info("Find Patient Record page loaded successfully");
    }

    @Test(priority = 3, description = "Find patient records")
    public void findPatientRecord(){
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
