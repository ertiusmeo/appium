package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Dashboard
{
    public static By main_screen = By.xpath("/hierarchy/android.widget.FrameLayout");
    public static By btnCalendar = By.id("com.roche.rpm.artios.autoQa:id/action_date_range");
    public static By btnMainScreen = By.id("com.roche.rpm.artios.autoQa:id/action_home");
    public static By btnDailyActivities = By.xpath("//*[@text='Start Daily Activities' or @text='Continue Daily Activities']");
    public static By btnWalkingTest = By.xpath("/hierarchy/android.widget.FrameLayout");
    public static By btnMenu = By.xpath("//android.widget.ImageView[@content-desc=\"More options\"]");

    public static void tapMenu()
    {
        BasePage.wait.until(ExpectedConditions.visibilityOfElementLocated(btnMenu)).click();
    }

    public static void tapDailyActivities()
    {
        BasePage.wait.until(ExpectedConditions.visibilityOfElementLocated(btnDailyActivities)).click();
    }

    public static void tapWalkingTest()
    {
        BasePage.wait.until(ExpectedConditions.visibilityOfElementLocated(btnDailyActivities)).click();
    }

}
