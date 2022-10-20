package com.trustpayment.stepDefinitions;

import com.trustpayment.pages.AWSSitePage;
import com.trustpayment.pages.CloudWebSitePage;
import com.trustpayment.pages.SearchDataPage;
import com.trustpayment.utils.TestBase;
import io.cucumber.java.en.*;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import static com.trustpayment.utils.DomainConstants.*;


public class CloudWebSiteStepDefinition extends TestBase {

    @Given("user navigate to the site")
    public void user_navigate_to_the_site() {
        SearchDataPage searchDataPage = PageFactory.initElements(driver, SearchDataPage.class);
        searchDataPage.clickOnTheSiteName();
        CloudWebSitePage cloudWebSitePage = PageFactory.initElements(driver, CloudWebSitePage.class);
        Assert.assertEquals(cloudWebSitePage.getCurrentURL().contains(FULLSITEURL), true);

    }

    @When("user view listed cloud services")
    public void user_view_listed_cloud_services() {
        CloudWebSitePage cloudWebSitePage = PageFactory.initElements(driver, CloudWebSitePage.class);
        cloudWebSitePage.viewListedServices();
        switchWindow(1);
    }

    @Then("user verify the details of relavant cloud services And AWS Sites")
    public void user_verify_the_details_of_relavant_cloud_services() {
        CloudWebSitePage cloudWebSitePage = PageFactory.initElements(driver, CloudWebSitePage.class);
        Assert.assertEquals(cloudWebSitePage.topic1 && cloudWebSitePage.topic2 && cloudWebSitePage.topic3,true);
        AWSSitePage awsSitePage = PageFactory.initElements(driver, AWSSitePage.class);
        Assert.assertEquals(getCurrentURL().contains(WEBSITENAME), true);
        Assert.assertEquals(awsSitePage.getTopic(), LANDINGPAGETOPIC);
    }

}
