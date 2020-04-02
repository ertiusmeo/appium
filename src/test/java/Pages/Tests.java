package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Tests
{

    public static By btnStart= By.xpath("//android.widget.Button[@text='Start']");
    public static By btnFinish= By.xpath("//android.widget.Button[@text='Finish']");
    public static By btnNext= By.xpath("//android.widget.Button[@text='Next']");
    public static By btnContinue= By.xpath("//android.widget.Button[@text='Continue']");
    public static By btnYes= By.xpath("//android.widget.Button[@text='Yes']");
    public static By btnNo= By.xpath("//android.widget.Button[@text='No']");
    public static By RadioButton= By.xpath("//android.widget.RadioButton[1]");
    public static By CheckBox= By.xpath("//android.widget.CheckBox[1]");
    public static By txtThankYou = By.xpath("//android.widget.TextView[@text='Thank you for sharing!']");
    public static By Picker= By.id("android.widget.NumberPicker");
    public static By CurrentScreen= By.xpath("/hierarchy/android.widget.FrameLayout");
    public static By btnHome= By.id("com.roche.rpm.artios.autoQa:id/action_end_game");

    public static void tapStart()
    {
        BasePage.wait.until(ExpectedConditions.visibilityOfElementLocated(btnStart)).click();
    }

    public static void tapNext()
    {
        BasePage.wait.until(ExpectedConditions.visibilityOfElementLocated(btnNext)).click();
    }

    public static void tapContinue()
    {
        BasePage.wait.until(ExpectedConditions.visibilityOfElementLocated(btnContinue)).click();
    }

    public static void tapYes()
    {
        BasePage.wait.until(ExpectedConditions.visibilityOfElementLocated(btnYes)).click();
    }

    public static void tapNo()
    {
        BasePage.wait.until(ExpectedConditions.visibilityOfElementLocated(btnNo)).click();
    }

    public static void tapFinish()
    {
        BasePage.wait.until(ExpectedConditions.visibilityOfElementLocated(btnFinish)).click();
    }

    public static void tapHome()
    {
        BasePage.wait.until(ExpectedConditions.visibilityOfElementLocated(btnHome)).click();
    }

    public static void tapRadioButton()
    {
        BasePage.wait.until(ExpectedConditions.visibilityOfElementLocated(RadioButton)).click();
    }

    public static void tapCheckBox()
    {
        BasePage.wait.until(ExpectedConditions.visibilityOfElementLocated(CheckBox)).click();
    }



}
