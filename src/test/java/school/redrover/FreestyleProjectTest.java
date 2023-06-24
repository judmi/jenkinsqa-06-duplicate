package school.redrover;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import school.redrover.model.page.MainPage;
import school.redrover.model.page.NewItemPage;
import school.redrover.runner.BaseTest;

public class FreestyleProjectTest extends BaseTest {

    private final static String PROJECT_NAME = "Freestyle Project TEST";

    @Test
    public void testCreateWithValidName() {
        String projectName = new MainPage(getDriver())
                .clickNewItem()
                .inputItemName(PROJECT_NAME)
                .selectFreestyleProject()
                .clickOkForFreestyleProject()
                .clickSaveButton()
                .getProjectName();

        Assert.assertEquals(projectName, String.format("Project %s", PROJECT_NAME));
    }

    @DataProvider(name = "unsafe-characters")
    public Object[][] providerUnsafeCharacters() {
        return new Object[][]{{"!"}, {"@"}, {"#"}, {"$"}, {"%"}, {"^"}, {"&"}, {"*"}, {"?"}, {"|"}, {">"}, {"["}, {"]"}};
    }

    @Test(dataProvider = "unsafe-characters")
    public void testCreateWithUnsafeCharacter(String unsafeCharacter) {
        NewItemPage newItemPage = new MainPage(getDriver())
                .clickNewItem()
                .inputItemName(unsafeCharacter);

        Assert.assertEquals(newItemPage.getInvalidItemNameMessage(),
                String.format("» ‘%s’ is an unsafe character", unsafeCharacter));
        Assert.assertTrue(newItemPage.isOkButtonDisabled());
    }

    @Test(dependsOnMethods = "testCreateWithValidName")
    public void testCreateWithExistingName() {
        NewItemPage newItemPage = new MainPage(getDriver())
                .clickNewItem()
                .inputItemName(PROJECT_NAME);

        Assert.assertEquals(newItemPage.getInvalidItemNameMessage(),
                String.format("» A job already exists with the name ‘%s’", PROJECT_NAME));
        Assert.assertTrue(newItemPage.isOkButtonDisabled());
    }
}
