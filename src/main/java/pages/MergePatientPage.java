package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MergePatientPage extends BasePage {

    @FindBy(id = "patient1-text")
    private WebElement firstPatientIdField;

    @FindBy(id = "patient2-text")
    private WebElement secondPatientIdField;

    @FindBy(tagName = "body")
    private WebElement page;

    @FindBy(css = "input[value='Continue']")
    private WebElement continueButton;

    @FindBy(css = "#content > form > div:nth-child(6) > h1")
    private WebElement mergeWarningMessage;

    @FindBy(id = "confirm-button")
    private WebElement yesContinueButton;

    @FindBy(xpath = "//*[@id='content']/div[6]/div[2]/div/span[1]")
    private WebElement mergedPatientIdentifier1;

    @FindBy(xpath = "//*[@id='content']/div[6]/div[2]/div/span[2]")
    private WebElement mergedPatientIdentifier2;

    @FindBy(css = "#first-patient")
    private WebElement selectPatient;

    public MergePatientPage(final WebDriver driver) {
        super(driver);
    }

    public void enterPatientIDs(String id1, String id2) {
        sendKeysToElement(firstPatientIdField, id1);
        sendKeysToElement(secondPatientIdField, id2);
        LOGGER.info("Entered patient IDs: " + id1 + ", " + id2);
    }

    public void clickPage(){
        clickElement(page);
    }

    public void clickContinueButton() {
        clickElement(continueButton);
        LOGGER.info("Clicked Continue button");
    }

    public void verifyWarningMessage() {
        verifyDisplayed(mergeWarningMessage, "Merging cannot be undone! Please check records before continuing.");
        LOGGER.info("Warning message verified");
    }

    public void selectPatientToKeep() {
        clickElement(selectPatient);
        LOGGER.info("Selected patient to merge into");
    }

    public void clickYesContinue() {
        clickElement(yesContinueButton);
        LOGGER.info("Clicked Yes, Continue button");
    }

    public void verifyMergedIDs(String id1, String id2) {
        verifyDisplayed(mergedPatientIdentifier1, id1);
        verifyDisplayed(mergedPatientIdentifier2, id2);
        LOGGER.info("Verified merged patient contains both IDs: " + id1 + ", " + id2);
    }
}