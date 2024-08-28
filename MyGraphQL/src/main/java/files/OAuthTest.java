package files;

import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OAuthTest {

    public static void main(String[] args) throws InterruptedException {

        String url = "https://rahulshettyacademy.com/getCourse.php?code=4%2F0AQlEd8yxVDdiQyddlt7rk77VH7VyCAchzz1k1wkqypGxGd-lg9qhvEquS7cPCrPQIHv-5g&scope=email+openid+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email&authuser=0&prompt=consent";

        String partialcode= url.split("code=")[1];
        String code = partialcode.split("&scope")[0];
        System.out.println(code);

        String accesstokenres =
        given().queryParam("code",code)
                .queryParam("client_id","692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
                .queryParam("client_secret","erZOWM9g3UtwNRj340YYaK_W")
                .queryParam("redirect_uri","https://rahulshettyacademy.com/getCourse.php")
                .queryParam("grant_type","authorization_code")
                .when().log().all()
                .post("https://www.googleapis.com/oauth2/v4/token")
                .asString();

        JsonPath js = new JsonPath(accesstokenres);
        String accesstoken = js.getString("access_token");
        System.out.println("Access Token : "+accesstoken);

        String response = given().queryParam("access_token","")
                .when()
                .get("https://rahulshettyacademy.com/getCourse.php").asString();

        System.out.println(response);

    }
}

