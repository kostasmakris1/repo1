package Utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utils {

    public static String getLettersFromString(String str){

        StringBuffer r = new StringBuffer();
        for (int k = 0; k < str.length(); k++) {
            if(Character.isLetter(str.charAt(k)))
                r.append(str.charAt(k));
        }
        return String.valueOf(r);
    }

    public static String getDigitsFromString(String str){
         return str.replaceAll("[^0-9?!\\.]","");
    }
}
