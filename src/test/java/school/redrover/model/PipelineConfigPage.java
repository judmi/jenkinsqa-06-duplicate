package school.redrover.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import school.redrover.model.base.BasePage;

public class PipelineConfigPage extends BasePage {
    public PipelineConfigPage(WebDriver driver) {
        super(driver);
    }

    public PipelineConfigPage selectNewScript() {
        getDriver().findElement((By.xpath("//div[@class = 'samples']/select")));
        return this;
    }

    public PipelineConfigPage selectScriptedPipelineScript() {
        Select select = new Select(getDriver().findElement((By.xpath("//div[@class = 'samples']/select"))));
        select.selectByVisibleText("Scripted Pipeline");
        return this;
    }

    public ProjectPage saveChanges() {
        WebElement saveNewPipelineConfigure = getWait2().until(ExpectedConditions.visibilityOfElementLocated(By.name("Submit")));
        saveNewPipelineConfigure.click();
        return (new ProjectPage(getDriver()));
    }
}
