package COM.ExampleProject.Android.Common;
import COM.ExampleProject.Android.ExampleAndroidRunner;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import static COM.ExampleProject.Android.ExampleAndroidRunner.wait;
import static COM.ExampleProject.Android.ExampleAndroidRunner.elementPrepend;


/**
 * This is where we use abstraction of pre-built navigation methods
 * All of our tests are STATELESS. This means, every-time the @Test hook is called, the driver will be broken down and
 * re-supplied the capability set from the runner.
 * Below is an example of an abstracted function for re-use with other tests
 * This is the onboarding and log-on function for musicCaseAndroid as the example
 */

public class ExampleProjectNav {

    public static void loggingIntoAppWithOnboardingSkip() {


        try {
            Thread.sleep(5000);

            wait.until(ExpectedConditions.visibilityOfElementLocated
                    (By.id(elementPrepend + ":id/onboarding_navigation_skip"))).click();
        } catch (Exception e) {

            Assert.fail("unable to skip onboarding" + e);
        }

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(elementPrepend + ":id/login_select_login")));

        } catch (Exception e) {

            Assert.fail("Unable to click on the initial login button" + e);


        }
        try {
            ExampleAndroidRunner.driver1.findElementById(elementPrepend + ":id/login_select_login").click();
            Thread.sleep(5000);
            ExampleAndroidRunner.driver1.findElementByXPath(
                    "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View[3]/android.view.View[2]/android.view.View/android.widget.EditText[1]").click();
            ExampleAndroidRunner.driver1.findElementByXPath(
                    " /hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View[3]/android.view.View[2]/android.view.View/android.widget.EditText[1]").setValue("ConnorDevTest1");
            ExampleAndroidRunner.driver1.findElementByXPath(
                    "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View[3]/android.view.View[2]/android.view.View/android.widget.EditText[2]").click();
            ExampleAndroidRunner.driver1.findElementByXPath(
                    "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View[3]/android.view.View[2]/android.view.View/android.widget.EditText[2]").setValue("coz@12345");
            ExampleAndroidRunner.driver1.findElementByXPath(
                    "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View[3]/android.view.View[2]/android.view.View/android.widget.Button").click();
            Thread.sleep(2000);

        } catch (Exception e) {
            Assert.fail("Unable to login" + e);
        }


        /**
         * This is where you will move pre-built navigation code for core requirements when restarting the application
         * Keeping in mind every-time @Test is called the entire cache will be cleared so things like logging in/Onboarding
         * or anything that requires a specific action to proceed. Will be cleared completely.
         *It can sometimes be important to consider tear-down as-well. If you are directly adding anything to an account
         * consider if it needs to be removed in the same or next operation.
         * And if it does consider adding your tear down to a navigation utility enabling you to call a static method instead of
         * defining it at each point. Abstraction at it's finest!
         */

    }
}




