package school.redrover.model.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import school.redrover.model.base.BasePage;
import school.redrover.model.page.config.FolderConfigPage;
import school.redrover.model.page.config.FreestyleProjectConfigPage;
import school.redrover.model.page.config.MultibranchPipelineConfigPage;
import school.redrover.model.page.config.MulticonfigurationProjectConfigPage;
import school.redrover.model.page.config.PipelineConfigPage;

public class NewItemPage extends BasePage {
    public NewItemPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "name")
    private WebElement nameField;

    @FindBy(xpath = "//li[@class = 'org_jenkinsci_plugins_workflow_job_WorkflowJob']")
    private WebElement choosenPipelineLink;

    @FindBy(xpath = "//button[@id='ok-button']")
    private WebElement okButton;

    @FindBy(xpath = "//li[descendant::input[@value ='hudson.matrix.MatrixProject']]")
    private WebElement multiconfigurationProjectItem;
    @FindBy(className = "hudson_model_FreeStyleProject")
    private WebElement freestyleProjectOption;

    @FindBy(className = "org_jenkinsci_plugins_workflow_multibranch_WorkflowMultiBranchProject")
    private WebElement multiBranchPipelineOption;

    @FindBy(id = "itemname-invalid")
    private WebElement invalidItemNameMessage;

    @FindBy(xpath ="//*[@class='com_cloudbees_hudson_plugins_folder_Folder']")
    private WebElement folderJob;

    public NewItemPage inputItemName(String itemName) {
        nameField.sendKeys(itemName);
        return this;
    }

    public NewItemPage selectPipeline() {
        choosenPipelineLink.click();
        return this;
    }
    public PipelineConfigPage clickOk() {
        okButton.click();
        return (new PipelineConfigPage(getDriver()));
    }

    public NewItemPage selectMulticonfigurationProjectItem() {
        multiconfigurationProjectItem.click();

        return this;
    }

    public MulticonfigurationProjectConfigPage clickOkButtonForMulticonfigurationProject() {
        okButton.click();
        return new MulticonfigurationProjectConfigPage(getDriver());
    }

    public NewItemPage selectFreestyleProject() {
        freestyleProjectOption.click();

        return this;
    }
    public NewItemPage selectMultibranchPipeline(){
        multiBranchPipelineOption.click();
        return this;
    }

    public FreestyleProjectConfigPage clickOkForFreestyleProject() {
        okButton.click();

        return new FreestyleProjectConfigPage(getDriver());
    }
    public MultibranchPipelineConfigPage clickOkForMultibranchPipeline(){
        okButton.click();
        return new MultibranchPipelineConfigPage(getDriver());
    }

    public boolean isOkButtonDisabled() {
        return !(okButton.isEnabled());
    }

    public String getInvalidItemNameMessage() {
        return getWait5().until(ExpectedConditions.visibilityOf(invalidItemNameMessage)).getText();
    }

    public NewItemPage selectFolder() {
        folderJob.click();

        return this;
    }

    public FolderConfigPage clickOkButtonForFolder() {
        okButton.click();

        return new FolderConfigPage(getDriver());
    }

}