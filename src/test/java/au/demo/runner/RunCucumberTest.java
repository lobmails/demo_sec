package au.demo.runner;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;


@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/au/demo/specs/demoFeature",
        plugin = {"pretty", "html:target/cucumber", "rerun:target/rerun.txt"},
        glue = {"au.demo.stepdefinitions",
                "au.demo.hooks"},
        tags = {"not @Ignore", "not @Pending", "not @pending"}
)
public class RunCucumberTest {

    static long startTime;
    static long endTime;

    @BeforeClass
    public static void startRunCucumberTest() {
        System.out.println(">>>>> STARTING RUN CUCUMBER TEST <<<<<");
        startTime = System.currentTimeMillis();
    }

    @AfterClass
    public static void endRunCucumberTest() {
        System.out.println(">>>>> FINISHED RUN CUCUMBER TEST <<<<<");
        endTime = (System.currentTimeMillis() - startTime)/1000;
    }

}
