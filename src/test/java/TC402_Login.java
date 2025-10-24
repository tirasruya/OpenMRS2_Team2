import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MenuPage;

public class TC402_Login extends BaseGUITest {

    private LoginPage loginPage;
    private MenuPage menuPage;

    @BeforeClass
    public void pages() {
        loginPage = new LoginPage(driver);
        menuPage = new MenuPage(driver);
    }

    @DataProvider(name = "userData")
    public Object[][] provideData() {
        return new Object[][]{
                {"A", "12345"},
                {"B", "abcde"},
                {"C", "123"},
                {"D", "pass"},
                {"E", "pass123"},
                {"F", "pass12345"},
                {"admin", "Admin123"}
        };
    }

    @Test(priority = 1, description = "Verify that login page is visible", dataProvider = "userData")
    public void loginPage(String username, String password) {
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