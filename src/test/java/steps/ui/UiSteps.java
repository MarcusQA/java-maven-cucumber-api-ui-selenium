package steps.ui;

import io.cucumber.java.en.*;

import org.junit.Assert;
import pages.GoogleSearchPage;

public class UiSteps extends BaseUiStep {
    @When("I search for {string}")
    public void i_search_for(String searchTerm) {
        GoogleSearchPage googleSearchPage = new GoogleSearchPage(driver);
        googleSearchPage.navigateToGoogle();
        googleSearchPage.rejectCookies();
        googleSearchPage.submitSearchTerm(searchTerm);
    }

    @Then("I see {string} in the results")
    public void i_see_in_the_results(String searchResult) {
        GoogleSearchPage googleSearchPage = new GoogleSearchPage(driver);
        // Example assertion
        Assert.assertEquals(true, googleSearchPage.pageContains(searchResult));
    }
}
