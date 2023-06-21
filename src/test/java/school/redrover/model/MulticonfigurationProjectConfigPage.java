package school.redrover.model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import school.redrover.model.base.BasePage;

public class MulticonfigurationProjectConfigPage extends BasePage {
    public MulticonfigurationProjectConfigPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(name = "Submit")
    private WebElement submitButton;

    public ProjectPage saveChanges() {
        submitButton.click();
        return (new ProjectPage(getDriver()));
    }

}
