package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeletePatientPage extends BasePage {

    @FindBy(id = "delete-reason")
    private WebElement deleteReasonField;

    @FindBy(css = "#delete-patient-creation-dialog > div.dialog-content > button.confirm.right")
    private WebElement confirmButton;

    @FindBy(css = ".toast-message")
    private WebElement successMessage;

    public DeletePatientPage(WebDriver driver) {
        super(driver);
    }

    public void enterDeleteReason(String reason) {
        sendKeysToElement(deleteReasonField, reason);
        LOGGER.info("Delete reason entered: " + reason);
    }

    public void confirmDeletion() {
        clickElement(confirmButton);
        LOGGER.info("Delete confirmation submitted");
    }

//    public void verifyPatientDeleted() {
//        verifyDisplayed(successMessage,"Patient has been deleted successfully");
//        LOGGER.info("Patient successfully deleted from the system");
//    }
}