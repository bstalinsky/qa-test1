package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.cucumber.core.internal.com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.RandomStringUtils;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Reservation {
    public int id;
    public String name;
    public String surname;
    @JsonProperty("afrom")
    private String from;
    @JsonProperty("ato")
    public String to;
    @JsonProperty("bugs")
    public int bagCount;
    public String discount;
    public int children;
    @JsonProperty("flight")
    public int flightDay;
    private String fullFlightDay;
    @JsonProperty("adults")
    public int adultCount;
    public int seat;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.equals("random")) {
            this.name = RandomStringUtils.randomAlphabetic(15);
        } else {
            this.name = name;
        }
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public int getBagCount() {
        return bagCount;
    }

    public void setBagCount(int bagCount) {
        this.bagCount = bagCount;
    }

    public String getDiscount(String discount) {
        return this.discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public int getChildren() {
        return children;
    }

    public void setChildren(int children) {
        this.children = children;
    }

    public int getFlightDay() {
        return flightDay;
    }

    public void setFlightDay(int flightDay) {
        this.flightDay = flightDay;
    }

    public String getFullFlightDay() {
        return fullFlightDay;
    }

    public void setFullFlightDay(String fullFlightDay) {
        this.fullFlightDay = fullFlightDay;
        this.flightDay = Integer.parseInt(fullFlightDay.split("-")[0]);
    }

    public int getAdultCount() {
        return adultCount;
    }

    public void setAdultCount(int adultCount) {
        this.adultCount = adultCount;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }
}