import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MenuPage;

public class TC405_My_Account extends BaseGUITest {

    private LoginPage loginPage;
    private MenuPage menuPage;

    private String username = "admin";
    private String password = "Admin123";

    @BeforeClass
    public void pages() {
        loginPage = new LoginPage(driver);
        menuPage = new MenuPage(driver);
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

    @Test(priority = 2, description = "Verify user can login successfully")
    public void verifyMyAccountsMenu() {
        menuPage.hoverOverProfileIcon();
        LOGGER.info("Hovered over profile icon");

        menuPage.clickMyAccountsLink();
        LOGGER.info("My Accounts link clicked");

        menuPage.verifyChangePasswordButton();
        LOGGER.info("Change Password button is visible and clickable");

        menuPage.verifyMyLanguagesButton();
        LOGGER.info("My Languages button is visible and clickable");
    }
}
