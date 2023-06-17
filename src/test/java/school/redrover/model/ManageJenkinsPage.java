package school.redrover.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import school.redrover.model.base.BasePage;

public class ManageJenkinsPage extends BasePage {
    public ManageJenkinsPage(WebDriver driver) {
        super(driver);
    }

    public UsersPage clickManageUsersSection() {
        getDriver().findElement(By.xpath("//a[@href = 'securityRealm/']")).click();
        return new UsersPage(getDriver());
    }
}
