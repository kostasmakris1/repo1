package kurtgeiger.pages;

import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;
    public HomePage(WebDriver driver, BasketPage basketPage) {
    }

    public void pageIsDisplayed(){
        driver.get("https://www.kurtgeiger.com/");
    }
}
