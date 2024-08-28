/*
package stepDefinitions;



import io.cucumber.java.Before;

import java.io.IOException;

public class Hooks {
    //get used when we want ot run only specific scenario
    //before running the main cucumber check for the Hooks
    @Before(" @DeletePlace")
    public void beforeScenario() throws IOException {
        System.out.println("Inside Before Scenario");
        Steps s = new Steps();

        if (Steps.place_id == null) {
            s.add_place_payload("Shin Hari", "Korean", "Korea");
            s.user_calls_with_http_request("AddPlaceAPI", "POST");
            s.verifyPlace_IdCreatedMapToUsing("Shin Hari", "getPlaceAPI");

        }
    }


}
*/


package stepDefinitions;


import io.cucumber.java.Before;
import io.cucumber.messages.types.StepDefinition;
import stepDefinitions.Steps;

import java.io.IOException;

public class Hooks {
    @Before("@DeletePlace")
    public void beforeScenario() throws IOException {
        //execute this code only when place id is null
        Steps m = new Steps();
        if (Steps.place_id == null) {
            m.add_place_payload_with("Shetty", "French", "Asia");
            m.user_calls_with_http_request("AddPlaceAPI", "POST");
            m.verify_place_id_created_maps_to_using("Shetty", "getPlaceAPI");
        }
    }
}
