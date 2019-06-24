package au.demo.ui;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleContains;

@DefaultUrl("https://www.google.com.au")
public class SearchEnginePage extends PageObject {

    public @FindBy(css = "input[name='q']")
    WebElementFacade SearchBox;

    public @FindBy(xpath = "//a[@href = 'https://www.securepay.com.au/']/h3[text() = 'SecurePay online payment and eCommerce solutions for businesses']")
    WebElementFacade SecurePayURLLink;

    public void search(String keywords) {
        SearchBox.sendKeys(keywords, Keys.ENTER);
        waitFor(titleContains("Google Search"));
    }

    public SearchEnginePage(WebDriver driver) {
        super(driver);
    }
}
