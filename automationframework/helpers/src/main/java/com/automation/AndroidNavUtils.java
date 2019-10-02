package com.automation;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

public class AndroidNavUtils {

    public static AndroidDriver<MobileElement> driver;
    public static WebDriverWait wait;

    public static void clickOnElementByID(AndroidDriver<MobileElement> driver, String elementID) throws InterruptedException {
        //AndroidNavUtils.wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(elementID))).click();
    }

    public static void clickOnElementByxPath(AndroidDriver<MobileElement> driver, String xPath) {
       // AndroidNavUtils.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPath)));
    }

    public static MobileElement checkForElementByID(AndroidDriver<MobileElement> driver, String elementID) {
        driver.findElement(By.id(elementID));
        return driver.findElement(By.id(elementID));
    }

    public static MobileElement checkForElementByxPath(AndroidDriver<MobileElement> driver, String xPath) {
        driver.findElement(By.xpath(xPath));
        return driver.findElement(By.xpath(xPath));
    }

    public static void androidSwipe(AndroidDriver<MobileElement> driver, int fromX, int fromY, int toX, int toY) throws InterruptedException {
        AndroidTouchAction swipe = new
                AndroidTouchAction(driver);
        swipe.press(PointOption.point(fromX, fromY)).moveTo(PointOption.point(toX, toY)).release();

    }

    //Get size of screen and swipes, in a direction from the exact centre to a Point of testers choosing
    public static boolean screenSizeSwipe(AndroidDriver<MobileElement> driver, String swipeType, int swipeLength){

        try {

            //   while (RACAndroidRunner.driver.findElementById("uk.co.rac.roadside:id/type_of_cover_list").isDisplayed() == false)
            //      {
            //WebElement abc = RACAndroidRunner.driver.findElementById("uk.co.rac.roadside:id/type_of_cover_list");

            int startY = driver.manage().window().getSize().getWidth() / 2;
            int startX = driver.manage().window().getSize().getHeight() / 2;
            int endY;
            int endX;

            switch (swipeType) {
                case "Up":
                    endX = startX;
                    endY = startY - swipeLength;
                    break;
                case "Down":
                    endX = startX;
                    endY = startY + swipeLength;
                    break;
                case "Left":
                    endX = startX - swipeLength;
                    endY = startY;
                    break;
                case "Right":
                    endX = startX + swipeLength;
                    endY = startY;
                    break;
                default:
                    return false;

            }

            TouchAction action = new TouchAction(driver);
            action.press(PointOption.point(startX, startY)).moveTo(PointOption.point(endX, endY)).release().perform();
            return true;

        } catch (Exception e) {
            Assert.assertTrue("Scroll action failed : \n" + e, false);
        }
        return false;
    }


    public static boolean actionScrollTofindElementByText(AndroidDriver<MobileElement> driver, String sText, int iAttempts) {


        boolean elementVisible = false;
        int attemptCounter = 0;

        while (!elementVisible && attemptCounter <= iAttempts) {

            try {
                driver.findElementByAndroidUIAutomator("new UiSelector().text(\"" + sText + "\")");
                elementVisible = true;

            } catch (Exception e) {
                elementVisible = false;
                attemptCounter = attemptCounter + 1;
            }

            AndroidNavUtils.screenSizeSwipe(driver, "Up", 75);

        }

        if (!elementVisible) {
            attemptCounter = 0;

            while (!elementVisible && attemptCounter <= iAttempts) {

                try {
                    driver.findElementByAndroidUIAutomator("new UiSelector().text(\"" + sText + "\")");
                    elementVisible = true;

                } catch (Exception e) {
                    elementVisible = false;
                    attemptCounter = attemptCounter + 1;
                }

                AndroidNavUtils.screenSizeSwipe(driver, "Down", 75);

            }

        }

        return elementVisible;

    }

