import helper.LoginHelper;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;

public class TC404_Register extends BaseGUITest {

    private LoginPage loginPage;
    private RegisterPage registerPage;
    private MenuPage menuPage;
    private PatientPage patientPage;

    @BeforeClass
    public void pages() {
        loginPage = new LoginPage(driver);
        registerPage = new RegisterPage(driver);
        menuPage = new MenuPage(driver);
        patientPage = new PatientPage(driver);
    }


    @Test(priority = 1, description = "Verify user can login successfully before registration")
    public void loginBeforeRegister() {
        LoginHelper.login(loginPage, menuPage, LOGGER, username, password);
    }

    @Test(priority = 2, description = "Verify that user can open Register a Patient form")
    public void openRegisterPatientForm() {
        menuPage.clickRegisterPatientButton();
        LOGGER.info("Register a Patient button clicked");

        registerPage.verifyRegisterPatientPage();
        LOGGER.info("Register a Patient form opened");
    }

    @Test(priority = 3, description = "Verify that user can fill patient details and register successfully")
    public void registerNewPatient() {
        registerPage.enterName("John", "Doe");
        LOGGER.info("Name and Surname entered");

        registerPage.clickNext();
        LOGGER.info("Next button clicked");

        registerPage.selectGender("Male");
        LOGGER.info("Gender selected");

        registerPage.clickNext();
        LOGGER.info("Next button clicked");

        registerPage.enterAge("20");
        LOGGER.info("Age entered");

        registerPage.clickNext();
        LOGGER.info("Next button clicked");

        registerPage.enterAddress("Main St");
        LOGGER.info("Contact info entered");

        registerPage.clickNext();
        LOGGER.info("Next button clicked");

        registerPage.enterPhoneNumber("11111");
        LOGGER.info("Phone number entered");

        registerPage.clickNext();
        LOGGER.info("Next button clicked");

        registerPage.selectRelationship("Parent");
        LOGGER.info("Relationship data entered");

        registerPage.clickNext();
        LOGGER.info("Next button clicked");

        registerPage.clickConfirmButton();
        LOGGER.info("Confirm button clicked");

        patientPage.verifyPatientPage();
        LOGGER.info("Patient page opened successfully after registration");

        patientPage.verifyPatientNameAndIdDisplayed();
        LOGGER.info("Patient name and ID verified on patient page");
    }
}