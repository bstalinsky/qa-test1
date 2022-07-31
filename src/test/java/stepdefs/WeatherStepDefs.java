package stepdefs;

import io.cucumber.core.internal.com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.eo.Do;
import model.WeatherResponse;
import org.junit.jupiter.api.Assertions;
import requesters.WeatherRequester;

import java.util.Map;

public class WeatherStepDefs {
    private long cityId;
    private WeatherResponse response;

    @Given("city id : {long}")
    public void city_id(long cityId) {
        this.cityId = cityId;
    }
    @When("We are requesting weather data")
    public void we_are_requesting_weather_data() throws JsonProcessingException {
        WeatherRequester requester = new WeatherRequester();
      response = requester.requestWeather(cityId);
    }
    @Then("coords are:")
    public void coords_are(Map<String, Double> params) {
        Assertions.assertEquals(params.get("lon"), response.getCoord().getLon(), "Wrong Lon");
        Assertions.assertEquals(params.get("lat"), response.getCoord().getLat(), "Wrong lat");
//    params.get("lon"); //145.77
    }
    @Then("weather is:")
    public void weather_is(Map<String, String> params) {
//        Long.parseLong(params.get("id"));
//        Double.parseDouble(params.get("id"));
//        Integer.parseInt(params.get("id"));

    }
    @Then("base is {string}")
    public void base_is(String string) {
    }
}
