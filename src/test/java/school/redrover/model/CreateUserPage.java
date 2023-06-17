package school.redrover.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import school.redrover.model.base.BasePage;

public class CreateUserPage extends BasePage {


    public CreateUserPage(WebDriver driver) {
        super(driver);
    }

    public UsersPage fillInCredentialsAndSubmit(String userName, String password, String email) {
        fillInUserNameField(userName);
        fillInPasswordField(password);
        fillInConfirmPasswordField(password);
        fillInFullNameField(userName);
        fillInEmailField(email);
        clickCreateUserBtn();
        return new UsersPage(getDriver());
    }

    private void fillInUserNameField(String userName) {
        getDriver().findElement(By.xpath("//input[@name = 'username']")).sendKeys(userName);
    }

    private void fillInPasswordField(String password) {
        getDriver().findElement(By.xpath("//input[@name = 'password1']")).sendKeys(password);
    }

    private void fillInConfirmPasswordField(String password) {
        getDriver().findElement(By.xpath("//input[@name = 'password2']")).sendKeys(password);
    }

    private void fillInFullNameField(String userName) {
        getDriver().findElement(By.xpath("//input[@name = 'fullname']")).sendKeys(userName);
    }

    private void fillInEmailField(String email) {
        getDriver().findElement(By.xpath("//input[@name = 'email']")).sendKeys(email);
    }

    private void clickCreateUserBtn() {
        getWait2().until(ExpectedConditions.elementToBeClickable(By
                .xpath("//button[@name = 'Submit']"))).click();
    }
}
