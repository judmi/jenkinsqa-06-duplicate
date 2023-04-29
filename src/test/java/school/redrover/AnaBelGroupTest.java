package school.redrover;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import school.redrover.runner.BaseTest;

import static org.testng.Assert.assertEquals;

public class AnaBelGroupTest extends BaseTest {

    @Test
    public void testLogo() {
        WebElement logo = getDriver().findElement(By.id("jenkins-name-icon"));
        Assert.assertTrue(logo.isDisplayed());
    }

    @Test
    public void testBuildHistory() {
        WebElement buildHistory = getDriver().findElement(By.xpath("//a[@href ='/view/all/builds']"));

        assertEquals(buildHistory.getText(), "Build History");
    }

    public void testAddDescription() {
        WebElement button = getDriver().findElement(By.xpath("//a[@id='description-link']"));
        button.click();

        WebElement textField = getDriver().findElement(By.cssSelector(".jenkins-input"));
        textField.clear();
        textField.sendKeys("testDesctiprion1");

        WebElement buttonSave = getDriver().findElement(By.xpath("//button[@name='Submit']"));
        buttonSave.click();

        WebElement verify = getDriver().findElement(By.cssSelector("#description>div"));

        assertEquals(verify.getText(), "testDesctiprion1");
    }

    @Test
    public void testWelcomeJenkins() {
        WebElement welcomeElement = getDriver().findElement(By.xpath("//div[@class='empty-state-block']/h1"));

        Assert.assertEquals(welcomeElement.getText(), "Welcome to Jenkins!");
    }


}