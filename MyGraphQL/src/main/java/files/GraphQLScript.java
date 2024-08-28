package files;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;


public class GraphQLScript {
    public static void main(String[] args) {

        String charid="8504";
        String response = given().log().all().header("Content-Type", "application/json")
                .body("{\"query\":\"query ($characterId: Int!, $episodeId: Int!) {\\n  character(characterId: $characterId) {\\n    name\\n    gender\\n    status\\n    type\\n    id\\n  }\\n  location(locationId: 8482) {\\n    name\\n    dimension\\n  }\\n  episode(episodeId: $episodeId) {\\n    name\\n    air_date\\n    episode\\n  }\\n  characters(filters: {name: \\\"Akanksha\\\"}) {\\n    info {\\n      count\\n    }\\n    result {\\n      name\\n      type\\n    }\\n  }\\n  episodes(filters: {episode: \\\"hulu\\\"}) {\\n    result {\\n      id\\n      name\\n      air_date\\n      episode\\n    }\\n  }\\n}\\n\",\"variables\":{\"characterId\":"+charid+",\"episodeId\":9890}}")
                .when().post("https://rahulshettyacademy.com/gq/graphql")
                .then().log().all().statusCode(200).extract().response().asString();

                System.out.println(response);
                JsonPath js = new JsonPath(response);
                String name = js.getString("data.character.name");  //give detailed path for nested JSON
                System.out.println(name);
                Assert.assertEquals(name, "Jungkook");

                //Mutation


        String newCharname="Jungkook";
        String mutresponse = given().log().all().header("Content-Type", "application/json")
                .body("{\"query\":\"mutation($locationName: String!, $charName:String!, $epiName:String!)\\n{\\n  createLocation(location: {name: $locationName, type:\\\"South\\\", dimension:\\\"234\\\"})\\n  {\\n    id\\n  }\\n  createCharacter(character: {name: $charName, type: \\\"Bias\\\", status: \\\"Alive\\\", species: \\\"Singer\\\", gender: \\\"Male\\\", image: \\\"png\\\", originId:12881, locationId:12881})\\n  {\\n    id\\n  }\\n  createEpisode(episode:{name: \\\"Run BTS\\\", air_date:\\\"1-9-1997\\\",episode: $epiName})\\n  {\\n    id\\n  }\\n  deleteLocations(locationIds:[12883,12882])\\n  {\\n    locationsDeleted\\n  }\\n}\",\"variables\":{\"locationName\":\"Korea\",\"charName\":\""+newCharname+"\",\"epiName\":\"weverse\"}}")
                .when().post("https://rahulshettyacademy.com/gq/graphql")
                .then().log().all().statusCode(200).extract().response().asString();

        System.out.println(mutresponse);
        JsonPath js2 = new JsonPath(mutresponse);
        String locationid = js2.getString("data.createLocation.id");
        System.out.println(locationid);

    }

}
