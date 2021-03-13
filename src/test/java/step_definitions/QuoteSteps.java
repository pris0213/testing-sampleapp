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

    @Given("User is at the {string} form")
    public void user_is_at_page(String page) {
        isAtPage(page);
    }

    @When("User chooses brand {string}")
    public void user_chooses_brand(String brand) {
        vehicleFormPage.pickBrand(brand);
    }

    @And("User goes to the {string} form")
    public void user_goes_to_the_next_form(String page) {
        switch (page) {
            case "Insurant":
                vehicleFormPage.goToTheNextPage();
                break;
        }
    }

    @Then("User is redirected to the {string} form")
    public void user_is_redirected_to_the_next_form(String page) {
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

    @After
    public void tearDown() {
        webDriver.close();
    }
}
