package school.redrover;

import org.testng.Assert;
import org.testng.annotations.Test;
import school.redrover.model.page.MainPage;
import school.redrover.runner.BaseTest;

public class FolderTest extends BaseTest {

    final String FOLDER_ITEM_NAME = "NEW FOLDER JOB";
    final String FOLDER_ITEM_RENAME = "FOLDER JOB";

    @Test
    public void testCreateFolder() {
        String folderItemName = new MainPage(getDriver())
                .clickNewItem()
                .inputItemName(FOLDER_ITEM_NAME)
                .selectFolder()
                .clickOkButtonForFolder()
                .clickSaveButton()
                .getProjectName();

        Assert.assertEquals(folderItemName, FOLDER_ITEM_NAME);
    }

    @Test(dependsOnMethods = "testCreateFolder")
    public void testRenameFolder() {
        String newFolderName = new MainPage(getDriver())
                .clickOnProject()
                .clickOnRenameProject()
                .clearOldName()
                .inputNewProjectName(FOLDER_ITEM_RENAME)
                .clickRenameButton()
                .getProjectName();

        Assert.assertEquals(newFolderName,FOLDER_ITEM_RENAME);
    }

}
