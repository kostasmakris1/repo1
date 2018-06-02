package com.kurtgeiger.pages;

import com.kurtgeiger.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import static com.kurtgeiger.Utils.refresh;
import static com.kurtgeiger.Utils.waiting;
import static java.lang.Long.valueOf;

public class BasketPage {


    @FindBy(id = "add-to-cart-ss17")
    private WebElement addToBasketElem;

    @FindBy(css = "ul[class='sizes ']")
    private WebElement sizesElem;

    @FindBy(id = "colours")
    private WebElement coloursElem;

    @FindBy(id = "go-to-cart-ss17")
    private WebElement goToBagElem;

    @FindBy(css = "span[class='skiplinks_count']")
    private WebElement myBagElem;


    private WebDriver driver;
    public BasketPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);

    }

    public void selectRandomColour(){
        List<WebElement> colourList = coloursElem.findElements(By.tagName("li"));
        colourList.get(Utils.randomElementFromList(colourList)).click();
    }

    public void addItemToBasket(){
        addToBasketElem.click();
        waiting(valueOf(2000));
    }

    public void goToBasket(){
        goToBagElem.click();
    }

    public boolean basketIsUpdatedWithQuantity(Integer quantity){
        return Integer.valueOf(myBagElem.getText()) == quantity;
    }

    public void selectRandomSize(){

            refresh(driver);
            List<WebElement> sizeList  =  sizesElem.findElements(By.tagName("li"));
            sizeList.get(Utils.randomElementFromList(sizeList)).click();
    }
    }




