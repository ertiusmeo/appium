package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Menu
{
    public static By btnResetApp= By.xpath("//android.widget.TextView[@text='Reset App']");
    public static By List= By.xpath("//android.widget.ListView");

    public static void tapReset()
    {
        BasePage.wait.until(ExpectedConditions.visibilityOfElementLocated(btnResetApp)).click();
    }
}
