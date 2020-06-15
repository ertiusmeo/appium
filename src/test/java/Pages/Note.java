package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Note
{
    public static By txtTitle= By.id("com.google.android.keep:id/editable_title");
    public static By txtContent= By.id("com.google.android.keep:id/edit_note_text");
    public static By btnBack= By.xpath("//android.widget.ImageButton[@content-desc=\"Open navigation drawer\"]");
    public static By btnOptions= By.id("com.google.android.keep:id/bs_action_button");




    public static void enterTitle(String text)
    {
        BasePage.wait.until(ExpectedConditions.visibilityOfElementLocated(txtTitle)).sendKeys(text);
    }

    public static void enterNote(String text)
    {
        BasePage.wait.until(ExpectedConditions.visibilityOfElementLocated(txtContent)).sendKeys(text);
    }

    public static void clickBack()
    {
        BasePage.wait.until(ExpectedConditions.visibilityOfElementLocated(btnBack)).click();
    }

    public static void clickOptions()
    {
        BasePage.wait.until(ExpectedConditions.visibilityOfElementLocated(btnOptions)).click();
    }

    public static void selectOption(String option)
    {
        clickOptions();
        BasePage.driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.google.android.keep:id/menu_text\" and @text=\""+option+"\"]")).click();
    }




}
