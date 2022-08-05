package requesters;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.core.internal.com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.client.RestTemplate;
import model.Reservation;

import java.util.List;

public class TicketsRequester {
    //http://qaguru.lv:8089/tickets/getReservations.php
    private final String  URL = "http://qaguru.lv:8089/tickets/getReservations.php";

    public List <Reservation> getReservations() throws JsonProcessingException, com.fasterxml.jackson.core.JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForEntity(URL, String.class).getBody();

        com.fasterxml.jackson.databind.ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(response, new TypeReference<List<Reservation>>() {});


    }

}
