package cucumbersteps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

public class NewCarSteps {

    //Hook gets called before and after every scenario
    @Before(order = 1)
    public void beforeHook()
    {
        System.out.println("Before Hook");
    }
    @After
    public void afterHook()
    {
        System.out.println("After Hook");
    }


    @Given("user navigate to website")
    public void userNavigateToWebsite() {

        System.out.println("navigate to website");
        
    }

    @When("user choose menu as new cars")
    public void userChooseMenuAsNewCars() {

        System.out.println("choose menu as new cars");
    }

    @Then("user click on find new cars")
    public void userClickOnFindNewCars(List<String> price) {

        System.out.println("click on find new cars: "+ price.get(1));

    }

    @And("user search for {string} car")      // denote any string input from the features
    public void user_search_for_car(String string) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Search for "+string+" car");
    }

    @And("user find car name and price")
    public void user_find_car_name_and_price() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Hello car and price");

    }

}
