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
    private WebElement submit;

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
        submit.click();
        return new MainPage(getDriver());
    }

    public LoginPage signInWithInvalidCredentials() {
        submit.click();
        return this;
    }

    public boolean isInvalidLoginMessageShown() {
        String text = loginForm.getText();
        return text.contains("Invalid username or password");
    }
}