package school.redrover.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import school.redrover.model.base.BaseModel;

public class WelcomeToJenkinsPage extends BaseModel {

    public WelcomeToJenkinsPage(WebDriver driver) {
        super(driver);
    }

       public NewJobPage clickOnWelcomeToJenkinsField() {
        getDriver()
                .findElement(By.xpath("//a[@href = 'newJob']"))
                .click();

        return new NewJobPage(getDriver());
    }

}
