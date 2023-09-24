package lib;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;

public class Platform {
    private static final String PLATFORM_ANDROID = "android";
    private static final String APPIUM_ANDROID_URL = "http://0.0.0.0:4723";
    private static Platform instance;
    public Platform(RemoteWebDriver driver){}

    public static Platform getInstance() {

        return instance;
    }

    public RemoteWebDriver getDriver() throws Exception {
        URL URL_ANDROID = new URL(APPIUM_ANDROID_URL);
        if (this.isAndroid()){
            return new AndroidDriver(URL_ANDROID, this.getAndroidDesiredCapabilities());
        }else throw new Exception("Cannot detect type of the driver. Platform value: " + this.getPlatformVar());
    }

    public boolean isAndroid() {return isPlatform();}

    private DesiredCapabilities getAndroidDesiredCapabilities(){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("autoGrantPermissions", true);
        capabilities.setCapability("unicodeKeyboard", "true");
        capabilities.setCapability("resetKeyboard", "true");

        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "and11");
        capabilities.setCapability("platformVersion", "11.0");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("appPackage", "com.riesapp.debug");
        capabilities.setCapability("appActivity", "com.riesapp.features.root.RootActivity");
        capabilities.setCapability("app", "C:\\Users\\SERGEY\\Documents\\UITests\\apk\\ries-ries-debug.apk");
        return capabilities;
    }


    private boolean isPlatform() {
        String platform = this.getPlatformVar();
        return Platform.PLATFORM_ANDROID.equals(platform);
    }

    public String getPlatformVar()
    {
        return System.getenv("PLATFORM");
    }

}
