package com.trustpayment.pages;

import com.trustpayment.utils.Elements;
import com.trustpayment.utils.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AWSSitePage extends TestBase {
    @FindBy(xpath = Elements.lblTopic)
    private WebElement lblTopic;

    public String getTopic() {
        return getWebElementText(lblTopic);
    }
}
