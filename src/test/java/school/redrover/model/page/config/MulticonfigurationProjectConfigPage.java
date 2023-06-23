package school.redrover.model.page.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import school.redrover.model.base.BasePage;
import school.redrover.model.base.BaseProjectPage;

public class MulticonfigurationProjectConfigPage extends BasePage {
    @FindBy (xpath = "//button[@name='Submit']")
    private WebElement saveButton;

    public MulticonfigurationProjectConfigPage(WebDriver driver) {
        super(driver);
    }

    public BaseProjectPage clickSaveButton() {
        getWait2().until(ExpectedConditions.elementToBeClickable(saveButton)).click();

        return new BaseProjectPage(getDriver());
    }
}

