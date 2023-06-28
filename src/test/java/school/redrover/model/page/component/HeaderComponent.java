package school.redrover.model.page.component;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import school.redrover.model.base.BasePage;
import school.redrover.model.base.Header;
import school.redrover.model.page.LoginPage;

public class HeaderComponent extends BasePage implements Header {

    @FindBy(xpath = "//a[@href = '/logout']")
    private WebElement logoutLink;

    public HeaderComponent(WebDriver driver) {
        super(driver);
    }

    @Override
    public LoginPage clickLogout() {
        logoutLink.click();
        return new LoginPage(getDriver());
    }
}
