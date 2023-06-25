package school.redrover.model.page.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import school.redrover.model.base.BasePage;
import school.redrover.model.base.BaseProjectPage;


public class FolderConfigPage extends BasePage {

    @FindBy(xpath = "//button[@name='Submit']")
    public WebElement saveButton;

    public FolderConfigPage(WebDriver driver) {
        super(driver);
    }

    public BaseProjectPage clickSaveButton() {
        saveButton.click();

        return new BaseProjectPage(getDriver());
    }
}

