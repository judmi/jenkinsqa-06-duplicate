package school.redrover.runner;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.reporters.jq.Main;
import school.redrover.model.page.MainPage;
import school.redrover.model.page.NewItemPage;

import static school.redrover.model.page.MainPage.LinkFromSidebarMenu.NEW_ITEM;

public class FreestyleProjectTest extends BaseTest{

    private final static String PROJECT_NAME = "Freestyle Project TEST";

    @Test
    public void testCreateWithValidName() {

        String projectName = new MainPage(getDriver())
                .clickLinkFromSidebarMenu(NEW_ITEM, new NewItemPage(getDriver()))
                .inputItemName(PROJECT_NAME)
                .selectFreestyleProject()
                .clickOkForFreestyleProject()
                .clickSaveButton()
                .getProjectName();

        Assert.assertEquals(projectName, String.format("Project %s",PROJECT_NAME));
    }

    @DataProvider(name = "unsafe-characters")
    public Object[][] providerUnsafeCharacters() {
        return new Object[][]{{"!"}, {"@"}, {"#"}, {"$"}, {"%"}, {"^"}, {"&"}, {"*"}, {"?"}, {"|"}, {">"}, {"["}, {"]"}};
    }

    @Test(dataProvider = "unsafe-characters")
    public void testCreateWithUnsafeCharacter(String unsafeCharacter) {

        NewItemPage newItemPage = new MainPage(getDriver())
                .clickLinkFromSidebarMenu(NEW_ITEM, new NewItemPage(getDriver()))
                .inputItemName(unsafeCharacter);


        Assert.assertEquals(newItemPage.getInvalidItemNameMessage(),
                String.format("» ‘%s’ is an unsafe character", unsafeCharacter));
        Assert.assertTrue(newItemPage.isOkButtonDisabled());
    }


}
