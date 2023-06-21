package school.redrover.model;

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
    private WebElement addBranchSourcesMenu;
    public MultibranchPipelineConfigPage(WebDriver driver){super(driver);}

    public MultibranchPipelineConfigPage displayNameOfMultibranchPipeline() {
        displayNameField.sendKeys(nameAndDescriptionOfProject);
        return this;
    }
    public MultibranchPipelineConfigPage description() {
        descriptionTextarea.sendKeys(nameAndDescriptionOfProject);
        return this;
    }
        public MultibranchPipelineConfigPage chooseBranchSources(){
            addBranchSourcesMenu.click();
        return this;
    }




}
