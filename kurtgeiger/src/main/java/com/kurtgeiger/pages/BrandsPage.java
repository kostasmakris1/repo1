package com.kurtgeiger.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BrandsPage {

    @FindBy(css = "div[class='brand-bg']")
    private WebElement shopByBrandElem;

    private WebDriver driver;
    private ProductPage productPage;

    public BrandsPage (WebDriver driver, ProductPage productPage){
        this.driver = driver;
        this.productPage = productPage;
        PageFactory.initElements(driver,this);
    }

    public boolean isBrandsPageDisplayed(){
        return shopByBrandElem.isDisplayed();
    }

    public void selectBrand(String brandName){
        driver.findElement(By.linkText(brandName)).click();
    }

}
