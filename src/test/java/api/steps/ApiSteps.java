package api.steps;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import api.helpers.HttpResponses;
import helpers.ScenarioContext;
import io.cucumber.java.en.*;
import org.junit.Assert;
import helpers.BaseSteps;

import java.io.IOException;
import java.net.HttpURLConnection;

import static api.helpers.HttpMethods.makeGetCall;


public class ApiSteps extends BaseSteps {
    @When("I request a list of cat breeds")
    public void i_request_a_list_of_cat_breeds() {
        try {
            HttpURLConnection connection = makeGetCall("https://catfact.ninja/breeds");
            int responseCode = connection.getResponseCode();
            Assert.assertEquals(200, responseCode);

            String responseBody = HttpResponses.getResponseBody(connection);
            scenarioContext = new ScenarioContext();
            scenarioContext.setContext("responseBody", responseBody);

            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Then("I see the first breed listed is {string}")
    public void i_see_the_first_breed_listed_is(String expectedBreed) {
        String responseBody = (String) scenarioContext.getContext("responseBody");
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(responseBody);
            JsonNode firstBreedNode = jsonNode.get("data").get(0);
            String firstBreed = firstBreedNode.get("breed").asText();

            // Example assertion
            Assert.assertEquals(expectedBreed, firstBreed);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
