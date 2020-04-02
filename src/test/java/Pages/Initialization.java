package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Initialization
{
    public static By txtPin= By.id("com.roche.rpm.artios.autoQa:id/initialization_pin");
    public static By btnNext= By.xpath("//android.widget.Button[@text='Next']");

    public static void inputPin(String text)
    {
        BasePage.wait.until(ExpectedConditions.visibilityOfElementLocated(txtPin)).sendKeys(text);
    }

    public static void tapNext()
    {
        BasePage.wait.until(ExpectedConditions.visibilityOfElementLocated(btnNext)).click();
    }

}
