package school.redrover.model.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import school.redrover.model.page.RenameProjectPage;

public class BaseProjectPage extends BasePage {

    @FindBy(xpath = "//h1[ancestor::div[@id='main-panel']]")
    private WebElement projectName;

    @FindBy(linkText = ("Rename"))
    private WebElement renamedProjectField;

    @FindBy(xpath = "//button[@class='jenkins-button  ']")
    private WebElement disableProjectButton;

    @FindBy(xpath = "//button[@name='Submit']")
    private WebElement disableEnableProjectButton;

    @FindBy(id = "description-link")
    private WebElement addDescriptionLink;

    @FindBy(xpath = "//textarea[@name='description']")
    private WebElement descriptionField;

    @FindBy(xpath = "//button[@class='jenkins-button jenkins-button--primary ']")
    private WebElement descriptionSaveButton;

    @FindBy(xpath = "//div[@id='description']/div")
    private WebElement descriptionTitle;

    @FindBy(xpath = "//div[@class='warning']")
    private WebElement projectIsDisabledTitle;

    @FindBy(xpath = "//button[@name = 'Submit']")
    private WebElement projectIsEnableTitle;

    public BaseProjectPage(WebDriver driver) {
        super(driver);
    }

    public String getProjectName() {
        return projectName.getText();
    }

    public RenameProjectPage clickOnRenameProject() {
        renamedProjectField.click();
        return new RenameProjectPage(getDriver());
    }

    public BaseProjectPage chooseDisableProject() {
        disableProjectButton.click();
        return this;
    }

    public BaseProjectPage pushDisable() {
        disableEnableProjectButton.click();
        return this;
    }

    public BaseProjectPage pushEnable() {
        disableEnableProjectButton.click();
        return this;
    }

    public BaseProjectPage clickAddDescription() {
        addDescriptionLink.click();
        return this;
    }

    public BaseProjectPage AddNewDescription() {
        descriptionField.sendKeys("Мой переименованный, c измененными настройками Pipeline");
        return this;
    }

    public BaseProjectPage saveDescription() {
        descriptionSaveButton.click();
        return this;
    }

    public String getTextOfNewDescription() {
        return descriptionTitle.getText();
    }

    public String getWarningMessage() {
        return projectIsDisabledTitle.getText();
    }

    public String getProjectIsEnabledConfirmation() {
        return projectIsEnableTitle.getText();
    }
}