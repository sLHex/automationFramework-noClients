package com.automation;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

public class CommonNavUtils {


    public static boolean clickAreaOfElementByLocation(AppiumDriver driver, WebElement element) throws InterruptedException{

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
}
