package school.redrover.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import school.redrover.model.base.BasePage;


public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    @FindBy (name = "j_username")
    private WebElement login;

    @FindBy (name = "j_password")
    private WebElement password;

    @FindBy (name = "Submit")
    private WebElement Submit;

    public LoginPage inputLogin() {
        login.sendKeys("login");
        return this;
    }

    public LoginPage inputPassword() {
       password.sendKeys("password");
        return this;
    }

    public MainPage login() {
        Submit.click();
        return new MainPage(getDriver());
    }

    public boolean invalidLogin() {
        String text = login.getText();
        return text.contains("Invalid username or password");
    }
}