package school.redrover;

import org.testng.Assert;
import org.testng.annotations.Test;
import school.redrover.model.DashboardPage;
import school.redrover.runner.BaseTest;

public class PipelineTest extends BaseTest {
    final String NamePipeline = "My Pipeline";
    final String DisabledProject = "This project is currently disabled\n" +
            "Enable";

    @Test
    public void testCreateNewPipelineWithScript() {
        String createNewPipeline = new DashboardPage(getDriver())
                .chooseNewItem()
                .chooseNameForProject(NamePipeline)
                .choosePipeline()
                .clickOk()
                .selectNewScript()
                .selectScriptedPipelineScript()
                .saveChanges()
                .getTitleOfNewProject()
                .getText();

        Assert.assertEquals(createNewPipeline,"Pipeline " + NamePipeline);
    }

    @Test(dependsOnMethods = "testCreateNewPipelineWithScript")
    public void testRenamePipeline() {
       String newNameOfPipeline = new DashboardPage(getDriver())
               .clickOnProject()
               .clickOnRenameProject()
               .clearOldName()
               .writeNewName()
               .submitRename()
               .getNewNameOfProjectAfterRenaming()
               .getText();

                Assert.assertEquals(newNameOfPipeline,"Pipeline " + NamePipeline + 1);
    }

    @Test(dependsOnMethods = "testCreateNewPipelineWithScript")
    public void testDisablePipeline() {
        String disableProject =  new DashboardPage(getDriver())
                .clickOnProject()
                .chooseDisableProject()
                .projectIsDisabled()
                .getText();

        Assert.assertEquals(disableProject,DisabledProject);
    }

    @Test(dependsOnMethods = {"testCreateNewPipelineWithScript", "testDisablePipeline"})
    public void testEnablePipeline() {
        String enableProject = new DashboardPage(getDriver())
                .clickOnProject()
                .pushDisable()
                .pushEnable()
                .projectIsEnable()
                .getText();

        Assert.assertEquals(enableProject, "Enable");
    }

    @Test(dependsOnMethods = "testCreateNewPipelineWithScript")
    public void testAddDescription() {
        String projectWithNewDescription = new DashboardPage(getDriver())
                .clickOnProject()
                .clickAddDescription()
                .AddNewDescription()
                .saveDescription()
                .textOfNewDescription()
                .getText();

        Assert.assertEquals(projectWithNewDescription,"Мой переименованный, c измененными настройками Pipeline");
    }
}