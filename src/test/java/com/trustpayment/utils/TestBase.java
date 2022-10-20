package com.trustpayment.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.logging.Logger;

import static com.trustpayment.utils.DomainConstants.GOOGLEURL;

public class TestBase {
    public static WebDriver driver;
    public static Logger testBaseLogger = Logger.getLogger(String.valueOf(TestBase.class));

    public void setupDrivers() {
        System.setProperty("webdriver.chrome.driver", "src/configurations/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(GOOGLEURL);
    }

    public static void clickOnElement(WebElement element) {
        element.click();
    }

    public static String getElementText(WebElement element) {

        String elementText = element.getText();
        if (!elementText.isEmpty()) {
            testBaseLogger.info("Retrieving text successful");
        } else {
            testBaseLogger.info("No text found on specific element " + element + "");
        }
        return elementText;
    }

    public static void clearAndType(WebElement element, String inputValue) {
        if (!inputValue.isEmpty()) {
            element.click();
            element.clear();
            element.sendKeys(inputValue);
            testBaseLogger.info("Typing successful");
        } else {
            testBaseLogger.info("No input value specified for " + element + "");
        }
    }

    public static void switchWindow(int childWindow){
        ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
        //switch to new tab
        driver.switchTo().window(newTb.get(childWindow));
    }
    public String getCurrentURL(){
        return  driver.getCurrentUrl();
    }

    public String getWebElementText(WebElement element){
        return element.getText();
    }

}
