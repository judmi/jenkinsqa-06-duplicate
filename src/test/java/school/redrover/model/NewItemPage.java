package school.redrover.model;

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
    private WebElement choosenPipelineLink;

    @FindBy(xpath = "//button[@id='ok-button']")
    private WebElement okButton;

    @FindBy(xpath = "//li[descendant::input[@value ='hudson.matrix.MatrixProject']]")
    private WebElement multiconfigurationalProjectItem;

    public NewItemPage chooseNameForProject(String itemName) {
        nameField.sendKeys(itemName);
        return this;
    }

    public NewItemPage choosePipeline() {
        choosenPipelineLink.click();
        return this;
    }

    public PipelineConfigPage clickOk() {
        okButton.click();
        return (new PipelineConfigPage(getDriver()));
    }

    public NewItemPage clickMulticonfigurationalProjectItem() {
        multiconfigurationalProjectItem.click();

        return this;
    }

    public MulticonfigurationProjectConfigPage clickOkButtonForMulticonfigurationProject() {
        okButton.click();
        return new MulticonfigurationProjectConfigPage(getDriver());
    }
}