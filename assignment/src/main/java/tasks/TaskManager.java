package tasks;

import org.openqa.selenium.WebDriver;
import pageobject.LoginPage;
import pageobject.SmartDataDashboardPage;

public class TaskManager {

    public WebDriver driver;
    LoginPage loginPage;

    public  TaskManager(WebDriver driver){
        this.driver=driver;
    }

    public Boolean login(String username, String password){
       loginPage = new LoginPage(driver);
       return loginPage.isLoginPageDisplayed() && loginPage.login(username,password);
    }

    public Boolean validateData(){
        SmartDataDashboardPage smartDataDashboardPage = new SmartDataDashboardPage(driver);
        smartDataDashboardPage.getTableData();

        return false;
    }
}
