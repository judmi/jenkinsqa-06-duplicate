package school.redrover.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy ;
import school.redrover.model.base.BasePage;

public class RenameProjectPage extends BasePage {
    @FindBy (xpath = "//input [@name='newName']")
    private WebElement oldNameField;

    @FindBy (xpath = "//input [@name='newName']")
    private WebElement newNameField;

    @FindBy (xpath = "//button [@name='Submit']")
    private WebElement newNameSaveButton;



    public RenameProjectPage(WebDriver driver) {
        super(driver);
    }



    public RenameProjectPage clearOldName() {
        oldNameField.clear();
        return this;
    }

    public RenameProjectPage writeNewName(String newName) {
        newNameField.sendKeys(newName);
        return this;
    }

    public ProjectPage submitRename() {
        newNameSaveButton.click();

        return new ProjectPage(getDriver());
    }
}
