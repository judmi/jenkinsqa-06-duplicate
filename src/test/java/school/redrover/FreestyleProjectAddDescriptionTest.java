package school.redrover;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import school.redrover.runner.BaseTest;


public class FreestyleProjectAddDescriptionTest extends BaseTest {

    private static final By DESCRIPTION_FIELD = By.xpath("//textarea[@name='description']");
    private static final By OK_BUTTON = By.xpath("//button[@name='Submit']");
    private static final By PROJECT_DESCRIPTION = By.xpath("//div[@id='description']/div[1]");
    private static final By CONFIGURE_OPTION = By.xpath("//span[contains(text(), 'Configure')]/ancestor::a");

    private void createFreestyleProject(String projectName) {
        getDriver().findElement(By.xpath("//a[contains(@href, 'newJob')]")).click();
        getWait2().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(@class, 'FreeStyleProject')]/label"))).click();
        getDriver().findElement(By.xpath("//input[@id='name']")).sendKeys(projectName);
        getDriver().findElement(By.xpath("//button[@id='ok-button']")).click();
        getDriver().findElement(By.xpath("//button[@name='Submit']")).click();
        getDriver().findElement(By.xpath("//a[contains(text(), 'Dashboard')]")).click();
    }

    private static String projectNameXpath(String projectName) {
        return "//span[contains(text(),'" + projectName + "')]/ancestor::a";
    }

    @Test
    public void testAddDescriptionToTheProjectViaConfigure() {
        String nameOfProject = "Leprechaun";
        createFreestyleProject(nameOfProject);

        WebElement jobProjectName = getDriver().findElement(By.xpath(projectNameXpath(nameOfProject)));
        WebElement projectDropdownArrow = getDriver().findElement(By.xpath(projectNameXpath(nameOfProject) + "//button[contains(@class, 'chevron')]"));

        new Actions(getDriver())
                .moveToElement(jobProjectName)
                .click(projectDropdownArrow)
                .build().perform();

        WebElement configureOption = getWait2().until(ExpectedConditions.visibilityOfElementLocated(CONFIGURE_OPTION));
        new Actions(getDriver())
                .moveToElement(configureOption)
                .click()
                .build().perform();

        String descriptionText = "My project description!";
        getDriver().findElement(DESCRIPTION_FIELD).sendKeys(descriptionText);
        getDriver().findElement(OK_BUTTON).click();
        Assert.assertEquals(getDriver().findElement(PROJECT_DESCRIPTION).getText(), descriptionText);
    }

}
