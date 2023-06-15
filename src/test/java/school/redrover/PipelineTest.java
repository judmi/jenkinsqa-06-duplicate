package school.redrover;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import school.redrover.runner.BaseTest;

public class PipelineTest extends BaseTest {
    final String NamePipeline = "My Pipeline";

    @Test
    public void testCreateNewPipelineWithScript() {
        WebElement newJobButton = getDriver().findElement(By.xpath("//a[@href='/view/all/newJob']"));
        newJobButton.click();
        WebElement newPipelineName = getDriver().findElement(By.id("name"));
        newPipelineName.sendKeys(NamePipeline);
        WebElement choosePipeline = getWait2().until(ExpectedConditions.elementToBeClickable(By.xpath
                ("//li[@class = 'org_jenkinsci_plugins_workflow_job_WorkflowJob']")));
        choosePipeline.click();
        WebElement chooseOkButton = getDriver().findElement(By.xpath("//button[@id='ok-button']"));
        chooseOkButton.click();
        WebElement chooseScript = getDriver().findElement((By.xpath("//div[@class = 'samples']/select")));
        Select select = new Select(chooseScript);
        select.selectByVisibleText("Scripted Pipeline");
        WebElement saveNewPipelineConfigure = getWait2().until(ExpectedConditions.visibilityOfElementLocated(By.name("Submit")));
        saveNewPipelineConfigure.click();

        Assert.assertEquals(getDriver().findElement(By.xpath("//h1[@class='job-index-headline page-headline']")).getText(),
                "Pipeline " + NamePipeline);
    }

    @Test(dependsOnMethods = "testCreateNewPipelineWithScript")
    public void testRenamePipeline() {
        getDriver().findElement(By.xpath("//a[@class='jenkins-table__link model-link inside']")).click();
        WebElement renamePipeline = getDriver().findElement(By.linkText("Rename"));
        renamePipeline.click();
        WebElement newName = getDriver().findElement(By.xpath("//input [@name='newName']"));
        newName.clear();
        newName.sendKeys(NamePipeline + 1);
        WebElement submitNewName = getDriver().findElement(By.xpath("//button [@name='Submit']"));
        submitNewName.click();

        Assert.assertEquals(getDriver().findElement(By.xpath("//h1 [@class='job-index-headline page-headline']"))
                        .getText(),
                "Pipeline " + NamePipeline + 1);
    }

    @Test(dependsOnMethods = "testCreateNewPipelineWithScript")
    public void testDisablePipeline() {
        getDriver().findElement(By.xpath("//a[@class='jenkins-table__link model-link inside']")).click();
        getDriver().findElement(By.xpath("//button[@class='jenkins-button  ']")).click();

        Assert.assertEquals(getDriver().findElement(By.xpath("//form[@id='enable-project']")).getText(),
                "This project is currently disabled\n" +
                        "Enable");
    }

    @Test(dependsOnMethods = {"testCreateNewPipelineWithScript", "testDisablePipeline"})
    public void testEnablePipeline() {
        getDriver().findElement(By.xpath("//a[@class='jenkins-table__link model-link inside']")).click();
        getDriver().findElement(By.xpath("//button[@name = 'Submit']")).click();

        Assert.assertEquals(getDriver().findElement(By.xpath("//button[@name = 'Submit']")).getText(),
                "Disable Project");
    }

    @Test(dependsOnMethods = "testCreateNewPipelineWithScript")
    public void testAddDescription() {
        getDriver().findElement(By.xpath("//a[@class='jenkins-table__link model-link inside']")).click();
        getDriver().findElement(By.id("description-link")).click();

        WebElement writeNewDescription = getDriver().findElement(By.xpath("//textarea[@name='description']"));
        writeNewDescription.sendKeys("Мой переименованный, c измененными настройками Pipeline");
        WebElement saveNewDescription = getDriver().findElement
                (By.xpath("//button[@class='jenkins-button jenkins-button--primary ']"));
        saveNewDescription.click();

        Assert.assertEquals(getDriver().findElement(By.xpath("//div[@id='description']/div")).getText(),
                "Мой переименованный, c измененными настройками Pipeline");

    }
}