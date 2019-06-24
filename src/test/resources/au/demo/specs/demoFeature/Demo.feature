Feature: Demo to navigate to Fill the Secure Pay - Contact Us form

  @Demo @SIT @Progression @Regression
  Scenario Outline: User should be able to fill the Contact-us form of the SecurePay website by searching for the website through search engine using keyword 'SecurePay'

    Given User navigates to the required search engine '<SearchEngineName>' home page
    When He search for the '<SearchString>' through the search engine
    And He clicks through to the '<SearchResultURL>' website link to reach Homepage of <SearchString>  and verifies that Page is loaded with title <PageTitle>
    And Navigates to the '<FormName>' page of the required <SearchString> website
    And he verifies that the '<FormName>' page is loaded
    And he generates random data using an open-source library to fill the <FormName> form
    And he verifies that the '<FormName>' page is still loaded and has not been submitted

  Examples:
  | SearchEngineName  | SearchString | FormName    | SearchResultURL                | PageTitle                                                       |
  | Google            | SecurePay    | contact-us  | https://www.securepay.com.au/  | SecurePay online payment and eCommerce solutions for businesses |