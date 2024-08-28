package steps;

import helper.LoginAPI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;

public class LoginSteps
{

    String basePath;
    String baseurl = "https://wdp-service-enterprise.wescodevops.com/";
    String loginPath;
    @Steps
    LoginAPI loginAPI;



    @Given("the login API")
    public void theLoginAPI()
    {
        loginPath="api/v1/wesco/auth/token";
        System.out.println("the Login API");

    }

    @When("user credentials are provided to login API")
    public void userCredentialsAreProvidedToLoginAPI() {
        basePath= baseurl+loginPath;
        loginAPI.postLoginAPI("https://wdp-service-enterprise.wescodevops.com/api/v1/wesco/auth/token","pradeep.baskaran@wescodist.com", "Login@1234");
        System.out.println("user credentials are provided to login API");

    }


    @Then("access token is extracted from response")
    public void accessTokenIsExtractedFromResponse() {

        System.out.println("the Login API");


    }


}
