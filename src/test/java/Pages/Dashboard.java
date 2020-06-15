package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Dashboard
{
    public static By txtSearchBar = By.id("com.google.android.keep:id/open_search_bar_text_view");
    public static By btnAddNote = By.id("com.google.android.keep:id/new_note_button");
    public static By msgNoResult= By.xpath("//android.widget.TextView[@text=\"No matching notes\"]");


    public static void searchNote(String text)
    {
        BasePage.wait.until(ExpectedConditions.visibilityOfElementLocated(txtSearchBar)).sendKeys(text);
    }

    public static void clickAddNote()
    {
        BasePage.wait.until(ExpectedConditions.visibilityOfElementLocated(btnAddNote)).click();
    }


    public static void openNote(String title)
    {
        searchNote(title);
        String xpath="//android.widget.TextView[@resource-id=\"com.google.android.keep:id/index_note_title\" and @text=\""+title+"\"]";
        BasePage.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))).click();
    }
}
