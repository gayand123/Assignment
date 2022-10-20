package com.trustpayment.stepDefinitions;

import com.trustpayment.pages.SearchDataPage;
import com.trustpayment.utils.TestBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import static com.trustpayment.utils.DomainConstants.*;

public class SearchDataStepDefinition extends TestBase {

    @Given("user open the google browser")
    public void user_open_the_google_browser() {
        setupDrivers();
    }

    @When("user enter the text to search")
    public void user_enter_the_text_to_search() {
        SearchDataPage searchDataPage = PageFactory.initElements(driver, SearchDataPage.class);
        searchDataPage.enterSeachData(SEARCHDATA);
    }

    @When("user click the search button")
    public void user_click_the_search_button() {
        SearchDataPage searchDataPage = PageFactory.initElements(driver, SearchDataPage.class);
        searchDataPage.clickGoogleSeachButton();
    }

    @Then("user verify  search result")
    public void userViewSearchResultAndUserClickOnRelevantUrl() {
        SearchDataPage searchDataPage = PageFactory.initElements(driver, SearchDataPage.class);
        Assert.assertEquals(searchDataPage.displaySearchedSiteName().contains(SITE_URL), true);
    }
}