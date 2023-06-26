package school.redrover.model.page.config;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import school.redrover.model.base.BasePage;
import school.redrover.model.page.job.ScanMultibranchPipelineLogPage;

import javax.swing.*;

public class MultibranchPipelineConfigPage extends BasePage {

    public String nameAndDescriptionOfProject = "My first Multibranch Pipeline";

    @FindBy (xpath="//input[@name='_.displayNameOrNull']")
     private WebElement displayNameField;

    @FindBy(xpath = "//textarea[@name='_.description']")
    private WebElement descriptionTextarea;

    @FindBy(xpath ="//span[@id='yui-gen1']")
    private WebElement branchSourcesMenu;

    @FindBy(className = "yui-button-selectedmenuitem")
    private WebElement gitItem;

    @FindBy(xpath = "//input[@name='_.remote']")
    private WebElement gitProjectLink;

    @FindBy(xpath = "//input[@name ='_.daysToKeepStr']")
    private WebElement keepOldItemsField;

    @FindBy(xpath = "//button[@name ='Submit']")
    private WebElement saveButton;

    public MultibranchPipelineConfigPage(WebDriver driver){super(driver);}

    public MultibranchPipelineConfigPage displayNameOfMultibranchPipeline() {
        displayNameField.sendKeys(nameAndDescriptionOfProject);
        return this;
    }

    public MultibranchPipelineConfigPage addDescription() {
        descriptionTextarea.sendKeys(nameAndDescriptionOfProject);
        return this;
    }

        public MultibranchPipelineConfigPage addChooseBranchSources(){
            branchSourcesMenu.click();
        return this;
    }

    public MultibranchPipelineConfigPage chooseGitAsSource(){
        gitItem.click();
        return this;
    }

    public MultibranchPipelineConfigPage addGitProject(){
     gitProjectLink.sendKeys("https://github.com/judmi/jenkinsqa-06-duplicate");
     return this;
    }

    public MultibranchPipelineConfigPage addRerunPeriod(){
        WebElement rerunPeriod = getDriver().findElement(By.xpath("//input[@name ='com-cloudbees-hudson-plugins-folder-computed-PeriodicFolderTrigger']"));
        new Actions(getDriver())
                .scrollToElement(rerunPeriod)
                .sendKeys("5")
                .perform();
                 return this;
    }

        public MultibranchPipelineConfigPage addKeepsOldItemsDay(){
        keepOldItemsField.sendKeys("5");
        return this;
    }

    public ScanMultibranchPipelineLogPage saveConfigChanges(){
        saveButton.click();
        return new ScanMultibranchPipelineLogPage(getDriver());
    }
}