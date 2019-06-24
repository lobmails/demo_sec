package au.demo.stepdefinitions;


import au.demo.serenity.SearchEngineSteps;
import au.demo.serenity.WorkflowSteps;
import cucumber.api.java.en.Then;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import net.thucydides.core.annotations.Steps;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
public class VerificationDefs {

    @Steps
    WorkflowSteps securepay;

    @Then("^s?he verifies that the (.*) page is .*loaded.*")
    public void userVerifiesLandingPage(String sectionName){
        securepay.verifyLandingPage(sectionName);
    }

}
