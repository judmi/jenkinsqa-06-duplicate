package school.redrover.model.base;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


public abstract class BaseConfigPage<Self extends BaseConfigPage<?, ?>, JobPage extends BaseMainHeaderPage<?>> extends BaseMainHeaderPage<Self> {

    private final JobPage jobPage;

    public BaseConfigPage(JobPage jobPage) {
        super(jobPage.getDriver());
        this.jobPage = jobPage;
    }

    protected JobPage getJobPage() {
        return jobPage;
    }

    public JobPage clickSaveButton() {
        getWait2().until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@name='Submit']"))).click();
        return getJobPage();
    }

    public Self addDescription(String description) {
        getDriver().findElement(By.xpath("//textarea[contains(@name, 'description')]")).sendKeys(description);
        return (Self) this;
    }

    public WebElement viewDescription(){
        return getDriver().findElement(By.xpath("//*[@id=\"description\"]/div[1]"));
    }

    public String getDescription() {
        return getDriver().findElement(By.xpath("//*[@id='description']/div")).getText();
    }

}
