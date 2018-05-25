package tasks;

import Utils.ApiUtils;

import com.jayway.restassured.response.Response;
import gherkin.deps.com.google.gson.Gson;
import gherkin.deps.com.google.gson.GsonBuilder;
import gherkin.deps.com.google.gson.JsonElement;
import gherkin.deps.com.google.gson.JsonParser;
import models.SmartDataModel;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageobject.LoginPage;
import pageobject.SmartDataDashboardPage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;

/*
This class performs tasks related to the SmartData test class
 */
public class SmartDataTaskManager {

    public WebDriver driver;
    LoginPage loginPage;
    private static Gson gson = new GsonBuilder().create();

    public SmartDataTaskManager(WebDriver driver){
        this.driver=driver;
    }

    public Boolean login(String username, String password){
       loginPage = new LoginPage(driver);
       return loginPage.isLoginPageDisplayed() && loginPage.login(username,password);
    }

    public void validateData(){
        SmartDataDashboardPage smartDataDashboardPage = new SmartDataDashboardPage(driver);
        Map<String, String> dataMapFromUI =  smartDataDashboardPage.getTableData();
        SmartDataModel smartDataModel = parseHttpResponse();
        Assert.assertEquals(dataMapFromUI.get("AUD"),smartDataModel.getRates().getAUD());
        Assert.assertEquals(dataMapFromUI.get("BGN"),smartDataModel.getRates().getBGN());
        Assert.assertEquals(dataMapFromUI.get("BRL"),smartDataModel.getRates().getBRL());
        Assert.assertEquals(dataMapFromUI.get("CAD"),smartDataModel.getRates().getCAD());
        Assert.assertEquals(dataMapFromUI.get("CHF"),smartDataModel.getRates().getCHF());
        Assert.assertEquals(dataMapFromUI.get("CNY"),smartDataModel.getRates().getCNY());
        Assert.assertEquals(dataMapFromUI.get("CZK"),smartDataModel.getRates().getCZK());
        Assert.assertEquals(dataMapFromUI.get("DKK"),smartDataModel.getRates().getDKK());
        Assert.assertEquals(dataMapFromUI.get("EUR"),smartDataModel.getRates().getEUR());
        Assert.assertEquals(dataMapFromUI.get("HKD"),smartDataModel.getRates().getHKD());
    }

    public SmartDataModel parseHttpResponse(){

        SmartDataModel smartDataModel = null;
        Response response = ApiUtils.sendHttpGETRequest("http://api.fixer.io/latest?base=GBP");
        if(response.statusCode() == 200 || response.statusCode()==201){

             smartDataModel = gson.fromJson(response.body().prettyPrint(),SmartDataModel.class);

        }
        return smartDataModel;
    }
}
