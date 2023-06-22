package school.redrover.model.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import school.redrover.model.base.BasePage;
import school.redrover.model.page.config.FreestyleProjectConfigPage;
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
    private WebElement multiconfigurationalProjectItem;

    @FindBy(className = "hudson_model_FreeStyleProject")
    private WebElement freestyleProjectOption;

    public NewItemPage inputItemName(String itemName) {
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

    public NewItemPage selectFreestyleProject() {
        freestyleProjectOption.click();

        return this;
    }

    public FreestyleProjectConfigPage clickOkForFreestyleProject() {
        okButton.click();

        return new FreestyleProjectConfigPage(getDriver());
    }
}