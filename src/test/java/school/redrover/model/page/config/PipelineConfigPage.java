package school.redrover.model.page.config;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import school.redrover.model.base.BasePage;
import school.redrover.model.base.BaseProjectPage;

public class PipelineConfigPage extends BasePage {
    @FindBy (xpath = "//div[@class = 'samples']/select")
    private WebElement scriptMenu;

    @FindBy (name = "Submit")
    private WebElement submitButton;

    public PipelineConfigPage(WebDriver driver) {
        super(driver);
    }

    public PipelineConfigPage selectNewScript() {
        getDriver().findElement((By.xpath("//div[@class = 'samples']/select")));
        return this;
    }

    public PipelineConfigPage selectScriptedPipelineScript() {
        Select select = new Select(scriptMenu);
        select.selectByVisibleText("Scripted Pipeline");
        return this;
    }

    public BaseProjectPage saveChanges() {
        submitButton.click();
        return (new BaseProjectPage(getDriver()));
    }
}
