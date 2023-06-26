package school.redrover.model.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy ;
import school.redrover.model.base.BasePage;
import school.redrover.model.base.BaseProjectPage;

public class RenameProjectPage extends BasePage {
    @FindBy (xpath = "//input [@name='newName']")
    private WebElement oldNameField;

    @FindBy (xpath = "//input [@name='newName']")
    private WebElement newNameField;

    @FindBy (xpath = "//button [@name='Submit']")
    private WebElement newNameSaveButton;

    final String NamePipeline = "My Pipeline1";

    public RenameProjectPage(WebDriver driver) {
        super(driver);
    }



    public RenameProjectPage clearOldName() {
        oldNameField.clear();
        return this;
    }

    public RenameProjectPage inputNewProjectName(String newName) {
        newNameField.sendKeys(newName);
        return this;
    }

    public BaseProjectPage clickRenameButton() {
        newNameSaveButton.click();

        return new BaseProjectPage(getDriver());
    }
}
