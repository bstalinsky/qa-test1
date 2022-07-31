package stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class HelloWorldStepDefs {
    private int alexApplesCount;
    private int kateApplesCount;
    private int applesTotalCount;

    @Given("Alex has {int} apples")
    public void alex_has_apples(int count) {
        alexApplesCount = count;
        System.out.println("Alex has: " + alexApplesCount);
    }

    @Given("Ekaterina has {int} apples")
    public void ekaterina_has_apples(int count) {
        kateApplesCount = count;
        System.out.println("Kate apples: " +kateApplesCount);
    }

    @When("they are putting all apples together")
    public void they_are_putting_all_apples_together() {
        applesTotalCount = alexApplesCount + kateApplesCount;
        System.out.println("Apples Total count: " + applesTotalCount);
    }

    @Then("they have {int} apples")
    public void they_have_apples(int count) {
        System.out.println("Checking if total count is OK..");
        Assertions.assertEquals(count , applesTotalCount , "Wrong total count!!");
        System.out.println("Total count is OK!");
    }
}
