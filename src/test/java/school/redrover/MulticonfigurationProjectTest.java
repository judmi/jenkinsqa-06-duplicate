package school.redrover;

import org.testng.Assert;
import org.testng.annotations.Test;
import school.redrover.model.page.MainPage;
import school.redrover.runner.BaseTest;

public class MulticonfigurationProjectTest extends BaseTest {
    private static final String MULTICONFIGURATIONAL_PROJECT_NAME = "My MC project";

    @Test
    public void testCreateMulticonfigurationProject() {
        String createdMulticonfigurationProject = new MainPage(getDriver())
                .clickNewItem()
                .inputItemName(MULTICONFIGURATIONAL_PROJECT_NAME)
                .clickMulticonfigurationalProjectItem()
                .clickOkButtonForMulticonfigurationProject()
                .clickSaveButton()
                .getProjectName();

        Assert.assertEquals(createdMulticonfigurationProject, "Project " + MULTICONFIGURATIONAL_PROJECT_NAME);
    }

    @Test(dependsOnMethods = "testCreateMulticonfigurationProject")
    public void testRenameMulticonfigurationProject() {
        String renamedMulticonfigurationProject = new MainPage(getDriver())
                .clickOnProject()
                .clickOnRenameProject()
                .clearOldName()
                .writeNewName(MULTICONFIGURATIONAL_PROJECT_NAME + "1")
                .submitRename()
                .getProjectName();

        Assert.assertEquals(renamedMulticonfigurationProject, "Project " + MULTICONFIGURATIONAL_PROJECT_NAME + "1");
    }

    @Test(dependsOnMethods = "testRenameMulticonfigurationProject")
    public void testDisableMulticonfigurationProject() {
        String disableProjectConfirmation = new MainPage(getDriver())
                .clickOnProject()
                .chooseDisableProject()
                .getWarningMessage();

        Assert.assertEquals(disableProjectConfirmation, "This project is currently disabled\n" + "Enable");
    }

    @Test(dependsOnMethods = "testDisableMulticonfigurationProject")
    public void testEnableMulticonfigurationProject() {
        String enableProjectConfirmation = new MainPage(getDriver())
                .clickOnProject()
                .pushDisable()
                .pushEnable()
                .getProjectIsEnabledConfirmation();

        Assert.assertEquals(enableProjectConfirmation, "Enable");
    }
}