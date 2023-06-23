package school.redrover.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import school.redrover.page.MainPage;
import school.redrover.runner.BaseTest;

public class PipelineTest extends BaseTest {
    final String pipelineName = "My Pipeline";
    final String disabledProjectText = "This project is currently disabled\n" +
            "Enable";
    final String newPipelineName = "My Pipeline1";

    @Test
    public void testCreateNewPipelineWithScript() {
        String createNewPipeline = new MainPage(getDriver())
                .chooseNewItem()
                .chooseNameForProject(pipelineName)
                .choosePipeline()
                .clickOk()
                .selectNewScript()
                .selectScriptedPipelineScript()
                .saveChanges()
                .getProjectTitle();

        Assert.assertEquals(createNewPipeline, "Pipeline " + pipelineName);
    }

    @Test(dependsOnMethods = "testCreateNewPipelineWithScript")
    public void testRenamePipeline() {
        String newNameOfPipeline = new MainPage(getDriver())
                .clickOnProject()
                .clickOnRenameProject()
                .clearOldName()
                .writeNewName(newPipelineName)
                .submitRename()
                .getProjectTitle();

        Assert.assertEquals(newNameOfPipeline, "Pipeline " + pipelineName + 1);
    }

    @Test(dependsOnMethods = "testCreateNewPipelineWithScript")
    public void testDisablePipeline() {
        String disableProject = new MainPage(getDriver())
                .clickOnProject()
                .chooseDisableProject()
                .getWarningMessage();

        Assert.assertEquals(disableProject, disabledProjectText);
    }

    @Test(dependsOnMethods = {"testCreateNewPipelineWithScript", "testDisablePipeline"})
    public void testEnablePipeline() {
        String enableProject = new MainPage(getDriver())
                .clickOnProject()
                .pushDisable()
                .pushEnable()
                .getConfirmationEnabledProject();

        Assert.assertEquals(enableProject, "Enable");
    }

    @Test(dependsOnMethods = "testCreateNewPipelineWithScript")
    public void testAddDescription() {
        String projectWithNewDescription = new MainPage(getDriver())
                .clickOnProject()
                .clickAddDescription()
                .addDescription()
                .saveDescription()
                .getDescriptionText();

        Assert.assertEquals(projectWithNewDescription, "Мой переименованный, c измененными настройками Pipeline");
    }
}