package school.redrover.model.page.config;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import school.redrover.model.base.BasePage;
import school.redrover.model.page.UserPage;

import java.util.HashSet;
import java.util.Set;

public class UserConfigPage extends BasePage {

    public UserConfigPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//textarea[@name = '_.description']")
    private WebElement descriptionField;

    @FindBy(name = "Submit")
    private WebElement saveButton;

    @FindBy(xpath = "//input[@name = 'email.address']")
    private WebElement emailField;

    @FindBy(xpath = "//select[@checkdependson = 'timeZoneName']")
    private WebElement timeZoneField;

    @FindBy(xpath = "//option[@value = 'Iceland']")
    private WebElement newTimeZone;

    private final String newUserDescription = new Faker().chuckNorris().fact();
    private final String newEmailAddress = new Faker().internet().emailAddress();
    static Set<String> profileChanges = new HashSet<>();

    public UserPage fillInProfileFieldsAndSave() {
        descriptionField.clear();
        descriptionField.sendKeys(newUserDescription);
        profileChanges.add(newUserDescription);

        emailField.clear();
        emailField.sendKeys(newEmailAddress);
        profileChanges.add(newEmailAddress);

        Actions action = new Actions(getDriver());
        action
                .moveToElement(timeZoneField)
                .click()
                .perform();
        newTimeZone.click();
        profileChanges.add(newTimeZone.getText());
        saveButton.click();
        return new UserPage(getDriver());
    }

    public boolean isChangesSaved() {
        return isDescriptionSaved() && isEmailSaved() && isTimeZoneSaved();
    }

    private boolean isDescriptionSaved() {
        return profileChanges.contains(descriptionField.getText());
    }

    private boolean isEmailSaved() {
        return profileChanges.contains(emailField.getAttribute("value"));
    }

    private boolean isTimeZoneSaved() {
        return profileChanges.contains(timeZoneField.getAttribute("value"));
    }
}
