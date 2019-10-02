package com.automation;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.time.Duration;

public class AppiumWorkaroundUtils {


    public static void returnAppFocus(AndroidDriver<MobileElement> driver) throws InterruptedException{

        try {
            driver.runAppInBackground(Duration.ofMillis(10));
        } catch (Exception e) {
            e.printStackTrace();
        }

        Thread.sleep(3000);

    }


    public static String getLCaseString(AndroidDriver<MobileElement> driver, String ElementID) throws InterruptedException{

      return driver.findElementById(ElementID).getText().toLowerCase();

    }

    public static String getUCaseString(AndroidDriver<MobileElement> driver, String ElementID) throws InterruptedException{

        return driver.findElementById(ElementID).getText().toUpperCase();

    }

}
