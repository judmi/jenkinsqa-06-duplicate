package school.redrover.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import school.redrover.model.base.BasePage;

public class MainPage extends BasePage {
    @FindBy(xpath = "//a[@href = '/manage']")
    WebElement manageJenkinsTab;

    @FindBy(xpath = "//a[@href = '/logout']")
    WebElement logout;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public NewItemPage chooseNewItem() {
        WebElement newItemButton = getDriver().findElement(By.xpath("//a[@href='/view/all/newJob']"));
        newItemButton.click();
        return (new NewItemPage(getDriver()));
    }

    public WebElement getTitleOfNewProject() {
        return getDriver().findElement(By.xpath("//h1[@class='job-index-headline page-headline']"));
    }

    public ManageJenkinsPage clickManageJenkinsTab() {
        getWait10().until(ExpectedConditions.elementToBeClickable(manageJenkinsTab)).click();
        return new ManageJenkinsPage(getDriver());
    }


    public ProjectPage clickOnProject() {
        WebElement chooseProject = getDriver().findElement(By.xpath("//a[@class='jenkins-table__link model-link inside']"));
        chooseProject.click();
        return new ProjectPage(getDriver());
    }

    public WebElement getNewNameOfProjectAfterRenaming() {
        return getDriver().findElement(By.xpath("//h1 [@class='job-index-headline page-headline']"));
    }

    public UsersDatabasePage getUsersDataBase() {
        clickManageJenkinsTab()
                .clickManageUsersSection();
        return new UsersDatabasePage(getDriver());
    }

    public LoginPage clickLogout(){
        logout.click();
        return new LoginPage(getDriver());
    }
}