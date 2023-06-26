package school.redrover;

import org.testng.Assert;
import org.testng.annotations.Test;
import school.redrover.model.page.MainPage;
import school.redrover.runner.BaseTest;

public class FolderTest extends BaseTest {

    final String FOLDER_ITEM_NAME = "NEW FOLDER JOB";

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
}
