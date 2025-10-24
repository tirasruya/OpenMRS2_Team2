import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MenuPage;

public class TC401_Invalid_Login extends BaseGUITest {

    private LoginPage loginPage;

    @DataProvider(name = "userData")
    public Object[][] provideData() {
        return new Object[][]{
                {"A", "12345"},
                {"B", "abcde"},
                {"C", "123"},
                {"D", "pass"},
                {"E", "pass123"},
                {"F", "pass12345"}
        };
    }

    @BeforeClass
    public void pages() {
        loginPage = new LoginPage(driver);
    }

    @Test(priority = 1, description = "Verify that login page is visible")
    public void loginPage() {
        loginPage.verifyLoginPage();
        LOGGER.info("Login page opened");
    }

    @Test(priority = 2, description = "Verify You must choose a location! warning", dataProvider = "userData")
    public void locationWarning(String username, String password) {
        loginPage.fillLoginForm(username, password);
        LOGGER.info("Username and password entered");

        loginPage.clickLoginButton();
        LOGGER.info("Login button clicked");

        loginPage.verifyLocationWarning();
        LOGGER.info("Location warning is displayed.");

    }

    @Test(priority = 3, description = "Verify Invalid username/password. Please try again. warning", dataProvider = "userData")
    public void invalidLoginWarning(String username, String password) {
        loginPage.clickLocationButton();
        LOGGER.info("Location button clicked");

        loginPage.fillLoginForm(username, password);
        LOGGER.info("Username and password entered");

        loginPage.clickLoginButton();
        LOGGER.info("Login button clicked");

        loginPage.verifyInvalidLoginWarning();
        LOGGER.info("Invalid login warning is displayed.");
    }
}