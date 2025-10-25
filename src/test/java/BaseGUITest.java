import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.*;
import utility.BaseDriver;

public class BaseGUITest {

    protected final Logger LOGGER = LogManager.getLogger(this.getClass());
    protected WebDriver driver;
    protected LoginPage loginPage;
    protected RegisterPage registerPage;
    protected MenuPage menuPage;
    protected FindPatientPage findPatientPage;
    protected PatientPage patientPage;
    protected DeletePatientPage deletePatientPage;
    protected MergePatientPage mergePatientPage;
    protected AppointmentPage appointmentPage;
    protected String deleteReason = "Test deletion for automation verification";

    @BeforeClass
    public void init() {
        driver = BaseDriver.driver("https://o2.openmrs.org/openmrs/login.htm");
        LOGGER.info("The website opened.");
        loginPage = new LoginPage(driver);
        registerPage = new RegisterPage(driver);
        menuPage = new MenuPage(driver);
        findPatientPage = new FindPatientPage(driver);
        patientPage = new PatientPage(driver);
        deletePatientPage = new DeletePatientPage(driver);
        mergePatientPage = new MergePatientPage(driver);
        appointmentPage = new AppointmentPage(driver);
    }

    @AfterClass
    public void quitTest() {
        driver.quit();
        LOGGER.info("The browser closed.");
    }
}
