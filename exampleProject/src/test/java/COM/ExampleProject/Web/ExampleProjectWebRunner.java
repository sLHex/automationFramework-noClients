package COM.ExampleProject.Web;

import COM.ExampleProject.Web.Suites.ExampleSiteLaunch;
import com.runner.annotations.Setup;
import com.runner.interfaces.EnhancedTestInterface;
import com.runner.runner.EnhancedSuite;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.MalformedURLException;


@RunWith(EnhancedSuite.class)

/**
 * We use the @RunWith in order to implement our enchancedSuite and EnchancedInterface
 */

@Suite.SuiteClasses({
        ExampleSiteLaunch.class,
})

/**
 * Here we declare what classes the EnhancedSuite Runner will look for to run - This can be more than one just
 * add a class in the same fashion as above, separated with a comma.
 */

@Setup(
        application = "ExampleProject (Web)",
        reportType = Setup.ReportType.EXCEL,
        version = "1",
        attempt = 2
)

/**
 * The @Setup is just for our reporter, the attempt number is the times the suite has been ran,
 * Version is the version number of the text#
 * Report type is always Excel as we use reflection of the results from J-Unit and
 * Enhanced test runner/Interface in order to output our completed report.
 */


public class ExampleProjectWebRunner implements EnhancedTestInterface {

    /**
     * When the above requirements are met we can now declare our class. Keeping in mind it HAS to
     * implement the EnchancedTestInterface or our runner won't be able to bind to anything.
     */


    public static String rootLocation = "/Users/admim/Downloads/chromedriver";
    public static ChromeDriver driver;

    /**
     * Static declarations - These are mainly for use when adding a parameter as there are elements of this runner that are
     * subject to frequent change - This just allows us to deal changes in one place instead of changing things all over the
     * class, simply alter the constants when required
     */


    public void onTestStarted(String className, String methodName) throws MalformedURLException {

        /**
         * Here we are using the onTeststarted method in order to initialize our driver and pass it
         * any required capabilities or pre defined settings before the test execution starts
         */


        StartWebRunner();
        /**
         * Here we are calling the private start driver function to kick off the required driver
         */


    }

    public void onTestFinished(boolean result, String className, String methodName) {
        if (driver != null) {
            driver.quit();

            /**
             * Here we are using another conditional statement but this time we are saying if
             * the driver is greater than or equal to (!=) null then we call driver.quit
             * this is to ensure there are no instances of a driver when we call the next @Test method
             * Which will in turn call the onTestStarted method.
             */
        }
    }

    public void onTestFailure(String className, String methodName, String message, String stack) {

    }

    public void onTestPassed(String className, String methodName) {
    }

    public void onTestIgnored(String className, String methodName) {

    }

    public void afterSuite() {

    }

    /**
     * These are just are test position method calls, currently only
     * onTestFinishes has any logic applied to it, which is the driver teardown. However,
     * Feel free to add any methods or surrounding logic in order to aid your test suites.
     */

    public static void customWebRunnerStart(){

        /**
         * Here we set up a public function to starte a driver so we can do so without having to rely on the @test hook if we need to
         * Helpful for when mobile app tests require  some inline web portal/site interactions
         * Or even if we need to pull some information out of an web email interface
         *
         */
        StartWebRunner();
        /**
         * Here we are calling the private start driver function to kick off the required driver
         *
         */


    }

    private static void StartWebRunner(){
        if (driver == null) {

            System.setProperty("webdriver.chrome.driver", rootLocation);
            driver = new ChromeDriver();

            /**
             * We use a conditional statement here to determine if the driver needs to be created.
             * we are saying if, the driver is equal to null (Non existent - ==)
             * then create a new driver using the System.setProperty call followed by rootLocation
             * rootLocation is the static we declared before the method in order to keep system level changes
             * in 1 place, thus making the class easier to alter on a per device set-up
             *
             * this is a privately shared function that enables us to start a driver from anwhere inside a webrunner
             */
        }
    }

}

    /**
     *Javadoc authored by
     * Connor Lovegrove
     */