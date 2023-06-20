package school.redrover.model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import school.redrover.model.base.BasePage;

public class CreateUserPage extends BasePage {
    @FindBy(xpath = "//input[@name = 'username']")
    WebElement userNameField;
    @FindBy(xpath = "//input[@name = 'password1']")
    WebElement passwordField;
    @FindBy(xpath = "//input[@name = 'password2']")
    WebElement confirmPasswordField;
    @FindBy(xpath = "//input[@name = 'fullname']")
    WebElement fullNameField;
    @FindBy(xpath = "//input[@name = 'email']")
    WebElement emailField;
    @FindBy(xpath = "//button[@name = 'Submit']")
    WebElement createUserBtn;

    public CreateUserPage(WebDriver driver) {
        super(driver);
    }

    public UsersDatabasePage fillInCredentialsAndSubmit(String userName, String password, String email) {
        fillInUserNameField(userName);
        fillInPasswordField(password);
        fillInConfirmPasswordField(password);
        fillInFullNameField(userName);
        fillInEmailField(email);
        clickCreateUserBtn();
        return new UsersDatabasePage(getDriver());
    }

    private void fillInUserNameField(String userName) {
        userNameField.sendKeys(userName);
    }

    private void fillInPasswordField(String password) {
        passwordField.sendKeys(password);
    }

    private void fillInConfirmPasswordField(String password) {
        confirmPasswordField.sendKeys(password);
    }

    private void fillInFullNameField(String userName) {
        fullNameField.sendKeys(userName);
    }

    private void fillInEmailField(String email) {
        emailField.sendKeys(email);
    }

    private void clickCreateUserBtn() {
        createUserBtn.click();
    }
}
