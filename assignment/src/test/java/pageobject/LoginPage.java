package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage implements Locators {

    private WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public Boolean isLoginPageDisplayed(){
        driver.get(SMART_DATA_WEB_APP_URL);
        return driver.findElement(By.cssSelector(LOGIN_PAGE_SUBMIT_BTN)).isDisplayed();
    }

    public Boolean login(String username,String password){

        driver.findElement(By.cssSelector(LOGIN_PAGE_USERNAME_FIELD)).sendKeys(username);
        driver.findElement(By.cssSelector(LOGIN_PAGE_PASSWORD_FIELD)).sendKeys(password);
        driver.findElement(By.cssSelector(LOGIN_PAGE_SUBMIT_BTN)).click();
        return new SmartDataDashboardPage(driver).isSmartDashboardPageDisplayed();
    }

}
