package school.redrover.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import school.redrover.model.base.BasePage;

public class NewItemPage extends BasePage {
    public NewItemPage(WebDriver driver) {
        super(driver);
    }
    @FindBy (id = "name")
    private WebElement name;

    @FindBy (xpath = "//li[@class = 'org_jenkinsci_plugins_workflow_job_WorkflowJob']")
    private WebElement choosePipeline;

    @FindBy(xpath = "//button[@id='ok-button']")
    private WebElement chooseOkButton;

    public NewItemPage chooseNameForProject(String namePipeline) {
        name.sendKeys("My Pipeline");
        return this;
    }

    public NewItemPage choosePipeline() {
        choosePipeline.click();
        return this;
    }

    public PipelineConfigPage clickOk() {
        chooseOkButton.click();
        return (new PipelineConfigPage(getDriver()));
    }
}
