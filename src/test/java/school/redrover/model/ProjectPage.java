package school.redrover.model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import school.redrover.model.base.BasePage;

public class ProjectPage extends BasePage {
    public ProjectPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (xpath = "//h1[@class='job-index-headline page-headline']")
    private WebElement titleOfProjectField;

    @FindBy (linkText=("Rename"))
    private WebElement renameProjectField;

    @FindBy (xpath = "//button[@class='jenkins-button  ']")
    private WebElement disableProjectButton;

    @FindBy (xpath = "//button[@name='Submit']")
    private WebElement disableEnableProjectButton;

    @FindBy ( id = "description-link")
    private WebElement addDescriptionLink;

    @FindBy (xpath = "//textarea[@name='description']")
    private WebElement NewDescriptionField;

    @FindBy (xpath = "//button[@class='jenkins-button jenkins-button--primary ']")
    private WebElement NewDescriptionSaveButton;

    @FindBy (xpath = "//div[@id='description']/div")
    private WebElement newDescriptionTitle;

    @FindBy (xpath = "//form[@id='enable-project']")
    private WebElement projectIsDisabledTitle;

    @FindBy (xpath = "//button[@name = 'Submit']")
    private WebElement projectIsEnableTitle;

    public WebElement getTitleOfNewProject() {
        return titleOfProjectField;
    }

    public RenameProjectPage clickOnRenameProject() {
        renameProjectField.click();
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
        NewDescriptionField.sendKeys("Мой переименованный, c измененными настройками Pipeline");
        return this;
    }

    public ProjectPage saveDescription() {
        NewDescriptionSaveButton.click();
        return this;
    }

    public WebElement textOfNewDescription() {
        return newDescriptionTitle;
    }
    public WebElement projectIsDisabled() {
        return projectIsDisabledTitle;
    }
    public WebElement projectIsEnable() {
        return projectIsEnableTitle;
    }
}
