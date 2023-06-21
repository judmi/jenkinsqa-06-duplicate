package school.redrover.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import school.redrover.model.base.BasePage;

public class NewItemPage extends BasePage{
    public NewItemPage (WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "name")
    private WebElement nameField;

    @FindBy (xpath = "//li[@class = 'org_jenkinsci_plugins_workflow_job_WorkflowJob']")
    private WebElement choosePipelineLink;

    @FindBy(xpath = "//button[@id='ok-button']")
    private WebElement chooseOkButton;

    public NewItemPage chooseNameForProject(String namePipeline) {
        nameField.sendKeys("My Pipeline");
        return this;
    }

    public NewItemPage choosePipeline() {
        choosePipelineLink.click();
        return this;
    }

    public PipelineConfigPage clickOk() {
        chooseOkButton.click();
        return (new PipelineConfigPage(getDriver()));
    }

    public MultibranchPipelineConfigPage chooseMultibranchPipelineAndClickOk() {
        WebElement multibranchPipeline = getDriver().findElement(By.linkText("Multibranch Pipeline"));
        multibranchPipeline.click();
        chooseOkButton.click();
        return new MultibranchPipelineConfigPage(getDriver());
    }
}
