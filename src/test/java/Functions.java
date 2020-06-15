import Pages.BasePage;
import Pages.Dashboard;
import Pages.Note;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Functions
{
    public static void AddNote(String title)
    {
        Dashboard.clickAddNote();
        Note.enterTitle(title);
        Note.enterNote("abcde");
        Note.clickBack();
    }

    public static boolean IsElementDisplayed(By by)
    {
        try
        {
            BasePage.wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            return true;
        }
        catch (TimeoutException ex)
        {
            BasePage.msg=by.toString() + " is not displayed";
            return false;
        }
    }

    public static String GetElementText(By by)
    {
        try
        {
            return BasePage.wait.until(ExpectedConditions.visibilityOfElementLocated(by)).getText();
        }
        catch (TimeoutException ex)
        {
            return null;
        }
    }
}
