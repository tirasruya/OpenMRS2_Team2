import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;

public class TC408_List_Patients extends BaseGUITest {

    private MenuPage menuPage;
    private FindPatientPage findPatientPage;
    private LoginPage loginPage;

    private String username = "admin";
    private String password = "Admin123";

    @BeforeClass
    public void pages() {
        menuPage = new MenuPage(driver);
        findPatientPage = new FindPatientPage(driver);
        loginPage = new LoginPage(driver);
    }

    @Test(priority = 1, description = "Verify user can login successfully")
    public void login() {
        loginPage.verifyLoginPage();
        LOGGER.info("Login page opened");
        loginPage.fillLoginForm(username, password);
        LOGGER.info("Username and password entered");
        loginPage.clickLocationButton();
        LOGGER.info("Location selected");
        loginPage.clickLoginButton();
        LOGGER.info("Login button clicked");
        menuPage.verifyAdminLogin();
        LOGGER.info("Login successful");
    }

    @Test(priority = 2, description = "Verify patient list and total count across all pages")
    public void verifyPatientListAcrossPages() {
        menuPage.clickFindPatientRecord();
        LOGGER.info("Find Patient Record clicked");

        findPatientPage.verifyPageLoaded();
        LOGGER.info("Find Patient Record page loaded");

        int totalCount = findPatientPage.getTotalPatientsFromFooter();
        LOGGER.info("Total patients from footer: " + totalCount);

        int allRowsCount = 0;

        do {
            int rowsOnPage = findPatientPage.getPatientTableRowCount();
            LOGGER.info("Rows on current page: " + rowsOnPage);
            allRowsCount += rowsOnPage;
        } while (findPatientPage.clickNextPageIfAvailable());

        LOGGER.info("Total rows across all pages: " + allRowsCount);
        Assert.assertEquals(allRowsCount, totalCount, "Total rows do not match footer total count");
        LOGGER.info("All patient rows across pages match footer total count successfully");
    }
}