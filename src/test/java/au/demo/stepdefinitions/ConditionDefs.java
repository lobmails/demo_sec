package au.demo.stepdefinitions;

import au.demo.serenity.SearchEngineSteps;
import cucumber.api.java.en.Given;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import net.thucydides.core.annotations.Steps;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
public class ConditionDefs {

    @Steps
    SearchEngineSteps search;

    @Given("^User navigates to the required search engine '.*' home page") //'Google keyword can be parameterised through examples/file to switch between search engines'
    public void userNavigatesToTheSearchEngineHomePage()  {
        search.userNavigatesToDefaultSearchEngineHomePage();
    }
}
