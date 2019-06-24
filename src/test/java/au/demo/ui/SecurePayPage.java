package au.demo.ui;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.*;
import org.openqa.selenium.WebDriver;

@DefaultUrl("https://www.securepay.com.au/")
public class SecurePayPage extends SearchEnginePage {


    public @FindBy(className = "full-image")
    WebElementFacade HomePageImage;

    public SecurePayPage(WebDriver driver) {
        super(driver);
    }

    @WhenPageOpens
    public void waitUntilImageAppears() {
        element(HomePageImage).waitUntilVisible();
    }

    public @FindBy(css = "ul#menu-support:nth-child(1) a[href*='contact-us']")
    WebElementFacade ContactUsLink;
}
