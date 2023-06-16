package school.redrover.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import school.redrover.model.base.BasePage;


public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage inputLogin(String login) {
        getWait5().until(ExpectedConditions.visibilityOfElementLocated(By.name("j_username"))).sendKeys(login);
        return this;
    }

    public LoginPage inputPassword(String password) {
        getDriver().findElement(By.name("j_password")).sendKeys(password);
        return this;
    }

    public DashboardPage login() {
        getDriver().findElement(By.name("Submit")).click();
        return new DashboardPage(getDriver());
    }

    public boolean invalidLogin() {
        String text = getDriver().findElement(By.name("login")).getText();
        return text.contains("Invalid username or password");
    }
}
