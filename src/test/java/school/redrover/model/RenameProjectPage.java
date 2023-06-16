package school.redrover.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import school.redrover.model.base.BasePage;

public class RenameProjectPage extends BasePage {
    String NamePipeline = "My Pipeline1";
    public RenameProjectPage(WebDriver driver) {
        super(driver);
    }

    public RenameProjectPage clearOldName() {
        WebElement oldName = getDriver().findElement(By.xpath("//input [@name='newName']"));
        oldName.clear();
        return this;
    }
    public RenameProjectPage writeNewName(){
        WebElement newName = getDriver().findElement(By.xpath("//input [@name='newName']"));
        newName.sendKeys(NamePipeline);
        return this;
    }
    public MainPage submitRename() {
        WebElement submitNewName = getDriver().findElement(By.xpath("//button [@name='Submit']"));
        submitNewName.click();
        return new MainPage(getDriver());
    }


}

