import Pages.*;
import com.testautomationguru.ocular.Ocular;
import com.testautomationguru.ocular.comparator.OcularResult;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;


public class VerifyScreenshots extends BasePage {
@BeforeMethod
@Override public void setup()throws MalformedURLException
    {

        Ocular.config()
                .resultPath(Paths.get("src/test/resources/results"))
                .snapshotPath(Paths.get("src/test/resources/baseline"))
                .globalSimilarity(100)
                .saveSnapshot(true);

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
        wait = new WebDriverWait(driver, 400);
    }


    void verifyScreen(String fileName)
    {

        Path path = Paths.get(fileName);
        OcularResult result=
                Ocular.snapshot().from(path).sample().using(driver).excluding(driver.findElement(Device.TopBar)).excluding(driver.findElement(Device.BottomBar)).element(driver.findElement(Tests.CurrentScreen)).compare();
        if (!result.isEqualsImages())
        {
            msg.add("Screen: " +fileName+ " doesn't match");
            res=false;
        }
    }

    void verifyMenuList(String fileName)
    {

        Path path = Paths.get(fileName);
        OcularResult result=
                Ocular.snapshot().from(path).sample().using(driver).element(driver.findElement(Menu.List)).compare();
        if (!result.isEqualsImages())
        {
            msg.add("Screen: " +fileName+ " doesn't match");
            res=false;
        }
    }



    @Test(priority = 0)
    public void MenuList ()
    {
        Dashboard.tapMenu();
        verifyMenuList("Menu_list.png");
        Assert.assertTrue(res,msg.toString());
    }


    @Test(priority = 0)
    public void Initialization ()throws Exception
    {
        Dashboard.tapMenu();
        Thread.sleep(1000);
        Menu.tapReset();
        Popup.inputText("135086");
        Popup.tapOk();
        Popup.tapYes();
        Initialization.inputPin("7927");
        Initialization.tapNext();
        Assert.assertTrue(res,msg.toString());
    }



    

    @Test(priority = 0)
    public void DailyQuestions ()
    {
        int screensCount =1;
        Dashboard.tapDailyActivities();
        verifyScreen("DailyQuestion_start.png");
        Tests.tapStart();
        while (screensCount<3)
        {
            Tests.tapRadioButton();
            verifyScreen("DailyQuestion_" + screensCount + ".png");
            Tests.tapNext();
            screensCount++;
        }
        verifyScreen("DailyQuestion_thankyou.png");
        Tests.tapNext();

        Assert.assertTrue(res,msg.toString());

    }

    @Test(priority = 1)
    public void SymptomTracker ()  {

        int screensCount =1;
        Dashboard.tapDailyActivities();
        verifyScreen("SymptomTracker_start.png");

        Tests.tapStart();
        verifyScreen("SymptomTracker_symptoms_worsened.png");

        Tests.tapYes();
        verifyScreen("SymptomTracker_symptoms_begin_1.png");

        driver.findElementByXPath("//android.widget.NumberPicker/android.widget.Button[1]").sendKeys("Wednesday, April 1, 2020");
        verifyScreen("SymptomTracker_symptoms_begin_2.png");

        Tests.tapContinue();


        while (screensCount<6)
        {
            Tests.tapCheckBox();
            verifyScreen("SymptomTracker_" + screensCount +".png");
            Tests.tapNext();
            screensCount++;
        }

        verifyScreen("SymptomTracker_relapse_definition.png");
        Tests.tapContinue();

        verifyScreen("SymptomTracker_relapse_select.png");
        Tests.tapYes();

        verifyScreen("SymptomTracker_relapse_end.png");
        Tests.tapContinue();

        verifyScreen("SymptomTracker_thankyou.png");
        Tests.tapNext();

    }




    @Test(priority = 2)
    public void MSIS29 (){

        int screensCount =1;
        Dashboard.tapDailyActivities();
        verifyScreen("MSIS_start.png");

        Tests.tapStart();
        verifyScreen("MSIS_instruction.png");

        Tests.tapStart();

        while (screensCount<30)
        {
            verifyScreen("MSIS_" + screensCount + ".png" );
            Tests.tapRadioButton();
            screensCount++;
        }
        verifyScreen("MSIS_thankyou.png");
        Tests.tapNext();
    }


    @Test(priority = 3)
    public void IPS () throws Exception{


        Dashboard.tapDailyActivities();
        verifyScreen("IPS_start.png");

        Tests.tapStart();
        verifyScreen("IPS_instruction.png");

        Tests.tapStart();
        verifyScreen("IPS_countdown.png");

        Thread.sleep(5000);
        verifyScreen("IPS_game.png");

        Tests.tapStart();
        verifyScreen("Baseline_start.png");

        Tests.tapStart();
        verifyScreen("Baseline_instruction.png");

        Tests.tapStart();
        verifyScreen("Baseline_countdown.png");

        Thread.sleep(5000);
        verifyScreen("Baseline_game.png");

        Tests.tapNext();
        verifyScreen("IPS_Baseline_thankyou.png");

        Tests.tapNext();

    }


    @Test(priority = 4)
    public void Pinching() throws Exception{

        Dashboard.tapDailyActivities();
        verifyScreen("Pinching_start.png");

        Tests.tapStart();
        verifyScreen("Pinching_instruction.png");

        Tests.tapStart();
        verifyScreen("Pinching_countdown.png");

        Thread.sleep(5000);
        verifyScreen("Pinching_game.png");


        Tests.tapNext();
        verifyScreen("Pinching_thankyou.png");

        Tests.tapNext();

    }


    @Test(priority = 5)
    public void Shape() throws Exception{

        Dashboard.tapDailyActivities();
        verifyScreen("DrawShape_start.png");

        Tests.tapStart();
        verifyScreen("DrawShape_instruction.png");

        Tests.tapStart();
        verifyScreen("DrawShape_countdown.png");

        Thread.sleep(5000);
        verifyScreen("DrawShape_game.png");

        Tests.tapNext();
        verifyScreen("DrawShape_thankyou.png");

        Tests.tapNext();

    }





    @Test(dataProvider = "Motor Test type", priority = 6)
    public void Motor(String type) throws Exception{


        if(type=="Walking") {
            Dashboard.tapWalkingTest();
        }
        else
        {
            Dashboard.tapDailyActivities();
        }
        verifyScreen(type +"_start.png");

        Tests.tapStart();
        verifyScreen(type + "_instruction.png");

        Functions.swipeUpDown(1957,746);

        Tests.tapStart();
        verifyScreen(type + "_question1.png");

        Tests.tapYes();
        verifyScreen(type + "_question2.png");

        Tests.tapYes();
        verifyScreen(type +"_countdown.png");

        Thread.sleep(15000);
        verifyScreen(type +"_game.png");

        wait.until(ExpectedConditions.or(ExpectedConditions.visibilityOfElementLocated(Tests.btnNext),ExpectedConditions.visibilityOfElementLocated(Tests.btnFinish)));
        verifyScreen(type +"_thankyou.png");

        if(type=="Walking" || type=="Uturn") {
            Tests.tapFinish();
        }
        else
        {
            Tests.tapNext();
        }

    }

    @DataProvider(name = "Motor Test type")

    public static Object[][] motortesttype() {

        return new Object[][]{{"Balance"}, {"Uturn"}, {"Walking"}};
    }


}


