package school.redrover.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import school.redrover.model.base.BasePage;

public class MainPage extends BasePage {

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
        getDriver().findElement(By.xpath("//a[@href = '/manage']")).click();
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
}