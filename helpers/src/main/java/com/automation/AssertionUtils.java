package com.automation;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Assert;
import org.testng.asserts.SoftAssert;

public class AssertionUtils {


    public static void softAssertWithMessage(boolean condition, String message) {

        SoftAssert softassert = new SoftAssert();
        // appendMessageToScenario(message);
        softassert.assertTrue(condition, message);

    }


    public static void assertOnScrollToElementById(AndroidDriver<MobileElement> driver, String ElementID, int iAttempts, String scrollDirection) {


        boolean elementVisible = false;
        int attemptCounter = 0;

        while (elementVisible == false && attemptCounter <= iAttempts) {

            try {
                driver.findElementById(ElementID).isDisplayed();
                elementVisible = true;

            } catch (Exception e) {
                elementVisible = false;
                attemptCounter = attemptCounter + 1;
            }

            AndroidNavUtils.screenSizeSwipe(driver, scrollDirection, 75);

        }
        Assert.assertTrue("Element:" + ElementID, elementVisible);

    }

    public static void assertOnScrollToElementByText(AndroidDriver<MobileElement> driver, String sText, int iAttempts, String scrollDirection) {


        boolean elementVisible = false;
        int attemptCounter = 0;

        while (elementVisible == false && attemptCounter <= iAttempts) {


            try {
                driver.findElementByAndroidUIAutomator("new UiSelector().text(\"" + sText + "\")");
                elementVisible = true;

            } catch (Exception e) {
                elementVisible = false;
                attemptCounter = attemptCounter + 1;
            }

            AndroidNavUtils.screenSizeSwipe(driver, scrollDirection, 75);

        }
        Assert.assertTrue("Element:" + sText, elementVisible);
    }

}
