package school.redrover;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import school.redrover.model.MainPage;
import school.redrover.runner.BaseTest;

public class ManageJenkinsTest extends BaseTest {

    public final String userName = new Faker().name().firstName();
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
        new MainPage(getDriver())
                .clickManageJenkinsTab()
                .clickManageUsersSection()
                .clickDeleteInDropdownMenu(userName);
        System.out.println("xsx");


    }
}
