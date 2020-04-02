import Pages.BasePage;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;

public class Functions
{


    public static void swipeUpDown(int fromY, int toY) {

       int x=620;
        (new TouchAction(BasePage.driver)).press(PointOption.point(x,fromY)).moveTo(PointOption.point(x,toY)).release().perform();

    }

}
