package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class Popup
{
    public static By popup= By.xpath("/hierarchy/android.widget.FrameLayout");
    public static By txtInput= By.id("com.roche.rpm.artios.autoQa:id/dialogInput");

    public static void tapCancel()
    {
        BasePage.wait.until(ExpectedConditions.visibilityOfElementLocated(popup));
        BasePage.driver.findElement(popup).findElement(By.xpath("//android.widget.Button[@text=\"CANCEL\"]")).click();
    }

    public static void tapOk()
    {
        BasePage.wait.until(ExpectedConditions.visibilityOfElementLocated(popup));
        BasePage.driver.findElement(popup).findElement(By.xpath("//android.widget.Button[@text=\"OK\"]")).click();
    }

    public static void tapYes()
    {
        BasePage.wait.until(ExpectedConditions.visibilityOfElementLocated(popup));
        BasePage.driver.findElement(popup).findElement(By.xpath("//android.widget.Button[@text=\"YES\"]")).click();
    }

    public static void inputText(String text)
    {
        BasePage.wait.until(ExpectedConditions.visibilityOfElementLocated(txtInput)).sendKeys(text);
    }

}
