package school.redrover.model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import school.redrover.model.base.BasePage;

import java.util.List;

public class UsersPage extends BasePage {

    @FindBy (xpath = "//a[@href = 'addUser']")
    private WebElement createUserBtn;

    @FindBy (xpath = "//a[@class ='jenkins-table__link model-link inside']")
    private List<WebElement> usersTable;

    public UsersPage(WebDriver driver) {
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
}