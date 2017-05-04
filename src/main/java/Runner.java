import api.android.Android;
import core.ADB;
import core.MyLogger;
import core.UiObject;
import core.UiSelector;
import core.managers.DriverManager;
import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Level;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by Alex on 3/31/2017.
 */
public class Runner {
//org.zwanoo.android.speedtest
//com.ookla.speedtest.softfacade.MainActivity
    public static void main(String[] args) throws MalformedURLException {
        MyLogger.log.setLevel(Level.DEBUG);
        AndroidDriver driver = null;
        try {
            DriverManager.createDriver();

            Android.adb.openAppsActivity("org.zwanoo.android.speedtest","com.ookla.speedtest.softfacade.MainActivity");
            // UiObject speedTestApp = new UiSelector().text("Speedtest").makeUiObject().tap();
            UiObject beginTest = new UiSelector().text("Begin Test").makeUiObject();
            UiObject testAgainButton = new UiSelector().text("Test Again").makeUiObject();
            UiObject ping = new UiSelector().resourceId("org.zwanoo.android.speedtest:id/pingSpeed").makeUiObject();
            UiObject download = new UiSelector().resourceId("org.zwanoo.android.speedtest:id/downloadSpeed").makeUiObject();
            UiObject upload = new UiSelector().resourceId("org.zwanoo.android.speedtest:id/uploadSpeed").makeUiObject();
            beginTest.waitToAppear(10).tap();
            testAgainButton.waitToAppear(500).tap();

            MyLogger.log.info("Ping: "+ping.getText());
            MyLogger.log.info("Download: "+download.getText());
            MyLogger.log.info("Upload: "+upload.getText());

        } finally {
            if (driver !=null) driver.quit();
        }

    }

}
