package Utils;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;

import static com.jayway.restassured.RestAssured.given;

public class ApiUtils {

    public static Response sendHttpGETRequest(String url){

        Response res = given().get (url);
        return res;
    }
}
