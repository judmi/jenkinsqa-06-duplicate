package school.redrover.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import school.redrover.model.base.BasePage;

import java.util.List;

public class UsersPage extends BasePage {
    public UsersPage(WebDriver driver) {
        super(driver);
    }

    public CreateUserPage clickCrateUserBtn() {
        getDriver().findElement(By.xpath("//a[@href = 'addUser']")).click();
        return new CreateUserPage(getDriver());
    }

    public boolean isUserExist(String name) {
        List<WebElement> users = getDriver().findElements(By
                .xpath("//a[@class ='jenkins-table__link model-link inside']"));
        for (WebElement element : users) {
            if (name.equals(element.getText())) {
                return true;
            }
        }
        return false;
    }
}
