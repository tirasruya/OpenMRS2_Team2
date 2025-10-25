import org.testng.annotations.Test;

public class TC403_Logout extends BaseGUITest {

    private final String username = "admin";
    private final String password = "Admin123";

    @Test(priority = 1, description = "Verify user can login successfully before logout")
    public void loginBeforeLogout() {
        loginPage.verifyLoginPage();
        LOGGER.info("Login page opened");
        loginPage.fillLoginForm(username, password);
        LOGGER.info("Username and password entered");
        loginPage.clickLocationButton();
        LOGGER.info("Location button clicked");
        loginPage.clickLoginButton();
        LOGGER.info("Login button clicked");
        menuPage.verifyLocation();
        LOGGER.info("Location is correct");
    }

    @Test(priority = 2, description = "Verify user can logout successfully ")
    public void logout() {
        menuPage.verifyLogout();
        LOGGER.info("Logout is displayed");
        menuPage.clickLogoutButton();
        LOGGER.info("Logout button clicked");
        loginPage.verifyLoginPage();
        LOGGER.info("Login page opened");
    }
}