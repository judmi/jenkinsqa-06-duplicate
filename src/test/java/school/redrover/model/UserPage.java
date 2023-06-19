package school.redrover.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import school.redrover.model.base.BasePage;

public class UserPage extends BasePage {
    public UserPage(WebDriver driver) {
        super(driver);
    }

    public MainPage clickYesBtn() {
        getDriver().findElement(By.xpath("//button[@name = 'Submit']")).click();
        return new MainPage(getDriver());
    }
}
