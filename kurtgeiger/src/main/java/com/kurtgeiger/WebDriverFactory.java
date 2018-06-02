package kurtgeiger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static java.lang.String.valueOf;
import static java.lang.System.getProperty;

public class WebDriverFactory {

    private static final String WEB_DRIVER_CHROME_STRING = "webdriver.chrome.driver";
    private static final String WEB_DRIVER_CHROME_BASE_PATH_STRING = "src/resources/bin/chromedriver";


        public static WebDriver getDriver(String driverName){
            WebDriver driver = null;
            String webDriverPath = getWebDriverPath();
            if(driverName!=null && driverName.equals("chrome")){
                System.setProperty(WEB_DRIVER_CHROME_STRING, webDriverPath);
                driver = new ChromeDriver();
            }
            else{
                try {
                    throw new WebDriverNotFoundException("please specify a valid driver");
                } catch (WebDriverNotFoundException e) {
                    e.printStackTrace();
                    System.exit(1);
                }
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            return driver;
        }

        private static String getWebDriverPath(){
            StringBuffer sb = new StringBuffer();
            sb.append(WEB_DRIVER_CHROME_BASE_PATH_STRING);
            if(getProperty("os.name").contains("Win")){
                sb.append(".exe");
            }
            return valueOf(sb);
        }


    }


