package school.redrover;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import school.redrover.runner.BaseTest;

public class CreateFreestyleProject2Test extends BaseTest {

    @Test
    public void testCreateNewFreestyleProject() {

        String expectedResult = "NewProject";

        getDriver().findElement(By.xpath("//span[text()='New Item']/../..")).click();

        WebElement itemName = getDriver().findElement(By.id("name"));
        itemName.click();
        itemName.sendKeys("NewProject");
        getDriver().findElement(By.xpath("//span [@class = 'label']")).click();
        getDriver().findElement(By.id("ok-button")).click();

        getDriver().findElement(By.xpath("//button [@name = 'Submit']")).click();

        getDriver().findElement(By.xpath("//li [@class='jenkins-breadcrumbs__list-item']")).click();

        String actualResult = getDriver().findElement(By.xpath("//a [@href = 'job/NewProject/']/span"))
                .getText();

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(dependsOnMethods = "testCreateNewFreestyleProject")
    public void testDisableFreestyleProject() {
        getDriver().findElement(By.xpath("//a [@href = 'job/NewProject/']/span")).click();

        WebElement disableProject = getWait5().until(ExpectedConditions.elementToBeClickable(getDriver().findElement(
                By.xpath("//button[@name='Submit']"))));
        disableProject.click();

        WebElement actualErrorMessageWarning = getDriver().findElement(By.id("enable-project"));
        Assert.assertEquals(actualErrorMessageWarning.getText().substring(0, 34), "This project is currently disabled");

        getDriver().findElement(By.xpath("//*[@id='jenkins-head-icon']")).click();

        WebElement iconDisabled = getDriver().findElement(By.xpath("//*[@tooltip='Disabled']"));

        Assert.assertTrue(iconDisabled.isDisplayed());
    }
}