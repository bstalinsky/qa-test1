package stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import pageobject.pages.BaseFunc;
import tickets.HomePage;
import tickets.PersonalInfoPage;
import tickets.SeatSelectionPage;
import tickets.SuccessfulBookingPage;

import java.util.List;
import java.util.Map;

public class ticketsStepDefs {
    private String from;
    private String to;
    private int seatNr;
    private Map<String, String> personaInfo;
    private BaseFunc baseFunc = new BaseFunc();
    private HomePage homePage;
    private PersonalInfoPage infoPage;
    private SeatSelectionPage seatSelectionPage;
    private SuccessfulBookingPage successfulBookingPage;

    @Given("airports {string} and {string}")
    public void set_airports(String from, String to) {
        this.from = from;
        this.to = to;

    }

    @Given("seat number is {int}")
    public void set_seat_nr(int seatNr) {
        this.seatNr = seatNr;
    }

    @Given("personal info is:")
    public void set_personal_info(Map<String, String> params) {
        personaInfo = params;


    }

    @Given("home page opened")
    public void open_home_page() {
        baseFunc.openUrl("http://qaguru.lv:8089/tickets/");
        homePage = new HomePage(baseFunc);

    }

    @When("we are selecting airports")
    public void select_airports() {
        homePage.selectAirports(from, to);
    }

    @When("pressing GoGoGo button")
    public void press_go_button() {
        homePage.pressGoBt();
        infoPage = new PersonalInfoPage(baseFunc);
    }
    @When("we are filling in personal info")
    public void fill_personal_info_form() {
        infoPage.fillPersonalInfoForm(personaInfo);
    }

    @When ("we are submitting form")
    public void submit_persona_info_form() {
        infoPage.submit_form();
    }
    @When("we are pressing Book btn")
    public void press_book_btn(){
        infoPage.book();
        seatSelectionPage = new SeatSelectionPage(baseFunc);
    }
    @When("we are making final book")
    public void final_book(){
        seatSelectionPage.book();
        successfulBookingPage = new SuccessfulBookingPage(baseFunc);
    }

    @Then("selected airports appears")
    public void check_selected_airports() {
        List<String> selectedAirports = infoPage.getSelectedAirports();
        Assertions.assertEquals(from, selectedAirports.get(0), "Wrong");
        Assertions.assertEquals(to, selectedAirports.get(1), "Wrong");
    }
    @Then ("passenger name is shown")
    public void check_passenger_name(){
       Assertions.assertEquals(personaInfo.get("first_name"), infoPage.getPassengerName(), "Wrong...");
    }

    @When ("selecting seat")
    public void selecting_seat_number(){

        seatSelectionPage.selectSeat(seatNr);
    }
    @Then("submitting seat")
    public void check_seat_nr(){
//    Assertions.assertEquals(seatNr, seatSelectionPage.getSelectedSeat(), "Wrong ....");

    }
    @Then ("sucessful message appears")
    public void success_message_appears(){
        Assertions.assertTrue(successfulBookingPage.isSuccessMessagePresents(), "There is no success message!");
    }

}
