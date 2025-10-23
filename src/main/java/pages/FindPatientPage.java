package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class FindPatientPage extends BasePage {

    @FindBy(xpath = "//*[@id='patient-search-results-table']/tbody/tr[1]/td[1]")
    private WebElement id1Element;

    @FindBy(xpath = "//*[@id='patient-search-results-table']/tbody/tr[2]/td[1]")
    private WebElement id2Element;

    @FindBy(tagName = "h2")
    private WebElement pageTitle;

    public FindPatientPage(final WebDriver driver) {
        super(driver);
    }

    public void verifyPageLoaded() {
        verifyDisplayed(pageTitle, "Find Patient Record");
        LOGGER.info("Find Patient Record page loaded successfully");
    }

    public String getFirstPatientID() {
        String id1 = id1Element.getText().replace("Recent", "").trim();
        LOGGER.info("First patient ID captured: " + id1);
        return id1;
    }

    public String getSecondPatientID() {
        String id2 = id2Element.getText().replace("Recent", "").trim();
        LOGGER.info("Second patient ID captured: " + id2);
        return id2;
    }
}
