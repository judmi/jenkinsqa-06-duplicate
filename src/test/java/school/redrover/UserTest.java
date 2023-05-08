package school.redrover;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import school.redrover.runner.BaseTest;


    public class UserTest extends BaseTest {
        @Test
        public void testCreatingUser() throws InterruptedException {

            WebElement manageJenkins = getDriver().findElement(By.xpath("//a[@href='/manage']"));
            manageJenkins.click();

            WebElement manageUsers = getDriver().findElement(By.xpath("(//dt[normalize-space()='Manage Users'])[1]"));
            manageUsers.click();

            WebElement createUser = getDriver().findElement(By.xpath("//a[@href='addUser']"));
            createUser.click();

            WebElement userName = getDriver().findElement(By.xpath("//input[@id='username']"));
            userName.sendKeys("admin");

            WebElement password = getDriver().findElement(By.xpath("//input[@name='password1']"));
            password.sendKeys("admin");

            WebElement confirmPassword = getDriver().findElement(By.xpath(" //input[@name='password2']"));
            confirmPassword.sendKeys("admin");

            WebElement fullName = getDriver().findElement(By.xpath("//input[@name='fullname']"));
            fullName.sendKeys("admin");

            WebElement email = getDriver().findElement(By.xpath("//input[@name='email']"));
            email.sendKeys("admin@gmail.com");

            WebElement createUserButton = getDriver().findElement(By.xpath("//button[@name='Submit']"));
            createUserButton.click();

            WebElement createdUser = getDriver().findElement(By.xpath("//a[text()='admin']"));
            Assert.assertEquals(createdUser.getText(),"admin");
        }
    }