    public static boolean actionScrollTofindElementById(AndroidDriver<MobileElement> driver, String sElementID, int iAttempts) {


        boolean elementVisible = false;
        int attemptCounter = 0;

        while (!elementVisible && attemptCounter <= iAttempts) {

            try {
                driver.findElementById(sElementID);
                elementVisible = true;

            } catch (Exception e) {
                elementVisible = false;
                attemptCounter = attemptCounter + 1;
            }

            AndroidNavUtils.screenSizeSwipe(driver, "Up", 75);

        }

        if (!elementVisible) {
            attemptCounter = 0;

            while (!elementVisible && attemptCounter <= iAttempts) {

                try {
                    driver.findElementById(sElementID);
                    elementVisible = true;

                } catch (Exception e) {
                    elementVisible = false;
                    attemptCounter = attemptCounter + 1;
                }

                AndroidNavUtils.screenSizeSwipe(driver, "Down", 75);

            }

        }

        return elementVisible;

    }


    public static WebElement getElementByTextUsingScreenScroll(AndroidDriver<MobileElement> driver, String sText, int iAttempts) throws InterruptedException {


        boolean elementVisible = false;
        int attemptCounter = 0;

        while (!elementVisible && attemptCounter <= iAttempts) {

            try {
                driver.findElementByAndroidUIAutomator("new UiSelector().text(\"" + sText + "\")");
                elementVisible = true;

            } catch (Exception e) {
                elementVisible = false;
                attemptCounter = attemptCounter + 1;
            }

            AndroidNavUtils.screenSizeSwipe(driver, "Up", 75);

        }

        if (!elementVisible) {
            attemptCounter = 0;

            while (!elementVisible && attemptCounter <= iAttempts) {

                try {
                    driver.findElementByAndroidUIAutomator("new UiSelector().text(\"" + sText + "\")");
                    elementVisible = true;

                } catch (Exception e) {
                    elementVisible = false;
                    attemptCounter = attemptCounter + 1;
                }

                AndroidNavUtils.screenSizeSwipe(driver, "Down", 75);

            }

        }

        if (elementVisible) {
            try {
                return driver.findElementByAndroidUIAutomator("new UiSelector().text(\"" + sText + "\")");
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }

    public static WebElement getElementByIdUsingScreenScroll(AndroidDriver<MobileElement> driver, String sElementID, int iAttempts) throws InterruptedException {


        boolean elementVisible = false;
        int attemptCounter = 0;


        while (!elementVisible && attemptCounter <= iAttempts) {

            try {
                driver.findElementById(sElementID);
                elementVisible = true;

            } catch (Exception e) {
                elementVisible = false;
                attemptCounter = attemptCounter + 1;
            }

            AndroidNavUtils.screenSizeSwipe(driver, "Up", 75);

        }

        if (!elementVisible) {
            attemptCounter = 0;

            while (!elementVisible && attemptCounter <= iAttempts) {

                try {
                    driver.findElementById(sElementID);
                    elementVisible = true;

                } catch (Exception e) {
                    elementVisible = false;
                    attemptCounter = attemptCounter + 1;
                }

                AndroidNavUtils.screenSizeSwipe(driver, "Down", 75);

            }

        }

        if (elementVisible) {
            try {
                return driver.findElementById(sElementID);
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }


    public static boolean clickAreaOfElement(AndroidDriver<MobileElement> driver, WebElement element) throws InterruptedException{

        Point elementloc =  element.getLocation();

        int X = elementloc.getX();
        int Y  = elementloc.getY();

        TouchAction action= new TouchAction(driver);
        try {
           System.out.println("Clicking Element with Text " + element.getText());
           action.tap(PointOption.point(X, Y)).perform();

        }catch(Exception e){
           System.out.println("Failed to click area of the passed element at location  for vehicle with Reg:"+  element.getText()+  "\n" + X + " - " + Y + "\n" + e);
            return false;
        }

        return true;

    }


    public static void captureScreenshot(AndroidDriver<MobileElement> driver, String sFileIdentifier) throws InterruptedException{


        try {
            String connectedDeviceName = driver.getCapabilities().getCapability("deviceName").toString();//getSessionDetail("deviceName").toString();


            String filename = "Login-Error-" + connectedDeviceName + "-" + sFileIdentifier.replace("@", "-") +
                    "-" + driver.getDeviceTime("hh:mm:ss").replace(":", "") + ".jpg";

            File file = driver.getScreenshotAs(OutputType.FILE);

            FileUtils.copyFile(file, new File(filename));
            System.out.println("captured screen shot " + filename + " and added it to project root");

        }catch(Exception e){

            System.out.println("Failed to capture screen shot with error :\n" + e);

        }
    }


}