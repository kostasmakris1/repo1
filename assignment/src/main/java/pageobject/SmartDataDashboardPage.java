package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static Utils.Utils.*;

public class SmartDataDashboardPage implements Locators {

    private WebDriver driver;

    public SmartDataDashboardPage(WebDriver driver){
        this.driver = driver;
    }

    public Boolean isSmartDashboardPageDisplayed(){
        return driver.findElement(By.cssSelector(SMART_PAGE_DASHBOARD_LABEL)).isDisplayed();
    }

    /**
     * This method reads and stores data from UI into a Map
     * @return map
     */
    public Map<String, String> getTableData(){
        List<WebElement> tableData = driver.findElements(By.tagName(TABLE_DATA_BODY));

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        List<WebElement> tableRecords  = tableData.get(0).findElements(By.tagName("tr"));

        List<String> tableDataList = new ArrayList<String>();

        for (WebElement el: tableRecords){
        tableDataList.add(el.getText());
        }
        Map<String,String> map = new HashMap<String,String>();

        for (String s: tableDataList){

            map.put( getLettersFromString(s),getDigitsFromString(s));
        }
        return  map;
    }

}
