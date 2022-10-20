package com.trustpayment.pages;

import com.trustpayment.utils.Elements;
import com.trustpayment.utils.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.trustpayment.utils.DomainConstants.SITE_URL;

public class SearchDataPage extends TestBase {
    static int tempIndex = 0;
    @FindBy(xpath = Elements.txtGoogleSearch)
    private WebElement txtGoogleSearch;
    @FindBy(xpath = Elements.btnGoogleSearch)
    private WebElement btnGoogleSearch;
    @FindBy(xpath = Elements.btnNextPage)
    private WebElement btnNextPage;

    public void enterSeachData(String inputValue) {
        clearAndType(txtGoogleSearch, inputValue);
    }

    public void clickGoogleSeachButton() {
        clickOnElement(btnGoogleSearch);
    }

    public String displaySearchedSiteName() {
        String topic = null;
        List<WebElement> ahref = driver.findElements(By.tagName("a"));
        int count = ahref.size();
        Done:
        for (int temp = 0; temp <= count; temp++) {
            topic = driver.findElements(By.tagName("a")).get(temp).getText();
            if (topic.contains(SITE_URL)) {
                tempIndex = temp;
                               break Done;
            } else
                System.out.println("Nothing find");
        }
             if (!topic.contains(SITE_URL)) {
            clickOnElement(btnNextPage);
            Done:
            for (int value = 0; value <= count; value++) {
                topic = driver.findElements(By.tagName("a")).get(value).getText();
                if (topic.contains(SITE_URL)) {
                    tempIndex = value;
                                    break Done;
                } else
                    System.out.println("Nothing find");
            }
        }
        return topic;
    }
    public void clickOnTheSiteName() {
        driver.findElements(By.tagName("a")).get(tempIndex).click();
    }
}
