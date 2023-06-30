package school.redrover.model.page.component;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import school.redrover.model.base.BaseHeader;
import school.redrover.model.page.LoginPage;

public class HeaderComponent implements BaseHeader {

    private final WebDriver driver;

    public HeaderComponent(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public LoginPage clickLogout() {
        driver.findElement(By.xpath("//a[@href = '/logout']")).click();
        return new LoginPage(driver);
    }
}
