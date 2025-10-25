import data.PatientData;
import helper.LoginHelper;
import org.testng.annotations.Test;

public class TC404_Register extends BaseGUITest {

    @Test(priority = 1, description = "Verify user can login successfully before registration")
    public void loginBeforeRegister() {
        LoginHelper.login(loginPage, menuPage, LOGGER);
    }

    @Test(priority = 2, description = "Verify that user can open Register a Patient form")
    public void openRegisterPatientForm() {
        menuPage.clickRegisterPatientButton();
        LOGGER.info("Register a Patient button clicked");

        registerPage.verifyRegisterPatientPage();
        LOGGER.info("Register a Patient form opened");
    }

    @Test(priority = 3, description = "Verify that user can fill patient details and register successfully",
    dataProvider = "patientData", dataProviderClass = PatientData.class)
    public void registerNewPatient(String firstname, String lastname, String gender, String age, String address, String phone, String relationship) {

        registerPage.registerPatient(firstname, lastname, gender, age, address, phone, relationship);

        registerPage.clickConfirmButton();
        LOGGER.info("Confirm button clicked");

        patientPage.verifyPatientPage();
        LOGGER.info("Patient page opened successfully after registration");

        patientPage.verifyPatientNameAndIdDisplayed();
        LOGGER.info("Patient name and ID verified on patient page");
    }
}