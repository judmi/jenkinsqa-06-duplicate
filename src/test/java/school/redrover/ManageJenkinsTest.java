package school.redrover;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import school.redrover.model.MainPage;
import school.redrover.runner.BaseTest;

public class ManageJenkinsTest extends BaseTest {
    @Test
    public void testCreateNewUser() {
        String userName = new Faker().name().firstName();
        String password = new Faker().internet().password();
        String email = new Faker().internet().emailAddress();
        boolean isUserCreated = new MainPage(getDriver())
                .clickManageJenkinsTab()
                .clickManageUsersSection()
                .clickCrateUserBtn()
                .fillInCredentialsAndSubmit(userName, password, email)
                .isUserExist(userName);
        Assert.assertTrue(isUserCreated);
    }
}
