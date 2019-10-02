package COM.ExampleProject.iOS;

import COM.ExampleProject.iOS.Suites.ExampleLogin;
import com.runner.annotations.Setup;
import com.runner.interfaces.EnhancedTestInterface;
import com.runner.runner.EnhancedSuite;
import io.appium.java_client.AppiumDriver;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.asserts.SoftAssert;

import java.net.MalformedURLException;
import java.net.URL;

@RunWith(EnhancedSuite.class)
@Suite.SuiteClasses({
        ExampleLogin.class
})
@Setup(
        application = "RAC Consumer",
        reportType = Setup.ReportType.EXCEL,
        version = "1.1(Parallel Runner)",
        attempt = 4
)


public class ExampleProjectiOSRunner implements EnhancedTestInterface {


    static SoftAssert softassert = new SoftAssert();
    public static AppiumDriver driver;
    public static WebDriverWait wait;



    public static void setupDriver(DesiredCapabilities capabilities) throws MalformedURLException {
        URL url = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AppiumDriver(url, capabilities);
        wait = new WebDriverWait(driver, 10);
    }

    public static void destroyDriver() {
        driver.quit();
    }

    public void onTestStarted(String className, String methodName) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        System.out.println("Creating Driver");
        caps.setCapability("automationName", "XCUITest");
        caps.setCapability("platformName", "iOS");
        caps.setCapability("platformVersion", "12.0");
        caps.setCapability("deviceName", "");
        caps.setCapability("xcodeSigningId", "iPhone Developer");
        caps.setCapability("App","");
        caps.setCapability("xcodeOrgId", "");
        caps.setCapability("bundleId", "");
        caps.setCapability("udid", "");
        setupDriver(caps);
    }


    public void onTestFinished(boolean result, String className, String methodName) {
        softassert.assertAll();
        destroyDriver();
    }


    public void onTestFailure(String className, String methodName, String message, String stack) {

    }


    public void onTestPassed(String className, String methodName) {

    }


    public void onTestIgnored(String className, String methodName) {

    }

    @AfterSuite
    public void afterSuite() {

    }
}

