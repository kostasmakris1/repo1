
import org.junit.Assert;
import org.junit.Test;
import pageobject.SmartDataDashboardPage;
import tasks.SmartDataTaskManager;

public class MosaicSmartDataTests extends WebDriverManager {

 @Test
    public  void test1()  {

  SmartDataTaskManager smartDataTaskManager = new SmartDataTaskManager(driver);

     Assert.assertTrue(smartDataTaskManager.login("kostas","password"));
     smartDataTaskManager.validateData();

 }
}
