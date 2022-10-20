package com.trustpayment.pages;

import com.trustpayment.utils.Elements;
import com.trustpayment.utils.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

import static com.trustpayment.utils.DomainConstants.*;

public class CloudWebSitePage extends TestBase {
    public static boolean topic1 = false;
    public static boolean topic2 = false;
    public static boolean topic3 = false;
    int tempLoction = 0;


    public void viewListedServices() {
        List<WebElement> webServicesList = driver.findElements(By.xpath(Elements.lblWebServiceList));
        ArrayList<String> ar = new ArrayList<String>();
        for (int temp = 0; temp < webServicesList.size(); temp++) {
            if (webServicesList.get(temp).getText().contains(WEBSERVICENAME)) {
                topic1 = true;
                ar.add(webServicesList.get(temp).getText());
                tempLoction = temp;
            }
            if (webServicesList.get(temp).getText().contains(WEBSERVICENAME2)) {
                topic2 = true;
                ar.add(webServicesList.get(temp).getText());
            }
            if (webServicesList.get(temp).getText().contains(WEBSERVICENAME3)) {
                topic3 = true;
                ar.add(webServicesList.get(temp).getText());
            }
        }
        webServicesList.get(tempLoction).click();
    }
}
