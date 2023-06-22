package school.redrover.model.page.job;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import school.redrover.model.base.BasePage;

public class FreestyleProjectPage extends BasePage {

    @FindBy(xpath = "//h1")
    private WebElement projectName;

    public FreestyleProjectPage(WebDriver driver) {
        super(driver);
    }

    public String getProjectName() {
        return projectName.getText();
    }
}
