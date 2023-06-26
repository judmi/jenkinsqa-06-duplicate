package school.redrover;

import org.testng.Assert;
import org.testng.annotations.Test;
import school.redrover.model.page.MainPage;
import school.redrover.runner.BaseTest;

public class MultibranchPipelineTest extends BaseTest {
final static String MULTIBRANCH_PIPELINE_PROJECT_NAME = "My first Multibranch Pipeline";
   @Test
    public void createNewMultiBranchPipelineProject(){
       String multiBranchPipelineProjectTitle = new MainPage(getDriver())
               .clickNewItem()
               .inputItemName(MULTIBRANCH_PIPELINE_PROJECT_NAME)
               .selectMultibranchPipeline()
               .clickOkForMultibranchPipeline()
               .displayNameOfMultibranchPipeline()
               .addDescription()
               .addChooseBranchSources()
               .chooseGitAsSource()
               .addGitProject()
               .addRerunPeriod()
               .addKeepsOldItemsDay()
               .saveConfigChanges()
               .getStatus()
               .getTitle();

       Assert.assertEquals(multiBranchPipelineProjectTitle, MULTIBRANCH_PIPELINE_PROJECT_NAME);

    }
}
