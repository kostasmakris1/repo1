package com.kurtgeiger.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;
import static com.kurtgeiger.Utils.randomElementFromList;

public class ProductPage {

    @FindBy(id = "product-list")
    private WebElement productsElem;

    private WebDriver driver;
    private BasketPage basketPage;

    public ProductPage (WebDriver driver, BasketPage basketPage){
        this.driver = driver;
        this.basketPage = basketPage;
        PageFactory.initElements(driver,this);
    }

    public WebElement getProductElem(){
        return  productsElem;
    }

    public void displayProductsOfSpecificdBrand(String brandName){
        List<WebElement> products = productsElem.findElements(By.tagName("li"));
        for(WebElement el: products){
            Assert.assertEquals(el.findElement(By.cssSelector("h3[class='product-brand']")).getText(),brandName.toUpperCase());
        }
    }

    public boolean addRandomProductToBasket(){
        selectRandomProduct();
        basketPage.selectRandomColour();
        basketPage.selectRandomSize();
        basketPage.addItemToBasket();
        basketPage.goToBasket();

       return  basketPage.basketIsUpdatedWithQuantity(1);
    }

    private void selectRandomProduct(){
        List<WebElement> products = productsElem.findElements(By.tagName("li"));
        products.get(randomElementFromList(products)).click();
    }

}
