package au.demo.stepdefinitions;

import au.demo.serenity.SearchEngineSteps;
import au.demo.serenity.WorkflowSteps;
import cucumber.api.java.en.When;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import net.thucydides.core.annotations.Steps;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
public class ActionDefs {

    @Steps
    SearchEngineSteps search;

    @Steps
    WorkflowSteps securepay;

    @When("^He search for the '(.*)' through the search engine")
    public void userSearchForTheRequiredSearchString(String searchString) {
        search.searchStringUsingSearchPage(searchString);
    }

    @When("^He clicks through to the '(.*)' website link to reach Homepage of .* and verifies that Page is loaded with title (.*)")
    public void userClicksOnTheSearchedURLBasedOnTheSearchString(String url, String pgTitle) {
        search.clickOnTheSearchedURLBasedOnString(url, pgTitle);
    }

    @When("^Navigates to the '(.*)' page of the required .* website")
    public void userNavigatesToTheRequiredSectionOnThePage(String sectionName) {
        securepay.userNavigatesToTheRequiredSection(sectionName);
    }

    @When("^s?he generates random data using an open-source library to fill the (.*) form")
    public void userGeneratesRandomDataAndFillsTheForm(String sectionName) {
        securepay.userFillsTheRequiredForm(sectionName);
    }
}
