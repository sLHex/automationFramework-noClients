package com.automation;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class WebNavUtils {

    // Global variable  Definitions

    static String rootLocation = "";
    static WebDriver driver;
    //static Map<String, Object> chromeOptions = new HashMap<String, Object>();
    static ChromeOptions chromeOptions = new ChromeOptions();
    static SoftAssert softassert = new SoftAssert();


    public static WebDriver getDriver() {
        return driver;
    }


    public static void setWebDriverLanguage(String locale){
        //System.setProperty("webdriver.chrome.driver", rootLocation + "/chromedriver");

        chromeOptions.addArguments("--lang=" + locale.substring(0,1));
        //options.addArguments("--Title=MG TEST");
    }



//    public static void softAssertTrueWithMessage(boolean condition, String message) {
//
//
//        appendMessageToScenario(message);
//        softassert.assertTrue(condition, message);
//        //softassert.assertAll();
//        //softassert.
//    }
//
//    public static void appendMessageToScenario(String message) {
//        if (currentScenario != null) {
//            currentScenario.write(message);
//        }
//    }
//
//    @Given("^I go to the website \"([^\"]*)\"$")
//    public void iGoToTheWebsite(String websiteName) {
//        driver.get(websiteName);
//    }
//
//    @Then("^I expect the website title to be \"([^\"]*)\"$")
//    public void iExpectTheWebsiteTitleToBe(String websiteTitle) {
//
//    String currentTitle = driver.getTitle();
//        String expectedTitle = websiteTitle;
//        Assert.assertTrue(currentTitle.equals(expectedTitle));
//
//    }


    public static void enterTexttoElementXPATH(String path, String data) {
        By elementSearch = By.xpath(path);
        WebElement element = driver.findElement(elementSearch);
        element.sendKeys(data);
    }

    public static void enterTextByCSS(String cssID, String data) {
        By elementSearch = By.cssSelector(cssID);
        WebElement element = driver.findElement(elementSearch);
        element.sendKeys(data);

    }

    public static WebElement clickOnElementXPATH(String xpathID) {
        WebElement element = driver.findElement(By.xpath(xpathID));
        element.click();
        return element;

    }
    public static WebElement clickOnElementByCSS(String cssID) {
        WebElement element = driver.findElement(By.cssSelector(cssID));
        element.click();
        return element;
    }

    public static boolean checkForElementXPATH(String xpathid) {
        WebElement checkForElement = driver.findElement(By.xpath(xpathid));

        return checkForElement.isDisplayed();

    }



    public static String getBgImagefromDivCSS(String CSS){

        WebElement MyImg = driver.findElement(By.cssSelector(CSS));
        String WelImg = MyImg.getCssValue("background-image");
        return WelImg;
        //Assert.assertTrue(WelImg.contains("imageurl"));
    }

    public static boolean checkForElementCSS(String CSS) {

        //Thread.sleep(1000);
        WebElement checkForElement = driver.findElement(By.cssSelector(CSS));
        return checkForElement.isDisplayed();

    }

    public static String getTextfromElementXPATH(String xpath){
        WebElement MyElement = driver.findElement(By.xpath(xpath));
        return MyElement.getText();
    }

    public static String getTextfromElementCSS(String CSS){
        WebElement MyElement = driver.findElement(By.cssSelector(CSS));
        return MyElement.getText();
    }


    public static void clickOnElementCSS(String cssID) {
        driver.findElement(By.cssSelector(cssID)).click();
    }

    public static void inputTexttoElementCSS(String cssID, String data) {
        driver.findElement(By.cssSelector(cssID))
                .sendKeys(data);

    }

    public static void pressEnterXPATH(String xpath) {
        WebElement element = driver.findElement(By.xpath(xpath));
        element.sendKeys(Keys.ENTER);
    }


    public static WebElement findElementTextbyXPATH(String text) {
        String query = String.format("//*[contains(text(), '%s')]", text);
        return driver.findElement(By.xpath(query));

    }

    public static WebElement findElementbyID(String ID) {
        //String query = String.format("//*[contains(text(), '%s')]", text);
        return driver.findElement(By.id(ID));

    }


    public static WebElement findElementbyCLASSNAME(String ClassName) {
        return driver.findElement(By.className(ClassName));

    }

    public static WebElement findElementbyCSS(String CSS) {
        return driver.findElement(By.cssSelector(CSS));

    }


    public static void hoverOverElementXPATH(String xpath) throws InterruptedException {
        WebElement element = driver.findElement(By.xpath(xpath));
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
        Thread.sleep(2000);
        WebElement clickElement = waitForElementWithTimeoutXPATH(xpath, 3000);
        action.moveToElement(clickElement).click().build().perform();
    }

    private static WebElement waitForElementWithTimeoutXPATH(String xPath1, int timeoutInMillis) throws InterruptedException {
        Calendar future = Calendar.getInstance();
        future.setTime(new Date());
        future.add(Calendar.MILLISECOND, timeoutInMillis);
        long futureEpoch = future.getTimeInMillis();
        while (futureEpoch >= Calendar.getInstance().getTimeInMillis()) {
            try {
                WebElement element = driver.findElement(By.xpath(xPath1));

                if (element != null) {
                    return element;
                }

            } catch (Exception e) {
                Thread.sleep(500);
            }
        }

        return null;
    }


    public static WebElement waitForElementWithTimeoutCSS(String cssName, int timeoutInMillis) throws InterruptedException {
        Calendar future = Calendar.getInstance();
        future.setTime(new Date());
        future.add(Calendar.MILLISECOND, timeoutInMillis);
        long futureEpoch = future.getTimeInMillis();
        while (futureEpoch >= Calendar.getInstance().getTimeInMillis()) {
            try {
                WebElement element = driver.findElement(By.cssSelector(cssName));
                if (element != null) {
                    return element;
                }

            } catch (Exception e) {
                Thread.sleep(500);
            }
        }

        return null;
    }

    public static void hoverOverElementCSS(String CSS) throws InterruptedException {
        WebElement element = driver.findElement(By.cssSelector(CSS));
        Actions action = new Actions(driver);
        Thread.sleep(2000);
        WebElement clickElement = waitForElementWithTimeoutCSS(CSS, 3000);
        action.moveToElement(element).perform();
    }

    public static void hoverOverElementAndClickCSS(String CSS) throws InterruptedException {
        WebElement element = driver.findElement(By.cssSelector(CSS));
        Actions action = new Actions(driver);
        Thread.sleep(2000);
        WebElement clickElement = waitForElementWithTimeoutCSS(CSS, 3000);
        action.moveToElement(element).perform();
    }

    public static boolean validateCurrentURL(String sURL) {

        boolean b;
        String stringCurrent = driver.getCurrentUrl();

        URL nURL = null;
        URL cURL = null;

        try {
            nURL = new URL(sURL);
        } catch (MalformedURLException exURL) {
            System.out.println(exURL);
            return false;
        }


        try {
            cURL = new URL(stringCurrent);
        } catch (MalformedURLException exURL) {
            System.out.println(exURL);
            return false;
        }

        return nURL.equals(cURL);
    }


    public static boolean checkURLonPage(String expURL) {

        java.util.List<WebElement> links = driver.findElements(By.tagName("a"));

        //System.out.println(expURL);

        for (int i = 0; i <= links.size() - 1; i = i + 1) {
            //System.out.println( links.get(i).getText() + " at positon " + i );

            if (links.get(i).getAttribute("href") != null) {
                //System.out.println(links.get(i).getText() + " " + links.get(i).getAttribute("href") + " at positon " + i );

                if (links.get(i).getAttribute("href").equals(expURL)) {
                    System.out.println(" Found URL : " + links.get(i).getAttribute("href") + " at positon " + i);
                    return true;
                }
            }

        }
        return false;

    }


    public static void findAndClickLink(String expURL) {

        java.util.List<WebElement> links = driver.findElements(By.tagName("a"));

        System.out.println(expURL);

        for (int i = 0; i <= links.size() - 1; i = i + 1) {
            //System.out.println( links.get(i).getText() + " at positon " + i );

            if (links.get(i).getAttribute("href") != null) {
                //System.out.println(links.get(i).getText() + " " + links.get(i).getAttribute("href") + " at positon " + i );

                if (links.get(i).getAttribute("href").equals(expURL)) {
                    //System.out.println(" Found URL : " + links.get(i).getAttribute("href") + " at positon " + i);
                    try {
                        links.get(i).click();
                        return;
                    } catch (Exception e) {
                        System.out.println(" Click on URL " + links.get(i).getAttribute("href") + "failed : " + e);
                    }
                }
            }

        }
    }

    public static void clickOnElementWithDelayXPATH(String xpath, int delayInMillis) throws InterruptedException {
        //WebElement element = driver.findElement(By.xpath(xpath));
        Actions act = new Actions(driver);
        WebElement element = waitForElementWithTimeoutXPATH(xpath, delayInMillis);
        act.moveToElement(element).perform();
        Thread.sleep(delayInMillis);
        element.click();
    }

    public static void HoverOverElementWithTimeoutPollingXPATH(String xPath) throws InterruptedException {
        try {
            //WebElement element = driver.findElement(By.xpath(xPath));
            WebElement element = waitForElementWithTimeoutXPATH(xPath, 5000);
            Actions act = new Actions(driver);
            act.moveToElement(element).perform();
        }catch (Exception e){
            System.out.println(e);
        }

        //WebElement clickElement = waitForElementWithTimeout(xPath, 5000);
        //act.moveToElement(clickElement).click().build().perform();

    }


    public static boolean checkPopUpAppears(){
        Boolean b = false;
        try{
            driver.switchTo().alert();
            // If it reaches here, it found a popup
            b =  true;

        } catch(Exception e){
            Assert.fail("No Pop Up detected");
        }

        return b;

    }

    public static WebDriver allowChromeMicAccess(String Enable,String siteURL){

        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<String, Object>();

        String sSite = "https://s3-eu-west-1.amazonaws.com";
        switch(Enable){
            case"Allow":
                prefs.put("profile.content_settings.exceptions.media_stream_mic.'" + sSite + ":443,'.setting","1");
                break;
            case"Block":
                prefs.put("profile.content_settings.exceptions.media_stream_mic.'" + sSite + ":443,'.setting","2");
                break;
            case"ForceAsk":
                prefs.put("profile.content_settings.exceptions.media_stream_mic.'" + sSite + ":443,'.setting","2");
            default:
                break;
        }

        options.setExperimentalOption("prefs", prefs);

        driver = new ChromeDriver(options);


        return driver;


    }


    public static boolean verifyElementAbsent(String locator) throws Exception {
        try {
            driver.findElement(By.cssSelector(locator));
            //System.out.println("Element Present");
            return false;

        } catch (NoSuchElementException e) {
            //System.out.println("Element absent");
            return true;
        }
    }




}
