
import org.junit.Assert;
import org.junit.Test;
import pageobject.LoginPage;
import pageobject.SmartDataDashboardPage;
import tasks.TaskManager;

public class MosaicSmartDataTests extends WebDriverManager {

 @Test
    public  void test1()  {

  TaskManager taskManager = new TaskManager(driver);
     // LoginPage loginPage = new LoginPage(driver);
     Assert.assertTrue(taskManager.login("kostas","password"));
    // loginPage.login("kostas","psw");
  SmartDataDashboardPage smartDataDashboardPage = new SmartDataDashboardPage(driver);
  smartDataDashboardPage.getTableData();




 }
}
