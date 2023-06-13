package school.redrover;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import school.redrover.model.MainPage;
import school.redrover.runner.BaseTest;

import java.util.ArrayList;
import java.util.List;

public class ConfigureGlobalSecurityTest extends BaseTest {
    public void navigateToConfigureGlobalSecurityPage() {
        getDriver().findElement(By.xpath("//a[@href='/manage']")).click();
        getDriver().findElement(By.xpath("//dt[text()='Configure Global Security']")).click();
        getWait5().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[text()='Configure Global Security']")));
    }

    @Test
    public void testCheckTitleTexts() {
        List<String> expectedTitleTexts = List.of(
                "Authentication",
                "Markup Formatter",
                "Agents",
                "CSRF Protection",
                "Git plugin notifyCommit access tokens",
                "Git Hooks",
                "Hidden security warnings",
                "API Token",
                "SSH Server",
                "Git Host Key Verification Configuration");

        navigateToConfigureGlobalSecurityPage();

        List<WebElement> titles = getDriver().findElements(By.cssSelector(".jenkins-section__title"));
        List<String> actualTitleTexts = new ArrayList<>();
        for (WebElement element : titles) {
            actualTitleTexts.add(element.getText());
        }
        Assert.assertEquals(actualTitleTexts, expectedTitleTexts);
    }

    @Test
    public void testCheckNumberOfTitles() {
        int expectedNumberOfTitles = 10;

        int actualNumberOfTitles = new MainPage(getDriver())
                .navigateToConfigureGlobalSecurityPage()
                .getNumberOfTitles();

        Assert.assertEquals(actualNumberOfTitles, expectedNumberOfTitles);
    }

    @Test
    public void testCheckNumberOfHelpButton() {
        int expectedNumberOfHelpButton = 15;

        int actualNumberOfHelpButton = new MainPage(getDriver())
                .navigateToConfigureGlobalSecurityPage()
                .getNumberOfHelpButton();

        Assert.assertEquals(actualNumberOfHelpButton, expectedNumberOfHelpButton);
    }

    @Ignore
    @Test
    public void testHostKeyVerificationStrategyDropdownMenuOptions() {
        List<String> expectedMenuNames = List.of(
                "Accept first connection",
                "Known hosts file",
                "Manually provided keys",
                "No verification");

        List<String> actualMenuNames = new MainPage(getDriver())
                .navigateToManageJenkinsPage()
                .clickConfigureGlobalSecurity()
                .navigateToHostKeyVerificationStrategyDropdownAndClick()
                .getDropDownMenuTexts();

        Assert.assertEquals(actualMenuNames, expectedMenuNames);
    }

    @Test
    public void testAPICheckboxesAreClickable() {
        boolean allChecksAreOk = new MainPage(getDriver())
                .navigateToManageJenkinsPage()
                .clickConfigureGlobalSecurity()
                .checkAPICheckBoxes();

        Assert.assertTrue(allChecksAreOk);
    }

    @Test
    public void testRadioButtonsAreClickable() {
        boolean allChecksAreOk = new MainPage(getDriver())
                .navigateToManageJenkinsPage()
                .clickConfigureGlobalSecurity()
                .checkRadioButtons();

        Assert.assertTrue(allChecksAreOk);
    }
}