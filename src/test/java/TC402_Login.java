import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MenuPage;

public class TC402_Login extends BaseGUITest {

    private LoginPage loginPage;
    private MenuPage menuPage;

    private String username = "admin";
    private String password = "Admin123";

    @BeforeClass
    public void pages() {
        loginPage = new LoginPage(driver);
        menuPage = new MenuPage(driver);
    }


    @Test(priority = 1, description = "Verify that login page is visible")
    public void loginPage() {
        loginPage.verifyLoginPage();
        LOGGER.info("Login page opened");

        loginPage.fillLoginForm(username, password);
        LOGGER.info("Username and password entered");

        loginPage.clickLocationButton();
        LOGGER.info("Location button clicked");

        loginPage.clickLoginButton();
        LOGGER.info("Login button clicked");
    }

    @Test(priority = 2, description = "Verify successful login")
    public void adminLogin() {
        menuPage.verifyAdminLogin();
        LOGGER.info("Login successful");
    }
}