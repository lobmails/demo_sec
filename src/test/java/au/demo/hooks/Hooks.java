package au.demo.hooks;

import au.demo.utilities.TestSettings;
import cucumber.api.Result;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Hooks {
    public static TestSettings testSettings;
    public static Properties constants;
    String testName;

    @Managed
    WebDriver _driver;

    public Hooks(){
        System.out.println("_____________ INITIALIZE HOOKS _____________");
        testSettings = TestSettings.getInstance();
        constants = testSettings.getConstantsProp();
    }

    @Before
    public void initiate(Scenario scenario){

        System.out.println("_____________ BEFORE SCENARIO _____________");
        System.out.println("SCENARIO ID AND NAME:" + scenario.getId() + "/" + scenario.getName());
        testName = scenario.getId() + "/" + scenario.getName();

        if(scenario.getName().contains("API")){
            //No need of opening the browser
        }else{
//        Driver configuration before scenario executes
            _driver.manage().window().maximize();
            _driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);

        }
        //This is to manage the asynchronous script waits e.g. waitForAngularRequests();
        //Implicit waits is handled in the serenity.properties and demoFeature method
    }

    @After
    public void terminate(Scenario scenario) throws Throwable {
        System.out.println("_____________ AFTER SCENARIO _____________");
        Result.Type status = scenario.getStatus();
        System.out.println("SCENARIO NAME: " + testName + " : STATUS: " + status);
        if (_driver != null) {
            _driver.close();
            _driver.quit();
        }
        Serenity.getCurrentSession().clear();

    }
}
