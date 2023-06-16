package school.redrover.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import school.redrover.model.base.BasePage;

public class ProjectPage extends BasePage {
    public ProjectPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getTitleOfNewProject() {
        return getDriver().findElement(By.xpath("//h1[@class='job-index-headline page-headline']"));
    }

    public RenameProjectPage clickOnRenameProject() {
        WebElement renamePipeline = getDriver().findElement(By.linkText("Rename"));
        renamePipeline.click();
        return new RenameProjectPage(getDriver());
    }

    public ProjectPage chooseDisableProject() {
        WebElement disableProject = getDriver().findElement(By.xpath("//button[@class='jenkins-button  ']"));
        disableProject.click();
        return new ProjectPage(getDriver());
    }
    public ProjectPage pushDisable() {
        WebElement disableProject = getDriver().findElement(By.xpath("//button[@name='Submit']"));
        disableProject.click();
        return new ProjectPage(getDriver());
    }
    public ProjectPage pushEnable() {
        WebElement enableProject= getDriver().findElement(By.xpath("//button[@name='Submit']"));
        enableProject.click();
        return new ProjectPage(getDriver());
    }
    public ProjectPage clickAddDescription() {
        WebElement addDescription = getDriver().findElement(By.id("description-link"));
        addDescription.click();
        return new ProjectPage(getDriver());
    }

    public ProjectPage AddNewDescription() {
        WebElement writeNewDescription = getDriver().findElement(By.xpath("//textarea[@name='description']"));
        writeNewDescription.sendKeys("Мой переименованный, c измененными настройками Pipeline");
        return this;
    }

    public ProjectPage saveDescription() {
        WebElement saveNewDescription = getDriver().findElement
                (By.xpath("//button[@class='jenkins-button jenkins-button--primary ']"));
        saveNewDescription.click();
        return new ProjectPage(getDriver());
    }


    public WebElement textOfNewDescription() {
        return getDriver().findElement(By.xpath("//div[@id='description']/div"));
    }
    public WebElement projectIsDisabled() {
        return getDriver().findElement(By.xpath("//form[@id='enable-project']"));
    }
    public WebElement projectIsEnable() {
        return getDriver().findElement(By.xpath("//button[@name = 'Submit']"));
    }
}


