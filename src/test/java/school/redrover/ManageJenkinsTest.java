package school.redrover;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import school.redrover.model.page.MainPage;
import school.redrover.model.page.ManageJenkinsPage;
import school.redrover.runner.BaseTest;


public class ManageJenkinsTest extends BaseTest {

    private final String userName = new Faker().name().firstName();
    private final String password = new Faker().internet().password();

    @Test
    public void testCreateNewUser() {
        String email = new Faker().internet().emailAddress();
        boolean isUserCreated = new MainPage(getDriver())
                .clickLinkFromSidebarMenu(MainPage.LinkFromSidebarMenu.MANAGE_JENKINS, new ManageJenkinsPage(getDriver()))
                .clickManageUsersSection()
                .clickCrateUserBtn()
                .fillInCredentialsAndSubmit(userName, password, email)
                .isUserExist(userName);
        Assert.assertTrue(isUserCreated);
    }

    @Test(dependsOnMethods = "testCreateNewUser")
    public void testChangeUserProfile() {
        boolean isProfileChanged = new MainPage(getDriver())
                .getUsersDataBase()
                .clickUserIdInTable(userName)
                .clickConfigureInSidebar()
                .fillInProfileFieldsAndSave()
                .clickConfigureInSidebar()
                .isChangesSaved();
        Assert.assertTrue(isProfileChanged);
    }

    @Test(dependsOnMethods = {"testCreateNewUser", "testChangeUserProfile"})
    public void testDeleteUser() {
        boolean isUserInDatabase = new MainPage(getDriver())
                .getUsersDataBase()
                .clickDeleteInDropdownMenu(userName)
                .clickYesBtn()
                .getUsersDataBase()
                .isUserExist(userName);
        Assert.assertFalse(isUserInDatabase);
    }

    @Test(dependsOnMethods = {"testCreateNewUser", "testChangeUserProfile", "testDeleteUser"})
    public void testLoginWithCredentialsOfDeletedUser() {
        boolean wasErrorMessageAppeared = new MainPage(getDriver())
                .clickLogoutInt()
                .inputLogin(userName)
                .inputPassword(password)
                .signInWithInvalidCredentials()
                .isInvalidLoginMessageShown();
        Assert.assertTrue(wasErrorMessageAppeared);
    }
}
