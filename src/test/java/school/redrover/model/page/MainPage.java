package school.redrover.model.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import school.redrover.model.base.BasePage;
import school.redrover.model.base.BaseProjectPage;

public class MainPage extends BasePage {

    private static final By manageJenkinsLink = By.xpath("//a[@href = '/manage']");

    private static final By newItemLink = By.xpath("//a[@href='/view/all/newJob']");

    private static final By peopleLink = By.xpath("//a[@href = '/asynchPeople/']");

    private static final By buildHistoryLink = By.xpath("//a[@href = '/view/all/builds']");

    private static final By myViewsLink = By.xpath("//a[@href = '/me/my-views']");

    public enum LinkFromSidebarMenu {
        NEW_ITEM(newItemLink),
        PEOPLE(peopleLink),
        BUILD_HISTORY(buildHistoryLink),
        MANAGE_JENKINS(manageJenkinsLink),
        MY_VIEWS(myViewsLink);

        private final By locator;

        LinkFromSidebarMenu(By locator) {
            this.locator = locator;
        }

        public WebElement getLocator(WebDriver driver) {
            return driver.findElement(locator);
        }
    }

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public NewItemPage clickNewItem() {
        WebElement newItemButton = getDriver().findElement(By.xpath("//a[@href='/view/all/newJob']"));
        newItemButton.click();
        return (new NewItemPage(getDriver()));
    }

    public WebElement getProjectTitle() {
        return getDriver().findElement(By.xpath("//h1[@class='job-index-headline page-headline']"));
    }

    public BaseProjectPage clickOnProject() {
        WebElement chooseProject = getDriver().findElement(By.xpath("//a[@class='jenkins-table__link model-link inside']"));
        chooseProject.click();
        return new BaseProjectPage(getDriver());
    }

    public UsersDatabasePage getUsersDataBase() {
        clickLinkFromSidebarMenu(LinkFromSidebarMenu.MANAGE_JENKINS, new ManageJenkinsPage(getDriver()))
                .clickManageUsersSection();
        return new UsersDatabasePage(getDriver());
    }

    private WebElement getLinkFromSidebarMenu(LinkFromSidebarMenu link) {
        return link.getLocator(getDriver());
    }

    public <Page extends BasePage> Page clickLinkFromSidebarMenu(LinkFromSidebarMenu link, Page page) {
        getLinkFromSidebarMenu(link).click();
        return page;
    }
}