package au.demo.serenity;

import au.demo.ui.ContactUsPage;
import au.demo.ui.SecurePayPage;
import au.demo.utilities.RandomGenerator;
import net.thucydides.core.annotations.*;
import net.thucydides.core.steps.ScenarioSteps;
import java.util.HashMap;
import static org.assertj.core.api.Assertions.assertThat;

@DefaultUrl("https://www.securepay.com.au/support/contact-us/")
public class WorkflowSteps extends ScenarioSteps {

    ContactUsPage contactUsPage;
    SecurePayPage homepage;

    public void userNavigatesToTheRequiredSection(String sectionName){
        //In case the page doesn't scroll
        //((JavascriptExecutor) getDriver()).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        homepage.ContactUsLink.click();
        assertThat(getDriver().getCurrentUrl().toLowerCase().contains(sectionName.toLowerCase()));
    }

    public void verifyLandingPage(String sectionName){
        assertThat(getDriver().getCurrentUrl().toLowerCase().contains(sectionName.toLowerCase()));
        contactUsPage.ContactUsForm.shouldBeCurrentlyVisible();
    }

    public void userFillsTheRequiredForm(String sectionName){ //Can be parameterised based on form name (left unused for the time being)
        HashMap newContactUsFormData = (HashMap) RandomGenerator.getFormData(sectionName);
        contactUsPage.FirstName.sendKeys((CharSequence) newContactUsFormData.get("FirstName"));
        contactUsPage.LastName.sendKeys((CharSequence) newContactUsFormData.get("LastName"));
        contactUsPage.Email.sendKeys((CharSequence) newContactUsFormData.get("Email"));
        contactUsPage.Phone.sendKeys((CharSequence) newContactUsFormData.get("Phone"));
        contactUsPage.WebsiteURL.sendKeys((CharSequence) newContactUsFormData.get("WebsiteURL"));
        contactUsPage.CompanyName.sendKeys((CharSequence) newContactUsFormData.get("Company"));
        contactUsPage.ReasonForEnquiry.selectByVisibleText(String.valueOf(newContactUsFormData.get("EnquiryReason")));
        System.out.println("wait here");
    }
}
