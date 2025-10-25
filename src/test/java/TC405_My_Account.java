import helper.LoginHelper;
import org.testng.annotations.Test;

public class TC405_My_Account extends BaseGUITest {

    @Test(priority = 1, description = "Verify user can login successfully")
    public void login() {
        LoginHelper.login(loginPage, menuPage, LOGGER);
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
