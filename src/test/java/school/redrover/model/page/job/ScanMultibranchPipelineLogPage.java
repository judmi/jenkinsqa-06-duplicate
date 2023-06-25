package school.redrover.model.page.job;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import school.redrover.model.base.BasePage;



public class ScanMultibranchPipelineLogPage extends BasePage {
    @FindBy(xpath = "//h1[@class = 'icon-pipeline-multibranch-project']")
    private WebElement pageTitle;
    @FindBy(xpath = "//h1[ancestor::div[@id='main-panel']]")
    private WebElement projectName;

    public ScanMultibranchPipelineLogPage(WebDriver driver) {super(driver);}

    public ScanMultibranchPipelineLogPage getStatus(){
        getWait2().until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Status"))).click();
        return this;
    }
    public String getTitle() {
        return projectName.getText();}
}
