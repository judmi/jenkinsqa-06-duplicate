package school.redrover.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import school.redrover.model.base.BasePage;

public class NewItemPage extends BasePage{
    public NewItemPage (WebDriver driver) {
        super(driver);
    }
    public NewItemPage chooseNameForProject(String NamePipeline){
        WebElement newPipelineName = getDriver().findElement(By.id("name"));
        newPipelineName.sendKeys(NamePipeline);
        return this;
    }
    public NewItemPage choosePipeline(){
        WebElement choosePipeline = getWait2().until(ExpectedConditions.elementToBeClickable(By.xpath
                ("//li[@class = 'org_jenkinsci_plugins_workflow_job_WorkflowJob']")));
        choosePipeline.click();
        return this;
    }
      public PipelineConfigPage clickOk(){
        WebElement chooseOkButton = getDriver().findElement(By.xpath("//button[@id='ok-button']"));
        chooseOkButton.click();
        return (new PipelineConfigPage(getDriver())) ;
    }
}
