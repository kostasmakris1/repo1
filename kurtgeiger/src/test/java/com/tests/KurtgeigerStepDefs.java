package com.tests;

import com.kurtgeiger.pages.*;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import static java.lang.System.getProperty;
import static com.kurtgeiger.WebDriverFactory.getDriver;

public class KurtgeigerStepDefs  {

    private WebDriver driver =  getDriver(getProperty("browserName"));
    private BasketPage basketPage ;
    private HomePage homePage;
    private BrandsPage brandsPage;
    private MensPage mensPage;
    private ProductPage productPage;

    public KurtgeigerStepDefs(){
        basketPage = new BasketPage(driver);
        brandsPage = new BrandsPage(driver,productPage);
        mensPage = new MensPage(driver);
        productPage = new ProductPage(driver,basketPage);
        homePage = new HomePage(driver,basketPage,brandsPage,mensPage,productPage);

    }

    @Given("^I am on the kurtgeiger home page for \"([^\"]*)\"$")
    public void i_am_on_the_kurtgeiger_home_page(String lang)  {

        Assert.assertTrue(homePage.pageIsDisplayed(lang));
    }

    @When("^I select \"([^\"]*)\" category from the header$")
    public void i_select_brand_category_from_the_header(String category)  {

        Assert.assertTrue(homePage.selectCategory(category));
    }

    @When("^I select brand \"([^\"]*)\" from the list$")
    public void i_select_a_brand_from_the_list(String brandName)  {
      brandsPage.selectBrand(brandName);
    }

    @Then("^I should see a list of products for the selected brand \"([^\"]*)\"$")
    public void i_should_see_a_list_of_products_for_the_selected_brand(String brandName)  {
      productPage.displayProductsOfSpecificdBrand((brandName));
    }

    @When("^I add random product to basket$")
    public void i_add_random_product_to_basket()  {
       Assert.assertTrue(productPage.addRandomProductToBasket());
    }

    @Then("^product is ready for checkout$")
    public void product_is_ready_for_checkout() {

    }

    @After
    public void tearDown () {
        if (driver != null) {
            driver.quit();
        }
    }

}
