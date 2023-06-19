package school.redrover.model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy ;
import school.redrover.model.base.BasePage;

public class RenameProjectPage extends BasePage {
    String NamePipeline = "My Pipeline1";

    public RenameProjectPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (xpath = "//input [@name='newName']")
    private WebElement oldName;
    @FindBy (xpath = "//input [@name='newName']")
    private WebElement newName;
    @FindBy (xpath = "//button [@name='Submit']")
    private WebElement submitNewName;

    public RenameProjectPage clearOldName() {
        oldName.clear();
        return this;
    }

    public RenameProjectPage writeNewName() {
        newName.sendKeys(NamePipeline);
        return this;
    }

    public MainPage submitRename() {
        submitNewName.click();
        return new MainPage(getDriver());
    }
}
