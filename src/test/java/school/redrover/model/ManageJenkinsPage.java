package school.redrover.model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import school.redrover.model.base.BasePage;

public class ManageJenkinsPage extends BasePage {

    @FindBy (xpath = "//a[@href = 'securityRealm/']")
    WebElement manageUsersSection;

    public ManageJenkinsPage(WebDriver driver) {
        super(driver);
    }

    public UsersDatabasePage clickManageUsersSection() {
        manageUsersSection.click();
        return new UsersDatabasePage(getDriver());
    }
}
