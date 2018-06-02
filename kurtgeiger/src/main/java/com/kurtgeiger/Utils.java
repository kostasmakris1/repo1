package com.kurtgeiger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class Utils {

    public static Integer randomElementFromList(List<WebElement> list) {
        Random random = new Random();
        return random.nextInt(list.size());
    }

    public static void refresh(WebDriver driver){
        driver.navigate().refresh();
    }

    public static void waiting(Long time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
