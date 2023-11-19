package steps;


import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import tests.LoginTest;
import tests.WhoAmITest;

import static base.Data.BASEURL;

public class Login  {


    LoginTest login = new LoginTest();
    WhoAmITest whoIam = new WhoAmITest();


    @Given("user tries to log in with credentials {string}, {string}, and {string} expecting status code {string}")
    public void userTriesToLogInWithCredentialsAndExpectingStatusCode(String arg0, String arg1, String arg2, String arg3) {
        login.validateLogin(arg0 ,arg1 ,arg2 ,arg3);
    }

    @When("i call whoami end point using token retrieved from login")
    public void iCallWhoamiEndPointUsingTokenRetrievedFromLogin() {
       whoIam.WhoAmI();
    }

    @Then("i should get correct status code")
    public void iShouldGetCorrectStatusCode() {
        whoIam.validateWhoAmI();
    }
}
