package Pages;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public abstract class BasePage
{
    public static AndroidDriver driver;
    public static WebDriverWait wait;

    public boolean res=true;
    public List<String> msg = new ArrayList<>();

    public void setup () throws MalformedURLException
    {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Galaxy A40");
        caps.setCapability("udid", "R58M823HXXM"); //DeviceId from "adb devices" command
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "9.0");
        caps.setCapability("skipUnlock","false");
        caps.setCapability("appPackage", "com.roche.rpm.artios.autoQa");
        caps.setCapability("appActivity","com.roche.rpm.ohand.initialization.InitializationActivity");
        caps.setCapability("noReset","true");
        caps.setCapability("automationName","UiAutomator1");
        caps.setCapability("autoLaunch", "true");
        caps.setCapability(MobileCapabilityType.TAKES_SCREENSHOT,true);
        caps.setCapability("adbExecTimeout", 500000);

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),caps);
        wait = new WebDriverWait(driver, 10);
    }

}
