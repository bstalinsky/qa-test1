package tickets;

import io.cucumber.java.it.Ma;
import model.Reservation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageobject.pages.BaseFunc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PersonalInfoPage {
    private final By SELECTED_AIRPORT = By.xpath(".//span[@class = 'bTxt']");
    private final BaseFunc baseFunc;
    private final By NAME_INPUT = By.id("name");
    private final By SURNAME_INPUT = By.id("surname");
    private final By DISCOUNT_INPUT = By.id("discount");
    private final By ADULTS_COUNT_INPUT = By.id("adults");
    private final By CHILDREN_COUNT_INPUT = By.id("children");
    private final By BAGS_COUNT_INPUT = By.id("bugs");
    private final By FLIGHT_SELECT = By.id("flight");
    private final By GET_PRICE_LINK = By.xpath(".//span[@onclick = 'setLang();']");
    private final By PASSENGER_NAME = By.xpath(".//div[@id = 'response']/span");
    private final By BOOK_BTN = By.id("book2");

    public PersonalInfoPage(BaseFunc baseFunc){
        this.baseFunc = baseFunc;
    }

    public List<String> getSelectedAirports(){
        List<WebElement> selectedAirports = baseFunc.findElements(SELECTED_AIRPORT);
        List<String> result = new ArrayList<>();

        for (WebElement we : selectedAirports) {
            result.add(we.getText());
        }
        return result;
        }
        public void  fillPersonalInfoForm(Reservation reservation){
        baseFunc.type(NAME_INPUT, reservation.getName());
        baseFunc.type(SURNAME_INPUT, reservation.getSurname());
        baseFunc.type(DISCOUNT_INPUT, reservation.getDiscount(""));
        baseFunc.type(ADULTS_COUNT_INPUT, reservation.getAdultCount());
        baseFunc.type(CHILDREN_COUNT_INPUT, reservation.getChildren());
        baseFunc.type(BAGS_COUNT_INPUT, reservation.getBagCount());
        baseFunc.selectByVisibleText(FLIGHT_SELECT, reservation.getFullFlightDay());
        }
        public void submit_form(){
        baseFunc.click(GET_PRICE_LINK);
        }

        public String getPassengerName(){
        return baseFunc.findElement(PASSENGER_NAME).getText().replace("!", "");
        }

        public void book(){
        baseFunc.click(BOOK_BTN);
        }

    }

