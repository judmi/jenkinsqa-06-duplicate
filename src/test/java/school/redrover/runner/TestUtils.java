package school.redrover.runner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestUtils {

    private static void createProject(BaseTest baseTest, String name) {
        baseTest.getDriver().findElement(By.linkText("New Item")).click();
        baseTest.getWait2().until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='name']"))).sendKeys(name);
    }

    private static void saveProject(BaseTest baseTest, Boolean goToHomePage) {
        baseTest.getWait2().until(ExpectedConditions.elementToBeClickable(By.id("ok-button"))).click();
        baseTest.getWait2().until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@name='Submit']"))).click();

        if (goToHomePage) {
            baseTest.getDriver().findElement(By.linkText("Dashboard")).click();
        }
    }

    public static void createFreestyleProject(BaseTest baseTest, String name, Boolean goToHomePage) {
        createProject(baseTest, name);
        baseTest.getDriver().findElement(By.cssSelector(".hudson_model_FreeStyleProject")).click();
        saveProject(baseTest, goToHomePage);
    }

    public static void createPipeline(BaseTest baseTest, String name, Boolean goToHomePage) {
        createProject(baseTest, name);
        baseTest.getDriver().findElement(By.xpath("//label/span[text()='Pipeline']")).click();
        saveProject(baseTest, goToHomePage);
    }

    public static void createMultiConfigurationProject(BaseTest baseTest, String name, Boolean goToHomePage) {
        createProject(baseTest, name);
        baseTest.getDriver().findElement(By.xpath("//label/span[contains(text(), 'Multi-configuration proj')]")).click();
        saveProject(baseTest, goToHomePage);
    }

    public static void createFolder(BaseTest baseTest, String name, Boolean goToHomePage) {
        createProject(baseTest, name);
        baseTest.getDriver().findElement(By.cssSelector(".com_cloudbees_hudson_plugins_folder_Folder")).click();
        saveProject(baseTest, goToHomePage);
    }

    public static void createMultibranchPipeline(BaseTest baseTest, String name, Boolean goToHomePage) {
        createProject(baseTest, name);
        baseTest.getDriver().findElement(By.xpath("//span[text()='Multibranch Pipeline']")).click();
        saveProject(baseTest, goToHomePage);
    }

    public static void createOrganizationFolder(BaseTest baseTest, String name, Boolean goToHomePage) {
        createProject(baseTest, name);
        baseTest.getDriver().findElement(By.xpath("//label/span[contains(text(), 'Organization Folder')]")).click();
        saveProject(baseTest, goToHomePage);
    }
    public enum JobType {
        FreestyleProject(1),
        Pipeline(2),
        MultiConfigurationProject(3),
        Folder(4),
        MultibranchPipeline(5),
        OrganizationFolder(6);

        public int getPosition(){
            return position;
        }

        private final int position;
        JobType(int position) {
            this.position = position;
        }
    }
}
