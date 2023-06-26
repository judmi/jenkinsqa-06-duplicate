package school.redrover.model.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import school.redrover.model.base.BasePage;
import school.redrover.model.page.config.UserConfigPage;

public class UserPage extends BasePage {
    @FindBy(xpath = "//button[@name = 'Submit']")
    private WebElement yesBtn;

    @FindBy(xpath = "//a[contains(@href, 'configure')]")
    private WebElement configureLink;

    public UserPage(WebDriver driver) {
        super(driver);
    }

    public MainPage clickYesBtn() {
        yesBtn.click();
        return new MainPage(getDriver());
    }

    public UserConfigPage clickConfigureInSidebar() {
        configureLink.click();
        return new UserConfigPage(getDriver());
    }
}
