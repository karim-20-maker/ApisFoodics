package tests;

import apiConfig.HeaderConfg;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import requests.LoginRequest;
import responses.LoginResponse;

import static base.Data.*;
import static io.restassured.RestAssured.given;

public class WhoAmITest {
    RequestSpecification requestSpecific;
    HeaderConfg headers = new HeaderConfg();
    LoginTest login = new LoginTest();


    public void createRequestSpecifications(){
        requestSpecific = new RequestSpecBuilder().setBaseUri(BASEURL).build();
    }


    public ValidatableResponse WhoAmI() {
        login.validateLogin("merchant@foodics.com","123456" , "Lyz22cfYKMetFhKQybx5HAmVimF1i0xO","200");
        createRequestSpecifications();
        ValidatableResponse response = given()
                .spec(requestSpecific)
                .headers(headers.authHeader(login.Token))
                .log().all()
                .when().get(WHOAMI)
                .then().log().all();
        return response;
    }
    public void validateWhoAmI(){
        WhoAmI().assertThat().statusCode(200);
    }

}
