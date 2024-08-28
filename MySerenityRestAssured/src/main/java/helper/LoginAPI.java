package helper;

import net.serenitybdd.rest.SerenityRest;

public class LoginAPI
{
    public void postLoginAPI(String basePath, String username, String password)
    {
        SerenityRest.given()
                .relaxedHTTPSValidation()
                .header("Content-Type", "application/x-www-form-urlencoded")
                .formParam("Client_id","iomp-sso")
                .formParam("username", username)
                .formParam("password", password)
                .formParam("grant_type", "password")
                .formParam("scope","openid")
                .post("https://wdp-service-enterprise.wescodevops.com/api/v1/wesco/auth/token").then().log().all();

    }

    public void verifyStatusCode(int statusCode)
    {
        if(SerenityRest.lastResponse().getStatusCode()!=statusCode)
        {
            throw new RuntimeException("Login API Status Code is not as expected");
        }
    }
/*

    public void getAccessToken()
    {
            String accessToken = SerenityRest.lastResponse().getBody().asString("access_token");
            System.out.println("Access Token : "+accessToken);

    }
*/


}
