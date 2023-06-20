package school.redrover.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import school.redrover.model.base.BasePage;

import java.util.List;

public class UsersDatabasePage extends BasePage {

    @FindBy(xpath = "//a[@href = 'addUser']")
    private WebElement createUserBtn;

    @FindBy(xpath = "//a[@class ='jenkins-table__link model-link inside']")
    private List<WebElement> usersTable;

    public UsersDatabasePage(WebDriver driver) {
        super(driver);
    }

    public CreateUserPage clickCrateUserBtn() {
        createUserBtn.click();
        return new CreateUserPage(getDriver());
    }

    public boolean isUserExist(String name) {
        List<WebElement> users = usersTable;
        for (WebElement element : users) {
            if (name.equals(element.getText())) {
                return true;
            }
        }
        return false;
    }

    public UserPage clickDeleteInDropdownMenu(String userName) {
        Actions action = new Actions(getDriver());
        action
                .moveToElement(getDriver().findElement(By
                        .xpath("//a[@href = 'user/" + userName.toLowerCase() + "/']")))
                .moveToElement(getDriver().findElement(By
                        .xpath("//a[@href = 'user/" +
                                userName.toLowerCase() + "/']/button[@class = 'jenkins-menu-dropdown-chevron']")))
                .click()
                .perform();
        getWait2().until(ExpectedConditions.visibilityOfElementLocated(By
                        .xpath("//a[@href = '/user/" + userName.toLowerCase() + "/delete']")))
                .click();
        return new UserPage(getDriver());
    }
}
