package stepdefs;

import io.cucumber.core.internal.com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.Weather;
import model.WeatherResponse;
import org.junit.jupiter.api.Assertions;
import requesters.WeatherRequester;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

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
        System.out.println("Printe city id: " +cityId);
        System.out.println(response.getCoord().getLat());
    }
    @Then("coords are:")
    public void coords_are(Map<String, Double> params) {
        assertEquals(params.get("lon"), response.getCoord().getLon(), "Wrong Lon");
        assertEquals(params.get("lat"), response.getCoord().getLat(), "Wrong lat");
        System.out.println("Coord :" + params);
//    params.get("lon"); //145.77
    }
    @Then("weather are:")
    public void weather_is(Map<String, String> params) {
        Weather weather = response.getWeathers().get(0);
        assertEquals(Long.parseLong(params.get("id")), weather.getId(), "Wrong id");
        assertEquals(params.get("main"), weather.getMain(), "Wrong Main");
        assertEquals(params.get("description"), weather.getDescription(), "Wrong Description");
        assertEquals(params.get("icon"), weather.getIcon(), "Wrong icon");
//        Long.parseLong(params.get("id"));
//        Double.parseDouble(params.get("id"));
//        Integer.parseInt(params.get("id"));

    }
    @Then("base is {string}")
    public void base_is(String base) {
        assertEquals(base, response.getBase(),"Wrong Base!");
        System.out.println("Base is :" + base);
    }
    @Then("main are:")
    public void main_are(Map<String , Double> params) {
        System.out.println("Main are : " +params);
        Assertions.assertEquals(params.get("temp"), response.getMain().getTemp(), "Wrong temp");
        assertEquals(params.get("pressure"), response.getMain().getPressure(), "Wrong pressure : ");
        assertEquals(params.get("humidity"), response.getMain().getHumidity(), "Wrong humidity : ");
        assertEquals(params.get("temp_min"), response.getMain().getTemp_min(), "Wrong temp min : ");
        assertEquals(params.get("temp_max"), response.getMain().getTemp_max(), "Wrong temp max : ");
    }
    @Then("visibility : {int}")
    public void visibility(int visibility) {
        assertEquals(visibility, response.getVisibility(), "Wrong visibility ");
        System.out.println("Visibility : " + visibility);
    }
    @Then("wind are :")
    public void wind_is(Map<String , Double> wind) {
        System.out.println("Wind is : " + wind);
        assertEquals(wind.get("deg") , response.getWind().getDeg(), "Wrong deg");
        assertEquals(wind.get("speed") , response.getWind().getSpeed(), "Wrong speed");
    }
    @Then("clouds are :")
    public void clouds_are(Map<String, Long> clouds) {
//        assertEquals(clouds, response.getClouds(), "Wrong clouds ");
        System.out.println("Clouds are : " + clouds);

    }
    @Then("dt : {int}")
    public void dt(Integer dt) {
        assertEquals(dt, response.getDt(), "Wrong dt");
        System.out.println("dt = " + dt);
    }
    @Then("sys are :")
    public void sys_are(Map<String, String> sys) {
        System.out.println("Sys are : " + sys);
        assertEquals(Integer.parseInt(sys.get("type")) , response.getSys().getType(), "Wrong type");
        assertEquals(Long.parseLong(sys.get("id")) , response.getSys().getId(), "Wrong id");
        assertEquals(Double.parseDouble(sys.get("message")) , response.getSys().getMessage(), "Wrong message");
        assertEquals(sys.get("country") , response.getSys().getCountry(), "Wrong country");
        assertEquals(Long.parseLong(sys.get("sunrise")) , response.getSys().getSunrise(), "Wrong sunrise");
        assertEquals(Long.parseLong(sys.get("sunset")) , response.getSys().getSunset(), "Wrong sunset");

    }
    @Then("id are : {int}")
    public void id_are(int id1) {
        assertEquals(id1, response.getId(), "Wrong id ");
        System.out.println("id is " + id1);
    }
    @Then("name is : {string}")
    public void string_string(String name) {
        assertEquals(name, response.getName(), "Wrong name ");
        System.out.println("Name is " + name);
    }
    @Then("cod is {int}")
    public void cod_is(Integer int1) {
        assertEquals(int1, response.getCod(), "Wrong cod ");
        System.out.println("Cod is " + int1);
    }
}
