package school.redrover;

import org.testng.Assert;
import org.testng.annotations.Test;
import school.redrover.model.MainPage;
import school.redrover.runner.BaseTest;

public class MulticonfigurationalProjectTest extends BaseTest {
    private static final String MULTICONFIGURATIONAL_PROJECT_NAME = "My MC project";


    @Test
    public void testCreateMulticonfigurationalProject() {
        String createdMulticonfigurationalProject = new MainPage(getDriver())
                .chooseNewItem()
                .chooseNameForProject(MULTICONFIGURATIONAL_PROJECT_NAME)
                .clickMulticonfigurationalProjectItem()
                .clickOkButtonForMulticonfigurationProject()
                .saveChanges()
                .getTitleOfNewMulticonfigurationProject()
                .getText();

        Assert.assertEquals(createdMulticonfigurationalProject, "Project " + MULTICONFIGURATIONAL_PROJECT_NAME);
    }

    @Test(dependsOnMethods = "testCreateMulticonfigurationalProject")
    public void testRenameMulticonfigurationalProject() {
        String renamedMulticonfigurationalProject = new MainPage(getDriver())
                .clickOnProject()
                .clickOnRenameProject()
                .clearOldName()
                .writeNewName(MULTICONFIGURATIONAL_PROJECT_NAME + "1")
                .submitRename()
                .getTitleOfNewMulticonfigurationProject()
                .getText();

        Assert.assertEquals(renamedMulticonfigurationalProject, "Project " + MULTICONFIGURATIONAL_PROJECT_NAME + "1");
    }
}
