package school.redrover.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import school.redrover.model.base.BasePage;

public class MainPage extends BasePage {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public ManageJenkinsPage clickManageJenkinsTab() {
        getDriver().findElement(By.xpath("//a[@href = '/manage']")).click();
        return new ManageJenkinsPage(getDriver());
    }
}

