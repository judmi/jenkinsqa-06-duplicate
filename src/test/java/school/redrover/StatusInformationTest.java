package school.redrover;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import school.redrover.runner.BaseTest;

public class StatusInformationTest extends BaseTest {

    @Test
    public void testMainPageJenkins() {
        WebElement mainPage = getDriver().findElement(By.xpath("//div[@class='empty-state-block']/h1"));

        Assert.assertEquals(mainPage.getText(),"Добро пожаловать в Jenkins!");
        }
}