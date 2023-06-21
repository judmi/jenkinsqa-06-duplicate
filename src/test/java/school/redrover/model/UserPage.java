package school.redrover.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import school.redrover.model.base.BasePage;

public class UserPage extends BasePage {
    @FindBy(xpath = "//button[@name = 'Submit']")
    private WebElement yesBtn;

    public UserPage(WebDriver driver) {
        super(driver);
    }

    public MainPage clickYesBtn() {
        yesBtn.click();
        return new MainPage(getDriver());
    }
}
