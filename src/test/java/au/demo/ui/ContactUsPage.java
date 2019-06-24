package au.demo.ui;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.*;
import org.openqa.selenium.WebDriver;

@DefaultUrl("https://www.securepay.com.au/support/contact-us/")
public class ContactUsPage extends PageObject {

    @Managed
    WebDriver _driver;

    public @FindBy(css = "form[action*='contact-us']")
    WebElementFacade ContactUsForm;

    public @FindBy(name = "first-name")
    WebElementFacade FirstName;

    public @FindBy(name = "last-name")
    WebElementFacade LastName;

    public @FindBy(name = "email-address")
    WebElementFacade Email;

    public @FindBy(name = "phone-number")
    WebElementFacade Phone;

    public @FindBy(name = "website-url")
    WebElementFacade WebsiteURL;

    public @FindBy(name = "business-name")
    WebElementFacade CompanyName;

    public @FindBy(name = "reason-for-enquiry")
    WebElementFacade ReasonForEnquiry;

    public ContactUsPage(WebDriver driver) {
        super(driver);
    }

}
