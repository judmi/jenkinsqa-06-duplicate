package school.redrover;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import school.redrover.model.MainPage;
import school.redrover.runner.BaseTest;

public class ManageJenkinsTest extends BaseTest {

    private final String userName = new Faker().name().firstName();
    private final String password = new Faker().internet().password();

    @Test
    public void testCreateNewUser() {
        String email = new Faker().internet().emailAddress();
        boolean isUserCreated = new MainPage(getDriver())
                .clickManageJenkinsTab()
                .clickManageUsersSection()
                .clickCrateUserBtn()
                .fillInCredentialsAndSubmit(userName, password, email)
                .isUserExist(userName);
        Assert.assertTrue(isUserCreated);
    }

    @Test(dependsOnMethods = "testCreateNewUser")
    public void testDeleteUser() {
        boolean isUserInDatabase = new MainPage(getDriver())
                .getUsersDataBase()
                .clickDeleteInDropdownMenu(userName)
                .clickYesBtn()
                .getUsersDataBase()
                .isUserExist(userName);
        Assert.assertFalse(isUserInDatabase);
    }

    @Test(dependsOnMethods = {"testCreateNewUser", "testDeleteUser"})
    public void testLoginWithCredentialsOfDeletedUser() {
        boolean isErrorMessageAppear = new MainPage(getDriver())
                .clickLogout()
                .inputLogin(userName)
                .inputPassword(password)
                .signInWithInvalidCredentials()
                .invalidLogin();
        Assert.assertTrue(isErrorMessageAppear);
    }
}
