package school.redrover.model.page.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import school.redrover.model.base.BasePage;
import school.redrover.model.page.job.FreestyleProjectPage;

public class FreestyleProjectConfigPage extends BasePage {

    @FindBy(name = "Submit")
    private WebElement saveButton;

    public FreestyleProjectConfigPage(WebDriver driver) {
        super(driver);
    }

    public FreestyleProjectPage clickSaveButton() {
        saveButton.click();

        return new FreestyleProjectPage(getDriver());
    }
}
