package school.redrover;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import school.redrover.runner.BaseTest;

public class UserTest extends BaseTest {

        private static final String USERDATA = "user1";
        @Test
        public void testCreatingUser() {
            WebElement manageJenkins = getDriver().findElement(By.xpath("//a[@href='/manage']"));
            manageJenkins.click();

            WebElement manageUsers = getDriver().findElement(By.xpath("(//dt[normalize-space()='Manage Users'])[1]"));
            manageUsers.click();

            WebElement createUser = getDriver().findElement(By.xpath("//a[@href='addUser']"));
            createUser.click();

            WebElement userName = getDriver().findElement(By.xpath("//input[@id='username']"));
            userName.sendKeys(USERDATA);

            WebElement password = getDriver().findElement(By.xpath("//input[@name='password1']"));
            password.sendKeys(USERDATA);

            WebElement confirmPassword = getDriver().findElement(By.xpath(" //input[@name='password2']"));
            confirmPassword.sendKeys(USERDATA);

            WebElement fullName = getDriver().findElement(By.xpath("//input[@name='fullname']"));
            fullName.sendKeys(USERDATA);

            WebElement email = getDriver().findElement(By.xpath("//input[@name='email']"));
            email.sendKeys("user1@gmail.com");

            WebElement createUserButton = getDriver().findElement(By.xpath("//button[@name='Submit']"));
            createUserButton.click();

            WebElement createdUserLink = getWait2().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[normalize-space()='" + USERDATA + "']")));
            Assert.assertTrue(createdUserLink.isDisplayed());

        }
    }

