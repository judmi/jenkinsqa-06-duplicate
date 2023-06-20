package school.redrover.model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import school.redrover.model.base.BasePage;


public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "j_username")
    private WebElement loginField;

    @FindBy(name = "j_password")
    private WebElement passwordField;

    @FindBy(name = "Submit")
    private WebElement Submit;

    @FindBy(xpath = "//div[@class = 'alert alert-danger']")
    private WebElement loginForm;

    public LoginPage inputLogin(String login) {
        loginField.sendKeys(login);
        return this;
    }

    public LoginPage inputPassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    public MainPage signInClick() {
        Submit.click();
        return new MainPage(getDriver());
    }

    public LoginPage signInWithInvalidCredentials() {
        Submit.click();
        return this;
    }

    public boolean isInvalidLoginMessageShown() {
        String text = loginForm.getText();
        return text.contains("Invalid username or password");
    }
}