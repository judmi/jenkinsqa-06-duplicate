package school.redrover;

import org.testng.Assert;
import org.testng.annotations.Test;
import school.redrover.model.MainPage;
import school.redrover.runner.BaseTest;

public class MulticonfigurationalProjectTest extends BaseTest {
    private final String MULTICONFIGURATIONAL_PROJECT_NAME = "My MC project";

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
}
