package school.redrover.model;

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
    private WebElement newDescriptionField;

    @FindBy(xpath = "//button[@class='jenkins-button jenkins-button--primary ']")
    private WebElement newDescriptionSaveButton;

    @FindBy(xpath = "//div[@id='description']/div")
    private WebElement newDescriptionTitle;

    @FindBy(xpath = "//form[@id='enable-project']")
    private WebElement projectIsDisabledTitle;

    @FindBy(xpath = "//button[@name = 'Submit']")
    private WebElement projectIsEnableTitle;

    public WebElement getTitleOfNewProject() {
        return  titleOfNewProject;
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
        newDescriptionField.sendKeys("Мой переименованный, c измененными настройками Pipeline");
        return this;
    }

    public ProjectPage saveDescription() {
        newDescriptionSaveButton.click();
        return this;
    }

    public WebElement getTextOfNewDescription() {
        return newDescriptionTitle;
    }
    public WebElement makeProjectIsDisabled() {
        return projectIsDisabledTitle;
    }
    public WebElement makeProjectIsEnable() {
        return projectIsEnableTitle;
    }
}
