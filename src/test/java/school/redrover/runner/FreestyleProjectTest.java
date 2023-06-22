package school.redrover.runner;

import org.testng.Assert;
import org.testng.annotations.Test;
import school.redrover.model.page.MainPage;
import school.redrover.model.page.NewItemPage;

import static school.redrover.model.page.MainPage.LinkFromSidebarMenu.NEW_ITEM;

public class FreestyleProjectTest extends BaseTest{

    private final static String PROJECT_NAME = "Freestyle Project TEST";

    @Test
    public void testCreateWithValidName() {

        String projectName = new MainPage(getDriver())
                .clickLinkFromSidebarMenu(NEW_ITEM, new NewItemPage(getDriver())).inputItemName(PROJECT_NAME)
                .selectFreestyleProject()
                .clickOkForFreestyleProject()
                .clickSaveButton()
                .getProjectName();

        Assert.assertEquals(projectName, String.format("Project %s",PROJECT_NAME));
    }
}
