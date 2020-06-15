import Pages.BasePage;
import Pages.Dashboard;
import Pages.Note;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyScreenshots extends BasePage {

    @Test
    public void AddNote()
    {
        Dashboard.clickAddNote();
        Note.enterTitle(BasePage.random_string);
        Note.enterNote("abcde");
        Note.clickBack();
        Dashboard.searchNote(BasePage.random_string);
    }

    @Test
    public void DeleteNote()
    {
        Functions.AddNote(BasePage.random_string);
        Dashboard.openNote(BasePage.random_string);
        Note.selectOption("Delete");
        Assert.assertTrue(Functions.IsElementDisplayed(Dashboard.msgNoResult),BasePage.msg);
    }

    @Test
    public void EditNote()
    {
        Functions.AddNote(BasePage.random_string);
        Dashboard.openNote(BasePage.random_string);
        Note.enterTitle(BasePage.random_string + "_edited");
        Note.enterNote("xyz");
        Note.clickBack();
        //Note.clickBack();
        Dashboard.openNote(BasePage.random_string + "_edited");
        Assert.assertEquals(Functions.GetElementText(Note.txtTitle),BasePage.random_string + "_edited");
        Assert.assertEquals(Functions.GetElementText(Note.txtContent),"xyz");
    }

}


