package kurtgeiger;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import kurtgeiger.pages.BasketPage;
import kurtgeiger.pages.HomePage;
import org.openqa.selenium.WebDriver;

import static java.lang.System.getProperty;
import static kurtgeiger.WebDriverFactory.getDriver;

public class KurtgeigerStepDefs  {

    private WebDriver driver =  getDriver(getProperty("browserName"));
    private BasketPage basketPage ;
    private HomePage homePage;

    public KurtgeigerStepDefs(){
        basketPage = new BasketPage(driver);
        homePage = new HomePage(driver,basketPage);
    }

    @Given("^I am on the kurtgeiger home page$")
    public void i_am_on_the_kurtgeiger_home_page()  {
    homePage.pageIsDisplayed();
    }

    @When("^I select brand category from the header$")
    public void i_select_brand_category_from_the_header()  {

    }

    @When("^I select a brand from the list$")
    public void i_select_a_brand_from_the_list()  {

    }

    @Then("^I should see a list of products for the selected brand$")
    public void i_should_see_a_list_of_products_for_the_selected_brand()  {

    }

    @After
    public void tearDown () {
        if (driver != null) {
            driver.quit();
        }
    }

}
