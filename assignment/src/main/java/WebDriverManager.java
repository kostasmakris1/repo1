import com.google.common.base.Optional;
import org.apache.commons.exec.util.StringUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * This class is used to initilase the web driver and is parent class of all the tests classes
 */
public class WebDriverManager {

    protected WebDriver driver;

    @Before
    public void setUp() {
        getWebdriver();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    private WebDriver getWebdriver() {

        String browserName = System.getProperty("browserName");

        if (browserName!=null) {
            if (browserName.equals("chrome")) {
                System.setProperty("webdriver.chrome.driver", "src/resources/bin/chromedriver.exe");
                driver = new ChromeDriver();
            }
        } else {
            try {
                throw new BrowserNotFountException("Please provide a valid browser");
            } catch (BrowserNotFountException e) {
                e.printStackTrace();
                System.exit(1);
            }
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;

    }
}