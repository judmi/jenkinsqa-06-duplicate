package school.redrover.model.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import school.redrover.model.base.BasePage;

public class ProjectPage extends BasePage {
    public ProjectPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (xpath = "//h1[ancestor::div[@id='main-panel']]")
    private WebElement titleOfNewProject;

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

    public String getProjectTitle() {
        return  titleOfNewProject.getText();
    }

    public RenameProjectPage clickOnRenameProject() {
        renamedProjectField.click();
        return new RenameProjectPage(getDriver());
    }

    public ProjectPage chooseDisableProject() {
        disableProjectButton.click();
        return this;
    }
    public ProjectPage pushDisable() {
        disableEnableProjectButton.click();
        return this;
    }
    public ProjectPage pushEnable() {
        disableEnableProjectButton.click();
        return this;
    }
    public ProjectPage clickAddDescription() {
        addDescriptionLink.click();
        return this;
    }

    public ProjectPage AddNewDescription() {
        descriptionField.sendKeys("Мой переименованный, c измененными настройками Pipeline");
        return this;
    }

    public ProjectPage saveDescription() {
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
