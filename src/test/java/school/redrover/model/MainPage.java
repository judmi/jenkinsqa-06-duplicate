package school.redrover.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import school.redrover.model.base.BasePage;

public class MainPage extends BasePage {
    @FindBy(xpath = "//a[@href = '/manage']")
    static WebElement manageJenkinsLink;

    @FindBy(xpath = "//a[@href='/view/all/newJob']")
    static WebElement newItemLink;

    @FindBy(xpath = "//a[@href = '/asynchPeople/']")
    static WebElement peopleLink;

    @FindBy(xpath = "//a[@href = '/view/all/builds']")
    static WebElement buildHistoryLink;

    @FindBy(xpath = "//a[@href = '/me/my-views']")
    static WebElement myViewsLink;

    @FindBy(xpath = "//a[@href = '/logout']")
    private WebElement logoutLink;

    public enum LinkFromSidebarMenu {
        NEW_ITEM(newItemLink),
        PEOPLE(peopleLink),
        BUILD_HISTORY(buildHistoryLink),
        MANAGE_JENKINS(manageJenkinsLink),
        MY_VIEWS(myViewsLink);

        private final WebElement locator;

        LinkFromSidebarMenu(WebElement locator) {
            this.locator = locator;
        }

        public WebElement getLocator() {
            return locator;
        }
    }


    public MainPage(WebDriver driver) {
        super(driver);
    }

    public NewItemPage chooseNewItem() {
        WebElement newItemButton = getDriver().findElement(By.xpath("//a[@href='/view/all/newJob']"));
        newItemButton.click();
        return (new NewItemPage(getDriver()));
    }

    public WebElement getTitleOfNewProject() {
        return getDriver().findElement(By.xpath("//h1[@class='job-index-headline page-headline']"));
    }

    public ManageJenkinsPage clickManageJenkinsTab() {
        getWait10().until(ExpectedConditions.elementToBeClickable(manageJenkinsLink)).click();
        return new ManageJenkinsPage(getDriver());
    }

    public ProjectPage clickOnProject() {
        WebElement chooseProject = getDriver().findElement(By.xpath("//a[@class='jenkins-table__link model-link inside']"));
        chooseProject.click();
        return new ProjectPage(getDriver());
    }

    public UsersDatabasePage getUsersDataBase() {
        clickLinkFromSidebarMenu(LinkFromSidebarMenu.MANAGE_JENKINS, new ManageJenkinsPage(getDriver()))
                .clickManageUsersSection();
        return new UsersDatabasePage(getDriver());
    }

    public LoginPage clickLogout() {
        logoutLink.click();
        return new LoginPage(getDriver());
    }

    private WebElement getLinkfromSidebarMenu(LinkFromSidebarMenu link) {
        return link.getLocator();
    }

    public <Page extends BasePage> Page clickLinkFromSidebarMenu(LinkFromSidebarMenu link, Page page) {
        getLinkfromSidebarMenu(link).click();
        return page;
    }
}