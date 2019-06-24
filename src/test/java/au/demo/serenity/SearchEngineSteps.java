package au.demo.serenity;

import au.demo.ui.SearchEnginePage;
import au.demo.ui.SecurePayPage;
import net.thucydides.core.annotations.Step;
import static org.assertj.core.api.Assertions.assertThat;

public class SearchEngineSteps extends WorkflowSteps {

    SecurePayPage securePayPage;
    SearchEnginePage base;

    @Step
    public void userNavigatesToDefaultSearchEngineHomePage() {
        base.open();
        getDriver().manage().window().maximize();
        assertThat(base.SearchBox.isCurrentlyVisible()).withFailMessage("Query box is not visible in the search engine").isTrue();
    }

    @Step
    public void searchStringUsingSearchPage(String searchString) {
        assertThat(base.SearchBox.isCurrentlyVisible()).withFailMessage("Search box is not visible on search engine home screen").isTrue();
        base.search(searchString);
        assertThat(base.SearchBox.getValue().equals(searchString)).withFailMessage("Search box value doesn't match with searched string: " + searchString + " on the search result page").isTrue();
    }

    @Step
    public void clickOnTheSearchedURLBasedOnString(String url, String pgTitle) {
        try {
            assertThat(base.SecurePayURLLink.isCurrentlyVisible()).withFailMessage("Searched URL is not visible on search engine home screen").isTrue();
            base.SecurePayURLLink.click();
            securePayPage.waitUntilImageAppears(); //Alternatively, for entire page load check, verifyOnHomePage()
            securePayPage.waitForTitleToAppear(pgTitle);
            assertThat(base.getDriver().getCurrentUrl().equals(url)).withFailMessage("Actual URL didn't match with expected").isTrue();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
