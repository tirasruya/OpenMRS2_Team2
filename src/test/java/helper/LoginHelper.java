package helper;

import org.apache.logging.log4j.Logger;
import pages.LoginPage;
import pages.MenuPage;

public class LoginHelper {

    private static final String username = "admin";
    private static final String password = "Admin123";

    public static void login(final LoginPage loginPage, final MenuPage menuPage, final Logger LOGGER) {
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
}
