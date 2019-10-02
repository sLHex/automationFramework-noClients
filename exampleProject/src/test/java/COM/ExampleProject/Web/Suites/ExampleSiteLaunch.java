package COM.ExampleProject.Web.Suites;
import COM.ExampleProject.Web.ExampleProjectWebRunner;
import com.runner.annotations.SuiteInformation;
import com.runner.annotations.TestInformation;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;


@SuiteInformation(
        suiteName = "Launch site",
        suiteDescription = "Able to launch and check the successful launch of a website",
        priority = SuiteInformation.SuitePriority.LOW,
        suiteAcceptanceCriteria = {
                "Browser launches," +
                        "Correct site is loaded" +
                        "And validated"
        }
)


public class ExampleSiteLaunch {


    @TestInformation(

            testName = "Test ID-(Jira US Reference EG. QTMS-1234) + Test name",
            testDescription = "<TEST OBJECTIVE JIRA/ADAPTAVIST>" +
                    "As a ... " +
                    "I want ..." +
                    "So that ...",
            /**
             * expected behaviour is just the BDD test script
            */

            expectedBehaviour = "Given I am on the Example project\n" +
                    "When I look at a class for information\n" +
                    "Then I see well commented javadocs by Connor",
            priority = TestInformation.TestPriority.HIGH,
            type = TestInformation.TestType.AUTOMATIC)


    @Test
    public void QTMS_T1234() throws InterruptedException {

        try {

            ExampleProjectWebRunner.driver.get("https://google.com");
            System.out.println("Website load success");

        } catch (Exception e) {
            Assert.fail("Unable to load google" + e);

        }
        try {

            ExampleProjectWebRunner.driver.findElementByCssSelector("#tsf > div:nth-child(2) > div > div.RNNXgb > div > div.a4bIc > input").click();
            WebElement element = ExampleProjectWebRunner.driver.findElement(By.cssSelector("#tsf > div:nth-child(2) > div > div.RNNXgb > div > div.a4bIc > input"));
            element.sendKeys("Selenium automation webtest");
            element.sendKeys(Keys.ENTER);
            System.out.println("Text entered");

        } catch (Exception e) {
            Assert.fail("Unable to search the required text" + e);

        }

        try {
            ExampleProjectWebRunner.driver.findElementByCssSelector("#rso > div:nth-child(1) > div > div > div.rc > div.r > a > h3 > div").click();
            System.out.println("Clicked on the Selenium homepage");
        } catch (Exception e) {
            Assert.fail("Unable to find the requested page" + e);
        }

        try {
            ExampleProjectWebRunner.driver.findElementByCssSelector("#menu_projects > a").click();
            System.out.println("Navigated to projects");
        } catch (Exception e) {
            Assert.fail("Unable to continue to projects" + e);
        }
    }
}










