package school.redrover.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import school.redrover.model.base.BasePage;

public class MultibranchPipelineConfigPage extends BasePage {

    public String nameAndDescriptionOfProject = "My first Multibranch Pipeline";

    @FindBy (xpath="//input[@name='_.displayNameOrNull']")
     private WebElement displayNameField;

    @FindBy(xpath = "//textarea[@name='_.description']")
    private WebElement descriptionTextarea;

    @FindBy(xpath ="//span[@id='yui-gen1']")
    private WebElement branchSourcesMenu;
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
}
