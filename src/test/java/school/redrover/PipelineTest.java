package school.redrover;

import org.testng.Assert;
import org.testng.annotations.Test;
import school.redrover.model.MainPage;
import school.redrover.runner.BaseTest;

public class PipelineTest extends BaseTest {
    final String NamePipeline = "My Pipeline";
    final String DisabledProject = "This project is currently disabled\n" +
            "Enable";
    final String newNamePipeline = "My Pipeline1";

    @Test
    public void testCreateNewPipelineWithScript() {
        String createNewPipeline = new MainPage(getDriver())
                .chooseNewItem()
                .chooseNameForProject(NamePipeline)
                .choosePipeline()
                .clickOk()
                .selectNewScript()
                .selectScriptedPipelineScript()
                .saveChanges()
                .getProjectTitle();

        Assert.assertEquals(createNewPipeline, "Pipeline " + NamePipeline);
    }

    @Test(dependsOnMethods = "testCreateNewPipelineWithScript")
    public void testRenamePipeline() {
        String newNameOfPipeline = new MainPage(getDriver())
                .clickOnProject()
                .clickOnRenameProject()
                .clearOldName()
                .writeNewName(newNamePipeline)
                .submitRename()
                .getProjectTitle();

        Assert.assertEquals(newNameOfPipeline, "Pipeline " + NamePipeline + 1);
    }

    @Test(dependsOnMethods = "testCreateNewPipelineWithScript")
    public void testDisablePipeline() {
        String disableProject = new MainPage(getDriver())
                .clickOnProject()
                .chooseDisableProject()
                .getWarningMessage();

        Assert.assertEquals(disableProject, DisabledProject);
    }

    @Test(dependsOnMethods = {"testCreateNewPipelineWithScript", "testDisablePipeline"})
    public void testEnablePipeline() {
        String enableProject = new MainPage(getDriver())
                .clickOnProject()
                .pushDisable()
                .pushEnable()
                .getProjectIsEnabledConfirmation();

        Assert.assertEquals(enableProject, "Enable");
    }

    @Test(dependsOnMethods = "testCreateNewPipelineWithScript")
    public void testAddDescription() {
        String projectWithNewDescription = new MainPage(getDriver())
                .clickOnProject()
                .clickAddDescription()
                .AddNewDescription()
                .saveDescription()
                .getTextOfNewDescription();

        Assert.assertEquals(projectWithNewDescription, "Мой переименованный, c измененными настройками Pipeline");
    }
}