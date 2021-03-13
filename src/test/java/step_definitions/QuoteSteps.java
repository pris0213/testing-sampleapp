package step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.InsurantFormPage;
import pages.VehicleFormPage;

public class QuoteSteps {
    private static WebDriver webDriver;
    private static VehicleFormPage vehicleFormPage;
    private static InsurantFormPage insurantFormPage;

    @Before
    public static void setUp() {
        ChromeDriverManager.getInstance().setup();
        webDriver = new ChromeDriver();

        vehicleFormPage = new VehicleFormPage(webDriver, "Enter Vehicle Data");
        insurantFormPage = new InsurantFormPage(webDriver, "Enter Insurant Data");

        vehicleFormPage.goToVehiclePage();
    }

    @After
    public void tearDown() {
        webDriver.close();
    }

    @Given("User is at the {string} form")
    public void userIsAtPage(String page) {
        assert isAtPage(page);
    }

    @When("User chooses brand {string}")
    public void userChoosesBrand(String brand) {
        vehicleFormPage.pickBrand(brand);
    }

    @And("User enters the engine performance {string}")
    public void userEntersTheEnginePerformance(String performance) {
        vehicleFormPage.setEnginePerformance(performance);
    }

    @And("User enters the date of manufacture {string}")
    public void userEntersTheDateOfManufacture(String date) {
        vehicleFormPage.setDateOfManufacture(date);
    }

    @And("User picks the number of seats {string}")
    public void userPicksTheNumberOfSeats(String quantity) {
        vehicleFormPage.pickNumberOfSeatsMenu(quantity);
    }

    @And("User chooses the fuel type {string}")
    public void userChoosesTheFuelType(String type) {
        vehicleFormPage.pickFuelType(type);
    }

    @And("User enters the payload {string}")
    public void userEntersThePayload(String payload) {
        vehicleFormPage.setPayload(payload);
    }

    @And("User enters the total weight {string}")
    public void userEntersTheTotalWeight(String weight) {
        vehicleFormPage.setTotalWeight(weight);
    }

    @And("User enters the list price {string}")
    public void userEntersTheListPrice(String price) {
        vehicleFormPage.setListPrice(price);
    }

    @And("User enters the annual mileage {string}")
    public void userEntersTheAnnualMileage(String mileage) {
        vehicleFormPage.setAnnualMileage(mileage);
    }

    @And("User goes to the {string} form")
    public void userGoesToTheNextForm(String page) {
        switch (page) {
            case "Insurant":
                vehicleFormPage.goToTheNextPage();
                break;
        }
    }

    @Then("User is redirected to the {string} form")
    public void userIsRedirectedToTheNextForm(String page) {
        assert isAtPage(page);
    }

    public boolean isAtPage(String page) {
        switch (page) {
            case "Vehicle":
                return vehicleFormPage.isAtPage();
            case "Insurant":
                return insurantFormPage.isAtPage();
            default:
                return false;
        }
    }
}
