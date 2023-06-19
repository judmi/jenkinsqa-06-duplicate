package school.redrover.model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import school.redrover.model.base.BasePage;

public class MainPage extends BasePage {
    @FindBy(xpath = "//a[@href = '/manage']")
    private WebElement manageJenkinsTab;

    @FindBy(xpath ="//a[@href='/view/all/newJob']")
    private WebElement newItemButton;

    @FindBy (xpath = "//h1[@class='job-index-headline page-headline']")
    private WebElement titleOfNewProject;

    @FindBy (xpath = "//a[@class='jenkins-table__link model-link inside']")
    private WebElement chooseProject;

    @FindBy (xpath="//h1 [@class='job-index-headline page-headline']")
    private WebElement nameOfProjectAfterRename;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public NewItemPage chooseNewItem() {
        newItemButton.click();
        return (new NewItemPage(getDriver()));
    }

    public WebElement getTitleOfNewProject() {
        return titleOfNewProject;
    }

    public ManageJenkinsPage clickManageJenkinsTab() {
        manageJenkinsTab.click();
        return new ManageJenkinsPage(getDriver());
    }


    public ProjectPage clickOnProject() {
        chooseProject.click();
        return new ProjectPage(getDriver());
    }

    public WebElement getNewNameOfProjectAfterRename() {
        return nameOfProjectAfterRename;
    }
}