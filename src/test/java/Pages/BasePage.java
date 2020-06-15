package Pages;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;

import java.net.URL;
import java.util.UUID;

public abstract class BasePage
{
    public static AndroidDriver driver;
    public static WebDriverWait wait;

    public static boolean res=true;
    public static String random_string;
    public static String msg ="";

    @BeforeMethod
    public void setup () throws Exception
    {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Galaxy S10+");
        caps.setCapability("udid", "R58N20ASJFR"); //DeviceId from "adb devices" command
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "10.0");
        caps.setCapability("skipUnlock","false");
        caps.setCapability("appPackage", "com.google.android.keep");
        caps.setCapability("appActivity","com.google.android.apps.keep.ui.activities.BrowseActivity");
        caps.setCapability("noReset","true");
        caps.setCapability("automationName","UiAutomator1");
        caps.setCapability("autoLaunch", "true");
        caps.setCapability(MobileCapabilityType.TAKES_SCREENSHOT,true);
        caps.setCapability("adbExecTimeout", 10000);
        random_string= UUID.randomUUID().toString();
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),caps);
        wait = new WebDriverWait(driver, 10);
    }

}
