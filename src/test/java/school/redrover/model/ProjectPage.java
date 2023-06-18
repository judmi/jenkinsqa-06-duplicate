package school.redrover.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import school.redrover.model.base.BasePage;

public class ProjectPage extends BasePage {
    public ProjectPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//h1[@class='job-index-headline page-headline']")
    private WebElement titleOfNewProject;
    @FindBy(linkText=("Rename"))
    private WebElement renameProject;
    @FindBy(xpath = "//button[@class='jenkins-button  ']")
    private WebElement disableProject;
    @FindBy(xpath = "//button[@name='Submit']")
    private WebElement confirmDisableProject;
    @FindBy(xpath = "//button[@name='Submit']")
    private WebElement confirmEnableProject;

    @FindBy( id = "description-link")
    private WebElement addDescription;
    @FindBy(xpath = "//textarea[@name='description']")
    private WebElement writeNewDescription;
    @FindBy(xpath = "//button[@class='jenkins-button jenkins-button--primary ']")
    private WebElement saveNewDescription;
    @FindBy(xpath = "//div[@id='description']/div")
    private WebElement textOfNewDescription;
    @FindBy(xpath = "//form[@id='enable-project']")
    private WebElement projectIsDisabled;
    @FindBy(xpath = "//button[@name = 'Submit']")
    private WebElement projectIsEnable;
    public WebElement getTitleOfNewProject() {
        return titleOfNewProject;
    }

    public RenameProjectPage clickOnRenameProject() {
        renameProject.click();
        return new RenameProjectPage(getDriver());
    }

    public ProjectPage chooseDisableProject() {
        disableProject.click();
        return this;
    }
    public ProjectPage pushDisable() {
        confirmDisableProject.click();
        return this;
    }
    public ProjectPage pushEnable() {
        confirmEnableProject.click();
        return this;
    }
    public ProjectPage clickAddDescription() {
       addDescription.click();
        return this;
    }

    public ProjectPage AddNewDescription() {
        writeNewDescription.sendKeys("Мой переименованный, c измененными настройками Pipeline");
        return this;
    }

    public ProjectPage saveDescription() {
        saveNewDescription.click();
        return this;
    }

    public WebElement textOfNewDescription() {
        return textOfNewDescription;
    }
    public WebElement projectIsDisabled() {
        return projectIsDisabled;
    }
    public WebElement projectIsEnable() {
        return projectIsEnable;
    }
}


