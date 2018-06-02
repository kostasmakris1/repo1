package com.kurtgeiger.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static java.lang.String.valueOf;

public class HomePage {

    @FindBy(id = "ss17-main-nav-wrapper")
    private WebElement kurtGeigerMainNavItemElem;

    private WebDriver driver;
    private BasketPage basketPage;
    private BrandsPage brandsPage;
    private MensPage mensPage;
    private ProductPage productPage;
    private static final String KURTGEIGER_BASE_URL = "https://www.kurtgeiger.";

    public HomePage(WebDriver driver, BasketPage basketPage, BrandsPage brandsPage, MensPage mensPage, ProductPage productPage) {
        this.driver = driver;
        this.basketPage = basketPage;
        this.brandsPage = brandsPage;
        this.mensPage =  mensPage;
        this.productPage = productPage;
        PageFactory.initElements(driver,this);
    }

    public boolean pageIsDisplayed(String lang){
        StringBuffer sb = new StringBuffer();
        driver.get(valueOf(sb.append(KURTGEIGER_BASE_URL).append(lang)));
        return kurtGeigerMainNavItemElem.isDisplayed();
    }

    public boolean selectCategory(String category){
        driver.findElement(By.cssSelector("a[href='"+category+"']")).click();
        boolean isPageDisplayed = false;

        switch (category){
        case "/shop-by-brand" : isPageDisplayed = brandsPage.isBrandsPageDisplayed();
        break;
        case "/men/shoes" : isPageDisplayed = mensPage.isMenPageDisplayed();
        break;

    }
        return isPageDisplayed;
    }

}
