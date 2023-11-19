package tests;

import apiConfig.HeaderConfg;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import requests.LoginRequest;
import responses.LoginResponse;
import static base.Data.BASEURL;
import static base.Data.LOGIN;
import static io.restassured.RestAssured.given;


public class LoginTest {
    RequestSpecification requestSpecific;
    HeaderConfg headers = new HeaderConfg();
    public  String Token ;

    public void createRequestSpecifications(){
        requestSpecific = new RequestSpecBuilder().setBaseUri(BASEURL).build();
    }


    public ValidatableResponse LginRestWrapper(String email, String password, String token , String status_code) {
        LoginRequest loginReq = new LoginRequest(email, password, token );
        createRequestSpecifications();

        ValidatableResponse response = given()
                .spec(requestSpecific)
                .headers(headers.defaultHeaders())
                .body(loginReq)
                .log().all()
                .when().post(LOGIN)
                .then().assertThat().statusCode(Integer.parseInt(status_code));
        return response;


    }
    public void validateLogin(String email, String password, String token , String status_code){
        ValidatableResponse response = LginRestWrapper(email,password,token,status_code);
        if (response.extract().statusCode() == 200) {
            LoginResponse login = response.extract().as(LoginResponse.class);
            Assert.assertNotNull(login.getToken());
                    Token = login.getToken();
        }
        if (response.extract().statusCode() == 429) {
            System.out.println("u exceeded rate limit");
        }

}


}
