package school.redrover.model;

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

    final String NamePipeline = "My Pipeline1";

    public RenameProjectPage(WebDriver driver) {
        super(driver);
    }



    public RenameProjectPage clearOldName() {
        oldNameField.clear();
        return this;
    }

    public RenameProjectPage writeNewName() {
        newNameField.sendKeys(NamePipeline);
        return this;
    }

    public MainPage submitRename() {
        newNameSaveButton.click();
        return new MainPage(getDriver());
    }
}
